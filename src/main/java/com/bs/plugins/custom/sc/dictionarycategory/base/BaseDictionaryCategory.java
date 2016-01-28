package com.bs.plugins.custom.sc.dictionarycategory.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.dictionary.entity.Dictionary;	
import java.util.ArrayList;

public class BaseDictionaryCategory extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**分类表代码-**/
	private String code;
	/**分类表名称-**/
	private String name;
	/**分类描述-**/
	private String description;
	/**创建时间-**/
	private Long creationDate;
	/**修改时间-**/
	private Long modificationDate;
	/**字典信息存储表**/
	private ArrayList<Dictionary> dictionarys;

	public BaseDictionaryCategory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	public ArrayList<Dictionary> getDictionary () {
		return dictionarys;
	}

	public void setDictionary(ArrayList<Dictionary> dictionarys) {
		this.dictionarys = dictionarys;
	}	
}
