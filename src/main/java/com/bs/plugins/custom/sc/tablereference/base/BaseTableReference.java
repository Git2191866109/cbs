package com.bs.plugins.custom.sc.tablereference.base;

import com.bs.core.entity.Entity;


public class BaseTableReference extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**数据库对象ID-**/
	private String objectId;
	/**表代码-**/
	private String code;
	/**表名称-**/
	private String name;
	/**主表ID-**/
	private Long parentTableId;
	/**子表ID-**/
	private Long childTableId;
	/**实现类型-**/
	private String implementationType;
	/**创建时间-**/
	private Long creationDate;
	/**修改时间-**/
	private Long modificationDate;
	/**字段说明-**/
	private String comment;

	public BaseTableReference() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
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
	public Long getParentTableId() {
		return parentTableId;
	}

	public void setParentTableId(Long parentTableId) {
		this.parentTableId = parentTableId;
	}
	public Long getChildTableId() {
		return childTableId;
	}

	public void setChildTableId(Long childTableId) {
		this.childTableId = childTableId;
	}
	public String getImplementationType() {
		return implementationType;
	}

	public void setImplementationType(String implementationType) {
		this.implementationType = implementationType;
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
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
