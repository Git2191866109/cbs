package com.bs.plugins.custom.pc.productcontract.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.product.entity.Product;
import com.bs.plugins.custom.pc.contracttemplate.entity.ContractTemplate;

public class BaseProductContract extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-主键ID**/
	private Long id;
	/**产品ID-**/
	private Long productId;
	/**来源模板Id-**/
	private Long templateId;
	/**合同名称-名称**/
	private String name;
	/**合同编码-编码**/
	private String code;
	/**合同文件路径-**/
	private String filePath;
	/**合同内容-**/
	private String content;
	/**合同描述-描述**/
	private String description;
	/**创建人-创建人**/
	private Long creatorId;
	/**创建时间-创建时间**/
	private String createTime;
	/**修改人-修改人**/
	private Long modifierId;
	/**修改时间-修改时间**/
	private String modifyTime;
	/**删除标识-删除标识**/
	private Integer delFlag;
	/**产品管理-产品信息存储表**/
	private Product product;
	/**产品中心-产品合同模板信息存储表**/
	private ContractTemplate contractTemplate;

	public BaseProductContract() {
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
	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
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
