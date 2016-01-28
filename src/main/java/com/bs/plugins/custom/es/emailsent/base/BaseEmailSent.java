package com.bs.plugins.custom.es.emailsent.base;

import com.bs.core.entity.Entity;


public class BaseEmailSent extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**邮件地址-**/
	private String email;
	/**会员Id-**/
	private Long memberId;
	/**标题-**/
	private String title;
	/**内容-**/
	private String content;
	/**发送者-**/
	private String senderEmail;
	/**发送者名称-**/
	private String senderName;
	/**业务类型代码-SM1001：验证码短信**/
	private String businessCode;
	/**是否重发-**/
	private Integer isRetry;
	/**重发次数-默认为0，每重发一次，该值+1，直到最大重发次数**/
	private Integer retryCount;
	/**发送状态-0 未发送 1 已发送 2 发送失败**/
	private Integer status;
	/**状态说明-**/
	private String statements;
	/**发送时间-**/
	private String sendTime;
	/**创建时间-**/
	private String createTime;
	/**超时时长-设置超时 （单位/毫秒）**/
	private Long timeout;
	/**开始时间-计算超时的开始时间**/
	private Long beginTime;

	public BaseEmailSent() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
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
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatements() {
		return statements;
	}

	public void setStatements(String statements) {
		this.statements = statements;
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
	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	
}
