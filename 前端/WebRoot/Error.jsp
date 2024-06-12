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
		
		if(butt.value=="��ʾ������ϸ��Ϣ"){
			document.getElementById('error2').style.display='inline';
			butt.value="���ش�����ϸ��Ϣ";
		}else{
			document.getElementById('error2').style.display='none';
			butt.value="��ʾ������ϸ��Ϣ";
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
					<IMG src="<%= basePath %>images/error1.gif" align=left border=0 alt="������">
				</td>
				<td valign="middle" width="70%" align="left">
					���ܳɹ���ʾ�������ʵ�ҳ�棡�뼰ʱ֪ͨ����Ա��<br>
				</td>
			</tr>
		</table>
		
		
	</div>
	<br>
	<div class=add>
		
		<input type="button" value="��ʾ������ϸ��Ϣ" onclick="button_click();" id="butt" />
		<hr>
	</div>
	<div class=add id="error2" style="display: none;">
		<ul>
			<li>�ļ�����:<c:out value="${requestScope['javax.servlet.error.servlet_name']}" ></c:out></li>
			<li>��������:<c:out value="${requestScope['javax.servlet.error.exception'].class.name}" ></c:out></li>
			<li>ҳ����Դ:<c:out value="${requestScope['javax.servlet.error.request_uri']}" ></c:out></li>
			<li>������Ϣ:<c:out value="${requestScope['javax.servlet.error.exception'].message}" ></c:out></li>
			<li>������ϸ��Ϣ:</li>
		</ul>
	
		<pre><% exception.printStackTrace(new PrintWriter(out)); %></pre>
	</div>

		

	
	
	
	
</body>
</html>
