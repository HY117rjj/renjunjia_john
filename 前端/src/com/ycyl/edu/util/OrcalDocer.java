package com.ycyl.edu.util;

import java.awt.Color;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

/**
 * 数据库文档生成器 Orcal版
 * 
 * @author Eric zhou
 * 
 */
public class OrcalDocer  {
	// 键类型字典
	private static Map<String, String> keyType = new HashMap<String, String>();
	// 初始化jdbc
	static {
		try {
			keyType.put("1", "P");
			// keyType.put("C", "Check");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@11.0.0.30:1521/ycyl";// 链接url
	private static String username = "ycyl"; // 用户名.需要设置默认表空间哈
	private static String password = "ycyl1120"; // 密码
	//private static String schema = "ycyl"; // 目标数据库名
	// 查询所有表的sql语句
	private static String sql_get_all_tables = "select a.TABLE_NAME,b.COMMENTS from user_tables a,user_tab_comments b WHERE a.TABLE_NAME = b.TABLE_NAME and a.TABLE_NAME like 'STD%' and a.TABLE_NAME not in('T_BA_BASE_TEMP','T_BA_BASE_NULL','T_BA_JGCB_KSDZ') order by TABLE_NAME"; // 查询所有字段的sql语句
	private static String sql_get_all_columns = "select T1.column_name,T1.data_type,T1.data_length,(select max(constraint_type) from user_constraints x left join user_cons_columns y on x.constraint_name=y.constraint_name where x.table_name=t1.TABLE_NAME and y.COLUMN_NAME=T1.column_name),T1.NULLABLE,t2.comments from user_tab_cols t1, user_col_comments t2, user_tab_comments t3 where t1.TABLE_NAME=t2.table_name(+) and t1.COLUMN_NAME=t2.column_name(+) and t1.TABLE_NAME=t3.table_name(+)  and t1.TABLE_NAME='{table_name}' order by T1.COLUMN_ID";

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		// 初始化word文档
		Document document = new Document(PageSize.A4);
		RtfWriter2.getInstance(document, new FileOutputStream("E:/word.doc"));
		document.open();
		// 查询开始
		Connection conn = getConnection();
		// 获取所有表
		List tables = getDataBySQL(sql_get_all_tables, conn);
		int i = 1;
		for (Iterator iterator = tables.iterator(); iterator.hasNext();) {
			String[] arr = (String[]) iterator.next();
			// 循环获取字段信息
			System.out.print(i + ".正在处理数据表-----------" + arr[0]);
			addTableMetaData(document, arr, i);
			List columns = getDataBySQL(sql_get_all_columns.replace("{table_name}", arr[0]), conn);
			addTableDetail(document, columns);
			addBlank(document);
			System.out.println("...done");
			i++;
		}
		document.close();
		conn.close();
		
//		data.getClass().getMethod("setYwname1", String.class).invoke(data, "haha");
//		System.out.println(data.getYwname1());
		System.out.println("2016-01-23".substring(5,7));
	}

	/**
	 * 添加一个空行
	 * 
	 * @param document
	 * @throws Exception
	 */
	public static void addBlank(Document document) throws Exception {
		Paragraph ph = new Paragraph("");
		ph.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(ph);
		document.add(ph);
	}

	/**
	 * 添加包含字段详细信息的表格
	 * 
	 * @param document
	 * @param arr1
	 * @param columns
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public static void addTableDetail(Document document, List columns)
			throws Exception {
		Table table = new Table(7);
		table.setWidth(100f);
		table.setBorderWidth(1);
		table.setBorderColor(Color.BLACK);
		table.setPadding(0);
		table.setSpacing(0);
		Cell cell1 = new Cell("序号");// 单元格
		cell1.setHeader(true);

		Cell cell2 = new Cell("列名");// 单元格
		cell2.setHeader(true);

		Cell cell3 = new Cell("类型");// 单元格
		cell3.setHeader(true);

		Cell cell4 = new Cell("长度");// 单元格
		cell4.setHeader(true);
		
		Cell cell5 = new Cell("主键");// 单元格
		cell5.setHeader(true);

		Cell cell6 = new Cell("空");// 单元格
		cell6.setHeader(true);

		Cell cell7 = new Cell("说明");// 单元格
		cell7.setHeader(true);
		// 设置表头格式
		table.setWidths(new float[] { 8f, 30f, 15f, 10f, 8f, 10f, 29f });
		cell1.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell1.setBackgroundColor(Color.gray);
		cell2.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell2.setBackgroundColor(Color.gray);
		cell3.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell3.setBackgroundColor(Color.gray);
		cell4.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell4.setBackgroundColor(Color.gray);
		cell5.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell5.setBackgroundColor(Color.gray);
		cell6.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell6.setBackgroundColor(Color.gray);
		cell7.setHorizontalAlignment(Cell.ALIGN_CENTER);
		cell7.setBackgroundColor(Color.gray);
		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		table.addCell(cell6);
		table.addCell(cell7);
		table.endHeaders();// 表头结束
		int x = 1;
		for (Iterator iterator = columns.iterator(); iterator.hasNext();) {
			String[] arr2 = (String[]) iterator.next();
			Cell c1 = new Cell(x + "");
			Cell c2 = new Cell(arr2[0]);
			Cell c3 = new Cell(arr2[1]);
			Cell c4 = new Cell(arr2[2]);

			String key = keyType.get(arr2[3]);
			if (key == null)
				key = "N";
			Cell c5 = new Cell(key);
			Cell c6 = new Cell(arr2[4]);
			Cell c7 = new Cell(arr2[5]);
			c1.setHorizontalAlignment(Cell.ALIGN_CENTER);
			c2.setHorizontalAlignment(Cell.ALIGN_CENTER);
			c3.setHorizontalAlignment(Cell.ALIGN_CENTER);
			c4.setHorizontalAlignment(Cell.ALIGN_CENTER);
			c5.setHorizontalAlignment(Cell.ALIGN_CENTER);
			c6.setHorizontalAlignment(Cell.ALIGN_CENTER);
			c7.setHorizontalAlignment(Cell.ALIGN_CENTER);
			table.addCell(c1);
			table.addCell(c2);
			table.addCell(c3);
			table.addCell(c4);
			table.addCell(c5);
			table.addCell(c6);
			table.addCell(c7);
			x++;
		}
		document.add(table);
	}

	/**
	 * 增加表概要信息
	 * 
	 * @param dcument
	 * @param arr
	 * @param i
	 * @throws Exception
	 */
	public static void addTableMetaData(Document dcument, String[] arr, int i)
			throws Exception {
		Paragraph ph = new Paragraph(i + ". 表名: " + arr[0] + "        说明: "
				+ (arr[1] == null ? "" : arr[1]));
		ph.setAlignment(Paragraph.ALIGN_LEFT);
		dcument.add(ph);
	}

	/**
	 * 把SQL语句查询出列表
	 * 
	 * @param sql
	 * @param conn
	 * @return
	 */
	@SuppressWarnings("all")
	public static List getDataBySQL(String sql, Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String[] arr = new String[rs.getMetaData().getColumnCount()];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = rs.getString(i + 1);
				}
				list.add(arr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
