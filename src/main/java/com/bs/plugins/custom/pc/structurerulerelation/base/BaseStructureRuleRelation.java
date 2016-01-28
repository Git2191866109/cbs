package com.bs.plugins.custom.pc.structurerulerelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;
import com.bs.plugins.custom.pc.validationrule.entity.ValidationRule;

public class BaseStructureRuleRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**验证规则主键Id-**/
	private Long validationRuleId;
	/**产品结构主键Id-**/
	private Long productStructureId;
	/**产品中心--产品结构配置表**/
	private StructureConfig structureConfig;
	/**产品管理-产品验证规则定义表**/
	private ValidationRule validationRule;

	public BaseStructureRuleRelation() {
	}

	public Long getValidationRuleId() {
		return validationRuleId;
	}

	public void setValidationRuleId(Long validationRuleId) {
		this.validationRuleId = validationRuleId;
	}
	public Long getProductStructureId() {
		return productStructureId;
	}

	public void setProductStructureId(Long productStructureId) {
		this.productStructureId = productStructureId;
	}
	
	public StructureConfig getStructureConfig () {
		return structureConfig;
	}

	public void setStructureConfig(StructureConfig structureConfig) {
		this.structureConfig = structureConfig;
	}
	public ValidationRule getValidationRule () {
		return validationRule;
	}

	public void setValidationRule(ValidationRule validationRule) {
		this.validationRule = validationRule;
	}
}
