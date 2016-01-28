package com.bs.plugins.custom.pc.attribute.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;	
import com.bs.plugins.custom.pc.attributedataconfig.entity.AttributeDataConfig;	
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;	
import java.util.ArrayList;

public class BaseAttribute extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**名称-名称**/
	private String name;
	/**编码-编码**/
	private String code;
	/**属性类型-**/
	private Integer category;
	/**是否为固定属性-1：是 0：否 固定属性一定配置，该属性代码不允许修改和删除，其他值可以修改**/
	private Integer isFixed;
	/**是否继承-1：是 2：否 如果为集成属性，在配置产品结构的时候可以自动引用 若不需要也可以不选取**/
	private Integer isInherit;
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
	/**删除标识-1：是 0：否**/
	private Integer isDelete;
	/**产品中心--产品结构配置表**/
	private ArrayList<StructureConfig> structureConfigs;
	/**产品中心-产品属性数据配置表**/
	private ArrayList<AttributeDataConfig> attributeDataConfigs;
	/**产品中心-产品属性信息表**/
	private ArrayList<ProductAttributeConfig> productAttributeConfigs;

	public BaseAttribute() {
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
	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getIsFixed() {
		return isFixed;
	}

	public void setIsFixed(Integer isFixed) {
		this.isFixed = isFixed;
	}
	public Integer getIsInherit() {
		return isInherit;
	}

	public void setIsInherit(Integer isInherit) {
		this.isInherit = isInherit;
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
	public Integer getisDelete() {
		return isDelete;
	}

	public void setisDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	public ArrayList<StructureConfig> getStructureConfig () {
		return structureConfigs;
	}

	public void setStructureConfig(ArrayList<StructureConfig> structureConfigs) {
		this.structureConfigs = structureConfigs;
	}	
	public ArrayList<AttributeDataConfig> getAttributeDataConfig () {
		return attributeDataConfigs;
	}

	public void setAttributeDataConfig(ArrayList<AttributeDataConfig> attributeDataConfigs) {
		this.attributeDataConfigs = attributeDataConfigs;
	}	
	public ArrayList<ProductAttributeConfig> getProductAttributeConfig () {
		return productAttributeConfigs;
	}

	public void setProductAttributeConfig(ArrayList<ProductAttributeConfig> productAttributeConfigs) {
		this.productAttributeConfigs = productAttributeConfigs;
	}	
}
