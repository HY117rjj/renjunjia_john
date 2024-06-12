<%@ page language="java" isELIgnored="false" pageEncoding="GBK" isErrorPage="true"%>
<jsp:directive.page import="java.io.PrintWriter"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	pageContext.setAttribute("basePath",basePath);
%>
<html>
<head>
	<link rel="stylesheet" href="<%= basePath %>common/css/httable.css" type="text/css">
	<script type="text/javascript">
	function button_click(){
		var butt = document.getElementById("butt");
		
		if(butt.value=="显示错误详细信息"){
			document.getElementById('error2').style.display='inline';
			butt.value="隐藏错误详细信息";
		}else{
			document.getElementById('error2').style.display='none';
			butt.value="显示错误详细信息";
		}
	}
	</script>
</head>
<body>
	
	<div class="add">
		<hr>
		<table class="tb" border=0 width="100%">
			<tr>
				<td width="20%" align="left">
					<IMG src="<%= basePath %>images/error1.gif" align=left border=0 alt="出错了">
				</td>
				<td valign="middle" width="70%" align="left">
					不能成功显示您所访问的页面！请及时通知管理员。<br>
				</td>
			</tr>
		</table>
		
		
	</div>
	<br>
	<div class=add>
		
		<input type="button" value="显示错误详细信息" onclick="button_click();" id="butt" />
		<hr>
	</div>
	<div class=add id="error2" style="display: none;">
		<ul>
			<li>文件类型:<c:out value="${requestScope['javax.servlet.error.servlet_name']}" ></c:out></li>
			<li>错误类型:<c:out value="${requestScope['javax.servlet.error.exception'].class.name}" ></c:out></li>
			<li>页面来源:<c:out value="${requestScope['javax.servlet.error.request_uri']}" ></c:out></li>
			<li>错误信息:<c:out value="${requestScope['javax.servlet.error.exception'].message}" ></c:out></li>
			<li>错误详细信息:</li>
		</ul>
	
		<pre><% exception.printStackTrace(new PrintWriter(out)); %></pre>
	</div>

		

	
	
	
	
</body>
</html>
