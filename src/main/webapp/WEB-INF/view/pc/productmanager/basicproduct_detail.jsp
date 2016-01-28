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
	var temp = "";
	if('${spvId }' != "") {
		temp = "spvId = ${spvId }"
	}
//	$("input[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"UC.Organization.Id.Name",dataCond:"Type=2" + temp});
	$("input[name=spvId]").initCol({tagClass:"dfinput",dataSrc:"table",dataCode:"CC.SpvCorporation.Id.Name",dataCond:"Status=1"});

});
</script>
</head>
<body>
<form:form method="post" action="${base}/form/submit/basicProduct/modify" commandName="basicProduct" name="basicProduct" >
<input type="hidden" name="isLog" value="1"/>
<input type="hidden" name="viewCode" value="${pc_productmanager_basicproduct_code}"/>
<input type="hidden" name="replaceName" value="name"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_basicproduct_code},<msg:message code='button.back.list'/>"/>
<input type="hidden" name="buttonGroup" value="${pc_productmanager_basicproduct_modify_code},<msg:message code='button.continue.modify'/>"/>
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.name'/>
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
					<b>*</b><msg:message code='basicProduct.code'/>
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
					<b>*</b><msg:message code='basicProduct.spvId'/>
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
					<b>*</b><msg:message code='basicProduct.totalAmount'/>
				</div>
				<div class="form-field-elt">
					<form:input path="totalAmount" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="totalAmount" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.interestRateDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="interestRateDate" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="interestRateDate" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.profitExpirationDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="profitExpirationDate" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="profitExpirationDate" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.actualExpirationDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="actualExpirationDate" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="actualExpirationDate" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.paymentDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="paymentDate" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="paymentDate" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.actualPaymentDate'/>
				</div>
				<div class="form-field-elt">
					<form:input path="actualPaymentDate" readonly="readonly" class="dfinput date twidth Wdate" style="height:30px;"  onfocus="WdatePicker({isShowWeek:false,dateFmt:'yyyy-MM-dd'})"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="actualPaymentDate" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.expectedProfitRatio'/>
				</div>
				<div class="form-field-elt">
					<form:input path="expectedProfitRatio" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="expectedProfitRatio" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.actualExpectedProfitRatio'/>
				</div>
				<div class="form-field-elt">
					<form:input path="actualExpectedProfitRatio" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="actualExpectedProfitRatio" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.expectedProfit'/>
				</div>
				<div class="form-field-elt">
					<form:input path="expectedProfit" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="expectedProfit" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<b>*</b><msg:message code='basicProduct.actualProfit'/>
				</div>
				<div class="form-field-elt">
					<form:input path="actualProfit" class="dfinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="actualProfit" delimiter=" "></form:errors>
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='basicProduct.description'/>
				</div>
				<div class="form-field-elt">
					<form:textarea path="description" class="textinput"/>
				</div>
				<div class="form-field-prompt">
					<form:errors path="description" delimiter=" "></form:errors>
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="button" onclick="window.location.href='${base}/history/back/${pc_productmanager_basicproduct_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>