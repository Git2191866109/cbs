package com.bs.plugins.custom.sc.dictionary.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;

public class BaseDictionary extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**字典分类主键ID-字典分类主键ID**/
	private Long dictCategoryId;
	/**值-值**/
	private String value;
	/**名称-名称**/
	private String name;
	/**描述-描述**/
	private String description;
	/**状态-状态**/
	private Integer state;
	/**创建时间-创建时间**/
	private Long creationDate;
	/**修改时间-修改时间**/
	private Long modificationDate;
	/**系统配置-字典分类信息存储表**/
	private DictionaryCategory dictionaryCategory;

	public BaseDictionary() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getDictCategoryId() {
		return dictCategoryId;
	}

	public void setDictCategoryId(Long dictCategoryId) {
		this.dictCategoryId = dictCategoryId;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
	public Long getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Long modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	public DictionaryCategory getDictionaryCategory () {
		return dictionaryCategory;
	}

	public void setDictionaryCategory(DictionaryCategory dictionaryCategory) {
		this.dictionaryCategory = dictionaryCategory;
	}
}
