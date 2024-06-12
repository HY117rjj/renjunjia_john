package com.ycyl.edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection2 {

	private static Connection connection = null;
	private static String driver =  "oracle.jdbc.driver.OracleDriver";
	// private static String driver = "org.logicalcobwebs.proxool.ProxoolDriver";
	private static String url = "jdbc:oracle:thin:@11.0.0.30:1521/ycyl";
	private static String username = "ycyl";
	private static String password = "ycyl1120";
	
	/**
	 * 连接数据库
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 上午09:20:37 2012-8-16 
	 * @see com.JDBCConnection.source.util.JDBCConnection.java#getConnection()  
	 *
	 * @return java.sql.Connection
	 */
	public static Connection getConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			// connection = DriverManager.getConnection("proxool.ProxoolConf:"+driver+":"+url,username,password);
			// Attempt to refer to a unregistered pool by its alias 'ProxoolConf' 解决：http://blog.csdn.net/shishaomeng/article/details/4432750
			// - Shutting down 'ProxoolConf' pool immediately [Shutdown Hook] 解决：http://blog.csdn.net/chenyanbo/article/details/6436404
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 连接数据库
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 上午09:20:37 2012-8-16 
	 * @see com.JDBCConnection.source.util.JDBCConnection.java#getConnection()  
	 *
	 * @return java.sql.Connection
	 */
	public static Connection getConnection(String driver, String url, String username, String password) {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
			// connection = DriverManager.getConnection("proxool.ProxoolConf:"+driver+":"+url,username,password);
			// Attempt to refer to a unregistered pool by its alias 'ProxoolConf' 解决：http://blog.csdn.net/shishaomeng/article/details/4432750
			// - Shutting down 'ProxoolConf' pool immediately [Shutdown Hook] 解决：http://blog.csdn.net/chenyanbo/article/details/6436404
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭连接
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 上午09:21:11 2012-8-16
	 * @see com.JDBCConnection.source.util.JDBCConnection.java#close()
	 * 
	 * @param rs
	 *            java.sql.ResultSet
	 * @param stmt
	 *            java.sql.Statement
	 * @param conn
	 *            java.sql.Connection
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String queryBABase() {
		String str = "";
		String sql = "select banum from T_BA_BASE t"+  
				" where t.cytime >= to_date('2014-12-30 00:00:00', 'yyyy-mm-dd hh24:mi:ss')"+
				" and t.cytime <= to_date('2015-01-15 23:59:59', 'yyyy-mm-dd hh24:mi:ss')"+
				" and zzdm ='49557184-0' and ZZYMD is null"+
				" group by banum having sum(1)>=2";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Object[] objs = null;
		List<Object[]> baseList = new ArrayList<Object[]>();
		int count = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			conn = JDBCConnection2.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				objs = new Object[1];
				objs[0] = rs.getObject(1);
				baseList.add(objs);
			}
			for(Object[] obj : baseList){
				Object[] objs2 = null;
				List<Object[]> baseList2 = new ArrayList<Object[]>();
				String banum = obj[0].toString();
				String sql2 = "select to_char(cytime,'yyyy-mm-dd') from T_BA_BASE t where banum = '" + banum +
						"' and t.cytime >= to_date('2014-12-30 00:00:00', 'yyyy-mm-dd hh24:mi:ss')"+
				" and t.cytime <= to_date('2015-01-15 23:59:59', 'yyyy-mm-dd hh24:mi:ss')"+
				" and zzdm ='49557184-0' and ZZYMD is null order by cytime";
				pstmt = conn.prepareStatement(sql2);
				rs2 = pstmt.executeQuery();
				
				while(rs2.next()){
					objs2 = new Object[2];
					objs2[0] = rs2.getObject(1);
					
					baseList2.add(objs2);
				}
				
				for(int i = 0; i<baseList2.size()-1; i++){
					Date date1 = sdf.parse(baseList2.get(i)[0].toString());
					Date date2 = sdf.parse(baseList2.get(i+1)[0].toString());
					if(subDate(date1, date2)<=31){
						count++;
						System.out.println("病案号： " + banum +" 第 " + count + "条");
						System.out.println(baseList2.get(i)[0].toString()+" ：" + baseList2.get(i+1)[0].toString());
					}
				}
				
			}
			System.out.println("再住院例数：" + count);
			str = "操作成功！";
		} catch (Exception e) {
			e.printStackTrace();
			str = "操作失败！";
		} finally {
			JDBCConnection2.close(rs, pstmt, conn);
		}
		System.out.println("- 执行操作==>" + str);
		return str;
	}
	
	public String queryBABase2() {
		String str = "";
		String sql = "select banum,to_char(rytime,'yyyy-mm-dd'),to_char(cytime,'yyyy-mm-dd'),baidentity,zycs from T_BA_BASE t where "+
			" t.cytime >= to_date('2014-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss')"+
			" and t.cytime <= to_date('2014-12-31 23:59:59', 'yyyy-mm-dd hh24:mi:ss')"+
			" and zzdm ='49557184-0' and ZZYMD is null and banum in " +
			"(select banum from T_BA_BASE t"+  
			" where t.cytime >= to_date('2014-01-01 00:00:00', 'yyyy-mm-dd hh24:mi:ss')"+
			" and t.cytime <= to_date('2014-12-31 23:59:59', 'yyyy-mm-dd hh24:mi:ss')"+
			" and zzdm ='49557184-0' and ZZYMD is null"+
			" group by banum having sum(1)>=2)"+
			" order by banum,zycs";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Object[] objs = null;
		List<Object[]> baseList = new ArrayList<Object[]>();;
		Map<String, List<Object[]>> map = new HashMap<String, List<Object[]>>();
		int count = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			conn = JDBCConnection2.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("执行SQL: "+sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				objs = new Object[5];
				objs[0] = rs.getObject(1);
				objs[1] = rs.getObject(2);
				objs[2] = rs.getObject(3);
				objs[3] = rs.getObject(4);
				objs[4] = rs.getObject(5);
				if(map.get(objs[0].toString()) == null){
					baseList = new ArrayList<Object[]>();
					baseList.add(objs);
					map.put(objs[0].toString(), baseList);
				}else{
					baseList.add(objs);
				}
			}
			Object s[] = map.keySet().toArray();
			for(int i = 0; i < map.size(); i++) {
				List<Object[]> baseList2 = map.get(s[i]);
				
				for(int j = 0; j<baseList2.size()-1; j++){
					Date date1 = sdf.parse(baseList2.get(j)[2].toString());
					Date date2 = sdf.parse(baseList2.get(j+1)[1].toString());
					
					if(subDate(date1, date2)<1){
						count++;
						System.out.println("病案号： " + s[i] +" 第 " + count + "条");
						System.out.println("标识码："+baseList2.get(j)[3].toString()+"  出院日期："+baseList2.get(j)[2].toString()+" || 下次住院标识码："+baseList2.get(j+1)[3].toString()+ "  下次住院日期：" + baseList2.get(j+1)[1].toString());
						System.out.println("天数："+subDate(date1, date2));
					}
				}
				
			}
			System.out.println("再住院例数：" + count);
			str = "操作成功！";
		} catch (Exception e) {
			e.printStackTrace();
			str = "操作失败！";
		} finally {
			JDBCConnection2.close(rs, pstmt, conn);
		}
		System.out.println("- 执行操作==>" + str);
		return str;
	}
	
	public int subDate(java.util.Date d1, java.util.Date d2) {
		long mss = d2.getTime() - d1.getTime();
		long ss = mss / 1000;
		long ms = ss / 60;
		long hs = ms / 60;
		long ds = hs / 24;
		return (int) ds;
	}
	
	public static void main(String[] args){
		JDBCConnection2 con = new JDBCConnection2();
		con.queryBABase2();
	}
}
