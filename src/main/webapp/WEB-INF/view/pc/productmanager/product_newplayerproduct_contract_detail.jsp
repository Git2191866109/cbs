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
//	$(".form-content").height(height-170);

});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/productContract/modify" commandName="productContract" name="productContract" >
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${pc_productmanager_product_newplayerproduct_contract_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_product_newplayerproduct_contract_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_product_newplayerproduct_contract_modify_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='productContract.name'/>
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
					<b>*</b><msg:message code='productContract.code'/>
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
					<b>*</b><msg:message code='productContract.templatePath'/>
				</div>
				<div class="form-field-elt">
					<form:input path="templatePath" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="templatePath" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='productContract.description'/>
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
					<msg:message code='productContract.templateContent'/>
				</div>
				<div class="form-field-elt">
					<form:textarea path="templateContent"  rows="50" cols="150"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="templateContent" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="button" onclick="window.location.href='${base}/history/back/${pc_productmanager_product_newplayerproduct_contract_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>