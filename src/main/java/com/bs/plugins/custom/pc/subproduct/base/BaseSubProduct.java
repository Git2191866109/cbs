package com.bs.plugins.custom.pc.subproduct.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.product.entity.Product;

public class BaseSubProduct extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**产品主键Id-**/
	private Long productId;
	/**子产品代码-编码**/
	private String code;
	/**发布时间-创建时间**/
	private String releaseTime;
	/**子产品状态-0：创建 1：生效中 2：已失效 3：失败**/
	private Integer status;
	/**托管账户号-**/
	private String umpayAccountNo;
	/**交易单号-**/
	private String transactionNumber;
	/**支付平台流水号-**/
	private String payPlantformNumber;
	/**产品管理-产品信息存储表**/
	private Product product;

	public BaseSubProduct() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUmpayAccountNo() {
		return umpayAccountNo;
	}

	public void setUmpayAccountNo(String umpayAccountNo) {
		this.umpayAccountNo = umpayAccountNo;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getPayPlantformNumber() {
		return payPlantformNumber;
	}

	public void setPayPlantformNumber(String payPlantformNumber) {
		this.payPlantformNumber = payPlantformNumber;
	}
	
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
