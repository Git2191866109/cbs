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
	
	var type = '${school.type}';
	var typeradio = document.getElementsByName("type");  
    for (var i=0; i<typeradio.length; i++){  
        if (typeradio[i].value==type) {  
        	typeradio[i].checked= true;  
            break;  
        }  
    }  
	
    var level = '${school.level}';
	var levelradio = document.getElementsByName("level"); 
	for(var j = 0; j< levelradio.length;j++){
		 if (levelradio[j].value==level) {  
			 levelradio[j].checked= true;  
	            break;  
	        }  
	}
	
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/school/modify/${sc_education_school_code}" commandName="school" name="school">
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='school.areaCode'/>
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
					<b>*</b><msg:message code='school.code'/>
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
					<b>*</b><msg:message code='school.name'/>
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
					<b>*</b><msg:message code='school.type'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="type" value="1" />公立
					<input type="radio" name="type" value="2" style="margin-left: 75px"/>私立
					<input type="radio" name="type" value="3" style="margin-left: 75px"/>国外
				</div>
				<div class="form-field-prompt">
					<form:errors path="type" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='school.level'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="level" value="1" />大学
					<input type="radio" name="level" value="2" style="margin-left: 75px"/>高中
					<input type="radio" name="level" value="3" style="margin-left: 75px"/>初中
					<input type="radio" name="level" value="4" style="margin-left: 75px"/>小学
					<input type="radio" name="level" value="5" style="margin-left: 75px"/>幼儿园
				</div>
				<div class="form-field-prompt">
					<form:errors path="level" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='school.address'/>
				</div>
				<div class="form-field-elt">
					<form:input path="address" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="address" delimiter=" "></form:errors>
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