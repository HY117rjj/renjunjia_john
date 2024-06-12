package com.ycyl.edu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期处理工具类
 * @date 2013-4-1 下午5:54:55 
 * @version V1.0
 */
public class DateUtil {
	
	/**
	 * 按照yyyy-MM-dd的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static String date2Str(Date date){
		return date2Str(date,"yyyy-MM-dd");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String dateTime2Str(Date date){
		return date2Str(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 按照参数format的格式，日期转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date==null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
	}
	
	/**
	 * 按照传入的format格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date,String format){
		if(StringUtils.isNotEmpty(date)){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return new Date();
		}else{
			return null;
		}
	}
	
	/**
	 * 按照yyyy-MM-dd的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2Date(String date){
		return str2Date(date,"yyyy-MM-dd");
	}
	
	/**
	 * 按照yyyy-MM-dd的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2LocalDate(String date){
		return str2Date(date,"yyyy-MM-dd hh:mm");
	}
	
	/**
	 * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
	 * @param date
	 * @return
	 */
	public static Date str2DateTime(String date){
		return str2Date(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取当月第一天   
	 * @return yyyy-MM-dd
	 */
    public static String getFirstDayOfMonth(){ 
       Calendar lastDate = Calendar.getInstance();   
       lastDate.set(Calendar.DATE,1);//设为当前月的1号   
       return date2Str(lastDate.getTime());     
    }
    
    /**
	 * 获取当月最后一天
	 * @return yyyy-MM-dd
	 */
    public static String getLastDayOfMonth(){ 
    	GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.DATE, gc.getActualMaximum(Calendar.DAY_OF_MONTH));
		return date2Str(gc.getTime(),"yyyy-MM-dd");   
    }   
    
    /**
     * 获取当天的日期   
     * @return 返回yyyy-MM-dd格式的日期字符串
     */
    public static String getCurrentDate(){   
    	return date2Str(new Date(),"yyyy-MM-dd");
    }
    
    /**
     * 获取当天的日期和时间   
     * @return 返回yyyy-MM-dd HH:mm:ss格式的日期字符串
     */
    public static String getCurrentDateAndTime(){
         return dateTime2Str(new Date());   
    }
    
    /**
     * 获取当天的日期和时间   
     * @return 返回yyyy-MM-dd HH:mm:ss.SSS格式的日期字符串
     */
    public static String getCurrentDateAndTimeSSS(){
         return date2Str(new Date(),"yyyy-MM-dd HH:mm:ss.SSS");   
    }
    
    /**
     * 获取下月的第一天
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfNextMonth(){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
    	c.set(Calendar.DATE,1);
    	return date2Str(c.getTime());
    }
    
    /**
     * 获取上月的第一天
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfPreMonth(){
    	return getFirstDayOfPreMonth(new Date());
    }
    
    /**
     * 获取上月的第一天
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfPreMonth(Date date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
    	c.set(Calendar.DATE,1);
    	return date2Str(c.getTime());
    }
    
    /**
     * 获取上月的第一天
     * @return yyyy-MM-dd
     */
    public static String getFirstDayOfPreMonth(String date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(str2Date(date));
    	c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
    	c.set(Calendar.DATE,1);
    	return date2Str(c.getTime());
    }
    
    /**
     * 获取上月的最后一天 
     * @return yyyy-MM-dd
     */
    public static String getLastDayOfPreMonth(){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
    	c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    	return date2Str(c.getTime());
    }
    
    /**
     * 获取上月的最后一天 
     * @return yyyy-MM-dd
     */
    public static String getLastDayOfPreMonth(String date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(str2Date(date));
    	c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
    	c.set(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    	return date2Str(c.getTime());
    }
    
    /**
     * 获得去年同期的日期字符串
     * @param thisDay yyyy-MM-dd
     * @return yyyy-MM-dd
     * @throws ParseException
     */
    public static String getDayOfLastYear(String thisDay) throws ParseException {
		Date date=str2Date(thisDay);
		Calendar cal=new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -1);
		return date2Str(cal.getTime());
	}
    
    /**
     * 格式化日期，如果不是两位，拼‘0’
     * @param rq
     * @return
     */
	public static String getTwoDate(int rq) {
		String temp = "" + rq;
		if (rq > 0 && rq < 10)
			temp = "0" + rq;
		return temp;
	}
	
	/**
	 * 计算并返回两个日期之间的秒数 
	 * @param 开始日期d1
	 * @param 结束日期d2
	 * @return
	 */
	public static int subSecond(java.util.Date d1, java.util.Date d2) {
		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;
		return (int) ss;
	}

	/**
	 * 计算并返回两个日期之间的天数
	 * @param 开始日期d1
	 * @param 结束日期d2
	 * @return
	 */
	public static int subDate(java.util.Date d1, java.util.Date d2) {
		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;
		long ms = ss / 60;
		long hs = ms / 60;
		long ds = hs / 24;
		return (int) ds;
	}
	
	/**
	 * 计算并返回两个日期之间的分钟数
	 * @param 开始日期d1
	 * @param 结束日期d2
	 * @return
	 */
	public static int subDateMine(java.util.Date d1, java.util.Date d2) {
		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;
		long ms = ss / 60;
		return (int) ms;
	}
	
	/**
	 * 从服务器上取得当前日期并格式化
	 * 格式：2002年04月25日 星期四
	 * @return
	 */
	public static String getCnDate() {
		String[] week = new String[7];
		week[0] = "日";
		week[1] = "一";
		week[2] = "二";
		week[3] = "三";
		week[4] = "四";
		week[5] = "五";
		week[6] = "六";
		java.util.Date d1 = new java.util.Date();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.YEAR) + "年" + (gc.get(Calendar.MONTH) + 1) + "月"
				+ gc.get(Calendar.DAY_OF_MONTH) + "日 星期"
				+ week[gc.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY];
	}
	
	/**
	 * 计算并返回给定年月的最后一天
	 * @param year
	 * @param month
	 * @return yyyy-MM-dd
	 */
	public static String lastDateOfMonth(int year, int month) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(Calendar.YEAR, year);
		gc.set(Calendar.MONTH, month - 1);
		int maxDate = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
		gc.set(Calendar.DATE, maxDate);
		return date2Str(gc.getTime(),"yyyy-MM-dd");
	}

	/**
	 * 计算并返回日期中的星期几
	 * @param d1
	 * @return
	 */
	public static int weekOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 计算并返回日期中的日
	 * @param d1
	 * @return
	 */
	public static int dayOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 计算并返回日期中的月
	 * @param d1
	 * @return
	 */
	public static int monthOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.MONTH) ;
	}

	/**
	 * 计算并返回日期中的年
	 */
	public static int yearOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.YEAR);
	}

	/**
	 * 计算并返回日期中的时
	 * @param d1
	 * @return
	 */
	public static int hourOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 计算并返回日期中的分
	 * @param d1
	 * @return
	 */
	public static int minuteOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.MINUTE);
	}

	/**
	 * 计算并返回日期中的秒
	 * @param d1
	 * @return
	 */
	public static int secondOfDate(java.util.Date d1) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d1);
		return gc.get(Calendar.SECOND);
	}

	/**
	 * 计算数年后的日期
	 * @param 给定日期
	 * @param 给定的年数
	 * @return
	 */
	public static java.util.Date addDateByYear(java.util.Date d, int dcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.YEAR, dcount);
		return new java.util.Date(gc.getTime().getTime());
	}
	
	
	/**
	 * 计算数月后的日期
	 * @param d
	 * @param 给定的月数 mcount
	 * @return
	 */
	public static java.util.Date addDateByMonth(java.util.Date d, int mcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.MONTH, mcount);
		gc.add(Calendar.DATE, -1);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 * 计算数日后的日期
	 * @param d
	 * @param 给定的天数 dcount
	 * @return
	 */
	public static java.util.Date addDateByDay(java.util.Date d, int dcount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.DATE, dcount);
		return new java.util.Date(gc.getTime().getTime());
	}

	/**
	 * 计算数秒后的日期
	 * @param d
	 * @param 给定的秒数  scount
	 * @return
	 */
	public static java.util.Date addDateBySecond(java.util.Date d, int scount) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(d);
		gc.add(Calendar.SECOND, scount);
		return gc.getTime();
	}
	
	/**
	 * 获得当天指定的时间
	 * @param time
	 * @return java.util.Date
	 */
	public static Date getDateByTime(String time){
		String[] strs = time.split(":");
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(strs[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(strs[1]));
		calendar.set(Calendar.SECOND, Integer.parseInt(strs[2]));
		return calendar.getTime(); //第一次执行定时任务的时间
	}
	
	/**
	 * 获得当天指定的时间
	 * @return yyyy-MM-dd hh24:mi:ss
	 */
	public static String getDateStrByTime(String time){
		return dateTime2Str(getDateByTime(time));
	}
	
	public static String weekDate(int week){
		Date today = new Date();
		int dayOfWeek = DateUtil.weekOfDate(today)-1;// 6 星期五
		int addDay = 0;
		if(week >= dayOfWeek){
			addDay = week - dayOfWeek;
		}else{
			addDay = week - dayOfWeek + 7;
		}
		
		Date schedule = DateUtil.addDateByDay(today, addDay);
		
		return date2Str(schedule);
	}
	
	public static void main(String[] args) {
		Date weekAfterDay = DateUtil.addDateByDay(new Date(), 8);//下周+1天
		int dayOfWeek = DateUtil.weekOfDate(weekAfterDay)-1;// 6 星期五
		System.out.println(date2Str(weekAfterDay));
		System.out.println(dayOfWeek);
		System.out.println(str2LocalDate("2017-01-01 下午 1:30"));
	}
}
