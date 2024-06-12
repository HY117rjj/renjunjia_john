package com.ycyl.edu.util;



/**
 * @Title:中联佳裕科技（北京） DRIVER 1.0
 * @Copyright: Copyright (c) 2014
 * @Company: 中联佳裕科技（北京）有限公司
 *
 * @ClassName: DateSqlUtil 
 * @Description: TODO
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 下午4:46:03 2015-7-30 
 * @see com.ycyl.edu.util.DateSqlUtil.java
 *
 */
public class DateSqlUtil {

	private static DateSqlUtil instance = null;

	/**
	 * 单例方法，获取当前类的实例
	 * 
	 * @return 当前类的实例对象
	 */
	public static DateSqlUtil getInstance() {
		if (null == instance) {
			instance = new DateSqlUtil();
		}
		return instance;
	}

	/**
	 * 私有的构造方法
	 */
	private DateSqlUtil() {
	}

	/**
	 * 返回Orcal形式的开始时间
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 下午4:51:21 2015-7-30
	 * @see com.ycyl.edu.util.DateSqlUtil.java#getStartDateStr()
	 * 
	 * @param start
	 *            开始时间
	 * @return
	 */
	public String getStartDateStr(String start){
		if(start.length() >=10){
			return "to_date('" + start.substring(0, 10) + " 00:00:00','yyyy-mm-dd hh24:mi:ss')";
		}
		return null;
	}
	
	/**
	 * 返回Orcal形式的结束时间
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 下午4:51:49 2015-7-30
	 * @see com.ycyl.edu.util.DateSqlUtil.java#getEndDateStr()
	 * 
	 * @param end
	 *            结束时间
	 * @return
	 */
	public String getEndDateStr(String end){
		if(end.length() >=10){
			return "to_date('" + end.substring(0, 10) + " 23:59:59','yyyy-mm-dd hh24:mi:ss')";
		}
		return null;
	}

}
