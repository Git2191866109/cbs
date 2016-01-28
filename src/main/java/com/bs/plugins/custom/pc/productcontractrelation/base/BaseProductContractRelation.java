package com.bs.plugins.custom.pc.productcontractrelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.contracttemplate.entity.ContractTemplate;

public class BaseProductContractRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**产品主键Id-**/
	private Long productId;
	/**合同模板主键Id-**/
	private Long contractTemplateId;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**产品中心-产品合同模板信息存储表**/
	private ContractTemplate contractTemplate;

	public BaseProductContractRelation() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getContractTemplateId() {
		return contractTemplateId;
	}

	public void setContractTemplateId(Long contractTemplateId) {
		this.contractTemplateId = contractTemplateId;
	}
	
	public Product getProduct () {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public ContractTemplate getContractTemplate () {
		return contractTemplate;
	}

	public void setContractTemplate(ContractTemplate contractTemplate) {
		this.contractTemplate = contractTemplate;
	}
}
