<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="${base}/static/css/skin.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align:center;">
<div class="message">
	<div class="message-failed-img"></div>
	<div class="message-content">
		${promptMessage}
	</div>
	<div class="message-btn">
		<input type="button" onclick="javascript:history.back();" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</body>
</html>
