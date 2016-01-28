package com.bs.plugins.custom.pc.contracttemplate.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.productcontract.entity.ProductContract;	
import java.util.ArrayList;

public class BaseContractTemplate extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-主键ID**/
	private Long id;
	/**名称-名称**/
	private String name;
	/**编码-编码**/
	private String code;
	/**模板路径-**/
	private String templatePath;
	/**模板内容-**/
	private String templateContent;
	/**描述-描述**/
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
	/**产品中心-产品合同表**/
	private ArrayList<ProductContract> productContracts;

	public BaseContractTemplate() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
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
	
	public ArrayList<ProductContract> getProductContract () {
		return productContracts;
	}

	public void setProductContract(ArrayList<ProductContract> productContracts) {
		this.productContracts = productContracts;
	}	
}
