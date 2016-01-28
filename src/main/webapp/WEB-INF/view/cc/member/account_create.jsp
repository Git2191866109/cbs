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
	$('.select3').uedSelect({width:345})
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/member/create" commandName="member" name="member">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="viewCode" value="${cc_member_account_code}">
<input type="hidden" name="buttonGroup" value="${cc_member_account_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${cc_member_account_create_code},<msg:message code='button.continue.create'/>"/>

<div class="form-body">
	<div class="form-title">
		<span>
			<msg:message code='system.prompt.basic.info'/>
		</span>
	</div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
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
					<b>*</b><msg:message code='member.password'/>
				</div>
				<div class="form-field-elt">
					<input type="password" name="password"  class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="password" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.confirmPassword'/>
				</div>
				<div class="form-field-elt">
					<input type="password" name="confirmPassword" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="confirmPassword" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div for="spvId" class="form-field-title">
					<b>*</b><msg:message code='spvCorporation.name'/>
				</div>
				<div class="form-field-elt-select">
					<form:select path="spvId" id="spvId" class="select3">
					<form:option value="${item.id}"><msg:message code='button.select'/></form:option>	
					<c:forEach items="${spvCorporationList}" var="item">
						<form:option value="${item.id}">${item.name}</form:option>
					</c:forEach>
					</form:select>
				</div>
				<div class="form-field-prompt">
					<form:errors path="spvId" delimiter=" "></form:errors>
				</div>
			</li>   
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.name'/>
				</div>
				<div class="form-field-elt">
					<input type="text" name="name" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="name" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.certificateNo'/>
				</div>
				<div class="form-field-elt">
					<input type="text" name="certificateNo" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="certificateNo" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='member.isActivate'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="isActivate" checked="checked"  value="0" >无效
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="isActivate" value="1" >有效
				</div>
				<div class="form-field-prompt">
					<form:errors path="isActivate" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${cc_member_account_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>