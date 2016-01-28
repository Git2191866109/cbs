package com.bs.plugins.custom.eb.greadeyear.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.bs.plugins.custom.eb.greadeyear.base.BaseGreadeYear;

public class GreadeYear extends BaseGreadeYear {

	private static final long serialVersionUID = 1L;
	public GreadeYear() {
	}
	/**名称-**/
	@NotEmpty
	private String name;
	/**年级-**/
	@NotNull
	private Integer greade;
	/**开始年序-**/
	@NotNull
	private Integer startYear;
	/**结束年序-**/
	@NotNull
	private Integer endYear;

		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGreade() {
		return greade;
	}

	public void setGreade(Integer greade) {
		this.greade = greade;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

}
