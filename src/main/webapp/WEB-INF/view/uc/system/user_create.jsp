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
<form:form id="user" method="post" action="${base}/form/submit/user/create" commandName="user" name="user">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="replaceName" value="account"/>
<input type="hidden" name="buttonGroup" value="${uc_system_user_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${uc_system_user_create_code},<msg:message code='button.continue.create'/>"/>
<input type="hidden" name="type" value="1"/>
<div class="form-body">
		<div class="form-title">
			<span><msg:message code='system.prompt.basic.info' /></span>
		</div>
		<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div for="orgCode" class="form-field-title">
					<b>*</b><msg:message code='user.orgCode'/>
				</div>
				<div class="form-field-elt-select">
					<form:select path="orgCode" id="orgCode" class="select3">
					<form:option value="${item.code}"><msg:message code='button.select'/></form:option>	
					<c:forEach items="${organizationList}" var="item">
						<form:option value="${item.code}">${item.name}</form:option>
					</c:forEach>
					</form:select>
				</div>
				<div class="form-field-prompt">
					<form:errors path="orgCode" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='user.account'/>
				</div>
				<div class="form-field-elt">
					<form:input path="account" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="account" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='user.password'/>
				</div>
				<div class="form-field-elt">
					<input type="password" name="password" value="${user.password}" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="password" delimiter=" "></form:errors>
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
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='user.name'/>
				</div>
				<div class="form-field-elt">
					<form:input path="name" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="name" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='user.status'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="status" value="1" checked="checked" />启用
					<input type="radio" name="status" value="0" />禁用
				</div>
				<div class="form-field-prompt">
					<form:errors path="status" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='user.mobilePhone'/>
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
					<msg:message code='user.officePhone'/>
				</div>
				<div class="form-field-elt">
					<form:input path="officePhone" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="officePhone" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='user.position'/>
				</div>
				<div class="form-field-elt">
					<form:input path="position" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="position" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='user.email'/>
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
					<msg:message code='user.description'/>
				</div>
				<div class="form-field-elt">
					<form:input path="description" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="description" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${uc_system_user_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
<script type="text/javascript">
	$('.select3').uedSelect({width:345})
</script>
</body>	
</html>