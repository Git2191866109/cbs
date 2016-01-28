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
<form:form method="post" action="${base}/form/submit/member/modify" commandName="member" name="member">
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.account'/>
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
					<b>*</b><msg:message code='member.phoneAccount'/>
				</div>
				<div class="form-field-elt">
					<form:input path="phoneAccount" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="phoneAccount" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.emailAccount'/>
				</div>
				<div class="form-field-elt">
					<form:input path="emailAccount" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="emailAccount" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.nickname'/>
				</div>
				<div class="form-field-elt">
					<form:input path="nickname" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="nickname" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.mobilePhone'/>
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
					<b>*</b><msg:message code='member.officePhone'/>
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
					<b>*</b><msg:message code='member.validEmail'/>
				</div>
				<div class="form-field-elt">
					<form:input path="validEmail" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="validEmail" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.male'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="male" value="0"
							<c:if test="${member.male == 0}">
								checked
							</c:if>/>男
					<input type="radio" name="male" value="1" style="margin-left: 50px;"
							<c:if test="${member.male == 1}">
								checked
							</c:if>/>女
				</div>
				<div class="form-field-prompt">
					<form:errors path="male" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.birthday'/>
				</div>
				<div class="form-field-elt">
					<form:input path="birthday" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="birthday" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.provinceSpell'/>
				</div>
				<div class="form-field-elt">
					<form:input path="provinceSpell" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="provinceSpell" delimiter=" "></form:errors>
				</div>
			</li>
	       
	      
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.provinceName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="provinceName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="provinceName" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.cityName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="cityName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="cityName" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.countryName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="countryName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="countryName" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.address'/>
				</div>
				<div class="form-field-elt">
					<form:input path="address" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="address" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="button" onclick="window.location.href='${base}/history/back/${cc_member_account_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>