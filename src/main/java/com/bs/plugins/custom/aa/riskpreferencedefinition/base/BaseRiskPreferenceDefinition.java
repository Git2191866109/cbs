package com.bs.plugins.custom.aa.riskpreferencedefinition.base;

import com.bs.core.entity.Entity;


public class BaseRiskPreferenceDefinition extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-**/
	private Long id;
	/**名称-**/
	private String name;
	/**最小值-**/
	private Integer minVal;
	/**最大值-**/
	private Integer maxVal;
	/**描述-**/
	private String description;

	public BaseRiskPreferenceDefinition() {
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
	public Integer getMinVal() {
		return minVal;
	}

	public void setMinVal(Integer minVal) {
		this.minVal = minVal;
	}
	public Integer getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(Integer maxVal) {
		this.maxVal = maxVal;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
