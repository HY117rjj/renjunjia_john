<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html class="no-js fixed-layout">
  <head>
    <base href="<%=basePath%>">
    
    <title>课程实训系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<meta name="renderer" content="webkit">
  	<meta http-equiv="Cache-Control" content="no-siteapp" />
  	<link rel="icon" type="image/png" href="assets/i/favicon.png">
  	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  	<meta name="apple-mobile-web-app-title" content="课程实训系统" />
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.min.css"/>
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/amazeui.page.css">
  	<link rel="stylesheet" href="js/AmazeUI-2.7.2/assets/css/admin.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function delCaseMessage(id){
			var url = "${pageContext.request.contextPath }/case/removeCaseMessage.do?ajax=1&id="+id;
			$.get(url, function(json){
				if(json.statusCode==200){
					window.location.href="${pageContext.request.contextPath }/case/listMessage.do";
				}
			},'json');
		}
		
		function addCaseMessage(){
			window.location.href="${pageContext.request.contextPath }/case/editCaseMessage.do";
		}
		
		function editCaseMessage(id){
			window.location.href="${pageContext.request.contextPath }/case/editCaseMessage.do?id="+id;
		}
	</script>
  </head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar am-topbar-inverse admin-header">
  <div class="am-topbar-brand">
    <strong>课程实训系统</strong> <small> </small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:void(0);"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:void(0);">
          <span class="am-icon-users"></span> ${user.name } <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="./student/editPersonalData.do?id=${user.id }"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="./student/editPersonalData.do?id=${user.id }"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="./systemlogout.do"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <%@ include file="./admin_sidbar.jsp"%>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统管理</strong> / <small>案例分析与讨论</small></div>
      </div>

      <hr>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
          <div class="am-btn-toolbar">
            <div class="am-btn-group am-btn-group-xs">
            <!-- 
              <button type="button" class="am-btn am-btn-default" onclick="addTeacher();"><span class="am-icon-plus"></span> 新增</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 审核</button>
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
             
              <a class="am-btn am-btn-default" href="${pageContext.request.contextPath }/case/editCaseMessage.do"><span class="am-icon-plus"></span> 新增</a>
             -->
            </div>
          </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">
          <div class="am-form-group">
            <select data-am-selected="{btnSize: 'sm'}">
              <option value="option1">所有类别</option>
              <option value="option2">姓名</option>
              <option value="option3">身份证号</option>
            </select>
          </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">
          <div class="am-input-group am-input-group-sm">
            <input type="text" class="am-form-field">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
          </div>
        </div>
      </div>

      <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-id">ID</th>
               	<th class="table-type">姓名</th>
                <th class="table-date am-hide-sm-only">案例分析任务</th>
                <th class="table-author am-hide-sm-only">讨论人</th>
                <th class="table-author am-hide-sm-only">讨论内容</th>
                <th class="table-date am-hide-sm-only">讨论时间</th>
                <th class="table-set">操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${pd.rows }" var="pd">
              	<tr>
	            	<td>${pd.id }</td>
	                <td>${pd.name }</td>
	                <td class="am-hide-sm-only">${pd.caseContent }</td>
	                <td>${pd.messagerName }</td>
	                <td class="am-hide-sm-only">${pd.messageContent }</td>
	                <td class="am-hide-sm-only"><fmt:formatDate type="both" value="${pd.recordTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                <td>
	                  <div class="am-btn-toolbar">
	                    <div class="am-btn-group am-btn-group-xs">
	                      <c:if test="${user.name eq pd.messagerName}">
	                        <a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${pageContext.request.contextPath }/case/editCaseMessage.do?id=${pd.id }"><span class="am-icon-pencil-square-o"></span> 编辑</a>
	                        <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delCaseMessage('${pd.id }');"><span class="am-icon-trash-o"></span> 删除</button>
	                      </c:if>
	                      <c:if test="${user.name ne pd.messagerName}">
	                        <a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${pageContext.request.contextPath }/case/editCaseMessage.do?id=${pd.id }"><span class="am-icon-pencil-square-o"></span> 查看</a>
	                      </c:if>
	                    </div>
	                  </div>
	                </td>
	          	</tr>
              </c:forEach>
              </tbody>
            </table>
            <div class="am-cf">
              	共 ${pd.total } 条记录
              	<div id="page" data-am-page="{pages:'${pd.totalPage }',jump:'./case/listMessage.do?page=%page%'}"></div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">来自教育系统网站的提示</div>
	    <div class="am-modal-bd">
	      	添加课程必须从教课人员模块中添加！
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn">确定</span>
	    </div>
	  </div>
	</div>
    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left">Copyright (C) 2024 www.bjtu.edu.cn, All Rights Reserved.</p>
    </footer>
  </div>
  <!-- content end -->

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/amazeui.page.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript">
$(function() {
	var page = window.location.search.match(/page=(\d+)/);   
	$("#page").page({pages:${pd.totalPage }}).setCurr(page?page[1]:1, function() {
		console.log('跳转到第' + page + "页");
	});
})
</script>
</body>
</html>
