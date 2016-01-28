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
	initDynamicSelect('spvId','CC.SpvCorporation.Id.Name',"dfinput");
	initSelect('status','TC.SpvRechargeRecords.Status',"dfinput");
});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/spvRechargeRecords/modify" commandName="spvRechargeRecords" name="spvRechargeRecords" >
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${tc_accounting_spvrecharge_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${tc_accounting_spvrecharge_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${tc_accounting_spvrecharge_modify_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvRechargeRecords.id'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.spvId'/>
				</div>
				<div class="form-field-elt">
					<form:input path="spvId" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="spvId" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvRechargeRecords.spvName'/>
				</div>
				<div class="form-field-elt">
					<form:input path="spvName" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="spvName" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='spvRechargeRecords.transactionNumber'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.payPlantformNumber'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.amount'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.bankName'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.handlingCharge'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.applyTime'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.status'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.checkingTime'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.checkingStatus'/>
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
					<b>*</b><msg:message code='spvRechargeRecords.remark'/>
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
		<input type="button" onclick="window.location.href='${base}/history/back/${tc_accounting_spvrecharge_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>