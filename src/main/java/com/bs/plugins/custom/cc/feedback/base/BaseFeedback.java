package com.bs.plugins.custom.cc.feedback.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseFeedback extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**客户ID-**/
	private Long memberId;
	/**ip地址-**/
	private String ipAddress;
	/**名称-**/
	private String nickName;
	/**邮箱-**/
	private String email;
	/**电话-**/
	private String mobilePhone;
	/**留言内容-**/
	private String content;
	/**创建时间-**/
	private String createTime;
	/**状态-**/
	private Integer state;
	/**回复内容-**/
	private String replyContent;
	/**处理人-**/
	private Long operatorId;
	/**处理时间-**/
	private String dealTime;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseFeedback() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
