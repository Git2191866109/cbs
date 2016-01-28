package com.bs.plugins.system.entity;


public class ReferenceJoin extends Entity {
	private static final long serialVersionUID = 5424269012341104947L;
	private String attributeId;
	private String objectId ;
	private Column parentTableColumn;
	private Column childTableColumn;
	private String creationDate ;
	private String creator ;
	private String modificationDate ;
	

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Column getParentTableColumn() {
		return parentTableColumn;
	}

	public void setParentTableColumn(Column parentTableColumn) {
		this.parentTableColumn = parentTableColumn;
	}

	public Column getChildTableColumn() {
		return childTableColumn;
	}

	public void setChildTableColumn(Column childTableColumn) {
		this.childTableColumn = childTableColumn;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

}
