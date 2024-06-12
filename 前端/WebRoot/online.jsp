<%@ page import="com.ycyl.edu.bean.SessionInfo"%>
<%@ page import="com.ycyl.edu.bean.ApplicationConstants"%>
<%@ page language="java" import="java.util.*, java.text.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线人数</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/WEB-INF/jsp/common/meta.jsp"%>
	<%@include file="/WEB-INF/jsp/common/easyuiInc.jsp"%>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="padding:10px">
	服务器启动时间：<%=DateFormat.getDateTimeInstance().format(ApplicationConstants.START_DATE) %><br>
	累计共接待过：<%=ApplicationConstants.TOTAL_HISTORY_COUNT %> 访客
	<br> 同时在线人数：<%=ApplicationConstants.MAX_ONLINE_COUNT %>
	发生在：<%=DateFormat.getDateTimeInstance().format(ApplicationConstants.MAX_ONLINE_COUNT_DATE) %><br>
	目前在线人数：<%=ApplicationConstants.SESSION_MAP.size() %>
	登录用户：<%=ApplicationConstants.CURRENT_LOGIN_COUNT %>
	<table cellpadding="0" cellspacing="0" style="font-size:12px;color:#000099;" width="100%">
		<tr>
			<td class="title">SESSIONID</td>
			<td class="title">单位编码</td>
			<td class="title">科室编码</td>
			<td class="title">用户编码</td>
			<td class="title">用户名</td>
			<td class="title">登录时间</td>
			<td class="title">访问次数</td>
			<td class="title">IP</td>
		</tr>
		<%for(String id : ApplicationConstants.SESSION_MAP.keySet()){
            HttpSession sess = ApplicationConstants.SESSION_MAP.get(id);
            SessionInfo sessionInfo = (SessionInfo)sess.getAttribute("sessionInfo");
        %>
		<tr>
			<td class="input"><%=id %></td>
			<td class="input"><%=sessionInfo==null ? "&nbsp;" : sessionInfo.getDwmc() %></td>
			<td class="input"><%=sessionInfo==null ? "&nbsp;" : sessionInfo.getKsmc() %></td>
			<td class="input"><%=sessionInfo==null ? "&nbsp;" : sessionInfo.getLoginname() %></td>
			<td class="input"><%=sessionInfo==null ? "未登录" : sessionInfo.getName() %></td>
			<td class="input"><%=DateFormat.getDateTimeInstance().format(sess.getCreationTime()) %></td>
			<td class="input"><%=sess.getAttribute("activityTimes")==null ? "0" : sess.getAttribute("activityTimes") %></td>
			<td class="input"><%=sess.getAttribute("ip")  %></td>
		</tr>
		<%}%>
	</table>
    </div>
  </body>
</html>
