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
<form:form method="post" action="${base}/form/submit/itemField/modify" commandName="itemField" name="itemField">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${eb_budget_name_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${eb_budget_name_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${eb_budget_name_modify_code},<msg:message code='button.continue.modify'/>"/>
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.serialVersionUID'/>
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
					<b>*</b><msg:message code='itemField.id'/>
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
					<b>*</b><msg:message code='itemField.areaCode'/>
				</div>
				<div class="form-field-elt">
					<form:input path="areaCode" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="areaCode" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.budgetItemId'/>
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
					<b>*</b><msg:message code='itemField.name'/>
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
					<b>*</b><msg:message code='itemField.code'/>
				</div>
				<div class="form-field-elt">
					<form:input path="code" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="code" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.showSort'/>
				</div>
				<div class="form-field-elt">
					<form:input path="showSort" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="showSort" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.age'/>
				</div>
				<div class="form-field-elt">
					<form:input path="age" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="age" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.isDataTemplate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="isDataTemplate" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="isDataTemplate" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.isValid'/>
				</div>
				<div class="form-field-elt">
					<form:input path="isValid" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="isValid" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.isTemplate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="isTemplate" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="isTemplate" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.createDate'/>
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
					<b>*</b><msg:message code='itemField.modifyDate'/>
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
					<b>*</b><msg:message code='itemField.creatorId'/>
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
					<b>*</b><msg:message code='itemField.budgetItem'/>
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
					<b>*</b><msg:message code='itemField.area'/>
				</div>
				<div class="form-field-elt">
					<form:input path="area" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="area" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.itemFieldValues'/>
				</div>
				<div class="form-field-elt">
					<form:input path="itemFieldValues" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="itemFieldValues" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.budgetListBeiJings'/>
				</div>
				<div class="form-field-elt">
					<form:input path="budgetListBeiJings" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="budgetListBeiJings" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemField.dataRelationalTables'/>
				</div>
				<div class="form-field-elt">
					<form:input path="dataRelationalTables" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="dataRelationalTables" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.modify'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${eb_budget_name_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>