package com.bs.plugins.custom.pc.contracttemplate.entity;

import com.bs.plugins.custom.pc.contracttemplate.base.BaseContractTemplate;

public class ContractTemplate extends BaseContractTemplate {

	private static final long serialVersionUID = 1L;

	public ContractTemplate() {
	}
	
	public Long productId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
}
