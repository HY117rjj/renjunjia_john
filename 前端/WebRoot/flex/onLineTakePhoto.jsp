<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	System.out.print(basePath);
	String photoPath = request.getServerName() + ":" + request.getServerPort() + path;
	System.out.println(photoPath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="history/history.css" />
<title>照片采集</title>
<script src="AC_OETags.js" language="javascript"></script>
<script src="history/history.js" language="javascript"></script>
<style>
body {
	margin: 0px;
	overflow: hidden
}
</style>
<script language="JavaScript" type="text/javascript">
<!--
// -----------------------------------------------------------------------------
// Globals
// Major version of Flash required
var requiredMajorVersion = 10;
// Minor version of Flash required
var requiredMinorVersion = 0;
// Minor version of Flash required
var requiredRevision = 0;
// -----------------------------------------------------------------------------
// -->
function setValueToField(obj) {
	var object = new Object();
	object.sc = obj;
	window.returnValue = object;
	window.close();
}
</script>
</head>

<body scroll="no">
<script language="JavaScript" type="text/javascript">
<!--
// Version check for the Flash Player that has the ability to start Player Product Install (6.0r65)
var hasProductInstall = DetectFlashVer(6, 0, 65);

// Version check based upon the values defined in globals
var hasRequestedVersion = DetectFlashVer(requiredMajorVersion, requiredMinorVersion, requiredRevision);

if ( hasProductInstall && !hasRequestedVersion ) {
	// DO NOT MODIFY THE FOLLOWING FOUR LINES
	// Location visited after installation is complete if installation is required
	var MMPlayerType = (isIE == true) ? "ActiveX" : "PlugIn";
	var MMredirectURL = window.location;
    document.title = document.title.slice(0, 47) + " - Flash Player Installation";
    var MMdoctitle = document.title;

	AC_FL_RunContent(
		"src", "playerProductInstall",
		"FlashVars", "MMredirectURL="+MMredirectURL+'&MMplayerType='+MMPlayerType+'&MMdoctitle='+MMdoctitle+"",
		"width", "290",
		"height", "245",
		"align", "middle",
		"id", "onLineTakePhoto",
		"quality", "high",
		"bgcolor", "#a6c9e2",
		"name", "onLineTakePhoto",
		"allowScriptAccess","sameDomain",
		"type", "application/x-shockwave-flash",
		"pluginspage", "http://www.adobe.com/go/getflashplayer",
		"FlashVars","photosName=${param.photosName}&path=<%=photoPath %>"
	);
} else if (hasRequestedVersion) {
	// if we've detected an acceptable version
	// embed the Flash Content SWF when all tests are passed
	AC_FL_RunContent(
			"src", "onLineTakePhoto",
			"width", "290",
			"height", "245",
			"align", "middle",
			"id", "onLineTakePhoto",
			"quality", "high",
			"bgcolor", "#a6c9e2",
			"name", "onLineTakePhoto",
			"allowScriptAccess","sameDomain",
			"type", "application/x-shockwave-flash",
			"pluginspage", "http://www.adobe.com/go/getflashplayer",
			"FlashVars","photosName=${param.photosName}&path=<%=photoPath %>"
	);
  } else {  // flash is too old or we can't detect the plugin
    var alternateContent = 'Alternate HTML content should be placed here. '
  	+ 'This content requires the Adobe Flash Player. '
   	+ '<a href=http://www.adobe.com/go/getflash/>Get Flash</a>';
    document.write(alternateContent);  // insert non-flash content
  }
// -->
</script>
<noscript>
	<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
		id="onLineTakePhoto" width="290" height="245"
		codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
		<param name="movie" value="onLineTakePhoto.swf" />
		<param name="quality" value="high" />
		<param name="bgcolor" value="#a6c9e2" />
		<param name="FlashVars" value="photosName=${param.photosName}&path=<%=photoPath %>" />
		<param name="allowScriptAccess" value="sameDomain" />
		<embed src="onLineTakePhoto.swf" quality="high" bgcolor="#a6c9e2"
			width="290" height="245" name="onLineTakePhoto" align="middle"
			play="true" loop="false" quality="high"
			allowScriptAccess="sameDomain" type="application/x-shockwave-flash"
			FlashVars="photosName=${param.photosName}&path=<%=photoPath %>"
			pluginspage="http://www.adobe.com/go/getflashplayer">
		</embed>
	</object>
</noscript>
</body>
</html>
