<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<jsp:include page="/WEB-INF/view/resource.jsp"></jsp:include>
<script type="text/javascript">
$(document).ready(function(e) {
	var height = $(window).height();
	$(".form-content").height(height-170);
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/feedback/modify" commandName="feedback" name="feedback">
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<msg:message code='feedback.nickName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="nickName" readonly="true" class="dfinput"/>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='feedback.email'/>
				</div>
				<div class="form-field-elt">
					<form:input path="email" readonly="true" class="dfinput"/>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='feedback.mobilePhone'/>
				</div>
				<div class="form-field-elt">
					<form:input path="mobilePhone" readonly="true" class="dfinput"/>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='feedback.state'/>
				</div>
				<div class="form-field-elt" style="line-height: 32px;">
					<c:if test="${feedback.state == 0}">
						未处理
					</c:if>
					<c:if test="${feedback.state == 1}">
						已处理
					</c:if>
					<c:if test="${feedback.state ==2 }">
						处理中
					</c:if>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='feedback.replyContent'/>
				</div>
				<div class="form-field-elt">
					<form:input path="replyContent" readonly="true" class="dfinput"/>
				</div>
			</li>
			<li>
				<div class="form-field-title">&nbsp;</div>
				<div class="form-field-elt">
					<input type="button" onclick="javascript:history.back();" class="btn-80" value="<msg:message code='button.back'/>"/>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>	
</html>