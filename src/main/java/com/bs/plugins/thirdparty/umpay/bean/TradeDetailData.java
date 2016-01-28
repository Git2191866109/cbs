package com.bs.plugins.thirdparty.umpay.bean;

public class TradeDetailData implements java.io.Serializable{
	private static final long serialVersionUID = -1978104014973898486L;
	/**交易记账日期**/
	private String accCheckDate;
	/**交易金额**/
	private String amount;
	/**资金类型**/
	private String amtType;
	/**该笔交易后余额**/
	private String balance;
	/**借贷方向**/
	private String dcMark;
	/**商户订单日期**/
	private String orderDate;
	/**商户订单号**/
	private String orderId;
	/**交易日期**/
	private String transDate;
	/**交易状态**/
	private String transState;
	/**交易时间**/
	private String transTime;
	/**交易代码**/
	private String transType;
	
	public TradeDetailData() {
		
	}

	public String getAccCheckDate() {
		return accCheckDate;
	}

	public void setAccCheckDate(String accCheckDate) {
		this.accCheckDate = accCheckDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmtType() {
		return amtType;
	}

	public void setAmtType(String amtType) {
		this.amtType = amtType;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getDcMark() {
		return dcMark;
	}

	public void setDcMark(String dcMark) {
		this.dcMark = dcMark;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getTransState() {
		return transState;
	}

	public void setTransState(String transState) {
		this.transState = transState;
	}

	public String getTransTime() {
		return transTime;
	}

	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}
}
