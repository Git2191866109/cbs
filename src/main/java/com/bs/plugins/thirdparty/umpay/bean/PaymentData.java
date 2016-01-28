package com.bs.plugins.thirdparty.umpay.bean;

public class PaymentData implements java.io.Serializable{
	
	private static final long serialVersionUID = -348608628665983357L;
	
	/**签名方式**/
	private String signType;
	/**签名**/
	private String sign;
	/**商户编号**/
	private String merId;
	/**版本号**/
	private String version;
	/**开户日期**/
	private String regDate;
	/**资金托管平台用户号**/
	private String userId;
	/**资金托管平台账户号**/
	private String accountId;
	/**商户订单号**/
	private String orderId;
	/**标的账户**/
	private String projectAccountId;
	/**标的账户状态**/
	private String projectState;
	/**商户对账日期**/
	private String merCheckDate;
	/**平台返回流水号**/
	private String tradeNo;
	/**余额**/
	private String balance;
	/**业务类型**/
	private String busiType;
	/**交易金额**/
	private String amount;
	/**原交易金额**/
	private String origAmt;
	/**手续费**/
	private String comAmt;
	/**手续非承担方式**/
	private String comAmtType;
	/**交易状态**/
	private String tranState;
	/**短信个数**/
	private String smsNum;
	/**姓名**/
	private String custName;
	/**证件类型**/
	private String identityType;
	/**证件号**/
	private String identityCode;
	/**手机号**/
	private String contactMobile;
	/**邮箱地址**/
	private String mailAddr;
	/**账户状态**/
	private String accountState;
	/**提现银行卡**/
	private String cardId;
	/**发卡行编号**/
	private String gateId;
	/**用户签约约的协议列表信息**/
	private String userBindAgreementList;
	/**总记录数**/
	private String totalNum;
	/**交易记录**/
	private String transDetail;
	/**查询商户号**/
	private String queryMerId;
	/**被充值企业资金账户托管平台的账户类型**/
	private String accountType;
	/**返回码**/
	private String retCode;
	/**返回信息**/
	private String retMsg;
	/**transDetail二级域信息????**/
	private TradeDetailData tradeDetailData;
	
	public PaymentData() {
		
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getProjectAccountId() {
		return projectAccountId;
	}

	public void setProjectAccountId(String projectAccountId) {
		this.projectAccountId = projectAccountId;
	}

	public String getProjectState() {
		return projectState;
	}

	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}

	public String getMerCheckDate() {
		return merCheckDate;
	}

	public void setMerCheckDate(String merCheckDate) {
		this.merCheckDate = merCheckDate;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrigAmt() {
		return origAmt;
	}

	public void setOrigAmt(String origAmt) {
		this.origAmt = origAmt;
	}

	public String getComAmt() {
		return comAmt;
	}

	public void setComAmt(String comAmt) {
		this.comAmt = comAmt;
	}

	public String getComAmtType() {
		return comAmtType;
	}

	public void setComAmtType(String comAmtType) {
		this.comAmtType = comAmtType;
	}

	public String getTranState() {
		return tranState;
	}

	public void setTranState(String tranState) {
		this.tranState = tranState;
	}

	public String getSmsNum() {
		return smsNum;
	}

	public void setSmsNum(String smsNum) {
		this.smsNum = smsNum;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getMailAddr() {
		return mailAddr;
	}

	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}

	public String getAccountState() {
		return accountState;
	}

	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getGateId() {
		return gateId;
	}

	public void setGateId(String gateId) {
		this.gateId = gateId;
	}

	public String getUserBindAgreementList() {
		return userBindAgreementList;
	}

	public void setUserBindAgreementList(String userBindAgreementList) {
		this.userBindAgreementList = userBindAgreementList;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getTransDetail() {
		return transDetail;
	}

	public void setTransDetail(String transDetail) {
		this.transDetail = transDetail;
	}

	public String getQueryMerId() {
		return queryMerId;
	}

	public void setQueryMerId(String queryMerId) {
		this.queryMerId = queryMerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public TradeDetailData getTradeDetailData() {
		return tradeDetailData;
	}

	public void setTradeDetailData(TradeDetailData tradeDetailData) {
		this.tradeDetailData = tradeDetailData;
	}
}
