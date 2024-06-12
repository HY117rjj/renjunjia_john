package com.ycyl.edu.util;

public class SimManagerUtil {

	
	public static String getSimManagerName(String simManager){
		if(StringUtil.isEmpyOrNull(simManager)){
			if("A".equals(simManager)){
				return "系统管理员";
			}else if("B".equals(simManager)){
				return "安全保密管理员";
			}else if("C".equals(simManager)){
				return "安全审计员";
			}else {
				return "用户";
			}
		}
		
		return "用户";
	}
}
