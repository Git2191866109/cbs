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
	initDynamicSelect('memberId','CC.Member.Id.Name',"dfinput");
	initSelect('status','TC.RechargeRecords.Status',"dfinput");

});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/rechargeRecords/modify" commandName="rechargeRecords" name="rechargeRecords" >
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${tc_accounting_recharge_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${tc_accounting_recharge_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${tc_accounting_recharge_modify_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.id'/>
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
					<b>*</b><msg:message code='rechargeRecords.memberId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="memberId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="memberId" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.transactionNumber'/>
				</div>
				<div class="form-field-elt">
					<form:input path="transactionNumber" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="transactionNumber" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.payPlantformNumber'/>
				</div>
				<div class="form-field-elt">
					<form:input path="payPlantformNumber" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="payPlantformNumber" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.amount'/>
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
					<msg:message code='rechargeRecords.iDCardType'/>
				</div>
				<div class="form-field-elt">
					<form:input path="iDCardType" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="iDCardType" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.iDCard'/>
				</div>
				<div class="form-field-elt">
					<form:input path="iDCard" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="iDCard" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.bankName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="bankName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="bankName" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.handlingCharge'/>
				</div>
				<div class="form-field-elt">
					<form:input path="handlingCharge" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="handlingCharge" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.applyTime'/>
				</div>
				<div class="form-field-elt">
					<form:input path="applyTime" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="applyTime" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.status'/>
				</div>
				<div class="form-field-elt">
					<form:input path="status" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="status" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.checkingTime'/>
				</div>
				<div class="form-field-elt">
					<form:input path="checkingTime" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="checkingTime" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.checkingStatus'/>
				</div>
				<div class="form-field-elt">
					<form:input path="checkingStatus" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="checkingStatus" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='rechargeRecords.remark'/>
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
		<input type="button" onclick="window.location.href='${base}/history/back/${tc_accounting_recharge_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>