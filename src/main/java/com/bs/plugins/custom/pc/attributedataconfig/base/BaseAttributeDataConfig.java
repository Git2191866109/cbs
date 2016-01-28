package com.bs.plugins.custom.pc.attributedataconfig.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.attribute.entity.Attribute;

public class BaseAttributeDataConfig extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-主键ID**/
	private Long id;
	/**产品属性ID-**/
	private Long attributeId;
	/**数据来源-数据来源方式 1- 来源于字典 2- 来源于模型 3- 自定义**/
	private Integer dataSource;
	/**字典分类Id-如果数据来源于字典，该字段有值**/
	private Long dictCategoryId;
	/**数据表名称-**/
	private String tableName;
	/**Key字段-**/
	private String keyColumn;
	/**Value字段-**/
	private String valueColumn;
	/**自定义key值-**/
	private String customKey;
	/**自定义Value值-**/
	private String customValue;
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
	/**产品管理-产品属性信息存储表**/
	private Attribute attribute;

	public BaseAttributeDataConfig() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}
	public Long getDictCategoryId() {
		return dictCategoryId;
	}

	public void setDictCategoryId(Long dictCategoryId) {
		this.dictCategoryId = dictCategoryId;
	}
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getKeyColumn() {
		return keyColumn;
	}

	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}
	public String getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}
	public String getCustomKey() {
		return customKey;
	}

	public void setCustomKey(String customKey) {
		this.customKey = customKey;
	}
	public String getCustomValue() {
		return customValue;
	}

	public void setCustomValue(String customValue) {
		this.customValue = customValue;
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
	
	public Attribute getAttribute () {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
}
