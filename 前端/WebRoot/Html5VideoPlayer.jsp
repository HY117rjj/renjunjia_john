<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String videoPath = request.getParameter("video");
String cwid = request.getParameter("cwid");
String mediaPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/Media"+"/"+videoPath;
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <title>北京交通大学涉密信息系统工程课程实训系统</title>

    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/i/app.png">
   
    <meta name="apple-mobile-web-app-title" content="远程教育" />
    <link rel="apple-touch-icon-precomposed" href="images/i/edu.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="images/i/favicon.png">
    <link href="js/jQuery-Video-5.10.8/css/video-js.min.css" rel="stylesheet">
    <script src="assets/js/jquery.min.js"></script>
	<script src="js/jQuery-Video-5.10.8/js/video.min.js"></script>
	
	<style>
	.video-self-adaption {
	    position: absolute;
	    right: 0;
	    bottom: 0;
	    z-index: -1;
	    min-width: 100%;
	    min-height: 100%;
	    width: auto;
	    height: auto;
	    background-size: cover;
	}
	</style>
    
    <script type="text/javascript">
    $(function(){
		//$.post("./notice/getFrontPagelist.do",{},function(data){
			
			
		//}, "json");
		
		$("#video_1").bind("contextmenu" ,function() { return false; });
		
		
		var player = videojs("video_1");
	    player.ready(function(){
	        player.play();
	        console.log(player.currentTime());
	    });
	    
	    player.on('timeupdate', function () {//当前播放时间   单位秒  
			console.log('当前播放时间：' + player.currentTime());
			if(player.currentTime() > 60*5){//5分钟
				//alert(1);
			}
		});
	 
	    player.options.flash.swf = "js/jQuery-Video-5.10.8/video-js.swf";
	});
	
	function closeVideo(){
		window.close();
		window.history.back();
	}
    </script>
</head>
<body style="background-color: black; padding-top: 60px;">
	<!-- poster="Temp-images/start.jpg" -->
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeVideo();">
				<span aria-hidden="true">×</span>
			</button>
		</div>
		<div class="modal-body met_editor">
			<video id="video_1" class="video-js vjs-default-skin vjs-big-play-centered video-self-adaption" controls preload="none" 
		    	poster="Temp-images/start.jpg" data-setup="{}" style="clear:both; display:block; margin:auto;" webkit-playsinline>
			    <source src="<%=mediaPath%>" type='video/mp4' />
				<p class="vjs-no-js">
			      	要查看此视频请启用JavaScript，并考虑升级到Web浏览器！
			    	<a href="http://videojs.com/html5-video-support/" target="_blank">支持 HTML5 Video的浏览器下载</a>
			    </p>
			</video>
		</div>
	</div>
	
</body>
</html>