package com.bs.plugins.custom.sc.parameter.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.parametercategory.entity.ParameterCategory;

public class BaseParameter extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**系统参数目录ID-字典分类主键ID**/
	private Long parameterCategoryId;
	/**名称-名称**/
	private String name;
	/**编码-编码**/
	private String code;
	/**值-值**/
	private String value;
	/**描述-描述**/
	private String description;
	/**状态-状态**/
	private Integer state;
	/**创建时间-创建时间**/
	private Long creationDate;
	/**修改时间-修改时间**/
	private Long modificationDate;
	/**系统配置-全局参数目录表**/
	private ParameterCategory parameterCategory;

	public BaseParameter() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getParameterCategoryId() {
		return parameterCategoryId;
	}

	public void setParameterCategoryId(Long parameterCategoryId) {
		this.parameterCategoryId = parameterCategoryId;
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
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
	public Long getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Long modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public ParameterCategory getParameterCategory () {
		return parameterCategory;
	}

	public void setParameterCategory(ParameterCategory parameterCategory) {
		this.parameterCategory = parameterCategory;
	}
}
