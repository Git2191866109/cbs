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
<form:form method="post" action="${base}/form/submit/itemFieldValue/create/${eb_budget_value_create_code}" commandName="itemFieldValue" name="itemFieldValue">
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.serialVersionUID'/>
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
					<b>*</b><msg:message code='itemFieldValue.id'/>
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
					<b>*</b><msg:message code='itemFieldValue.itemNameId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="itemNameId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="itemNameId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.value'/>
				</div>
				<div class="form-field-elt">
					<form:input path="value" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="value" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.isValid'/>
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
					<b>*</b><msg:message code='itemFieldValue.isDefault'/>
				</div>
				<div class="form-field-elt">
					<form:input path="isDefault" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="isDefault" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.year'/>
				</div>
				<div class="form-field-elt">
					<form:input path="year" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="year" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.month'/>
				</div>
				<div class="form-field-elt">
					<form:input path="month" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="month" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.description'/>
				</div>
				<div class="form-field-elt">
					<form:input path="description" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="description" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.createDate'/>
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
					<b>*</b><msg:message code='itemFieldValue.modifyDate'/>
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
					<b>*</b><msg:message code='itemFieldValue.creatorId'/>
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
					<b>*</b><msg:message code='itemFieldValue.itemField'/>
				</div>
				<div class="form-field-elt">
					<form:input path="itemField" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="itemField" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='itemFieldValue.itemFieldCollectValues'/>
				</div>
				<div class="form-field-elt">
					<form:input path="itemFieldCollectValues" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="itemFieldCollectValues" delimiter=" "></form:errors>
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