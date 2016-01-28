package com.bs.plugins.custom.sm.serviceprovider.base;

import com.bs.core.entity.Entity;


public class BaseServiceProvider extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键Id-**/
	private Long id;
	/**SP名称-**/
	private String name;
	/**SP代码-**/
	private String code;
	/**是否使用-1：使用 0：未使用**/
	private Integer isUse;
	/**SP描述-**/
	private String description;
	/**创建时间-**/
	private String creationDate;

	public BaseServiceProvider() {
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
	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
}
