package com.bs.plugins.system.entity;

import java.util.ArrayList;

public class Reference extends Entity {
	private static final long serialVersionUID = -8801792870836202645L;
	private String attributeId;
	private String objectId;
	private String name;
	private String code;
	private String constraintName;
	private Table parentTable;
	private Table childTable;
	private Integer updateConstraint = 1;
	private Integer deleteConstraint = 1;
	private String implementationType;
	private ArrayList<ReferenceJoin> joins = new ArrayList<ReferenceJoin>();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getConstraintName() {
		return constraintName;
	}

	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}

	public Table getParentTable() {
		return parentTable;
	}

	public void setParentTable(Table parentTable) {
		this.parentTable = parentTable;
	}

	public Table getChildTable() {
		return childTable;
	}

	public void setChildTable(Table childTable) {
		this.childTable = childTable;
	}

	public Integer getUpdateConstraint() {
		return updateConstraint;
	}

	public void setUpdateConstraint(Integer updateConstraint) {
		this.updateConstraint = updateConstraint;
	}

	public Integer getDeleteConstraint() {
		return deleteConstraint;
	}

	public void setDeleteConstraint(Integer deleteConstraint) {
		this.deleteConstraint = deleteConstraint;
	}

	public String getImplementationType() {
		return implementationType;
	}

	public void setImplementationType(String implementationType) {
		this.implementationType = implementationType;
	}

	public ArrayList<ReferenceJoin> getJoins() {
		return joins;
	}

	public void setJoins(ArrayList<ReferenceJoin> joins) {
		this.joins = joins;
	}

	public void addReferenceJoin(ReferenceJoin pdmReferenceJoin) {
		joins.add(pdmReferenceJoin);
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
