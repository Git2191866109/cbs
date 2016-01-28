package com.bs.plugins.custom.pc.structureconfig.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.category.entity.Category;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;
import com.bs.plugins.custom.pc.structurerulerelation.entity.StructureRuleRelation;	
import com.bs.plugins.custom.pc.structurekindrelation.entity.StructureKindRelation;	
import java.util.ArrayList;

public class BaseStructureConfig extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-主键ID**/
	private Long id;
	/**产品分类ID-**/
	private Long categoryId;
	/**产品属性ID-**/
	private Long attributeId;
	/**是否显示-1：显示 0：不显示**/
	private Integer isShow;
	/**显示类型-1：input文本框 2：select下拉选择框 3：redio单选按钮 4：checkbox复选按钮 5：textarea大文本 6：hidden隐藏域 7：text 存文本 8：editor编辑器 9：datatime 日期 10：upload 上传空间**/
	private Integer showType;
	/**是否为表头-1：是 0：否**/
	private Integer isHeader;
	/**默认值-**/
	private String defaultValue;
	/**排序-**/
	private Integer sortBy;
	/**数据来源-数据来源方式 1- 静态参数 2- 动态数据 3- 程序指定**/
	private Integer dataSource;
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
	/**产品管理-产品分类信息存储表**/
	private Category category;
	/**产品管理-产品属性信息存储表**/
	private Attribute attribute;
	/**产品管理-产品结构属性与验证规则定义表**/
	private ArrayList<StructureRuleRelation> structureRuleRelations;
	/**产品中心-产品结构属性与分组定义表**/
	private ArrayList<StructureKindRelation> structureKindRelations;

	public BaseStructureConfig() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}
	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}
	public Integer getIsHeader() {
		return isHeader;
	}

	public void setIsHeader(Integer isHeader) {
		this.isHeader = isHeader;
	}
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public Integer getSortBy() {
		return sortBy;
	}

	public void setSortBy(Integer sortBy) {
		this.sortBy = sortBy;
	}
	public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
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
	
	public Category getCategory () {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Attribute getAttribute () {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	public ArrayList<StructureRuleRelation> getStructureRuleRelation () {
		return structureRuleRelations;
	}

	public void setStructureRuleRelation(ArrayList<StructureRuleRelation> structureRuleRelations) {
		this.structureRuleRelations = structureRuleRelations;
	}	
	public ArrayList<StructureKindRelation> getStructureKindRelation () {
		return structureKindRelations;
	}

	public void setStructureKindRelation(ArrayList<StructureKindRelation> structureKindRelations) {
		this.structureKindRelations = structureKindRelations;
	}	
}
