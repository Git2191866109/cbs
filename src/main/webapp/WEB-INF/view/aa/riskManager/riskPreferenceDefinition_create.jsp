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
<form:form method="post" action="${base}/form/submit/riskPreferenceDefinition/create" commandName="riskPreferenceDefinition" name="riskPreferenceDefinition">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${aa_riskManager_riskPreferenceDefinition_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${aa_riskManager_riskPreferenceDefinition_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${aa_riskManager_riskPreferenceDefinition_create_code},<msg:message code='button.continue.create'/>"/>
	<div class="form-body">
		<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
		<div class="form-content">
			<ul style="overflow-y:auto;height:100%;width:100%">
				<li>
					<div class="form-field-title">
						<b>*</b><msg:message code='riskPreferenceDefinition.name'/>
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
						<b>*</b><msg:message code='riskPreferenceDefinition.minVal'/>
					</div>
					<div class="form-field-elt">
						<form:input path="minVal" class="dfinput"/>
					</div>
					<div class="form-field-prompt">
						<form:errors path="minVal" delimiter=" "></form:errors>
					</div>
				</li>
				<li>
					<div class="form-field-title">
						<b>*</b><msg:message code='riskPreferenceDefinition.maxVal'/>
					</div>
					<div class="form-field-elt">
						<form:input path="maxVal" class="dfinput"/>
					</div>
					<div class="form-field-prompt">
						<form:errors path="maxVal" delimiter=" "></form:errors>
					</div>
				</li>
				<li>
					<div class="form-field-title">
						<b>*</b><msg:message code='riskPreferenceDefinition.description'/>
					</div>
					<div class="form-field-elt">
						<form:textarea path="description" class="textinput"/>
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
			<input type="button" onclick="window.location.href='${base}/history/back/${aa_riskManager_riskPreferenceDefinition_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
		</div>
	</div>
</form:form>
</body>
</html>