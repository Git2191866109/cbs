package com.bs.plugins.custom.eb.itemfieldcollectvalue.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;

public class BaseItemFieldCollectValue extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**字段值主键ID-**/
	private Long itemValueId;
	/**字段代码-**/
	private String value;
	/**是否为默认值-**/
	private Integer isDefault;
	/**是否有效-**/
	private Integer isValid;
	/**年级-**/
	private Integer grade;
	/**描述信息-**/
	private String description;
	/**创建时间-**/
	private String createDate;
	/**修改时间-**/
	private String modifyDate;
	/**创建者-**/
	private Long creatorId;
	/**预算项目字段值信息存储表**/
	private ItemFieldValue itemFieldValue;

	public BaseItemFieldCollectValue() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemValueId() {
		return itemValueId;
	}

	public void setItemValueId(Long itemValueId) {
		this.itemValueId = itemValueId;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public ItemFieldValue getItemFieldValue () {
		return itemFieldValue;
	}

	public void setItemFieldValue(ItemFieldValue itemFieldValue) {
		this.itemFieldValue = itemFieldValue;
	}
}
