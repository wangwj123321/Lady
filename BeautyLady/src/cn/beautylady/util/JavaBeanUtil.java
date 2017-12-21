package cn.beautylady.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by 王 on 2017/11/30.
 */
public class JavaBeanUtil {

    public <T> T newInstance(Class clazz) {
        T t = null ;
        try {
            t = (T) clazz.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
    
    /**
     * 封装javabean对象
     * @param clazz	需要封装的对象
     * @param map	对象属性和值键
     * @return	
     */
    public static <T> T populate(Class<T> clazz, Map<String, String[]> map) {
        T t= null;
        try {
            t = (T) clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String methodName = getSetter(field.getName()); //获取set方法名
                String type = field.getType().getName();
                Method method = clazz.getMethod(methodName, field.getType());   //获取方法对象--field.getType数据类型
                String[] valus = map.get(field.getName());
                if (!"null".equals(valus[0]) && !"".equals(valus[0])) {
                    String value = valus[0];
                    Object obj = getObject(field.getType(), value);
                    method.invoke(t, obj);
                }

            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static String getSetter(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    public static String getGetter(String fieldName) {
        return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    public static <T>T getObject(Class<T> type, String value) {
        T t = null ;
        if ("java.lang.Integer".equals(type.getName())) {
            t = (T) new Integer(value);
        } else if ("java.lang.Float".equals(type.getName())) {
            t = (T) new Float(value);
        } else if ("java.lang.Double".equals(type.getName())) {
            t = (T) new Double(value);
        } else if("java.lang.Byte".equals(type.getName())){
            t = (T) new Byte(value);
        }else if("java.lang.Boolean".equals(type.getName())){
            t = (T) new Boolean(value);
        }else if("java.lang.Short".equals(type.getName())){
            t = (T) new Short(value);
        }else if("java.lang.Long".equals(type.getName())){
            t = (T) new Long(value);
        }else if("java.lang.Character".equals(type.getName())){
            t = (T) new Character(value.charAt(0));
        }else if("java.lang.String".equals(type.getName())){
            t = (T) new String(value);
        }else if("java.util.Date".equals(type.getName())){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                t = (T) format.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
