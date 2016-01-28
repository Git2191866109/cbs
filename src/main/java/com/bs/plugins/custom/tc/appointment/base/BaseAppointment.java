package com.bs.plugins.custom.tc.appointment.base;

import com.bs.core.entity.Entity;
import java.math.BigDecimal;

import com.bs.plugins.custom.cc.member.entity.Member;
import com.bs.plugins.custom.pc.product.entity.Product;

public class BaseAppointment extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**会员主键Id-**/
	private Long memberId;
	/**SPV公司Id-**/
	private Long spvId;
	/**产品主键Id-**/
	private Long productId;
	/**联系人-**/
	private String contact;
	/**预约手机号-**/
	private String mobilePhone;
	/**产品名称-**/
	private String productName;
	/**产品代码-**/
	private String productCode;
	/**预约金额-**/
	private BigDecimal appointAmount;
	/**份额-**/
	private Integer shares;
	/**预约时间-**/
	private String appointTime;
	/**预约状态-1：预约成功 0：预约失败**/
	private Integer status;
	/**备注-**/
	private String remark;
	/**用户中心-会员信息存储表**/
	private Member member;
	/**产品管理-产品信息存储表**/
	private Product product;

	public BaseAppointment() {
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
	public Long getSpvId() {
		return spvId;
	}

	public void setSpvId(Long spvId) {
		this.spvId = spvId;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public BigDecimal getAppointAmount() {
		return appointAmount;
	}

	public void setAppointAmount(BigDecimal appointAmount) {
		this.appointAmount = appointAmount;
	}
	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}
	public String getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Member getMember () {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
