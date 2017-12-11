package cn.beautylady.util;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.beautylady.dao.BaseDao;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 王 on 2017/11/14.
 */
public class ExcelAction {
    private static final long serialVersionUID = 1L;

    public static final String RELACE=".0";
    public static final String SPACE="";

    private String fileName;
    private String suffix;
    private String uploadName;

    public String getUploadName() {
        return uploadName;
    }


    public void setUploadName(String uploadName) {
        this.uploadName = uploadName.trim();
    }

    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName.trim();
    }

	/*public String upload(){
		getResponse().setContentType("text/html; charset=utf-8");
		String message = null;
		if(fileName==null || "".equalsIgnoreCase(fileName)){
			message = "上传文件有误";
		}else if(uploadName==null || "".equalsIgnoreCase(uploadName)){
			message = "上传文件类型不能为空";
		}else{
			File file = getUploadFile();
			//这里确定传入excel是哪个实体类，并获取class文件
			if("userInfo".equalsIgnoreCase(uploadName)){
				Class<Userinfo> beanClass = Userinfo.class;
				message = readExcel(beanClass,file);
			}else if("cameraCode".equalsIgnoreCase(uploadName)){
				Class<CameraCode> beanClass = CameraCode.class;
				message = readExcel(beanClass,file);
			}else{
				message = "传入数据失败";
			}
		}
		writeText(message);
		return NONE;
	}  */


	/*private File getUploadFile() {
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) getRequest();
		File file = wrapper.getFiles("fileName")[0];
		fileName = wrapper.getFileNames("fileName")[0];
		suffix = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		int maxPostSize = 1000 * 1024 * 1024;
		if(file.length() > maxPostSize){
			String temStr = "上传文件大小超过限制。";
			writeText(temStr);
		}
		return file;
	} */


    //beanClass为封装的对象
    public <T> String  readExcel(File file) throws EncryptedDocumentException, InvalidFormatException, InvocationTargetException, IOException {
        try {
            InputStream in = new FileInputStream(file);
            boolean flag = false;
            if(".xls".equals(file.getName().substring(file.getName().lastIndexOf(".")))){
                Workbook hssfWorkbook= WorkbookFactory.create(in);
                //HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);  //获取excel工作簿
                //hssfWorkbook.getNumberOfSheets()获取工作簿的页数
                for (int numPage = 0; numPage < hssfWorkbook.getNumberOfSheets(); numPage++) {
                    HSSFSheet hssfSheet = (HSSFSheet) hssfWorkbook.getSheetAt(numPage);  //获取excel每一页，然后遍历每一页
                    String tableName = hssfSheet.getSheetName();
                    Class<T> beanClass = (Class<T>) Class.forName(ClassNameUtil.getClassName(tableName));
                    if(hssfSheet!=null){  	//判读是否为空
                        HSSFRow row = hssfSheet.getRow(0);  //获取第一个行
                        if(row!=null){
                            Field[] declaredFields = beanClass.getDeclaredFields();  //获取所有bean的属性
                            Method[] methods = beanClass.getMethods();  //获取所有的方法
                            //hssfSheet.getLastRowNum()获取当前的页的行数，然后遍历
                            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) { //行的遍历，每遍历一行生成一个对象
                                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                                if (hssfRow != null) {
                                    T newInstance = beanClass.newInstance();  //实例化要封装的对象
                                    //hssfRow.getLastCellNum()获取行的单元格的数量
                                    for (int i = 0; i < hssfRow.getLastCellNum(); i++) {  //列的遍历，对每一个对象的属性赋值
                                        String valueName = CellToString.getStringValueFromCell(row.getCell(i));
                                        String value = CellToString.getStringValueFromCell(hssfRow.getCell(i));
                                        for (Field field : declaredFields) {  //遍历javabean的每个属性
                                            if(valueName.equalsIgnoreCase(field.getName())){  //判断属性名是否等于
                                                String methodName = "set" + valueName.substring(0, 1).toUpperCase() + valueName.substring(1);
                                                String typeName = field.getType().getName();  //获取属相的类型名称
                                                Method method=null;
                                                try {
                                                    if("int".equalsIgnoreCase(typeName)){
                                                        method = beanClass.getMethod(methodName, int.class);
                                                        method.invoke(newInstance, Integer.parseInt(value));
                                                    }else if("java.lang.Integer".equalsIgnoreCase(typeName)){
                                                        method = beanClass.getMethod(methodName, Integer.class);
                                                        method.invoke(newInstance, Integer.valueOf(value));
                                                    }else if("boolean".equalsIgnoreCase(typeName)){
                                                        method = beanClass.getMethod(methodName, boolean.class);
                                                        method.invoke(newInstance, Boolean.parseBoolean(value));
                                                    }else if("java.lang.Boolean".equalsIgnoreCase(typeName)){
                                                        method = beanClass.getMethod(methodName, Boolean.class);
                                                        method.invoke(newInstance, Boolean.valueOf(value));
                                                    }else if("double".equalsIgnoreCase(typeName)){
                                                        method = beanClass.getMethod(methodName, double.class);
                                                        method.invoke(newInstance, Double.parseDouble(value));
                                                    }else if("java.lang.Double".equalsIgnoreCase(typeName)){
                                                        method = beanClass.getMethod(methodName, Double.class);
                                                        method.invoke(newInstance, Double.valueOf(value));
                                                    }else if("float".equalsIgnoreCase(typeName)){
                                                        //System.out.println("float");
                                                        method = beanClass.getMethod(methodName, float.class);
                                                        method.invoke(newInstance, Float.parseFloat(value));
                                                    }else if("java.lang.Float".equalsIgnoreCase(typeName)){
                                                        //System.out.println("Float");
                                                        method = beanClass.getMethod(methodName, Float.class);
                                                        method.invoke(newInstance, Float.valueOf(value));
                                                    }else{
                                                        //System.out.println("String");
                                                        method = beanClass.getMethod(methodName, String.class);
                                                        if("男".equalsIgnoreCase(value)){
                                                            value = "M";
                                                        }else if("女".equalsIgnoreCase(value)){
                                                            value = "F";
                                                        }
                                                        method.invoke(newInstance, value);
                                                    }
                                                } catch (NoSuchMethodException e) {
                                                    System.out.println(e);
                                                    return "导入失败";
                                                } catch (SecurityException e) {
                                                    System.out.println(e);
                                                    return "导入失败";
                                                } catch (IllegalArgumentException e) {
                                                    System.out.println(e);
                                                    return "导入失败";
                                                } catch (InvocationTargetException e) {
                                                    System.out.println(e);
                                                    return "导入失败";
                                                }

                                                break;
                                            }
                                        }
                                    }
                                    BaseDao dao = new BaseDao();
                                    dao.insertData(beanClass);
                                }
                            }

                        }
                    }

                }
                return "导入成功";
            }else if(".xlsx".equals(file.getName().substring(file.getName().lastIndexOf(".")))){
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
                if(xssfWorkbook!=null){
                    for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                        String tableName = xssfSheet.getSheetName();
                        Class<T> beanClass = (Class<T>) Class.forName(ClassNameUtil.getClassName(tableName));
                        if (xssfSheet != null) {
                            XSSFRow row = xssfSheet.getRow(0);
                            if(row!=null){
                                Field[] declaredFields = beanClass.getDeclaredFields();
                                Method[] methods = beanClass.getMethods();
                                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                                    if(xssfRow!=null){
                                        T newInstance = beanClass.newInstance();
                                        for (int i = 0; i < xssfRow.getLastCellNum(); i++) {
                                            String valueName = CellToString.getStringValueFromCell(row.getCell(i));
                                            String value = CellToString.getStringValueFromCell(xssfRow.getCell(i));
                                            for (Field field : declaredFields) {
                                                if(valueName.equalsIgnoreCase(field.getName())){
                                                    if(value==null || "".equals(value)){
                                                        break;
                                                    }else {
                                                        String methodName = "set" + valueName.substring(0, 1).toUpperCase() + valueName.substring(1);
                                                        String typeName = field.getType().getName();
                                                        Method method=null;
                                                        try {
                                                            if("int".equalsIgnoreCase(typeName)){
                                                                //System.out.println("int");
                                                                method = beanClass.getMethod(methodName, int.class);
                                                                method.invoke(newInstance, Integer.parseInt(value));
                                                            }else if("java.lang.Integer".equalsIgnoreCase(typeName)){
                                                                //System.out.println("Integer");
                                                                method = beanClass.getMethod(methodName, Integer.class);
                                                                method.invoke(newInstance, Integer.valueOf(value));
                                                            }else if("boolean".equalsIgnoreCase(typeName)){
                                                                ///System.out.println("boolean");
                                                                method = beanClass.getMethod(methodName, boolean.class);
                                                                method.invoke(newInstance, Boolean.parseBoolean(value));
                                                            }else if("java.lang.Boolean".equalsIgnoreCase(typeName)){
                                                                //System.out.println("Boolean");
                                                                method = beanClass.getMethod(methodName, Boolean.class);
                                                                method.invoke(newInstance, Boolean.valueOf(value));
                                                            }else if("double".equalsIgnoreCase(typeName)){
                                                                //System.out.println("double");
                                                                method = beanClass.getMethod(methodName, double.class);
                                                                method.invoke(newInstance, Double.parseDouble(value));
                                                            }else if("java.lang.Double".equalsIgnoreCase(typeName)){
                                                                //System.out.println("Double");
                                                                method = beanClass.getMethod(methodName, Double.class);
                                                                method.invoke(newInstance, Double.valueOf(value));
                                                            }else if("float".equalsIgnoreCase(typeName)){
                                                                //System.out.println("float");
                                                                method = beanClass.getMethod(methodName, float.class);
                                                                method.invoke(newInstance, Float.parseFloat(value));
                                                            }else if("java.lang.Float".equalsIgnoreCase(typeName)){
                                                                //System.out.println("Float");
                                                                method = beanClass.getMethod(methodName, Float.class);
                                                                method.invoke(newInstance, Float.valueOf(value));
                                                            }else{
                                                                //System.out.println("String");
                                                                method = beanClass.getMethod(methodName, String.class);
                                                                if("男".equalsIgnoreCase(value)){
                                                                    value = "M";
                                                                }else if("女".equalsIgnoreCase(value)){
                                                                    value = "F";
                                                                }
                                                                method.invoke(newInstance, value);
                                                            }
                                                        } catch (NoSuchMethodException e) {
                                                            System.out.println(e);
                                                            return "导入失败";
                                                        } catch (SecurityException e) {
                                                            System.out.println(e);
                                                            return "导入失败";
                                                        } catch (IllegalArgumentException e) {
                                                            System.out.println(e);
                                                            return "导入失败";
                                                        } catch (InvocationTargetException e) {
                                                            System.out.println(e);
                                                            return "导入失败";
                                                        }

                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        //这里判断实例化class是哪个实体类，这里可以设置一些特定不变，创建时间，之类的字段
                                        //这步主要是确定调用什么service来操作保存数据
                                        BaseDao dao = new BaseDao();
                                        dao.insertData(beanClass);
                                    }
                                }
                            }
                        }

                    }
                }
                return "导入成功";
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);;
            return "文件未找到";
        } catch (IOException e) {
            System.out.println(e);
            return "读取或写入失败";
        } catch (InstantiationException e) {
            System.out.println(e);
            return "实例失败";
        } catch (IllegalAccessException e) {
            System.out.println(e);
            return "非法";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "导入失败";
    }

}
