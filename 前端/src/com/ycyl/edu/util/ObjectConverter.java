package com.ycyl.edu.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Title:中联佳裕科技（北京） DRIVER 1.0
 * @Copyright: Copyright (c) 2011
 * @Company: 中联佳裕科技（北京）有限公司
 *
 * @ClassName: ObjectConverter 
 * @Description: 该类提供一系列的类型装换，将各种数据类型转为String 
 * 该类的获取方式  ObjectConverter oc = ObjectConverter.getInstance();
 * @author KAY E-mail: gaochangkai@21cn.com
 * @version Created on: 下午02:45:15 2015-7-6 
 * @see com.ycyl.edu.util.ObjectConverter.java
 *
 */
public class ObjectConverter {

	private static ObjectConverter instance = null;

	/**
	 * 单例方法，获取当前类的实例
	 * 
	 * @return 当前类的实例对象
	 */
	public static ObjectConverter getInstance() {
		if (null == instance) {
			instance = new ObjectConverter();
		}
		return instance;
	}

	/**
	 * 私有的构造方法
	 */
	private ObjectConverter() {
	}

	/**
	 * 将Byte/byte类型转成String，如果Byte/byte为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertByteToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将int类型转成String，如果int为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertIntToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将char类型转成String，如果char为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertCharToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将Long/long类型转成String，如果Long/long为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertLongToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将Short/short类型转成String，如果Short/short为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertShortToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将Double/double类型转成String，如果Double/double为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertDoubleToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将BigDecimal类型转成String，如果BigDecimal为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertBigDecimalToString(Object obj) 
	{
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}
	
	/**
	 * 将Float/float类型转成String，如果Float/float 为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertFloatToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将Byte类型转成String，如果Byte为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertBooleanToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		} else {
			return Boolean.valueOf(String.valueOf(obj)) ? "是" : "否";
		}
	}

	/**
	 * 将Integer类型转成String，如果Integer为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertIntegerToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将Character类型转成String，如果Character为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertCharacterToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将String类型转成String，如果String为null,则返回"空"
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertStringToString(Object obj) {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将TimeStamp类型转成String，如果TimeStamp为null,则返回"空"， 如果时分秒都为0的话，将 00:00:00 去掉。
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertTimestampToString(Object obj) throws Exception {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		} else {
			Timestamp ts = (Timestamp) obj;
			String tsStr = null;

			try {
				tsStr = ValueConvert.convertTimestampToString(ts, false);
				if (ValueCheck.isEqualString(tsStr.substring(11), "00:00:00")) {
					return tsStr.substring(0, 10);
				}
			} catch (Exception e) {
				tsStr = String.valueOf(obj);
				throw e;
			}
			return tsStr;
		}
	}

	/**
	 * 将Date类型转成String，如果Date为null,则返回"空"， 如果时分秒都为0的话，将 00:00:00 去掉。
	 * 
	 * @param obj
	 *            Object 对象
	 * @return 转换后的String
	 */
	public String convertDateToString(Object obj) throws Exception {
		if (ValueCheck.isNullOrEmpty(String.valueOf(obj))) {
			return "";
		} else {
			Date date = (Date) obj;
			String dateStr = null;
			try {
				dateStr = ValueConvert.convertDateToString(date, false);
				if (ValueCheck.isEqualString(dateStr.substring(11), "00:00:00")) {
					return dateStr.substring(0, 10);
				}
			} catch (Exception e) {
				dateStr = String.valueOf(obj);
				throw e;
			}
			return dateStr;
		}
	}
	
	
	
	public Byte convertStringToByte(Object obj) {
		
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Byte.valueOf(String.valueOf(obj));
		
	}


	public Integer convertStringToInt(Object obj) {
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Integer.parseInt(String.valueOf(obj));
	}



	public Long convertStringToLong(Object obj) {
		
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Long.parseLong(String.valueOf(obj));
	}


	public Short convertStringToShort(Object obj) {
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Short.parseShort(String.valueOf(obj));
	}

	
	public Double convertStringToDouble(Object obj) {
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Double.parseDouble(String.valueOf(obj));
	}

	
	public Float convertStringToFloat(Object obj) {
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Float.parseFloat(String.valueOf(obj));
	}

	
	public Boolean convertStringToBoolean(Object obj) {
		
		Boolean flag = false;
		
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			flag = null;
		}
		
		if(ValueCheck.isEqualString("1", obj.toString()) || ValueCheck.isEqualString("TRUE", obj.toString().toUpperCase()) || ValueCheck.isEqualString("是", obj.toString().trim()))
		{
			flag = true;
		}
		
		return flag;
	}

	
	public Integer convertStringToInteger(Object obj) {
		if(null == obj || ValueCheck.isNullOrEmpty(obj.toString()))
		{
			return null;
		}
		return Integer.parseInt(String.valueOf(obj));
		
	}
	
	
	public Timestamp convertStringToTimestamp(Object obj) throws Exception {
		if (null == obj || ValueCheck.isNullOrEmpty(obj.toString())) 
		{
			return null;
		} 
		else 
		{
			Timestamp ts = null;

			try 
			{
				String timestr = String.valueOf(obj);
				timestr = timestr.length()==10?timestr+" 00:00:00":timestr;
				ts = ValueConvert.convertStringToTimestamp(timestr, false); 
			} catch (Exception e) {
				throw e;
			}
			return ts;
		}
	}

	
	public Date convertStringToDate(Object obj) throws Exception {
		if (null == obj || ValueCheck.isNullOrEmpty(obj.toString())) 
		{
			return null;
		} 
		else 
		{
			Date date = null;
			try 
			{
				String timestr = String.valueOf(obj);
				timestr = timestr.length()==10?timestr+" 00:00:00":timestr;
				date = ValueConvert.convertStringToDate(timestr, false); 
			} catch (Exception e) {
				throw e;
			}
			return date;
		}
	}

}
