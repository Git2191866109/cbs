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
<form:form method="post" action="${base}/form/submit/educationConfigure/create/${eb_budget_configure_create_code}" commandName="educationConfigure" name="educationConfigure">
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.ids'/>
				</div>
				<div class="form-field-elt">
					<form:input path="ids" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="ids" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.serialVersionUID'/>
				</div>
				<div class="form-field-elt">
					<form:input path="serialVersionUID" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="serialVersionUID" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.id'/>
				</div>
				<div class="form-field-elt">
					<form:input path="id" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="id" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.eduGoalId_master'/>
				</div>
				<div class="form-field-elt">
					<form:input path="eduGoalId_master" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="eduGoalId_master" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.eduGoalId_vice'/>
				</div>
				<div class="form-field-elt">
					<form:input path="eduGoalId_vice" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="eduGoalId_vice" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.createDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="createDate" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="createDate" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.modifyDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="modifyDate" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="modifyDate" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.creatorId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="creatorId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="creatorId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='educationConfigure.educationGoal'/>
				</div>
				<div class="form-field-elt">
					<form:input path="educationGoal" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="educationGoal" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${uc_system_configure_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>