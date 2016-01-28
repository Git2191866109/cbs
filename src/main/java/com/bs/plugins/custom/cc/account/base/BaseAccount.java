package com.bs.plugins.custom.cc.account.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseAccount extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**账户表主键ID-**/
	private Long id;
	/**会员ID-**/
	private Long memberId;
	/**累计收益-**/
	private BigDecimal totalProfit;
	/**累计投入-**/
	private BigDecimal totalInvestment;
	/**累计本金返还-**/
	private BigDecimal accumulatedInvestmen;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseAccount() {
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
	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}
	public BigDecimal getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(BigDecimal totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	public BigDecimal getAccumulatedInvestmen() {
		return accumulatedInvestmen;
	}

	public void setAccumulatedInvestmen(BigDecimal accumulatedInvestmen) {
		this.accumulatedInvestmen = accumulatedInvestmen;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
