package cn.beautylady.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.beautylady.entity.Page;
import cn.beautylady.util.C3p0Utils;
import cn.beautylady.util.JNDIJdbcUtil;
import cn.beautylady.util.JdbcUtil;


/**
 * 数据库增删改查操作
 * @author acsars
 *
 */
public class BaseDao {

	/**
	 * 数据增删改操作
	 * @param sql sql语句
	 * @param params 参数字符串数组
	 * @return 执行结果
	 */
	/*public int executeUpdate(String sql,Object...params) {
		PreparedStatement pstmt = null;
		int num = -1;
		try {
			conn = C3p0Utils.getInstance().getConnection();
			pstmt = C3p0Utils.setStatement(conn, sql);
			num = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			C3p0Utils.releaseSources(conn, pstmt, null);
		}
		return num;
	}*/
	
	/**
	 * 查询数据列表
	 * @param sql sql语句
	 * @param T 查询对象的类型
	 * @param params 参数字符串数组
	 * @return 数据列表
	 */
	public<T>List<T> getArrayList(String sql,Class<T> clazz,Object...params){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = JdbcUtil.getConnection();
			pstmt = C3p0Utils.setStatement(conn, sql);
			pstmt = C3p0Utils.setSQLParameters(pstmt, params);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int count = metaData.getColumnCount();
			while(rs.next()) {
				T temp = (T) clazz.newInstance();
				for (int i = 0; i < count; i++) {
					String fieldName = metaData.getColumnName(i+1);
					Field field = clazz.getDeclaredField(fieldName);
					Method method = clazz.getMethod(getSetter(fieldName), field.getType());
					method.invoke(temp, rs.getObject(i+1));
				}
				list.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JNDIJdbcUtil.closeAll(conn, pstmt, rs);
		}
		return list;
	}
	/**
	 * 拼接对象当前属性的set方法
	 * @param fieldName 对象当前属性
	 * @return set方法字符串
	 */
	public static String getSetter(String fieldName) {
		return "set" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
	/**
	 * 拼接对象当前属性的get方法
	 * @param fieldName 对象当前属性
	 * @return get方法字符串
	 */
	public static String getGetter(String fieldName) {
		return "get" + fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
	/**
	 * 获取单一数据
	 * @param sql sql语句
	 * @param T 查询对象的类型
	 * @param params 参数字符串数组
	 * @return 查找的数据
	 */
	public <T> T getOne(String sql,Class<T> clazz,Object...params) {
		List<T> list = getArrayList(sql, clazz, params);
		if(list.size() != 0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	/**
	 * 获取数据总数
	 * @param <T>
	 * @param type 表名/表中存储的数据类型
	 * @return 信息总数
	 */
	public <T> int getCountByClass(Class<T> clazz) {
		String sql = "SELECT COUNT(*) FROM `"+getClassName(clazz)+"`";
		Connection conn =JdbcUtil.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JNDIJdbcUtil.closeAll(conn, pstmt, rs);
		}
		return result;
	}
	/**
	 * 向数据库增加数据
	 * @param T 
	 * @return 执行结果
	 * @throws SQLException 
	 */
	public <T>int insertData(Class<T> clazz) throws SQLException{
		String sql = "INSERT INTO '"+getClassName(clazz)+"'";
		String values = "VALUES(";
		Field[] fields = clazz.getDeclaredFields();//获取类的所有属性
		List<Object> list = new ArrayList<>();
		boolean flag = true;//判断是否第一次添加sql参数
		try {
			for (int i = 0; i < fields.length; i++) {
				String methodName = getGetter(fields[i].getName());//根据属性名获取get方法字符串
				Method method = clazz.getMethod(methodName);
				T t = clazz.newInstance();
				Object obj = method.invoke(t);
				if(obj != null) {
					if(flag) {
						values += "?";
						sql += "(";
						sql += "`"+fields[i].getName()+"`";
						list.add(obj);
						flag = false;
					}else {
						values += ",?";
						sql += ",`"+fields[i].getName()+"`";
						list.add(obj);
					}
				}
				if(list.size() > 0) {
					values += ")";
					sql += ")";
					sql += values;
				}else {
					throw new RuntimeException("传入的对象属性值都为空");
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return executeUpdate(sql, fields);
	}
	/**
	 * 在数据库中删除数据
	 * @param T 
	 * @return 执行结果
	 * @throws SQLException 
	 */
	public <T>int delData(Class<T> clazz) throws SQLException {
		String sql = "DELECT FROM `"+getClassName(clazz)+"`";
		Field[] fields = clazz.getDeclaredFields();//获取对象中所有的属性
		List<Object> list = new ArrayList<>();
		boolean flag = true;//判断是否插入第一个参数
		try {
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				String methodName = getGetter(fieldName);
				Method method = clazz.getMethod(methodName);
				Object obj = method.invoke(clazz.newInstance());
				if(obj != null) {
					if(flag) {
						sql += "WHERE `"+ fields[i].getName() + "` = ?";
						list.add(obj);
					}else {
						sql += "AND `"+ fields[i].getName() + "` = ?";
					}
				}
				if(list.size() == 0) {
					throw new RuntimeException("要删除的对象属性值为空");
				}
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return executeUpdate(sql, fields);
	}
	/**
	 * 获取对应数据当前页面对象
	 * @param pageNo 页码
	 * @param pageSize 当前页数据条数
	 * @param T 
	 * @return 当前页信息
	 */
	public <T>Page<T> getPage(Integer pageNo, Integer pageSize,Class<T> clazz){
		String sql ="SELECT * FROM`"+getClassName(clazz)+"` LIMIT "+ (pageNo-1)*pageSize+","+pageSize;
		Page<T> page = new Page<>();
		int dataCount = getCountByClass(clazz);
		page.setPageSize(pageSize);
		page.setDataCount(dataCount);
		page.setPageNo(pageNo);
		page.setType(getClassName(clazz));
		List<T> list = getArrayList(sql, clazz, null);
		page.setList(list);
		return page;
		
	}
	

	public int getCount(String sql,Object...objs) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			if (objs!=null && objs.length!=0) {
				for (int i = 0; i < objs.length; i++) {
					pstmt.setObject((i+1), objs[i]);
				}
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JNDIJdbcUtil.closeAll(conn, pstmt, rs);
		}
		return result;
	}

	
	 /**
     * 将字符串的一个字母转换成大写
     * @param str
     * @return
     */
    public String initcap(String str) {
        char[] ch=str.toCharArray();
        if(ch[0]>='a' && ch[0]<='z'){
            ch[0]= (char) (ch[0]-32);
        }
        return new String(ch);
    }

    


    


    /**
     * 根据主键进行删除（可传入多个主键）
     * @param clazz 数据类型
     * @param keys 主键 字符串数组
     * @return 执行结果
     * @throws SQLException
     */
    public <T>int delete(Class<T> clazz,Object...keys) throws SQLException{
        StringBuffer sql = new StringBuffer().append("DELETE FROM `"+getClassName(clazz)+"` WHERE " +getPrimaryKey(clazz)+ " IN (");
        boolean flag = true;//判断是否拼接的是第一个属性
        for (int i = 0; i < keys.length; i++) {
            if(flag){
                sql.append("?");
                flag = false;
            }else{
                sql.append(",?");
            }
        }
        sql.append(")");
        return executeUpdate(sql.toString(), keys);
    }
    /**
     * 根据用户提供的对象信息删除
     * @param t
     * @return 执行结果
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public <T>int delete(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException {
        Class clazz = t.getClass();
        StringBuffer sql = new StringBuffer().append("DELETE FROM `"+getClassName(clazz)+"` WHERE ");
        StringBuffer condition = new StringBuffer().append(" WHERE ");
        Field[] fields = clazz.getDeclaredFields();//获取对象所有属性
        List<Object> paramList = new ArrayList<>();
        Object param = null;//属性值
        boolean flag = true;//是否添加的是第一个属性
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();//当前对象属性
            Method method = clazz.getMethod(getGetter(fieldName));//当前属性的Getter方法
            param = method.invoke(t);//获取属性值
            if(param != null && !"".equals(param)){
                paramList.add(param);//添加有效属性值到属性列表
                if(flag){
                    sql.append("`"+fieldName+"` =?");
                    flag = false;
                }else{
                    sql.append(" AND `"+fieldName+"` =?");
                }
            }
        }
        return executeUpdate(sql.toString(), paramList.toArray());
    }
    
    
    public <T>int insert(List<T> objs) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException{
    	int result=-1;
    	String sql1=null;
    	if(objs.size()>0 && objs!=null){
    		T t = objs.get(0);
    		Class<?> clazz = t.getClass();  //根据对象获取class类
            StringBuffer sql =new StringBuffer("INSERT INTO `" + getClassName(clazz) + "`");//根据class类获取类名称
            StringBuffer values =new StringBuffer("VALUES(");
            Field[] fields = clazz.getDeclaredFields();   //获取所有的属性类
            List<Object> list = new ArrayList<>();
            boolean flag=true;
                for (int i = 0 ; i<fields.length ; i++) {
                    String methodName = getGetter(fields[i].getName()); //根据数据类获取属性名称，获取get方法名称
                    Method method = clazz.getDeclaredMethod(methodName);    //根据get方法名称获取方法对象
                    Object obj = method.invoke(t);
                    if (obj != null) {
                        if(flag){
                            values.append("?");
                            sql.append("(");
                            sql.append("`" + fields[i].getName() + "`");
                            list.add(obj);
                            flag=false;
                        }else {
                            values.append(",?");
                            sql.append(",`"+fields[i].getName() +"`");
                            list.add(obj);
                        }
                    }
                }
                if (list.size()> 0) {
                    sql.append(")");
                    sql.append(")");
                    sql1=sql.toString()+values.toString();
                }else {
                    throw new RuntimeException("传入的对象属性值都为空");
                }
    	}
    	for(T t : objs){
    		
    	}
    	
    	return result;
    }



    /**
     * 根据对象向数据库插入数据
     * @param t
     * @return
     */
    public <T>int insert(T t) throws SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = t.getClass();  //根据对象获取class类
        String sql1=null;
        StringBuffer sql =new StringBuffer("INSERT INTO `" + getClassName(clazz) + "`");//根据class类获取类名称
        StringBuffer values =new StringBuffer("VALUES(");
        Field[] fields = clazz.getDeclaredFields();   //获取所有的属性类
        List<Object> list = new ArrayList<>();
        boolean flag=true;
            for (int i = 0 ; i<fields.length ; i++) {
                String methodName = getGetter(fields[i].getName()); //根据数据类获取属性名称，获取get方法名称
                Method method = clazz.getDeclaredMethod(methodName);    //根据get方法名称获取方法对象
                Object obj = method.invoke(t);
                if (obj != null) {
                    if(flag){
                        values.append("?");
                        sql.append("(");
                        sql.append("`" + fields[i].getName() + "`");
                        list.add(obj);
                        flag=false;
                    }else {
                        values.append(",?");
                        sql.append(",`"+fields[i].getName() +"`");
                        list.add(obj);
                    }
                }
            }
            if (list.size()> 0) {
                sql.append(")");
                values.append(")");
                sql1=sql.toString()+values.toString();
            }else {
                throw new RuntimeException("传入的对象属性值都为空");
            }
            return executeUpdate(sql1, list.toArray());
    }



    /**
     *根据对象的主键进行修改
     * @param t 传入的对象
     * @param <T>
     * @return  受影响的行数
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws SQLException
     * @throws NoSuchFieldException
     */
    public <T> int update(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, SQLException, NoSuchFieldException {
        Class clazz = t.getClass();
        String tableName =getClassName(clazz);
        List<Object> list = new ArrayList<>();
        boolean flag = true;
        StringBuffer sql = new StringBuffer("update " + tableName +" set ");
        String primaryKey = getPrimaryKey(tableName);
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String methodName = getGetter(fieldName);
            Method method = clazz.getDeclaredMethod(methodName);
            Object obj = method.invoke(t);
            if (obj != null) {
                if (flag) {
                    sql.append(fieldName+"=? ");
                    flag=false;
                }else{
                    sql.append(","+fieldName+"=? ");
                }
                list.add(obj);
            }
        }
        Field primary = clazz.getDeclaredField(primaryKey);
        Method primaryKeyMethod = clazz.getDeclaredMethod(getGetter(primaryKey));
        Object primaryKeyValue = primaryKeyMethod.invoke(t);
        list.add(primaryKeyValue);
        sql.append(" where "+primaryKey+"=?");
        return executeUpdate(sql.toString(),list.toArray());
    }






    /**
     * 通过class对象获取类名
     * @param clazz class对象
     * @param <T>
     * @return  类名
     */
    public <T>String getClassName(Class<T> clazz){
        return clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
    }

    /**
     * 获取表的主键字段名称
     * @param table
     * @return
     * @throws SQLException
     */
    public static String getPrimaryKey(String table) throws SQLException {
        DatabaseMetaData databaseMetaData = JNDIJdbcUtil.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getPrimaryKeys(null,null,table);
        rs.next();
        return rs.getString("COLUMN_NAME");
    }

    /**
     * 获取到实体类的主键属性
     * @param clazz 查找的实体类
     * @return
     */
    public String getPrimaryKey(Class clazz){
        String primaryKey =null ;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] as = field.getAnnotations();
            for (Annotation a : as) {
                String aName = a.annotationType().getSimpleName();
                if("PrimaryKey".equals(aName)){
                    primaryKey = field.getName();
                    break;
                }
            }
        }
        return  primaryKey;
    }

    /**
     * 传入对象查找该实体对象的主键
     * @param t
     * @param <T>
     * @return
     */
    public <T>String getPrimaryKey(T t){
        Class<T> clazz= (Class<T>) t.getClass();
        return getPrimaryKey(clazz);
    }


    public PreparedStatement getStatement(String sql ,Object ... params) throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        if (params != null && params.length > 0) {
            for (int i =0 ;i <params.length ;i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        return pstmt;
    }
    
    /**
     * 增删改操作
     * @param sql SQL语句字符串
     * @param params 参数字符串数组
     * @return 执行结果
     */
    public int executeUpdate(String sql,Object...params) throws SQLException {
        PreparedStatement pstmt = getStatement(sql, params);
        return pstmt.executeUpdate();
    }



    /**
     * 通过对象查询对象集合
     * @param t 查找的对象
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public <T>List<T> select(T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, SQLException, InstantiationException {
        Class<T> clazz = (Class<T>) t.getClass();
        String tableName = getClassName(clazz);
        StringBuffer sql = new StringBuffer("SELECT * FROM "+tableName);
        StringBuffer condition = new StringBuffer(" where ");
        boolean flag = true; //判断是否是第一个参数
        List<Object> list = new ArrayList<Object>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String methodName = getGetter(field.getName());
            Method method = clazz.getDeclaredMethod(methodName);
            Object object = method.invoke(t);
            if (object != null && !"".equals(object)) {
                if (flag) {
                    condition.append(field.getName()+"=?");
                    flag=false;
                }else {
                    condition.append(" and "+field.getName()+"=?");
                }
                list.add(object);
            }
        }
        if (list != null && list.size() > 0) {
            sql.append(condition);
        }

        return select(clazz,sql.toString(),list.toArray());
    }


    /**
     * 根据class对象和sql语句查找数据集合
     * @param clazz 查找class对象
     * @param sql   执行的sql语句
     * @param params    sql语句的参数
     * @param <T>
     * @return
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public <T>List<T> select(Class<T> clazz,String sql ,Object ... params) throws SQLException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<T> list = new ArrayList<T>();
        PreparedStatement pstmt = getStatement(sql, params);
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        while (rs.next()) {
            T t = clazz.newInstance();
            for (int i =0 ; i <columnCount ; i++) {
                String fieldName = resultSetMetaData.getColumnName(i + 1);  //获取到字段名称
                //通过字段名称获取到类的属性名称，属性名称获取到类的Setxxx方法对象
                Method method = clazz.getDeclaredMethod(getSetter(fieldName), clazz.getDeclaredField(fieldName).getType());
                method.invoke(t, rs.getObject(i + 1));
            }
            list.add(t);
        }
        return list;
    }

    /**
     * 查找一个对象
     * @param clazz 查找的对象类型
     * @param sql   执行的sql语句
     * @param obj   sql参数
     * @param <T>
     * @return
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public <T> T selectOne(Class<T> clazz , String sql,Object ... obj) throws SQLException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = clazz.newInstance();
        PreparedStatement pstmt = getStatement(sql,obj);
        ResultSet rs = pstmt.executeQuery();
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        if(rs.next()) {
        	int columnCount = resultSetMetaData.getColumnCount();
            for (int i =0 ;i <columnCount ;i ++) {
                String fieldName = resultSetMetaData.getColumnName(i + 1);
                String methodName = getSetter(fieldName);
                Method method = clazz.getDeclaredMethod(methodName, clazz.getDeclaredField(fieldName).getType());
                method.invoke(t, rs.getObject(i + 1));
            }
        }else {
        	return null;
        }
        JNDIJdbcUtil.closeAll(null, pstmt, rs);
        return t;
    }

    /**
     * 根据用户对象的主键查找对象
     * @param t 用户对象
     * @param <T>
     * @return
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> T selectOne(T t) throws SQLException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<T> clazz = (Class<T>) t.getClass();
        String tableName = getClassName(clazz);
        String primaryKey = getPrimaryKey(tableName);
        String methodName = getGetter(primaryKey);
        Method method = clazz.getDeclaredMethod(methodName);
        Object obj = method.invoke(t);
        StringBuffer sql = new StringBuffer("SELECT * FROM " + tableName +" where "+primaryKey+"= ?");
        return selectOne(clazz, sql.toString(),obj);
    }

    /**
     * 查找单个对象
     * @param clazz 查找的对象的类
     * @param key   查找对象的主键值
     * @param <T>
     * @return
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public <T> T selectOne(Class<T> clazz, Object key) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String tableName = getClassName(clazz);
        String primaryKey = getPrimaryKey(tableName);
        StringBuffer sql = new StringBuffer("SELECT * FROM " + tableName +" where "+primaryKey+"= ?");
        return selectOne(clazz, sql.toString(),key);
    }

}
