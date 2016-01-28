package com.bs.plugins.custom.cc.realnameauthenticate.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseRealnameAuthenticate extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**会员表主键ID-**/
	private Long id;
	/**客户账号-**/
	private Long memberId;
	/**姓名-**/
	private String name;
	/**证件类型-1：身份证 2：警官证 3：护照 4：驾驶证 5：其他**/
	private Integer certificateType;
	/**证件号码-**/
	private String certificateNo;
	/**是否成功-1：是 0：否**/
	private Integer isSuccess;
	/**验证时间-**/
	private String authenticateTime;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseRealnameAuthenticate() {
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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public Integer getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getAuthenticateTime() {
		return authenticateTime;
	}

	public void setAuthenticateTime(String authenticateTime) {
		this.authenticateTime = authenticateTime;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
