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
	
	var isValid = '${degree.isValid}';
	var radio = document.getElementsByName("isValid");  
    for (var i=0; i<radio.length; i++){  
        if (radio[i].value == isValid) {  
        	radio[i].checked= true;  
            break;  
        }  
    } 
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/degree/modify/${sc_education_degree_code}" commandName="degree" name="degree">
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='degree.name'/>
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
					<b>*</b><msg:message code='degree.description'/>
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
					<b>*</b><msg:message code='degree.isValid'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="isValid" value="0" />无效
					<input type="radio" name="isValid" value="1" style="margin-left: 50px;" />有效
				</div>
				<div class="form-field-prompt">
					<form:errors path="isValid" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">&nbsp;</div>
				<div class="form-field-elt">
					<input type="submit" class="btn-80" value="<msg:message code='button.modify'/>"/>
					<input type="button" onclick="javascript:history.back();" class="btn-80" value="<msg:message code='button.back'/>"/>
				</div>
			</li>
		</ul>
	</div>
</div>
</form:form>
</body>	
</html>