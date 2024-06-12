package com.ycyl.edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnection {

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
	 * @see com.zljy.source.util.JDBCConnection.java#getConnection()  
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
	 * @see com.zljy.source.util.JDBCConnection.java#getConnection()  
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
	 * @see com.zljy.source.util.JDBCConnection.java#close()
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

	/**
	 * 更新密码为DES密文
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 上午09:22:03 2012-8-16 
	 * @see com.zljy.source.util.JDBCConnection.java#updatePWDtoDES()  
	 *
	 * @return String类型
	 */
	public String updatePassWordtoDES() {
		String str = "";
		String sql = "select bm, pwd from GL_USERS";
		Boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Object[] users = null;
		List<Object[]> usersList = new ArrayList<Object[]>();

		try {
			conn = JDBCConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				users = new Object[2];
				users[0] = rs.getObject(1);
				users[1] = rs.getObject(2);
				usersList.add(users);
			}
			for(Object[] obj : usersList){
				String pwd = obj[1].toString();
				String enc = "";//DESUtil.encryption(pwd);
				String yhbm = obj[0].toString();
				String sql2 = "update GL_USERS set pwd = '" + enc + "' where bm = '" + yhbm + "'";
				pstmt = conn.prepareStatement(sql2);
				flag = pstmt.execute();
				System.out.println("- 把用户编码为：" + yhbm + " || 下的密码为：" + pwd + " || 加密为：" + enc + "！");
			}
			System.out.println("- 共加密【" + usersList.size() + "】条！");
			if(flag){
				str = "更新成功！";
			}else{
				str = "更新成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = "更新失败！";
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		System.out.println("- 执行操作==>" + str);
		return str;
	}
	
	public String updateBABase() {
		String str = "";
		String sql = "select BSM from T_BA_BASE_TEMP where BSM is not null and ZYZDBM is null";
		Boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Object[] objs = null;
		List<Object[]> baseList = new ArrayList<Object[]>();

		try {
			conn = JDBCConnection.getConnection();
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
				String bsm = obj[0].toString();
				String sql2 = "select ZDTYPE, JBZDBM from T_BNJBZD t where JBIDENTITY = '" + bsm +"'";
				pstmt = conn.prepareStatement(sql2);
				rs2 = pstmt.executeQuery();
				
				int i = 1;
				while(rs2.next()){
					objs2 = new Object[2];
					objs2[0] = rs2.getObject(1);
					objs2[1] = rs2.getObject(2);
					
					baseList2.add(objs2);
				}
				for(Object[] obj2 : baseList2){
					String zdType = obj2[0].toString();
					String jbzdbm = obj2[1].toString();
					String sql3 = "";
					String sql4 = "";
					if("1".equals(zdType) || "11".equals(zdType) || "12".equals(zdType)){
						sql3 = "update T_BA_BASE_TEMP t set MZZD = '" + jbzdbm + "' where BSM = '" + bsm +"'";
					}else if("22".equals(zdType)){
						sql3 = "update T_BA_BASE_TEMP t set ZYZDBM = '" + jbzdbm + "' where BSM = '" + bsm +"'";
						sql4 = "update T_BA_BASE_TEMP t set ZYZD = (select name_ from STDDISEASE_ where code_ = ZYZDBM) where BSM = '" + bsm +"'";
					}else if("23".equals(zdType)){
						sql3 = "update T_BA_BASE_TEMP t set QTZDBM"+i+" = '" + jbzdbm + "' where BSM = '" + bsm +"'";
						sql4 = "update T_BA_BASE_TEMP t set QTZD"+i+" = (select name_ from STDDISEASE_ where code_ = QTZDBM"+i+") where BSM = '" + bsm +"'";
						i++;
					}
					if(!"".equals(sql3) && i<5){
						pstmt = conn.prepareStatement(sql3);
						pstmt.executeUpdate();
					}
					if(!"".equals(sql4) && i<5){
						System.out.println("sql4: " + sql4);
						pstmt = conn.prepareStatement(sql4);
						pstmt.executeUpdate();
					}
				}
				
			}
			if(flag){
				str = "更新成功！";
			}else{
				str = "更新成功！";
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = "更新失败！";
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		System.out.println("- 执行操作==>" + str);
		return str;
	}
	
	public static void main(String[] args){
		JDBCConnection con = new JDBCConnection();
		con.updateBABase();
	}
}
