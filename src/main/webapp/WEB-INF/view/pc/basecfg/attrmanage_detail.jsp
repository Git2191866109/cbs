<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="/WEB-INF/view/taglib.jsp"%>
<%@ include file="/WEB-INF/view/pc/pccommonhead.jsp"%>
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

	initSelect('category','PC.Attribute.Category',"dfinput");
	initSelect('isFixed','PC.Common.Boolean',"dfinput");
	initSelect('isInherit','PC.Common.Boolean',"dfinput");
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/attribute/modify" commandName="attribute" name="attribute" >
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${pc_basecfg_attrmanage_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${pc_basecfg_attrmanage_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${pc_basecfg_attrmanage_modify_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='attribute.name'/>
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
					<b>*</b><msg:message code='attribute.code'/>
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
					<b>*</b><msg:message code='attribute.category'/>
				</div>
				<div class="form-field-elt">
					<form:input path="category" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="category" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='attribute.isFixed'/>
				</div>
				<div class="form-field-elt">
					<form:input path="isFixed" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="isFixed" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='attribute.isInherit'/>
				</div>
				<div class="form-field-elt">
					<form:input path="isInherit" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="isInherit" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='attribute.description'/>
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
		<input type="button" onclick="window.location.href='${base}/history/back/${pc_basecfg_attrmanage_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>