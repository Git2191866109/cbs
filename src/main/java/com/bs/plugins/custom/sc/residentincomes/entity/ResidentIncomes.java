package com.bs.plugins.custom.sc.residentincomes.entity;

import com.bs.plugins.custom.sc.residentincomes.base.BaseResidentIncomes;

public class ResidentIncomes extends BaseResidentIncomes {

	private static final long serialVersionUID = 1L;
	
	private String spelling;
	private String relationPath;
	public String getRelationPath() {
		return relationPath;
	}

	public void setRelationPath(String relationPath) {
		this.relationPath = relationPath;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public ResidentIncomes() {
	}
	
}
