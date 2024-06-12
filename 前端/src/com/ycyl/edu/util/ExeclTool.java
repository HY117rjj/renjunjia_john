package com.ycyl.edu.util;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("all")
public class ExeclTool<T> {

	private static ExeclTool instance;

	private ExeclTool() {
		
	}

	// 单例
	public static ExeclTool getInstance() {
		if (null == instance)
			instance = new ExeclTool();
		return instance;
	}

	/**
	 * 导出方法
	 * 
	 * @param title
	 *            ：标题
	 * @param herders
	 *            封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds
	 *            ：数据源，实现了Collection接口的任意集合类
	 * @param out
	 *            ：OutputStream对象
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public void exportExecl(String title, List<ExeclBean> herders,
			Collection<T> ds, OutputStream out) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(title);

		sheet.setDefaultColumnWidth(15);

		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(getTitleStyle(workbook));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, herders.size() - 1));

		HSSFRow dateRow = sheet.createRow(1);
		if (herders.size() == 1) {
			HSSFCell dateCell = dateRow.createCell(0);
			dateCell.setCellValue("制单日期：" + Tool.stringOfCnDate());
		} else {
			dateRow.createCell(herders.size() - 2).setCellValue("制单日期：");
			dateRow.createCell(herders.size() - 1).setCellValue(Tool.stringOfCnDate());
		}

		HSSFRow row = sheet.createRow(2);

		HSSFCellStyle headerSytle = getHeaderStyle(workbook);

		HSSFCellStyle contentSyle = getContentStyle(workbook);

		// 循环表头，设置样式
		for (int i = 0; i < herders.size(); i++) {

			HSSFCell cell = row.createCell(i);

			cell.setCellStyle(headerSytle);

			HSSFRichTextString text = new HSSFRichTextString(herders.get(i).getName());

			cell.setCellValue(text);

		}

		Iterator<T> it = ds.iterator();

		int idx = 2;

		String getMethod = "";

		// 循环表体
		while (it.hasNext()) {
			idx++;

			row = sheet.createRow(idx);

			T t = it.next();

			Class tClass = t.getClass();

			String textValue = "";

			for (int i = 0; i < herders.size(); i++) {

				HSSFCell cell = row.createCell(i);

				cell.setCellStyle(contentSyle);

				getMethod = herders.get(i).getGetterMethod();

				// 通过反射得到get方法
				Method getter = tClass.getMethod(getMethod, null);

				// 通过反射执行get方法
				Object value = getter.invoke(t, null);

				if (null == value)
					value = "";

				// 处理日期类型值的显示方法
				if (value instanceof Date) {
					Date date = (Date) value;

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					textValue = sdf.format(date);
				} else {
					textValue = value.toString();
				}

				// 处理数字类型值的显示方法
				Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");

				Matcher matcher = p.matcher(textValue);

				if (!getter.getReturnType().getName().equals("java.lang.String") && matcher.matches()) {

					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(textValue));

				} else {

					HSSFRichTextString richString = new HSSFRichTextString(

					textValue);

					HSSFFont font3 = workbook.createFont();

					font3.setColor(HSSFColor.BLUE.index);

					richString.applyFont(font3);

					cell.setCellValue(richString);

				}
			}
		}
		// 向outputstream对象中输出
		workbook.write(out);
	}
	
	/**
	 * 导出方法
	 * 
	 * @param title
	 *            ：标题
	 * @param herders
	 *            封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds
	 *            ：数据源，实现了Collection接口的任意集合类
	 * @param out
	 *            ：OutputStream对象
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public void exportExecl(String title, List<ExeclBean> herders, Collection<T> ds, OutputStream out, HttpServletRequest request) throws Exception {
		String filePath = request.getSession().getServletContext().getRealPath("/")+"resource\\数据流调.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(title);

		sheet.setDefaultColumnWidth(15);

		XSSFRow titleRow = sheet.createRow(0);
		XSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(getTitleStyle(workbook));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, herders.size() - 1));

		XSSFRow dateRow = sheet.createRow(1);
		if (herders.size() == 1) {
			XSSFCell dateCell = dateRow.createCell(0);
			dateCell.setCellValue("报表日期：" + Tool.stringOfDate());
		} else {
			XSSFCell createCell = dateRow.createCell(herders.size() - 2);
			createCell.setCellValue("报表日期：");
			XSSFCellStyle createCellStyle = workbook.createCellStyle();
			createCellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
			createCell.setCellStyle(createCellStyle);
			dateRow.createCell(herders.size() - 1).setCellValue(Tool.stringOfDate());
		}

		XSSFRow row = sheet.createRow(2);

		XSSFCellStyle headerSytle = getHeaderStyle(workbook);

		XSSFCellStyle contentSyle = getContentStyle(workbook);

		// 循环表头，设置样式
		for (int i = 0; i < herders.size(); i++) {

			XSSFCell cell = row.createCell(i);

			cell.setCellStyle(headerSytle);

			XSSFRichTextString text = new XSSFRichTextString(herders.get(i).getName());

			cell.setCellValue(text);

		}

		Iterator<T> it = ds.iterator();

		int idx = 2;

		String getMethod = "";

		// 循环表体
		while (it.hasNext()) {
			idx++;

			row = sheet.createRow(idx);

			T t = it.next();

			Class tClass = t.getClass();

			String textValue = "";

			for (int i = 0; i < herders.size(); i++) {

				XSSFCell cell = row.createCell(i);

				cell.setCellStyle(contentSyle);

				getMethod = herders.get(i).getGetterMethod();

				// 通过反射得到get方法
				Method getter = tClass.getMethod(getMethod, null);

				// 通过反射执行get方法
				Object value = getter.invoke(t, null);

				if (null == value)
					value = "";

				// 处理日期类型值的显示方法
				if (value instanceof Date) {
					Date date = (Date) value;

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

					textValue = sdf.format(date);
				} else {
					textValue = value.toString();
				}

				// 处理数字类型值的显示方法
				Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");

				Matcher matcher = p.matcher(textValue);

				if (!getter.getReturnType().getName().equals("java.lang.String") && matcher.matches()) {

					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(textValue));

				} else {

					XSSFRichTextString richString = new XSSFRichTextString(textValue);

					XSSFFont font3 = workbook.createFont();

					font3.setColor(HSSFColor.BLUE.index);

					richString.applyFont(font3);

					cell.setCellValue(richString);

				}
			}
		}
		// 向outputstream对象中输出
//		workbook.write(new FileOutputStream(filePath));
		workbook.write(out);
		out.flush();
		out.close();
	}

	/**
	 * 导出方法
	 * 
	 * @param title
	 *            ：标题
	 * @param herders
	 *            封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds
	 *            ：数据源，实现了Collection接口的任意集合类
	 * @param out
	 *            ：OutputStream对象
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public void exportExecl(String title, List<ExeclBean> herders, Collection<T> ds, Map<String, String> others, OutputStream out) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet(title);

		sheet.setDefaultColumnWidth(15);

		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(getTitleStyle(workbook));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, herders.size() - 1));

		HSSFRow dateRow = sheet.createRow(1);
		if (herders.size() == 1) {
			HSSFCell dateCell = dateRow.createCell(0);
			dateCell.setCellValue("制表日期：" + Tool.stringOfCnDate());
		} else {
			dateRow.createCell(herders.size() - 2).setCellValue("制表日期：");
			dateRow.createCell(herders.size() - 1).setCellValue(Tool.stringOfCnDate());
		}

		HSSFRow row = sheet.createRow(2);

		HSSFCellStyle headerSytle = getHeaderStyle(workbook);

		HSSFCellStyle contentSyle = getContentStyle(workbook);

		// 循环表头，设置样式
		for (int i = 0; i < herders.size(); i++) {

			HSSFCell cell = row.createCell(i);

			cell.setCellStyle(headerSytle);

			HSSFRichTextString text = new HSSFRichTextString(herders.get(i).getName());

			cell.setCellValue(text);

		}

		Iterator<T> it = ds.iterator();

		int idx = 2;

		String getMethod = "";

		// 循环表体
		while (it.hasNext()) {
			
			idx++;

			row = sheet.createRow(idx);

			T t = it.next();

			Class tClass = t.getClass();

			String textValue = "";

			for (int i = 0; i < herders.size(); i++) {

				HSSFCell cell = row.createCell(i);

				cell.setCellStyle(contentSyle);

				getMethod = herders.get(i).getGetterMethod();

				// 通过反射得到get方法
				Method getter = tClass.getMethod(getMethod, null);
				// 通过反射执行get方法
				Object value = getter.invoke(t, null);

				if (null == value)
					value = "";

				// 处理日期类型值的显示方法
				if (value instanceof Date) {
					Date date = (Date) value;

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					textValue = sdf.format(date);
				} else {
					textValue = value.toString();
				}

				// 处理数字类型值的显示方法
				Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");

				Matcher matcher = p.matcher(textValue);

				if (!getter.getReturnType().getName().equals("java.lang.String") && matcher.matches()) {

					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(textValue));

				} else {

					HSSFRichTextString richString = new HSSFRichTextString(textValue);

					HSSFFont font3 = workbook.createFont();

					font3.setColor(HSSFColor.BLUE.index);

					richString.applyFont(font3);

					cell.setCellValue(richString);
				}
			}
		}

		idx++;
		
		Iterator<String> oit = others.keySet().iterator();
		
		while (oit.hasNext()) {
			
			idx++;
			String key = oit.next();
			String value = others.get(key);

			row = sheet.createRow(idx);
			HSSFCell keyCell = row.createCell(0);
			keyCell.setCellValue(key);
			HSSFCell valueCell = row.createCell(1);
			valueCell.setCellValue(value);

		}
		// 向outputstream对象中输出
		workbook.write(out);
	}

	/**
	 * 导出方法
	 * 
	 * @param title
	 *            ：标题
	 * @param herders
	 *            封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds
	 *            ：数据源，实现了Collection接口的任意集合类
	 * @param footers
	 *            ：表尾的说明
	 * @param out
	 *            ：OutputStream对象
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public void exportExecl(String title, List<ExeclBean> herders, Collection<T> ds, List<String> footers, OutputStream out) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet(title);

		sheet.setDefaultColumnWidth(15);

		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(getTitleStyle(workbook));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, herders.size() - 1));

		HSSFRow dateRow = sheet.createRow(1);
		if (herders.size() == 1) {
			HSSFCell dateCell = dateRow.createCell(0);
			dateCell.setCellValue("制表日期：" + Tool.stringOfCnDate());
		} else {
			dateRow.createCell(herders.size() - 2).setCellValue("制表日期：");
			dateRow.createCell(herders.size() - 1).setCellValue(Tool.stringOfCnDate());
		}

		HSSFRow row = sheet.createRow(2);

		HSSFCellStyle headerSytle = getHeaderStyle(workbook);

		HSSFCellStyle contentSyle = getContentStyle(workbook);

		HSSFCellStyle footerSyle = getFooterStyle(workbook);

		// 循环表头，设置样式
		for (int i = 0; i < herders.size(); i++) {

			HSSFCell cell = row.createCell(i);

			cell.setCellStyle(headerSytle);

			HSSFRichTextString text = new HSSFRichTextString(herders.get(i).getName());

			cell.setCellValue(text);

		}

		Iterator<T> it = ds.iterator();

		int idx = 2;

		String getMethod = "";

		// 循环表体
		while (it.hasNext()) {
			idx++;

			row = sheet.createRow(idx);

			T t = it.next();

			Class tClass = t.getClass();

			String textValue = "";

			for (int i = 0; i < herders.size(); i++) {

				HSSFCell cell = row.createCell(i);

				cell.setCellStyle(contentSyle);

				getMethod = herders.get(i).getGetterMethod();

				// 通过反射得到get方法
				Method getter = tClass.getMethod(getMethod, null);
				// 通过反射执行get方法
				Object value = getter.invoke(t, null);

				if (null == value)
					value = "";

				// 处理日期类型值的显示方法
				if (value instanceof Date) {
					Date date = (Date) value;

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					textValue = sdf.format(date);
				} else {
					textValue = value.toString();
				}

				// 处理数字类型值的显示方法
				Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");

				Matcher matcher = p.matcher(textValue);

				if (!getter.getReturnType().getName().equals("java.lang.String") && matcher.matches()) {

					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(textValue));

				} else {

					HSSFRichTextString richString = new HSSFRichTextString(

					textValue);

					HSSFFont font3 = workbook.createFont();

					font3.setColor(HSSFColor.BLUE.index);

					richString.applyFont(font3);

					cell.setCellValue(richString);
				}
			}
		}

		idx++;

		for (String footer : footers) {
			idx++;
			row = sheet.createRow(idx);
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(footer);
			cell.setCellStyle(footerSyle);
			// sheet.addMergedRegion(new CellRangeAddress(idx, idx, 0,
			// herders.size()-1));
		}
		// 向outputstream对象中输出
		workbook.write(out);
	}

	/**
	 * 导出方法
	 * 
	 * @param title
	 *            ：标题
	 * @param herders
	 *            封装了ExeclBean类的list，用于循环输出表头信息
	 * @param ds
	 *            ：数据源，实现了Collection接口的任意集合类
	 * @param footers
	 *            ：表尾的说明
	 * @param out
	 *            ：OutputStream对象
	 * @throws Exception
	 */
	@SuppressWarnings("all")
	public void exportExeclMultiHeader(String title, List<List<ExeclBean>> heads, Collection<T> ds, List<String> foots, OutputStream out) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(title);
		// sheet.setDefaultColumnWidth(15);
		int headLength = heads.get(heads.size() - 1).size();

		HSSFRow titleRow = sheet.createRow(0);// 标题
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue(title);
		titleCell.setCellStyle(getTitleStyle(workbook));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headLength - 1));

		HSSFRow dateRow = sheet.createRow(1);// 表格头的上一行
		if (headLength == 1) {
			HSSFCell dateCell = dateRow.createCell(0);
			dateCell.setCellValue("制表日期：" + Tool.stringOfCnDate());
		} else {
			dateRow.createCell(0).setCellValue("填报单位：");
			dateRow.createCell(headLength - 2).setCellValue("制表日期：");
			dateRow.createCell(headLength - 1).setCellValue(Tool.stringOfCnDate());
		}

		HSSFCellStyle headerSytle = getHeaderStyle(workbook);
		HSSFCellStyle contentSyle = getContentStyle(workbook);
		HSSFCellStyle footerSyle = getFooterStyle(workbook);

		for (int i = 0; i < heads.size(); i++) {
			HSSFRow headRow = sheet.createRow(i + 2);
			// 循环表头，设置样式
			int col = 0;
			for (int j = 0; j < headLength; j++) {// 循环遍历表头，设置边框，解决合并单元格后无边框问题
				HSSFCell cell = headRow.createCell(j);
				cell.setCellStyle(headerSytle);
				sheet.autoSizeColumn(j);// 宽度自适应
			}
			for (int j = 0; j < heads.get(i).size(); j++) {
				HSSFCell cell = headRow.createCell(col);
				cell.setCellStyle(headerSytle);
				ExeclBean execl = heads.get(i).get(j);
				HSSFRichTextString text = new HSSFRichTextString(execl.getName());
				cell.setCellValue(text);
				if (execl.getRowspan() > 1 || execl.getColspan() > 1) {
					CellRangeAddress cellRangeAddress = new CellRangeAddress(
							i + 2, i + 2 + execl.getRowspan() - 1, col, col + execl.getColspan() - 1);
					sheet.addMergedRegion(cellRangeAddress);
					// for (int ii = cellRangeAddress.getFirstRow(); ii <=
					// cellRangeAddress.getLastRow(); ii++){
					// HSSFRow tempRow = HSSFCellUtil.getRow(i, sheet);
					// for (int jj = cellRangeAddress.getFirstColumn(); jj <=
					// cellRangeAddress.getLastColumn(); jj++){
					// HSSFCell singleCell = HSSFCellUtil.getCell(tempRow,
					// (short)jj);
					// singleCell.setCellStyle(headerSytle);
					// }
					// }
				}
				// 确定下一列的下标
				col = execl.getColspan() > 0 ? col + execl.getColspan() : col + 1;
			}
		}

		Iterator<T> it = ds.iterator();
		int rowIndex = 1 + heads.size();
		String getMethod = "";

		// 循环表体
		while (it.hasNext()) {
			rowIndex++;
			HSSFRow detailRow = sheet.createRow(rowIndex);
			T t = it.next();
			Class tClass = t.getClass();
			String textValue = "";
			for (int i = 0; i < headLength; i++) {
				HSSFCell cell = detailRow.createCell(i);
				cell.setCellStyle(contentSyle);
				getMethod = heads.get(heads.size() - 1).get(i).getGetterMethod();

				// 通过反射得到get方法
				Method getter = tClass.getMethod(getMethod, null);
				// 通过反射执行get方法
				Object value = getter.invoke(t, null);
				if (null == value)
					value = "";

				// 处理日期类型值的显示方法
				if (value instanceof Date) {
					Date date = (Date) value;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					textValue = sdf.format(date);
				} else {
					textValue = value.toString();
				}

				// 处理数字类型值的显示方法
				Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
				Matcher matcher = p.matcher(textValue);
				if (!getter.getReturnType().getName().equals("java.lang.String") && matcher.matches()) {
					// 是数字当作double处理
					cell.setCellValue(Double.parseDouble(textValue));
				} else {
					HSSFRichTextString richString = new HSSFRichTextString(textValue);
					HSSFFont font3 = workbook.createFont();
					font3.setColor(HSSFColor.BLUE.index);
					richString.applyFont(font3);
					cell.setCellValue(richString);
				}
			}
		}

		rowIndex++;
		for (String footer : foots) {
			rowIndex++;
			HSSFRow footRow = sheet.createRow(rowIndex);
			HSSFCell cell = footRow.createCell(0);
			cell.setCellValue(footer);
			cell.setCellStyle(footerSyle);
			// sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0,
			// headLength-1));
		}
		// 向outputstream对象中输出
		workbook.write(out);
	}

	// 设置表头样式，可自定义
	public HSSFCellStyle getHeaderStyle(HSSFWorkbook workbook) {
		HSSFCellStyle style = workbook.createCellStyle();

		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);

		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(CellStyle.BORDER_THIN);

		style.setBorderLeft(CellStyle.BORDER_THIN);

		style.setBorderRight(CellStyle.BORDER_THIN);

		style.setBorderTop(CellStyle.BORDER_THIN);

		style.setAlignment(CellStyle.ALIGN_CENTER);

		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		HSSFFont font = workbook.createFont();

		font.setColor(HSSFColor.VIOLET.index);

		font.setFontHeightInPoints((short) 12);

		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		style.setFont(font);

		return style;
	}

	public HSSFCellStyle getTitleStyle(HSSFWorkbook workbook) {
		HSSFCellStyle style = workbook.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);

		HSSFFont font = workbook.createFont();

		font.setColor(HSSFColor.BLACK.index);

		font.setFontHeightInPoints((short) 16);

		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		style.setFont(font);

		return style;
	}

	// 设置表体样式，可自定义
	public HSSFCellStyle getContentStyle(HSSFWorkbook workbook) {
		HSSFCellStyle style2 = workbook.createCellStyle();

		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style2.setBorderBottom(CellStyle.BORDER_THIN);

		style2.setBorderLeft(CellStyle.BORDER_THIN);

		style2.setBorderRight(CellStyle.BORDER_THIN);

		style2.setBorderTop(CellStyle.BORDER_THIN);

		style2.setAlignment(CellStyle.ALIGN_CENTER);

		style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		HSSFFont font2 = workbook.createFont();

		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);

		style2.setFont(font2);

		return style2;
	}

	// 设置表体样式，可自定义
	public XSSFCellStyle getFooterStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style3 = workbook.createCellStyle();

		XSSFFont font3 = workbook.createFont();

		font3.setFontHeightInPoints((short) 11);

		font3.setBoldweight(Font.BOLDWEIGHT_NORMAL);

		style3.setFont(font3);

		return style3;
	}
	
	// 设置表头样式，可自定义
	public XSSFCellStyle getHeaderStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();

		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);

		style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(CellStyle.BORDER_THIN);

		style.setBorderLeft(CellStyle.BORDER_THIN);

		style.setBorderRight(CellStyle.BORDER_THIN);

		style.setBorderTop(CellStyle.BORDER_THIN);

		style.setAlignment(CellStyle.ALIGN_CENTER);

		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		XSSFFont font = workbook.createFont();

		font.setColor(HSSFColor.VIOLET.index);

		font.setFontHeightInPoints((short) 12);

		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		style.setFont(font);

		return style;
	}
	
	public XSSFCellStyle getTitleStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style = workbook.createCellStyle();

		style.setAlignment(CellStyle.ALIGN_CENTER);

		XSSFFont font = workbook.createFont();

		font.setColor(HSSFColor.BLACK.index);

		font.setFontHeightInPoints((short) 16);

		font.setBoldweight(Font.BOLDWEIGHT_BOLD);

		style.setFont(font);

		return style;
	}

	// 设置表体样式，可自定义
	public XSSFCellStyle getContentStyle(XSSFWorkbook workbook) {
		XSSFCellStyle style2 = workbook.createCellStyle();

		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);

		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);

		style2.setBorderBottom(CellStyle.BORDER_THIN);

		style2.setBorderLeft(CellStyle.BORDER_THIN);

		style2.setBorderRight(CellStyle.BORDER_THIN);

		style2.setBorderTop(CellStyle.BORDER_THIN);

		style2.setAlignment(CellStyle.ALIGN_CENTER);

		style2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

		XSSFFont font2 = workbook.createFont();

		font2.setBoldweight(Font.BOLDWEIGHT_NORMAL);

		style2.setFont(font2);

		return style2;
	}

	// 设置表体样式，可自定义
	public HSSFCellStyle getFooterStyle(HSSFWorkbook workbook) {
		HSSFCellStyle style3 = workbook.createCellStyle();

		HSSFFont font3 = workbook.createFont();

		font3.setFontHeightInPoints((short) 11);

		font3.setBoldweight(Font.BOLDWEIGHT_NORMAL);

		style3.setFont(font3);

		return style3;
	}
}
