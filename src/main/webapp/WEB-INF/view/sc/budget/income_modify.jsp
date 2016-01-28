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
	
	var isBaseDate = '${residentIncomes.isBaseDate}';
	var radio = document.getElementsByName("isBaseDate");  
    for (var i=0; i<radio.length; i++){  
        if (radio[i].value == isBaseDate) {  
        	radio[i].checked= true;  
            break;  
        }  
    }
	
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/residentIncomes/modify/${sc_budget_income_code}" commandName="residentIncomes" name="residentIncomes">
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='residentIncomes.areaCode'/>
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
					<b>*</b><msg:message code='residentIncomes.amount'/>
				</div>
				<div class="form-field-elt">
					<form:input path="amount" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="amount" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='residentIncomes.isBaseDate'/>
				</div>
				<div class="form-field-elt">
					<input type="radio" name="isBaseData" value="0" />否
					<input type="radio" name="isBaseData" value="1" style="margin-left: 50px;" />是
				</div>
				<div class="form-field-prompt">
					<form:errors path="isBaseData" delimiter=" "></form:errors>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b><msg:message code='residentIncomes.ratio'/>
				</div>
				<div class="form-field-elt">
					<form:input path="ratio" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="ratio" delimiter=" "></form:errors>
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