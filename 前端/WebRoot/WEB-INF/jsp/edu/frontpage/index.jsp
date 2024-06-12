<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String mediaPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/Media"+"/";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imagePath = request.getScheme()+"://"+request.getServerName()+":9090/image";
if("127.0.0.1".equals(request.getServerName()) || request.getServerName().contains("192.168")){
	imagePath = request.getScheme()+"://11.0.0.66:9090/image";
}
%>
<!doctype html>
<html class="no-js">
<head>
	<base href="<%=basePath%>">
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="课程实训系统" />
    <meta name="description" content="北京交通大学涉密信息系统工程课程实训系统" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>课程实训系统</title>

    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/i/app.png">
    <!--Safari on iOS -->
    <!--Session ChuanDi Bu Guoqu-->
    <!--
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
     -->
    <meta name="apple-mobile-web-app-title" content="课程实训系统" />
    <link rel="apple-touch-icon-precomposed" href="images/i/edu.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="images/i/favicon.png">
    <link rel="stylesheet" href="assets/css/amazeui.css">
    <link rel="stylesheet" href="css/public.css">
    <style type="text/css">
	    .am-live a {
		  	display: inline-block;
		  	text-decoration: none;
		}
	    .am-live-fixed {
			position: fixed;
		  	right: 10px;
		  	top: 200px;
		  	z-index: 1010;
		  	opacity: 0;
		  	width: 32px;
		  	min-height: 32px;
		  	overflow: hidden;
		  	border-radius: 0;
		  	text-align: center;
		  	opacity: .9;
		  	
		    line-height: 32px;
		    background-color: #555555;
		    vertical-align: middle;
		    color: #ddd;
		    border-radius:15px;<!--调节圆周程度-->
		}
		
		.am-live-fixed a {
		  	display: block;
		}
		
		.am-live-2 a {
		  	display: inline-block;
		  	text-decoration: none;
		}
	    .am-live-fixed-2 {
			position: fixed;
		  	right: 10px;
		  	top: 380px;
		  	z-index: 1010;
		  	opacity: 0;
		  	width: 32px;
		  	min-height: 32px;
		  	overflow: hidden;
		  	border-radius: 0;
		  	text-align: center;
		  	opacity: .9;
		  	
		    line-height: 32px;
		    background-color: #555555;
		    vertical-align: middle;
		    color: #ddd;
		    border-radius:15px;<!--调节圆周程度-->
		}
    </style>

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
    <script src="assets/js/amazeui.min.js"></script>
    <script src="js/public.js"></script>
    <script type="text/javascript">
    $(function(){
    	liveRecStatusURL();// 直播按钮样式
    	
		$.post("./notice/getFrontPagelist.do",{},function(data){
			var notice = data["notice"];
			if(notice.length){
				var noticetable = $("#noticeTable");
				var head="<tr><td>通知标题</td><td>发布日期</td></tr>";
				for(var index in notice){
					var obj = notice[index];
					var id = obj.id;
					var title = obj.title;
					var content = obj.content;
					var noticeTime = obj.teachingTime;
					var promulgator = obj.promulgator;
					var noticeTime_ = formatDate(new Date(noticeTime),"yyyy-MM-dd");
					var noticeRow = $("<tr></tr>");
					var noticeCol1 = $("<td width=\"70%\" style=\"overflow:hidden;white-space:nowrap;text-overflow:ellipsis;\"></td>");
					var noticeCol2 = $("<td></td>");
					noticeCol1.append("<a href=\"./notice/viewNoticeFrontPage.do?id="+id+"\">"+title+"</a>");
					noticeCol2.append("").append(noticeTime_);
					noticeRow.append(noticeCol1);
					noticeRow.append(noticeCol2);
					noticetable.append(noticeRow);
				}
			}
		}, "json");
		
		liveRecStatusURL();// 直播按钮样式
	});
	
	//格式化日期, 
	function formatDate(date, format) {
		var paddNum = function(num) {
			num += "";
			return num.replace(/^(\d)$/, "0$1");
		}
		//指定格式字符 
		var cfg = {
			yyyy : date.getFullYear() //年 : 4位 
			,
			yy : date.getFullYear().toString().substring(2)//年 : 2位 
			,
			M : date.getMonth() + 1 //月 : 如果1位的时候不补0 
			,
			MM : paddNum(date.getMonth() + 1) //月 : 如果1位的时候补0 
			,
			d : date.getDate() //日 : 如果1位的时候不补0 
			,
			dd : paddNum(date.getDate())//日 : 如果1位的时候补0 
			,
			hh : date.getHours() //时 
			,
			mm : date.getMinutes() //分 
			,
			ss : date.getSeconds()
		//秒 
		}
		format || (format = "yyyy-MM-dd HH:mm:ss");
		return format.replace(/([a-z])(\1)*/ig, function(m) {
			return cfg[m];
		});
	}
	
	function chairLecture(id){
		if("${user}" == ""){
			$('#my-alert2').modal({
		        relatedTarget: this,
		        onConfirm: function(options) {// 具有 data-am-modal-confirm 属性的按钮关闭时触发的函数
		        	window.top.location.href="./login.do";
		        },
		        onCancel: function() {// 具有 data-am-modal-cancel 属性的按钮关闭时触发的函数
		          
		        }
		    });
			return;
		}
		var url = "${pageContext.request.contextPath }/chair/chairLecture.do?ajax=1&type=${type }&id="+id;
		$.post(url, {}, function(json){
			if(json["json"][0].statusCode==200){
				var $modal = $('#my-alert');
				$modal.modal();
			}
		},"json");
	}
	
	function coursewareMessage(id, title){
		if("${user}" == ""){
			$('#my-alert3').modal({
		        relatedTarget: this,
		        onConfirm: function(options) {// 具有 data-am-modal-confirm 属性的按钮关闭时触发的函数
		        	window.top.location.href="./login.do";
		        },
		        onCancel: function() {// 具有 data-am-modal-cancel 属性的按钮关闭时触发的函数
		          
		        }
		    });
			return;
		}
		var url = "${pageContext.request.contextPath }/courseware/addCoursewareMessage.do?serialNumber="+id+"&title="+title;
		window.top.location.href=url;
	}
	
	function liveURL1(){
		//var liveHTML = document.getElementById("live").contentWindow.document.getElementById("showID");
		//alert(liveHTML);
		//am-live-title
		
		var liveRecStatusURL = "https://prov.myvmr.cn/meeting/getLiveRecStatus";
		$.ajax({
            type: "POST",
            url: liveRecStatusURL,
            data: JSON.stringify({"sipkey": "9000033"}),
            contentType: "application/json",
            dataType: "json", //表示返回值类型
            headers:{
            	auth: "3cck5c1e2uco39tlbxtv8ra8hunusvs8:ttec0ka1j6j5b5ji0csrakwghaf2a5mz"
            },
            success: function(data){
    			if(data.message=="当前会议室没有开启会议"){
    				$('#my-alert4').modal({
    					relatedTarget: this,
    				    onConfirm: function(options) {// 具有 data-am-modal-confirm 属性的按钮关闭时触发的函数
    				        return false;
    				    },
    				    onCancel: function() {// 具有 data-am-modal-cancel 属性的按钮关闭时触发的函数
    				    	return false;
    				    }
    				});
    			}else if(data.message=="auth码不能为空" || data.message=="消息体缺失,请检查"){
    				
    			}else {
    				var url = "${pageContext.request.contextPath }/chair/networkFlow.do?ip="+returnCitySN["cip"];
    				$.post(url, {}, function(json){
    					if(json["json"][0].statusCode==200){
    						
    					}
    				},"json");
    		        window.location.href = "https://cs.zijingcloud.com/live/9000033";
    			}
    		}
        });
		
		//window.location.href = "https://cs.huishicloud.com/share/liverec/no-validate-live-player.do?sign=EuifTPUlsGuCEYa1Uu8gdcts6GdhPTEwMDIyMDE2Jms9QUtJRHVqTTJMRTBHRldNaGdqcGNRbWU0MlRYOFRUb2NHcGs1JmU9MTU4NjkyODkzOTgwNCZ0PTE1ODY5Mjg3MjM4MDQmcj0xMzg0MDkyMzM0Jmk9MjM4MzI=";
	}
	
	function liveURL2(){
		var url = "${pageContext.request.contextPath }/chair/networkFlow.do?ip="+returnCitySN["cip"];
		$.post(url, {}, function(json){
			if(json["json"][0].statusCode==200){
				
			}
		},"json");
		window.location.href = "https://cs.zijingcloud.com/live/9000661";
	}
	
	function liveURL22(){
		var url = "${pageContext.request.contextPath }/chair/networkFlow.do?ip="+returnCitySN["cip"];
		$.post(url, {}, function(json){
			if(json["json"][0].statusCode==200){
				
			}
		},"json");
		window.location.href = "http://live.remoteconsultation.cn/";
	}
	
	function liveRecStatusURL(){
		var liveRecStatusURL = "https://prov.myvmr.cn/meeting/getLiveRecStatus";
		$.ajax({
	        type: "POST",
	        url: liveRecStatusURL,
	        data: JSON.stringify({"sipkey": "9000033"}),
	        contentType: "application/json",
	        dataType: "json", //表示返回值类型
	        headers:{
	        	auth: "3cck5c1e2uco39tlbxtv8ra8hunusvs8:ttec0ka1j6j5b5ji0csrakwghaf2a5mz"
	        },
	        success: function(data){
				if(data.message=="当前会议室没有开启会议"){
					$("#am-live-a").attr("style", "color: #808080;");
				}
			}
	    });
	}
    </script>
</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="<%=basePath%>"><img src="images/logo.png" alt=""></a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-warning am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li class="am-active"><a href="<%=basePath%>">首页</a></li>
                <li><a href="javascript:void(0);">用户管理</a></li>
                <li><a href="javascript:void(0);">教学文档管理</a></li>
                <li><a href="javascript:void(0);">实训操作模块</a></li>
                <li><a href="javascript:void(0);">案例分析模块</a></li>
                <li><a href="./systemlogin.do">系统管理</a></li>
            </ul>
            <c:if test="${not empty user.name }">
            <li class="am-dropdown am-topbar-right" data-am-dropdown>
	          <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:void(0);">
	            </span> ${user.name } <span class="am-icon-caret-down"></span>
	          </a>
	          <ul class="am-dropdown-content am-list-item-text">
	            <li><a href="./student/editPersonalDataFP.do?id=${user.id }"><span class="am-icon-user"></span> 资料</a></li>
	            <li><a href="./student/editPersonalDataFP.do?id=${user.id }"><span class="am-icon-cog"></span> 设置</a></li>
	            <li><a href="./logout.do"><span class="am-icon-power-off"></span> 退出</a></li>
	          </ul>
	        </li>
            </c:if>
            <c:if test="${empty user.name }">
            <div class="am-topbar-right">
                <a type="button" href="./student/editPersonalDataRegister.do" class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span> 注册</a>
            </div>

            <div class="am-topbar-right">
                <a type="button" href="./systemlogin.do" class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</a>
            </div>
            </c:if>
        </div>
    </div>
</header>
<!--banner-->
<!--class="banner" 去掉可在移动端显示-->
<div>
    <div class="am-g am-container">
  		<!-- 图片展示 建议大小1280*720 -->
        <div class="am-u-sm-12 am-u-md-12 am-u-lg-8">
            <div data-am-widget="slider" class="am-slider am-slider-c1" data-am-slider='{"directionNav":false}' >
                <ul class="am-slides">
                	<!-- 
                	<c:forEach items="${image }" var="img">
	                	<li>
	                        <a href="javascript:void(0);"><img src="<%=imagePath %>${img.titlePath }"></a>
	                        <div class="am-slider-desc">${img.title }</div>
	                    </li>
                	</c:forEach>
                	 -->
                	 
                	<c:forEach items="${courseware }" var="cw" >
	                	<li>
	                        <a href="<%=mediaPath%>${cw.addressLink }" target="_blank"><img src="<%=mediaPath %>${cw.coverImage }"></a>
	                        <div class="am-slider-desc">${cw.title }</div>
	                    </li>
                	</c:forEach>
                	
                	<!-- 
                    <li>
                        <a href="javascript:void(0);"><img src="Temp-images/876962285589691400.jpg"></a>
                        <div class="am-slider-desc">山东省医师协会远程医疗分会筹备会胜利召开</div>
                    </li>
                    <li>
                        <a href="javascript:void(0);"><img src="Temp-images/1A0B0625.jpg"></a>
                        <div class="am-slider-desc">国家卫生计生委副主任王贺胜视察我中心建设情况</div>
                    </li>
                    <li>
                        <a href="javascript:void(0);"><img src="Temp-images/682247995245119429.jpg"></a>
                        <div class="am-slider-desc">国家卫生计生委规划与信息司副司长刘文先视察我中心建设情况</div>
                    </li>
                    <li>
                        <a href="javascript:void(0);"><img src="Temp-images/IMG_20161209_091636.jpg"></a>
                        <div class="am-slider-desc">东明县卫计委考察团参观省中心</div>
                    </li>
                     -->
                </ul>
            </div>
        </div>
        <div class="am-u-sm-0 am-u-md-0 am-u-lg-4 padding-none">
            <div class="star am-container"><span><a href="./notice/listFP.do">通知栏 &raquo;</a></span></div>
            
            <table id="noticeTable" class="am-table am-table-striped am-table-hover am-list-item-text" style="table-layout:fixed; height: 100%;">
				<tr><th width="70%">通知</th><th>授课时间</th></tr>
			</table>
        </div>
    </div>
</div>

<!--news-->
<div class="am-g am-container newatype">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 oh">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" style="border-bottom: 0px; margin-bottom: -10px">
            <h2 class="am-titlebar-title ">
            	热门视频
            </h2>
            <nav class="am-titlebar-nav">
                <a href="./moreVideo.do">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default news">
            <div class="am-list-news-bd">
                <ul class="am-list">
	                <c:forEach items="${courseware }" var="cw">
	                	<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
	                        <div class="am-u-sm-5 am-list-thumb">
	                          <c:if test="${fn:contains(cw.addressLink, '.mp4') || fn:contains(cw.addressLink, '.MP4')}">
	                          	<!-- 
	                        	<a href="<%=basePath%>Html5VideoPlayer.jsp?cwid=${cw.id }&video=${cw.addressLink }" target="_blank">
	                                <img src="<%=mediaPath %>${cw.coverImage }" alt=""/>
	                            </a>
	                            -->
	                            <a href="<%=mediaPath%>${cw.addressLink }" target="_blank">
	                                <img src="<%=mediaPath %>${cw.coverImage }" alt=""/>
	                            </a>
	                          </c:if>
	                          <!-- <%=mediaPath%>${cw.addressLink } -->
	                          <c:if test="${fn:contains(cw.addressLink, '.wmv') || fn:contains(cw.addressLink, '.WMV')  || empty cw.addressLink}">
	                          	<!-- 
	                        	<a href="<%=basePath%>Html5VideoPlayer.jsp?cwid=${cw.id }&video=${cw.addressLink }" target="_blank">
	                                <img src="<%=mediaPath %>${cw.coverImage }" alt=""/>
	                            </a>
	                            -->
	                            <a href="<%=mediaPath%>${cw.addressLink }" target="_blank">
	                                <img src="<%=mediaPath %>${cw.coverImage }" alt=""/>
	                            </a>
	                          </c:if>
	                        </div>
	
	                        <div class=" am-u-sm-7 am-list-main">
	                        	<!-- <%=mediaPath%>${cw.addressLink } -->
	                            <div class="am-list-item-text"><a href="<%=basePath%>Html5VideoPlayer.jsp?cwid=${cw.id }&video=${cw.addressLink }" target="_blank">授课：${cw.name == '佚名' ? '' : cw.name}</a></div>
	
	                            <div class="am-list-item-text">题目：${cw.title }</div>
	                            
	                            <div class="am-list-item-text">时长：${cw.duration }分钟</div>
	                        </div>
	                        
	                        <div class="am-text-right"><button type="button" class="am-btn am-btn-primary am-btn-xs" onclick="coursewareMessage('${cw.id }','${cw.title }');">留言</button></div>
	                    </li>
	                    <div class="newsico am-fr">
	                        <i class="am-icon-clock-o"> ${cw.teachingTime_ }</i>
	                        <!-- <i class="am-icon-hand-pointer-o"> 12322</i> -->
	                    </div>
	                </c:forEach>
	                <!-- 
                	<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=iRf6yRmc_-RkYdBXMeXkRA">
                                <img src="./assets/i/demos/7170cc56-22d6-46a7-9d4d-531b63cccba0.jpg" alt=""/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=iRf6yRmc_-RkYdBXMeXkRA">陈兵副主任医师</a></h3>

                            <div class="am-list-item-text">狼疮性肾炎的诊断与治疗【山东省立医院 肾内科 】</div>

                        </div>
                    </li>
                    <div class="newsico am-fr">
                        <i class="am-icon-clock-o">2017/01/11</i>
                        <i class="am-icon-hand-pointer-o">12322</i>
                    </div>
                    
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=jYo3d6_DdE6QjE4Y7ahJ8w">
                                <img src="./assets/i/demos/d65eb091-8c87-4e7f-bcff-f5b1055e8d54.jpg" alt=""/>
                            </a>

                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=jYo3d6_DdE6QjE4Y7ahJ8w">姜军梅主任医师</a></h3>
                            <div class="am-list-item-text">消化道早癌的诊治与我的ESD之路【山东省立医院 消化内科】</div>
                        </div>

                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=dLeYdP8uHey95_gTLkn6Bw">
                                <img src="./assets/i/demos/3aea1160-ac37-4355-97b2-b221a557595c.jpg" alt=""/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=dLeYdP8uHey95_gTLkn6Bw">李怀臣主任医师</a></h3>

                            <div class="am-list-item-text">重症社区获得性肺炎的诊断与鉴别【山东省立医院 呼吸内科】</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=N1W1jsZn04V_4QOWlZGHIQ">
                                <img src="./assets/i/demos/0017eef4-2dbe-4cbf-8f50-5d9926517cf0.jpg" alt=""/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=N1W1jsZn04V_4QOWlZGHIQ">李道卫主治医师</a></h3>

                            <div class="am-list-item-text">呼吸内科疑难病例讨论【山东省立医院 呼吸内科】</div>

                        </div>
                    </li>
                    
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=N1W1jsZn04V_4QOWlZGHIQ">
                                <img src="./assets/i/demos/14817013812660.jpg" alt=""/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=67dG3X6aUscDsSEORP0E1g">徐进主任医师</a></h3>

                            <div class="am-list-item-text">从2011原发性骨质疏松指南看骨质疏松的诊疗【山东省立医院 内分泌科】</div>

                        </div>
                    </li>
                    
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" data-am-scrollspy="{animation:'fade'}">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=bbJCdNeMG14b1_38jxu0jQ">
                                <img src="./assets/i/demos/5f8c0d60-291f-4f5c-9206-45ae17901b55.jpg" alt=""/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://wap.yilian.zhuojianchina.com/wap/live/course.htm?annexId=bbJCdNeMG14b1_38jxu0jQ">王洪波主任医师</a></h3>

                            <div class="am-list-item-text">炎性肠病的诊治进展【山东省立医院 消化内科】</div>

                        </div>
                    </li>
                    -->
                </ul>
            </div>
        </div>
    </div>
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
            	预约讲座
            </h2>
            <nav class="am-titlebar-nav">
                <a href="#more">more &raquo;</a>
            </nav>
        </div>

        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg" data-am-scrollspy="{animation:'fade'}">
            <article class="am-comment">
              <c:forEach items="${lecture }" var="lec">
	              <div class="am-panel am-panel-default admin-sidebar-panel">
			        <div class="am-panel-bd">
			          <p><span class="am-icon-bookmark"></span>&nbsp;&nbsp;${lec.name }</p>
			          <p>
			          	讲座题目：${lec.title }<br/>
			          	讲课时间：${lec.teachingTime_ }<br/>
			          	<div class="am-text-right"><button type="button" class="am-btn am-btn-primary am-btn-xs" onclick="chairLecture('${lec.id }');">预约</button></div>
					  </p>
			        </div>
			      </div>
		      </c:forEach>
			</article>
        </div>
        
        <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default">
            <h2 class="am-titlebar-title ">
            	授课专家
            </h2>
            <nav class="am-titlebar-nav">
                <a href="./moreTeacher.do">more &raquo;</a>
            </nav>
        </div>
        <div data-am-widget="list_news" class="am-list-news am-list-news-default right-bg" data-am-scrollspy="{animation:'fade'}">
        	<ul class="am-list">
	        	<c:forEach items="${teacher }" var="t" begin="${random }" end="${random + 2 }">
	            	<li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left">
	                	<div class="am-u-sm-4 am-list-thumb">
	                    	<a href="./demand/listForFrontPage.do?type=4&code=${t[1] }">
	                        	<c:if test="${empty t[3] }">
	                            	<img src="./images/male.jpg" class="face"/>
	                            </c:if>
	                            <c:if test="${not empty t[3] }">
	                            	<img src="http://www.telemedicine.net.cn:9080/telemedicine${fn:replace(t[3], 'viewfile', 'viewfile.do')}" class="face" onerror="this.src='./images/male.jpg'"/>
	                            </c:if>
	                        </a>
	                    </div>
	
	                    <div class=" am-u-sm-8 am-list-main">
	                        <h3 class="am-list-item-hd"><a href="./demand/listForFrontPage.do?type=4&code=${t[1] }">${t[1] }</a></h3>
	
							<div class="am-list-item-text-line6">
	                        	<c:if test="${empty t[2] }">
	                            	暂无简介....
	                            </c:if>
	                            <c:if test="${not empty t[2] }">
	                            	${t[2] }
	                            </c:if>
	                        </div>
	                    </div>
	                </li>
	                <hr data-am-widget="divider" style="" class="am-divider am-divider-default" />
	            </c:forEach>
            </ul>
        </div>
    </div>
</div>

<div class="am-live am-live-fixed">
    <a id="am-live-a" href="javascript:void(0);" onclick="liveURL1();" title="直播2">
        <span id="am-live-title" class="am-live-title">直 播<br/>1<br/></span>
        <i class="am-gotop-icon am-icon-chevron-circle-right"></i>
    </a>
</div>

<div class="am-live-2 am-live-fixed-2">
    <a id="am-live-a" href="javascript:void(0);" onclick="liveURL2();" title="直播2">
        <span id="am-live-title" class="am-live-title">直 播<br/>2<br/></span>
        <i class="am-gotop-icon am-icon-chevron-circle-right"></i>
    </a>
</div>

<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
    <a href="#top" title="回到顶部">
        <span class="am-gotop-title">回到顶部</span>
        <i class="am-gotop-icon am-icon-chevron-up"></i>
    </a>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
	<div class="am-modal-dialog">
	    <div class="am-modal-hd"></div>
	    <div class="am-modal-bd">
	      	预约授课成功！
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn">确定</span>
	    </div>
	</div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert2">
	<div class="am-modal-dialog">
	    <div class="am-modal-hd"></div>
	    <div class="am-modal-bd">
	      	预约授课请先登录！
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
	    </div>
	</div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert3">
	<div class="am-modal-dialog">
	    <div class="am-modal-hd"></div>
	    <div class="am-modal-bd">
	      	留言请先登录！
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
	    </div>
	</div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert4">
	<div class="am-modal-dialog">
	    <div class="am-modal-hd"></div>
	    <div class="am-modal-bd">
	      	当前没有正在直播的会议！
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn" data-am-modal-confirm>确定</span>
	    </div>
	</div>
</div>

<footer>
    <div class="content">
        <ul class="am-avg-sm-5 am-avg-md-5 am-avg-lg-5 am-thumbnails">
            <li><a href="#">联系我们</a></li>
            <li><a href="#">加入我们</a></li>
            <li><a href="#">合作伙伴</a></li>
            <li><a href="#">广告及服务</a></li>
            <li><a href="http://www.telemedicine.net.cn/">友情链接</a></li>
        </ul>
        <p>Copyright (C) 2024 www.bjtu.edu.cn, All Rights Reserved.</p>
        <div class="w2div">
        <ul data-am-widget="gallery" class="am-gallery am-avg-sm-2 am-avg-md-2 am-avg-lg-2 am-gallery-overlay" 
        	data-am-gallery="{pureview: true }" >
        </ul>
        </div>
    </div>
</footer>
</body>
</html>