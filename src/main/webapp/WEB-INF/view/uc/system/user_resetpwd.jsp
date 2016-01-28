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
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/user/resetpwd" id="user" commandName="user" name="user">
<form:hidden path="id" />	
<form:hidden path="name" />
<form:hidden path="orgCode" />
<form:hidden path="account" />
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${uc_system_user_code},<msg:message code='button.back.list'/>"/>
<div class="form-body">
	<div class="form-title">
		<span><msg:message code='system.prompt.resetpwd.info' /></span>
	</div>
	<div class="form-content">
	<ul style="overflow-y:auto;height:100%;width:100%">
        <li>
			<div class="form-field-title">
				<b>*</b><msg:message code='user.newPassword'/>
			</div>
			<div class="form-field-elt">
				<input type="password" name="newPassword" value="${user.newPassword}" class="dfinput"/>
			</div>
			<div class="form-field-prompt">
				<form:errors path="newPassword" delimiter=" "></form:errors>
			</div>
		</li>
        <li>
			<div class="form-field-title">
				<b>*</b><msg:message code='user.confirmPassword'/>
			</div>
			<div class="form-field-elt">
				<input type="password" name="confirmPassword" value="${user.confirmPassword}" class="dfinput"/>
			</div>
			<div class="form-field-prompt">
				<form:errors path="confirmPassword" delimiter=" "></form:errors>
			</div>
		</li>
	</ul>
	</div>
		<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.modify'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${uc_system_user_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>