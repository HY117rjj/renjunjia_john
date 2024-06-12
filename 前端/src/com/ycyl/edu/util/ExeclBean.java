package com.ycyl.edu.util;

public class ExeclBean {

	String name;
	
	private Integer colspan = 1;
	private Integer rowspan = 1;
	
	Integer leng = 15;
	
	String getterMethod;

	public ExeclBean(String name, String getterMethod) {
		super();
		this.name = name;
		this.getterMethod = getterMethod;
	}

	public ExeclBean(){
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLeng() {
		return leng;
	}

	public void setLeng(Integer leng) {
		this.leng = leng;
	}

	public String getGetterMethod() {
		return getterMethod;
	}

	public void setGetterMethod(String getterMethod) {
		this.getterMethod = getterMethod;
	}

	public Integer getColspan() {
		return colspan;
	}

	public void setColspan(Integer colspan) {
		this.colspan = colspan;
	}

	public Integer getRowspan() {
		return rowspan;
	}

	public void setRowspan(Integer rowspan) {
		this.rowspan = rowspan;
	}
	
	
}
