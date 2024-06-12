package com.ycyl.edu.util;

import java.util.Map;

/**
 * 按照dwz需要的格式封装数据
 * 
 * 
 */
public class Json {
	public final static String STAE_CODE_SUCCESS = "200"; // 表示操作成功
	public final static String STAE_CODE_ERROR = "300"; // 表示操作失败
	private String statusCode; 
	private String message; // 提示框中的提示信息

	private Map<String, Object> param;
	
	private Object params;
		
	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	public Json(){}
	
	public Json(String code){
		this.statusCode = code;
	}
	
	public Json(String code,String msg){
		this.statusCode = code;
		this.message = msg;
	}

	public Map<String, Object> getParam() {
		return param;
	}

	public void setParam(Map<String, Object> param) {
		this.param = param;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
