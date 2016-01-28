package com.bs.plugins.custom.eb.educationgoal.entity;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.eb.educationgoal.base.BaseEducationGoal;

public class EducationGoal extends BaseEducationGoal {

	private static final long serialVersionUID = 1L;

	public EducationGoal() {
	}
	/**阶段名称-**/
	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	private String arr;
	private String PseudoId;
	public String getPseudoId() {
		return PseudoId;
	}


	public void setPseudoId(String pseudoId) {
		PseudoId = pseudoId;
	}


	public String getArr() {
		return arr;
	}


	public void setArr(String arr) {
		this.arr = arr;
	}
	
	private String[] inputLevels;

	public String[] getInputLevels() {
		return inputLevels;
	}

	public void setInputLevels(String[] inputLevels) {
		this.inputLevels = inputLevels;
	}
}
