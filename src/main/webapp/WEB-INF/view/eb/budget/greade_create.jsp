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
<form:form method="post" action="${base}/form/submit/greadeYear/create" commandName="greadeYear" name="greadeYear">
<form:hidden path="growStageId" />
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${eb_budget_greade_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${eb_budget_greade_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${eb_budget_greade_create_code},<msg:message code='button.continue.create'/>"/>
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='greadeYear.name'/>
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
					<b>*</b><msg:message code='greadeYear.greade'/>
				</div>
				<div class="form-field-elt">
					<form:input path="greade" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="greade" delimiter=" "></form:errors>
				</div>
			</li>
			 <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='greadeYear.startYear'/>
				</div>
				<div class="form-field-elt">
					<form:input path="startYear" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="startYear" delimiter=" "></form:errors>
				</div>
			</li>
			 <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='greadeYear.endYear'/>
				</div>
				<div class="form-field-elt">
					<form:input path="endYear" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="endYear" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${eb_budget_greade_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>