package com.ycyl.edu.util;

import javax.servlet.http.HttpServletRequest;

public class DatagridSort {
	
	public static String getSortStr(HttpServletRequest request){
		String retStr="";
		String column = request.getParameter("sort");
		String sort =   request.getParameter("order");
		if (column!=null && sort!=null){
			retStr = " order by "+ column+" "+sort;
		}
		return retStr;
	}

}
