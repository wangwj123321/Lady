package cn.beautylady.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.beautylady.entity.Page;
import cn.beautylady.util.C3p0Utils;


/**
 * 数据库增删改查操作
 * @author acsars
 *
 */
public class BaseDao {
	private Connection conn = null;
	/**
	 * 数据增删改操作
	 * @param sql sql语句
	 * @param params 参数字符串数组
	 * @return 执行结果
	 */
	public int executeUpdate(String sql,Object...params) {
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
	}
	
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
			conn = C3p0Utils.getInstance().getConnection();
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
			C3p0Utils.releaseSources(conn, pstmt, rs);
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
		Connection conn = C3p0Utils.getInstance().getConnection();
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
		}
		return result;
	}
	/**
	 * 向数据库增加数据
	 * @param T 
	 * @return 执行结果
	 */
	public <T>int insertData(Class<T> clazz){
		String sql = "INSERT INTO '"+getClassName(clazz)+"'";
		String values = "VALUES(";
		Field[] fields = clazz.getDeclaredFields();//获取类的所有属性
		List<Object> list = new ArrayList<>();
		boolean flag = true;//判断是否第一次添加sql参数
		try {
			for (int i = 0; i < fields.length; i++) {
				String methodName = getGetter(fields[i].getName());//根据属性名获取get方法字符串
				Method method = clazz.getMethod(methodName);
				Object obj = method.invoke(clazz.newInstance());
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
	 */
	public <T>int delData(Class<T> clazz) {
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
	/**
	 * 获取对象的类名
	 * @param T 
	 * @return 类名
	 */
	public <T>String getClassName(Class<T> clazz) {
		return clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
		
	}

	public int getCount(String sql,Object...objs) {
		Connection conn = C3p0Utils.getInstance().getConnection();
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
		}
		return result;
	}
}
