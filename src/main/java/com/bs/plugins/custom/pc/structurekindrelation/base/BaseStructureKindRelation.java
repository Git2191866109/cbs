package com.bs.plugins.custom.pc.structurekindrelation.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;

public class BaseStructureKindRelation extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**分组ID-**/
	private Long kindId;
	/**产品结构主键Id-**/
	private Long productStructureId;
	/**产品中心--产品结构配置表**/
	private StructureConfig structureConfig;

	public BaseStructureKindRelation() {
	}

	public Long getKindId() {
		return kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
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
}
