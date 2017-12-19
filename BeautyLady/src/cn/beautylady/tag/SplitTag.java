package cn.beautylady.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 将字符分割
 * @author 王
 *
 */
public class SplitTag extends SimpleTagSupport{
	
	private String str;	//要分割的字符串
	private String symbol;	//分割的字符
	private String var;	//分割后接受的变量
	private String index; //每次循环的下标，从0开始
	
	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public void doTag() throws JspException, IOException {
		String[] arr = str.split(symbol);
		if(str!=null && arr.length>0) {
			for(int i=0 ; i < arr.length ;i++) {
				this.getJspContext().setAttribute(index, i+"");
				this.getJspContext().setAttribute(var, arr[i]);
				this.getJspBody().invoke(null);
			}
		}
	}
	
	
	
	
	
	
}
