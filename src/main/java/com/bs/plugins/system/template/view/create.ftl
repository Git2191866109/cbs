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
	$(".form-content").height(height-70);
});
</script>
</head>
<body>
<form:form method="post" action="<#noparse>${</#noparse>base<#noparse>}</#noparse>/form/submit/${config.modelNameSuffix?uncap_first}/create/<#noparse>${</#noparse>${config.codeKey}_code<#noparse>}</#noparse>" commandName="${config.modelNameSuffix?uncap_first}" name="${config.modelNameSuffix?uncap_first}">
<#if (fileds?size >0) >	
<#list fileds as list>
<#if list.hidden == '1'>
<form:hidden path="${list.name}"/>
</#if>
</#list>
</#if>
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul>
		<#if (fileds?size >0) >	
			<#list fileds as list>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='${config.modelNameSuffix?uncap_first}.${list.name}'/>
				</div>
				<div class="form-field-elt">
					<form:input path="${list.name}" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="${list.name}" delimiter=" "></form:errors>
				</div>
			</li>
			</#list>
		</#if>
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