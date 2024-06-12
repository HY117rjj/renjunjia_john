package com.ycyl.edu.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class DocPrintUtil {
	
	@SuppressWarnings("all")
	public void printDoc(HttpServletRequest request, HttpServletResponse response, String fileName, 
			Map<String, Object> data, String templateName) throws Exception {
		String templateurl = templateName;

		Map inputData = formatData(data);
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		String templatePath = request.getSession().getServletContext().getRealPath("/");
		if ((templatePath == null) || (templatePath.equals(""))) {
			URL url = super.getClass().getResource("/");
			String templatePath_url = url.getFile();
			if ((templatePath_url != null) && (!"".equals(templatePath_url))) {
				templatePath_url = templatePath_url.replace("\\", "/");
				String separator = "/";
				int lastSlash = templatePath_url.lastIndexOf(separator);
				if (lastSlash == -1) {
					separator = "\\";
					lastSlash = templatePath_url.lastIndexOf(separator);
				}
				templatePath = templatePath_url.substring(0, lastSlash);
				templatePath = templatePath.substring(0, templatePath
						.lastIndexOf(separator));
				templatePath = templatePath.substring(0, templatePath
						.lastIndexOf(separator) + 1);
			}
		}
		templatePath = templatePath + "\\resource\\";
		OutputStream out = null;
		try {
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			String name = null;

			int k = templateName.lastIndexOf(".");
			if (k != -1) {
				name = templateName.substring(0, k) + ".doc";
				templateName = templateName.substring(0, k) + ".xml";
			} else {
				name = templateName + ".doc";
				templateName = templateName + ".xml";
			}

			if ((fileName != null) && (!"".equals(fileName))) {
				name = fileName + ".doc";
			}

			Template templet = null;
			templet = configuration.getTemplate(templateurl, "UTF-8");
			if (templet == null) {
				// throw new AppException("加载名称为" + templateurl + "的模板出错");
			}
			response.reset();
			response.setHeader("pragma", "no-cache");
			response.setDateHeader("Expires", 0L);
			response.setContentType("application/octet-stream;charset=GBK");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("GBK"), "ISO8859-1"));
			
			out = new BufferedOutputStream(response.getOutputStream());
			OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
			templet.process(inputData, writer);
			out.flush();
			out.close();
		} finally {
			if (out != null){
				out.close();
			}
		}
	}

	@SuppressWarnings("all")
	public void printExcel(HttpServletRequest request,
			HttpServletResponse response, String fileName,
			Map<String, Object> data, String templateName) throws Exception {
		String templateurl = templateName;

		Map inputData = formatData(data);
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");

		String templatePath = request.getSession().getServletContext().getRealPath("/");

		if ((templatePath == null) || (templatePath.equals(""))) {
			URL url = super.getClass().getResource("/");
			String templatePath_url = url.getFile();
			if ((templatePath_url != null) && (!"".equals(templatePath_url))) {
				templatePath_url = templatePath_url.replace("\\", "/");
				String separator = "/";
				int lastSlash = templatePath_url.lastIndexOf(separator);
				if (lastSlash == -1) {
					separator = "\\";
					lastSlash = templatePath_url.lastIndexOf(separator);
				}
				templatePath = templatePath_url.substring(0, lastSlash);
				templatePath = templatePath.substring(0, templatePath
						.lastIndexOf(separator));
				templatePath = templatePath.substring(0, templatePath
						.lastIndexOf(separator) + 1);
			}
		}
		templatePath = templatePath + "\\resource\\";
		OutputStream out = null;
		try {
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			String name = null;

			int k = templateName.lastIndexOf(".");
			if (k != -1) {
				name = templateName.substring(0, k) + ".xls";
				templateName = templateName.substring(0, k) + ".xml";
			} else {
				name = templateName + ".xls";
				templateName = templateName + ".xml";
			}

			if ((fileName != null) && (!"".equals(fileName))) {
				name = fileName + ".xls";
			}

			Template templet = null;
			templet = configuration.getTemplate(templateurl, "UTF-8");
			if (templet == null) {
				// throw new BusinessException("加载名称为" + templateurl + "的模板出错");
			}
			response.reset();

			response.setHeader("pragma", "no-cache");
			response.setDateHeader("Expires", 0L);
			response.setContentType("application/octet-stream;charset=GBK");
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(name.getBytes("GBK"), "ISO8859-1"));

			out = new BufferedOutputStream(response.getOutputStream());
			OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
			templet.process(inputData, writer);
			out.flush();
			out.close();
		} finally {
			if (out != null){
				out.close();
			}
		}
	}

	@SuppressWarnings("all")
	private Map<String, Object> formatData(Map<String, Object> input) throws Exception {
		Map out = new HashMap();
		for (Map.Entry en : input.entrySet()) {
			String key = (String) en.getKey();
			Object obj = en.getValue();
			String value = "";
			if (obj != null) {
				if (obj instanceof Collection) {
					List oldList = (List) obj;
					List newList = new ArrayList();
					for (int i = 0; i < oldList.size(); ++i) {
						Map oldData = PropertyUtils.describe(oldList.get(i));
						Map newData = new HashMap();
						Set keys = oldData.keySet();
						for (Iterator localIterator2 = keys.iterator(); localIterator2.hasNext();) {
							Object element = localIterator2.next();
							String oldKey = (String) element;
							String oldValue = (oldData.get(oldKey) != null) ? String.valueOf(oldData.get(oldKey)) : "";
							String newValue = oldValue.replace("<", "&lt;").replace(">", "&gt;");
							newData.put(oldKey, newValue);
						}
						newList.add(newData);
					}
					out.put(key, newList);
				} else {
					value = String.valueOf(obj);
					value = value.replace("<", "&lt;").replace(">", "&gt;");
					out.put(String.valueOf(key), value);
				}
			} else
				out.put(String.valueOf(key), "");
		}

		return out;
	}

	@SuppressWarnings("all")
	public Map<String, Object> buildMapByBean(Object bean) {
		Map result = new HashMap();
		Method[] methods = bean.getClass().getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			if ((methodName.indexOf("get") != 0) || (methodName.indexOf("getSerialVersionUID") != -1)){
				continue;
			}
			Object value = null;
			try {
				value = method.invoke(bean, null);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			result.put(methodName.substring(3).toLowerCase(), value);
		}
		return result;
	}
}