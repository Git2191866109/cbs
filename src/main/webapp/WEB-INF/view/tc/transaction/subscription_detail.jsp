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
<form:form method="post" action="" commandName="subscription" name="subscription">
<form:hidden path="id" />
<div class="form-body">
	<div class="form-title"><span><msg:message code='system.prompt.basic.info'/></span></div>
	<div class="form-content">
		<ul style="overflow-y:auto;height:100%;width:100%">
	        <li>
				<div class="form-field-title">
					<msg:message code='subscription.member.name'/>：
				</div>
				<div class="form-field-elt">
					${subscription.memberName }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.productName'/>：
				</div>
				<div class="form-field-elt">
					${subscription.productName}
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='subscription.transactionNumber'/>：
				</div>
				<div class="form-field-elt">
					${subscription.transactionNumber }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.productCode'/>：
				</div>
				<div class="form-field-elt">
					${subscription.productCode }
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='subscription.tradeStatus'/>：
				</div>
				<div class="form-field-elt">
					<c:if test="${subscription.status == 0 }">认购失败</c:if>
					<c:if test="${subscription.status == 1 }">存续中</c:if>
					<c:if test="${subscription.status == 2 }">兑付中</c:if>
					<c:if test="${subscription.status == 3 }">已兑付</c:if>
					<c:if test="${subscription.status == 4 }">兑付失败</c:if>
					<c:if test="${subscription.status == 5 }">延期</c:if>
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.investAmount'/>：
				</div>
				<div class="form-field-elt">
					${subscription.investAmount }
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='subscription.shares'/>：
				</div>
				<div class="form-field-elt">
					${subscription.shares }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.loanStatus'/>：
				</div>
				<div class="form-field-elt">
					<c:if test="${subscription.loanStatus == 0 }">未放款</c:if>
					<c:if test="${subscription.loanStatus == 1 }">已放款</c:if>
					<c:if test="${subscription.loanStatus == 2 }">放款成功</c:if>
					<c:if test="${subscription.loanStatus == 3 }">放款失败</c:if>
					<c:if test="${subscription.loanStatus == 4 }">拒绝放款</c:if>
				</div>
			</li>
	        <li>
				<div class="form-field-title">
					<msg:message code='subscription.status'/>：
				</div>
				<div class="form-field-elt">
					<c:if test="${subscription.status == 0 }">认购失败</c:if>
					<c:if test="${subscription.status == 1 }">认购成功</c:if>
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.paymentDate'/>：
				</div>
				<div class="form-field-elt">
					${subscription.paymentDate }
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='subscription.expectedProfitRatio'/>：
				</div>
				<div class="form-field-elt">
					${subscription.expectedProfitRatio }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.expectedProfit'/>：
				</div>
				<div class="form-field-elt">
					${subscription.expectedProfit }
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='subscription.spvServiceFee'/>：
				</div>
				<div class="form-field-elt">
					${subscription.spvServiceFee }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.spvServiceFeeRatio'/>：
				</div>
				<div class="form-field-elt">
					${subscription.spvServiceFeeRatio }
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='subscription.orderTime'/>：
				</div>
				<div class="form-field-elt">
					${subscription.orderTime }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.interestRateDate'/>：
				</div>
				<div class="form-field-elt">
					${subscription.interestRateDate }
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='subscription.distributeStatus'/>：
				</div>
				<div class="form-field-elt">
					${subscription.distributeStatus }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.distributeTime'/>：
				</div>
				<div class="form-field-elt">
					${subscription.distributeTime }
				</div>
			</li>
			<li>
				<div class="form-field-title">
					<msg:message code='subscription.checkingStatus'/>：
				</div>
				<div class="form-field-elt">
					<c:if test="${subscription.checkingStatus == 0 }">未对账</c:if>
					<c:if test="${subscription.checkingStatus == 1 }">对账成功</c:if>
					<c:if test="${subscription.checkingStatus == 2 }">对账失败</c:if>
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.checkingTime'/>：
				</div>
				<div class="form-field-elt">
					${subscription.checkingTime }
				</div>
			</li>
			 <li>
				 <div class="form-field-title">
						<msg:message code='subscription.actualLoanAmount'/>：
					</div>
					<div class="form-field-elt">
						${subscription.actualLoanAmount }
				</div>
				<div class="form-field-title">
					<msg:message code='subscription.remark'/>：
				</div>
				<div class="form-field-elt">
					${subscription.remark }
				</div>
			</li>
		</ul>
	</div>
	<div class="form-footer">
		<input type="button" onclick="window.location.href='${base}/history/back/${tc_transaction_subscription_code}'" class="btn-80" value="<msg:message code='button.back'/>"/>
	</div>
</div>
</form:form>
</body>	
</html>