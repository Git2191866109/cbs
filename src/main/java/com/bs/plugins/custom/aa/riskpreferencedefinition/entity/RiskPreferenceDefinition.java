package com.bs.plugins.custom.aa.riskpreferencedefinition.entity;

import com.bs.plugins.custom.aa.riskpreferencedefinition.base.BaseRiskPreferenceDefinition;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RiskPreferenceDefinition extends BaseRiskPreferenceDefinition {

	private static final long serialVersionUID = 1L;
	/**名称-**/
	@NotEmpty
	private String name;
	/**最小值-**/
	@Max(value = 100)
	@NotNull
	private Integer minVal;
	/**最大值-**/
	@Max(value = 100)
	@NotNull
	private Integer maxVal;
	/**描述-**/
	@NotNull
	private String description;

	public RiskPreferenceDefinition() {
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public Integer getMinVal() {
		return minVal;
	}

	@Override
	public void setMinVal(Integer minVal) {
		this.minVal = minVal;
	}

	@Override
	public Integer getMaxVal() {
		return maxVal;
	}

	@Override
	public void setMaxVal(Integer maxVal) {
		this.maxVal = maxVal;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
}
