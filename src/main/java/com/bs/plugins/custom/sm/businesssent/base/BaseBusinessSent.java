package com.bs.plugins.custom.sm.businesssent.base;

import com.bs.core.entity.Entity;


public class BaseBusinessSent extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**发送手机号-**/
	private String mobilePhone;
	/**客户ID-**/
	private Long memberId;
	/**内容-**/
	private String content;
	/**业务类型-SM1001：验证码短信**/
	private String businessCode;
	/**SP代码-**/
	private String spCode;
	/**是否重发-**/
	private Integer isRetry;
	/**重发次数-默认为0，每重发一次，该值+1，直到最大重发次数**/
	private Integer retryCount;
	/**短信序列号-**/
	private String messageSerial;
	/**发送状态-**/
	private Integer status;
	/**状态报告-**/
	private Integer statusReport;
	/**状态说明-**/
	private String statements;
	/**短信类型-长短信 32 短短信 15**/
	private String type;
	/**短信拆分总条数-长短信被拆分的总条数**/
	private Integer totalCount;
	/**发送时间-**/
	private String sendTime;
	/**创建时间-**/
	private String createTime;
	/**超时时长-超时时长： 单位/毫秒**/
	private Long timeout;
	/**开始时间-**/
	private Long originTime;

	public BaseBusinessSent() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	public Integer getIsRetry() {
		return isRetry;
	}

	public void setIsRetry(Integer isRetry) {
		this.isRetry = isRetry;
	}
	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
	public String getMessageSerial() {
		return messageSerial;
	}

	public void setMessageSerial(String messageSerial) {
		this.messageSerial = messageSerial;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getStatusReport() {
		return statusReport;
	}

	public void setStatusReport(Integer statusReport) {
		this.statusReport = statusReport;
	}
	public String getStatements() {
		return statements;
	}

	public void setStatements(String statements) {
		this.statements = statements;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public Long getOriginTime() {
		return originTime;
	}

	public void setOriginTime(Long originTime) {
		this.originTime = originTime;
	}
	
}
