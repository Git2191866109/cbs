<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><msg:message code="system.name" /></title>
<script src="${base}/static/js/jquery.min.js" type="text/javascript" ></script>
<script src="${base}/static/js/layer/layer.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	var height = $(window).height();
	var width = $(window).width();
	$("#leftFrame").height(height-88);
	$("#rightFrame").height(height-88);
	$("#rightFrameConfig").height(height-88);
	$("#rightFrame").width(width-187);
	$("#rightFrameConfig").width(width-187);
	
});
</script>
</head>
<body topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td id="top" height="88" colspan="2">
			<iframe src="${base}/goto/authorization/jumpTop" frameborder="0" width="100%" height="88" name="topFrame" id="topFrame" scrolling="No" title="topFrame">
			</iframe>
		</td>
	</tr>
	<tr>
		<td id="left" width="187" valign="top">
			<iframe name="leftFrame" id="leftFrame"  width="100%" frameborder="0" scrolling="no" id="leftFrame" title="leftFrame">
			</iframe>
		</td>
		<td id="right" valign="top">
			<iframe src="${base}/right" width="100%" frameborder="0" name="rightFrame" id="rightFrame" scrolling="no" title="rightFrame">
			</iframe>
			<iframe width="100%" frameborder="0" width="100%" name="rightFrameConfig" id="rightFrameConfig" scrolling="no" style="display:none;" title="rightFrame">
			</iframe>
		</td>
	</tr>
</table>
</body>
</html>
