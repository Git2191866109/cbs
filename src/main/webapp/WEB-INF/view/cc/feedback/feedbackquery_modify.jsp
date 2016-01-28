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
	<input type="hidden" name="isLog" value="1"/>
	<input type="hidden" name="replaceName" value="nickName"/>
	<input type="hidden" name="buttonGroup" value="${cc_feedback_feedbackquery_code},<msg:message code='button.back.list'/>"/>
	<input type="hidden" name="buttonGroup" value="${cc_feedback_feedbackquery_modify_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='feedback.nickName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="nickName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="nickName" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='feedback.email'/>
				</div>
				<div class="form-field-elt">
					<form:input path="email" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="email" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='feedback.mobilePhone'/>
				</div>
				<div class="form-field-elt">
					<form:input path="mobilePhone" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="mobilePhone" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='feedback.state'/>
				</div>
				<div class="form-field-elt" style="line-height: 35px;">
					<input type="radio" name="state" value="0"
							<c:if test="${feedback.state == 0}">
								checked
							</c:if>/>未处理
					<input type="radio" name="state" value="1" style="margin-left: 50px;"
						   <c:if test="${feedback.state == 1}">
							   checked
						   </c:if>
							/>已处理
					<input type="radio" name="state" value="2" style="margin-left: 50px;"
							<c:if test="${feedback.state ==2 }">
								checked
							</c:if>
							/>处理中
				</div>
				<div class="form-field-prompt">
					<form:errors path="state" delimiter=" "></form:errors>
				</div>
			</li>
			  <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='feedback.replyContent'/>
				</div>
				<div class="form-field-elt">
					<form:textarea path="replyContent" rows="5" cols="55" class="dftextarea"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="replyContent" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.modify'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${cc_feedback_feedbackquery_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>