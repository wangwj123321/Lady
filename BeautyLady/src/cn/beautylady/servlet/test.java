package cn.beautylady.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test {
	static InputStream is = test.class.getClassLoader().getResourceAsStream("savePath.properties");
	public static void main(String[] args) {
    	Properties prop = new Properties();
    	try {
			prop.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String path = prop.getProperty("workspacePath");
    	System.out.println(path);
	}
}
