package com.ycyl.edu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PDF2SwfHelper {


	public static void execPdfToSwf(String pdfPath) {
		String SWFPath = PropUtil.getProperties("SWFPath");
		Process process = null;
		String cmd = "\"" + SWFPath + "\\pdf2swf.exe\" \"" + pdfPath + "\" -s flashversion=9 \"" + pdfPath + ".swf\"";
		System.out.println("cmd--->" + cmd);
		
		try {
			process = Runtime.getRuntime().exec(cmd);// 执行命令
			
			System.out.print(loadStream(process.getInputStream()));
			System.err.print(loadStream(process.getErrorStream()));
			System.out.print(loadStream(process.getInputStream()));
			int result = process.waitFor();
			if (result == 0) {
				try {
					// TODO:
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("cmd over!");
	}
	
	public static void main(String[] args){
		try {
			//System.out.println(Runtime.getRuntime().exec("cmd /c start c://swf.bat"));
			System.out.println("11");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		execPdfToSwf("D:\\ActivitiTomcat\\webapps\\oa\\upload\\winPlan\\201503201530571522746426268764261.pdf");
	}
	
	private static String loadStream(InputStream in) throws IOException {
		int ptr = 0;
		// 把InputStream字节流 替换为BufferedReader字符流
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder buffer = new StringBuilder();
		while ((ptr = reader.read()) != -1) {
			buffer.append((char) ptr);
		}
		return buffer.toString();
	}
}
