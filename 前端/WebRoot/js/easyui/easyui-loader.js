/**
 *  页面加载等待页面
 *
 * @author 来源于网络
 * @date 2014/03/24
 *
 */
 var height = window.screen.height-250;
 var width = window.screen.width;
 var leftW = 300;
 if(width>1200){
 	leftW = 500;
 }else if(width>1000){
 	leftW = 350;
 }else {
 	leftW = 100;
 }
 //filter:alpha(opacity=80);透明    filter:alpha(opacity=800);不透明
 //var _html = "<div id='loading' style='position:absolute;left:0px;width:100%;height:" + height 
 //+ "px;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=800);'><div style='position:absolute;cursor:wait;left:" + 
 //leftW + "px;top:200px;width:auto;height:16px;padding:12px 5px 10px 30px;background:#fff url(./js/easyui/themes/default/images/loading.gif) no-repeat scroll 5px 10px;border:2px solid #ccc;color:#000;'>正在处理，请稍待。。。</div></div>";
 
 var _html = "<div id='loading' style='position:absolute;left:0px;width:100%;height:" + height 
 + "px;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=800);'><div style='position:absolute;cursor:wait;left:" + 
 leftW + "px;top:200px;width:auto;height:16px;padding:12px 5px 10px 30px;'></div></div>";
 
 window.onload = function(){
 	var _mask = document.getElementById('loading');
 	_mask.parentNode.removeChild(_mask);
 }
 //alert(_html);
 document.write(_html);
 