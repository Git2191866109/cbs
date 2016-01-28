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
	$("#isUse1").attr("checked",true);
	
	$("#form").submit(function(){
		var isExist = $("#isExist").val();
		var isUse = $("input[name=isUse]:checked").val();
		if(isExist == "1" && isUse == "1"){
			top.layer.alert("请先将其他通道关闭再试");
			return false;
		}else{
			return true;
		}
	});
});
</script>
</head>
<body>
<form:form method="post" id="form" action="${base}/form/submit/serviceProvider/create" commandName="serviceProvider" name="serviceProvider">
<input type="hidden" name="replace_message_element_name" value="code">
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${sm_sms_config_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${sm_sms_config_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${sm_sms_config_create_code},<msg:message code='button.continue.create'/>"/>
<input type="hidden" id="isExist" value="${isExist }"/>
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='serviceProvider.code'/>
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
					<b>*</b><msg:message code='serviceProvider.name'/>
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
					<b>*</b><msg:message code='serviceProvider.isUse'/>
				</div>
				<div class="form-field-elt">
					<form:radiobutton path="isUse" value="0" />否
					<form:radiobutton path="isUse" value="1" style="margin-left: 50px;"/>是
					
				</div>
				<div class="form-field-prompt">
					<form:errors path="isUse" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='serviceProvider.description'/>
				</div>
				<div class="form-field-elt">
					<form:input path="description" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="description" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">&nbsp;</div>
				<div class="form-field-elt">
					<input type="submit" class="btn-80" value="<msg:message code='button.create'/>"/>
					<input type="button" onclick="window.location.href='${base}/history/back/${sm_sms_config_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>	
</html>