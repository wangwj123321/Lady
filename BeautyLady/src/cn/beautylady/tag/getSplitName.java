package cn.beautylady.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class getSplitName extends SimpleTagSupport{
	private String strNo;	//要分割的字符串
	private String strName; 
	private String symbol;	//分割的字符
	private String varNo;	//分割后接受的变量
	private String varName;
	

	public String getStrNo() {
		return strNo;
	}


	public void setStrNo(String strNo) {
		this.strNo = strNo;
	}


	public String getStrName() {
		return strName;
	}


	public void setStrName(String strName) {
		this.strName = strName;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getVarNo() {
		return varNo;
	}


	public void setVarNo(String varNo) {
		this.varNo = varNo;
	}


	public String getVarName() {
		return varName;
	}


	public void setVarName(String varName) {
		this.varName = varName;
	}


	@Override
	public void doTag() throws JspException, IOException {
		String[] arrNo = strNo.split(symbol);
		String[] arrName = strName.split(symbol);
		if(arrNo!=null && arrNo.length>0 && arrName!=null && arrName.length>0 ) {
			for(int i=0 ; i < arrNo.length ;i++) {
				this.getJspContext().setAttribute(varNo, arrNo[i]);
				this.getJspContext().setAttribute(varName, arrName[i]);
				this.getJspBody().invoke(null);
			}
		}
	}
	
	
	
}
