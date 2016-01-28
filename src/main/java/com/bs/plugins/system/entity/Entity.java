package com.bs.plugins.system.entity;

import java.io.Serializable;



public class Entity implements Serializable{
	
	private static final long serialVersionUID = 5574468630643899188L;
	/**数据更改后返回更改数据唯一标识串 */
	private Long generatedKey;
	private Long id;
	
	public Long getGeneratedKey() {
		return generatedKey;
	}
	public void setGeneratedKey(Long generatedKey) {
		this.generatedKey = generatedKey;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
