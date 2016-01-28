package com.bs.plugins.custom.pc.productattributeconfig.entity;

import com.bs.plugins.custom.pc.productattributeconfig.base.BaseProductAttributeConfig;
import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;

import java.util.Map;

public class ProductAttributeConfig extends BaseProductAttributeConfig {

	private static final long serialVersionUID = 1L;

	private StructureConfig structureConfig;
	private Map<String, String> options;


	public StructureConfig getStructureConfig() {
		return structureConfig;
	}

	public void setStructureConfig(StructureConfig structureConfig) {
		this.structureConfig = structureConfig;
	}

	public ProductAttributeConfig() {
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
	//产品属性code
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
