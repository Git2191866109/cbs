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
<form:form method="post" action="${base}/form/submit/viewConfiguration/create/${sc_view_structure_update_code}" commandName="viewConfiguration" name="viewConfiguration">
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.serialVersionUID'/>
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
					<b>*</b><msg:message code='viewConfiguration.id'/>
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
					<b>*</b><msg:message code='viewConfiguration.authId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="authId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="authId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.tableId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="tableId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="tableId" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.pageType'/>
				</div>
				<div class="form-field-elt">
					<form:input path="pageType" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="pageType" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.showType'/>
				</div>
				<div class="form-field-elt">
					<form:input path="showType" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="showType" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.columnSort'/>
				</div>
				<div class="form-field-elt">
					<form:input path="columnSort" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="columnSort" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.dataSourcesType'/>
				</div>
				<div class="form-field-elt">
					<form:input path="dataSourcesType" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="dataSourcesType" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.dataSources'/>
				</div>
				<div class="form-field-elt">
					<form:input path="dataSources" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="dataSources" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.comment'/>
				</div>
				<div class="form-field-elt">
					<form:input path="comment" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="comment" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.code'/>
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
					<b>*</b><msg:message code='viewConfiguration.name'/>
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
					<b>*</b><msg:message code='viewConfiguration.authorization'/>
				</div>
				<div class="form-field-elt">
					<form:input path="authorization" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="authorization" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.table'/>
				</div>
				<div class="form-field-elt">
					<form:input path="table" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="table" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='viewConfiguration.viewAttributes'/>
				</div>
				<div class="form-field-elt">
					<form:input path="viewAttributes" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="viewAttributes" delimiter=" "></form:errors>
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