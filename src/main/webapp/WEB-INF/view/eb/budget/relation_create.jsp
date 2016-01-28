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
<form:form method="post" action="${base}/form/submit/modeItemRelation/create/${eb_budget_relation_create_code}" commandName="modeItemRelation" name="modeItemRelation">
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.serialVersionUID'/>
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
					<b>*</b><msg:message code='modeItemRelation.id'/>
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
					<b>*</b><msg:message code='modeItemRelation.growStagesId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="growStagesId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="growStagesId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.eduModeId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="eduModeId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="eduModeId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.budgetCategoryId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetCategoryId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetCategoryId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.budgetItemDataId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetItemDataId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetItemDataId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.budgetItemId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetItemId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetItemId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.growStages'/>
				</div>
				<div class="form-field-elt">
					<form:input path="growStages" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="growStages" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.educationMode'/>
				</div>
				<div class="form-field-elt">
					<form:input path="educationMode" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="educationMode" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.budgetCategory'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetCategory" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetCategory" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.budgetItem'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetItem" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetItem" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='modeItemRelation.budgetItemData'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetItemData" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetItemData" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">&nbsp;</div>
				<div class="form-field-elt">
					<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
					<input type="button" onclick="javascript:history.back();" class="btn-80" value="<msg:message code='button.back'/>"/>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>	
</html>