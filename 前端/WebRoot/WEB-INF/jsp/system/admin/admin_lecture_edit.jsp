<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
  	
  	<script src="assets/js/jquery.min.js"></script>
  	
  	<link rel="stylesheet" href="assets/css/amazeui.autocomplete.css"/>
    <script src="assets/js/amazeui.autocomplete.js"></script>
    <script src="assets/js/amazeui.autocomplete.icd.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var autoComplete;
		var autoCompleteICD;
		$(function () {
		    var dataf = [];
		    var datad = [];
	        $.ajax({
	            url: "./teacher/getAvailableTeacher.do",
	            type: "POST",
	            dataType: "json",
	            data: "{'companyname': 'targetVal'}",
	            contentType: "application/json; charset=utf-8",
	            //该属性表示前台请求到的数据为返回json数据格式的方法        
	            async: false,
	            success: function(data) {
	                dataf = eval(data.d);
	                datad = eval(data.n);
	                //数组          
	            }
	        });
	        
		    autoComplete = new AutoComplete('idcard','name','auto',dataf);//不能加[],加上就变成了数组size=1,包含3个数组了
		    autoCompleteICD = new AutoCompleteICD('icd','icdName','autoICD',datad);//不能加[],加上就变成了数组size=1,包含3个数组了
		    //autoComplete=new AutoComplete('idcard','name','auto',['b0','b12','b22','b3','b4','b5','b6','b7','b8','b2','abd','ab','acd','accd','b1','cd','ccd','cbcv','cxf']);
	    });
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统管理</strong> / <small>拟授课管理</small></div>
      </div>
      <hr>
		<form method="post" class="am-form" action="./lecture/saveLecture.do">
			<input type="hidden" name="id" id="id" value="${cw.id }"/>
			<input type="hidden" name="organizationId" value="49557184-0"/>
			<input type="hidden" name="serialNumber" id="sn" value="${sn }"/>
			<input type="hidden" name="icdName" id="icdName" value=""/>
			<fieldset>
    		<legend>编辑预约信息</legend>
    		<div class="am-form-group">
		      <label for="organization">组织机构</label>
		      <select id="organization" name="organization">
		      	<option value="山东省立医院" selected="selected">山东省立医院</option>
		      </select>
		      <span class="am-form-caret"></span>
		    </div>
    		<div class="am-form-group">
		      <label for="idcard">教师身份证号码</label>
		      <input type="text" class="am-form-field" id="idcard" name="idcard" value="${cw.idcard }" placeholder="输入身份证号码" onkeyup="autoComplete.start(event)" required>
		      <div class="auto_hidden" id="auto"><!--自动完成 DIV--></div>
		    </div>
		    <div class="am-form-group">
		      <label for="name">授课教师姓名</label>
		      <input type="text" class="am-form-field" id="name" name="name" value="${cw.name }" placeholder="输入姓名" required>
		    </div>
		    <div class="am-form-group">
		      <label for="subject">专业学科</label>
		      <select id="subject" name="subject">
		      	<c:forEach items="${zyxk }" var="zz">
		      		<option value="${zz.code }" ${cw.subject == zz.code ? 'selected="selected"' : '' }>${zz.name }</option>
		      	</c:forEach>
		      </select>
		      <span class="am-form-caret"></span>
		    </div>
    		<div class="am-form-group">
		      <label for="major">诊疗科目</label>
		      <select multiple class="" id="major" name="major">
		        <c:forEach items="${zlkm }" var="zz">
		      		<option value="${zz.code }" ${fn:contains(cw.major, zz.code) ? 'selected="selected"' : '' }>${zz.name }</option>
		      	</c:forEach>
		      </select>
		    </div>
		    <div class="am-form-group">
		      <label for="icd">疾病分类</label>
		      <input type="text" class="am-form-field" id="icd" name="icd" value="${cw.icd }" onkeyup="autoCompleteICD.start(event)" placeholder="">
		      <div class="auto_hidden" id="autoICD"><!--自动完成 DIV--></div>
		    </div>
    		<div class="am-form-group">
		      <label for="title">授课题目</label>
		      <input type="text" class="am-form-field" id="title" name="title" value="${cw.title }" placeholder="" required>
		    </div>
		    <div class="am-form-group">
		      <label for="summary">内容提要</label>
		      <input type="text" class="am-form-field" id="summary" name="summary" value="${cw.summary }" placeholder="">
		    </div>
			<div class="am-form-group">
		      <label for="nature">课程类型</label>
		      <select id="nature" name="nature">
		        <c:forEach items="${kclx }" var="zz">
		      		<option value="${zz.code }" ${cw.nature == zz.code ? 'selected="selected"' : '' }>${zz.name }</option>
		      	</c:forEach>
		      </select>
		    </div>
		    <div class="am-form-group">
		      <label for="modality">授课形式</label>
		      <select id="modality" name="modality">
		        <c:forEach items="${skxs }" var="zz">
		      		<option value="${zz.code }" ${cw.modality == zz.code ? 'selected="selected"' : '' }>${zz.name }</option>
		      	</c:forEach>
		      </select>
		    </div>
		    <div class="am-form-group">
		      <label for="teachingTime_">授课时间</label>
		      <div class="am-form-group am-form-icon">
                  <i class="am-icon-calendar"></i>
                  <input type="datetime-local" class="am-form-field am-input-sm" id="teachingTime_" name="teachingTime_" value="${cw.teachingTime_ }" placeholder="日期">
              </div>
		    </div>
		    <div class="am-form-group">
		      <label for="duration">授课时长（分钟）</label>
		      <input type="text" class="am-form-field" id="duration" name="duration" value="${cw.duration }" placeholder="">
		    </div>
		    <div class="am-form-group">
		      <label for="charge">授课费</label>
		      <input type="text" class="am-form-field" id="charge" name="charge" value="${cw.charge }" placeholder="">
		    </div>
    		</fieldset>
		
			<div class="am-margin">
		      <button type="submit" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
		      <button type="button" onclick="window.history.back();" class="am-btn am-btn-primary am-btn-xs">放弃保存</button>
		    </div>
	    </form>
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
<!--
<script src="assets/js/jquery.min.js"></script>
-->
<!--<![endif]-->
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/amazeui.page.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
