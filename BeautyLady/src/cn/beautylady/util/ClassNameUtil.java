package cn.beautylady.util;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 类名获取全路径
 * @author acsars
 *
 */
public class ClassNameUtil {
	private static SAXReader reader=new SAXReader();
    private static Document document;

    static {
        try {
            document = reader.read(ClassNameUtil.class.getResourceAsStream("/ClassName.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    public static String getClassName(String name){
        String className=null;
        Element root=document.getRootElement();
        List<Element> eles=root.elements("file-pattern");
        for(Element ele : eles){
            Element fileEle = ele.element("fileName");
            if(name.equalsIgnoreCase(fileEle.getText())){
                return className=fileEle.getParent().element("className").getText();
            }
        }
        return className;
    }
}
