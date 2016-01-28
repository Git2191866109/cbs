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
<form:form method="post" action="${base}/form/submit/subscription/modify" commandName="subscription" name="subscription">
<form:hidden path="id" />
<form:hidden path="transactionNumber" />
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="replaceName" value="transactionNumber"/>
<input type="hidden" name="buttonGroup" value="${tc_transaction_subscription_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${tc_transaction_subscription_modify_code},<msg:message code='button.continue.modify'/>"/>
<input type="hidden" name="viewCode" value="${tc_transaction_subscription_code}">

<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					订单号：
				</div>
				<div class="form-field-elt">
					${subscription.transactionNumber }
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<b>*</b>备注：
				</div>
				<div class="form-field-elt">
					<form:input path="remark" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="remark" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="submit" class="btn-80" value="<msg:message code='button.save'/>"/>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" onclick="window.location.href='${base}/history/back/${tc_transaction_subscription_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>