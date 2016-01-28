package com.bs.plugins.custom.cc.loginrecord.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseLoginRecord extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**会员表主键ID-**/
	private Long id;
	/**客户账号-**/
	private Long memberId;
	/**登录IP-1：身份证 2：警官证 3：护照 4：驾驶证 5：其他**/
	private String loginIp;
	/**登录时间-**/
	private String loginTime;
	/**浏览器类型-**/
	private String explorer;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseLoginRecord() {
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
	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getExplorer() {
		return explorer;
	}

	public void setExplorer(String explorer) {
		this.explorer = explorer;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
