package com.bs.plugins.custom.cc.accounting.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseAccounting extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**账户表主键ID-**/
	private Long id;
	/**会员ID-**/
	private Long memberId;
	/**账户可用余额-包括但钱持有本金收益和已经返回的收益**/
	private BigDecimal availableAmount;
	/**账户冻结金额-包括但钱持有本金收益和已经返回的收益**/
	private BigDecimal frozenAmount;
	/**免手续费金额-**/
	private BigDecimal freeChargeAmount;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseAccounting() {
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
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	public BigDecimal getFrozenAmount() {
		return frozenAmount;
	}

	public void setFrozenAmount(BigDecimal frozenAmount) {
		this.frozenAmount = frozenAmount;
	}
	public BigDecimal getFreeChargeAmount() {
		return freeChargeAmount;
	}

	public void setFreeChargeAmount(BigDecimal freeChargeAmount) {
		this.freeChargeAmount = freeChargeAmount;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
