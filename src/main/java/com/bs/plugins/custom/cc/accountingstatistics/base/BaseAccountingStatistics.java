package com.bs.plugins.custom.cc.accountingstatistics.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;

public class BaseAccountingStatistics extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**账户表主键ID-**/
	private Long id;
	/**会员ID-**/
	private Long memberId;
	/**累计预期收益-包括但钱持有本金收益和已经返回的收益**/
	private BigDecimal totalExpectedProfit;
	/**累计实际收益-包括但钱持有本金收益和已经返回的收益**/
	private BigDecimal totalActualProfit;
	/**累计投入-**/
	private BigDecimal totalInvestment;
	/**累计本金返还-包括持有和已经返还**/
	private BigDecimal totalPrincipal;
	/**当前持有本金-**/
	private BigDecimal holdPrincipal;
	/**累计预期资产总额-**/
	private BigDecimal totallExpectedAsset;
	/**累计活动奖金-**/
	private BigDecimal totalActivityBonus;
	/**累计体验金-**/
	private BigDecimal totalExperienceGold;
	/**用户中心-会员信息存储表**/
	private Member member;

	public BaseAccountingStatistics() {
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
	public BigDecimal getTotalExpectedProfit() {
		return totalExpectedProfit;
	}

	public void setTotalExpectedProfit(BigDecimal totalExpectedProfit) {
		this.totalExpectedProfit = totalExpectedProfit;
	}
	public BigDecimal getTotalActualProfit() {
		return totalActualProfit;
	}

	public void setTotalActualProfit(BigDecimal totalActualProfit) {
		this.totalActualProfit = totalActualProfit;
	}
	public BigDecimal getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(BigDecimal totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	public BigDecimal getTotalPrincipal() {
		return totalPrincipal;
	}

	public void setTotalPrincipal(BigDecimal totalPrincipal) {
		this.totalPrincipal = totalPrincipal;
	}
	public BigDecimal getHoldPrincipal() {
		return holdPrincipal;
	}

	public void setHoldPrincipal(BigDecimal holdPrincipal) {
		this.holdPrincipal = holdPrincipal;
	}
	public BigDecimal getTotallExpectedAsset() {
		return totallExpectedAsset;
	}

	public void setTotallExpectedAsset(BigDecimal totallExpectedAsset) {
		this.totallExpectedAsset = totallExpectedAsset;
	}
	public BigDecimal getTotalActivityBonus() {
		return totalActivityBonus;
	}

	public void setTotalActivityBonus(BigDecimal totalActivityBonus) {
		this.totalActivityBonus = totalActivityBonus;
	}
	public BigDecimal getTotalExperienceGold() {
		return totalExperienceGold;
	}

	public void setTotalExperienceGold(BigDecimal totalExperienceGold) {
		this.totalExperienceGold = totalExperienceGold;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
