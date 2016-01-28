package com.bs.plugins.custom.eb.growstages.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.eb.growstages.base.BaseGrowStages;

public class GrowStages extends BaseGrowStages {

	private static final long serialVersionUID = 1L;
	/**阶段名称-**/
	@NotEmpty
	private String name;
	/**阶段代码-**/
	@NotEmpty
    @Pattern(regexp = "^[0-9]{1,20}")
	private String code;
	private String parentId;
	private Integer  level;
	private String   rId;
	private String areaCode;
	private String provinceCode;
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public GrowStages() {
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


}
