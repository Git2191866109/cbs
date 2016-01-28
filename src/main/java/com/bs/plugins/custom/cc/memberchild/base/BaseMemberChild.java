package com.bs.plugins.custom.cc.memberchild.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseMemberChild extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-**/
	private Long id;
	/**用户主键Id-**/
	private Long memberId;
	/**性别-**/
	private String sex;
	/**生日-**/
	private String birthday;
	/**姓名-**/
	private String name;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String updateDate;
	/**创建者-**/
	private Long creatorId;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseMemberChild() {
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
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
