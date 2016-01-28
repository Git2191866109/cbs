package com.bs.plugins.custom.sc.dictionarycategory.entity;

import com.bs.plugins.custom.sc.dictionarycategory.base.BaseDictionaryCategory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DictionaryCategory extends BaseDictionaryCategory {

	private static final long serialVersionUID = 1L;

	public DictionaryCategory() {
	}
	/**分类表代码-**/
	@NotEmpty
	private String code;
	/**分类表名称-**/
	@NotEmpty
	private String name;

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
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
