package com.bs.plugins.system.entity;

import java.util.ArrayList;

public class Pdm extends Entity{
	private static final long serialVersionUID = 4922003313923752820L;
	private String attributeId;
	private String name;
	private String code;
	private String dBMSCode;
	private String dBMSName;
	private ArrayList<PhysicalDiagram> physicalDiagrams = new ArrayList<PhysicalDiagram>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Table> tables = new ArrayList<Table>();
	private ArrayList<Reference> references = new ArrayList<Reference>();
	
	private String creationDate;
	private String creator ;
	private String modificationDate ;


	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
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

	public String getDBMSCode() {
		return dBMSCode;
	}

	public void setDBMSCode(String code) {
		dBMSCode = code;
	}

	public String getDBMSName() {
		return dBMSName;
	}

	public void setDBMSName(String name) {
		dBMSName = name;
	}

	public ArrayList<PhysicalDiagram> getPhysicalDiagrams() {
		return physicalDiagrams;
	}

	public void setPhysicalDiagrams(
			ArrayList<PhysicalDiagram> physicalDiagrams) {
		this.physicalDiagrams = physicalDiagrams;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	public ArrayList<Reference> getReferences() {
		return references;
	}

	public void setReferences(ArrayList<Reference> references) {
		this.references = references;
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

	public User getUser(String id) throws Exception {
		for (User user : users) {
			if (id.equals(user.getAttributeId())) {
				return user;
			}
		}
		throw new Exception("Id为：" + id + "对应的User不存在！");
	}

	public Table getTable(String id) throws Exception {
		for (Table table : tables) {
			if (id.equals(table.getAttributeId())) {
				return table;
			}
		}
		throw new Exception("Id为：" + id + "对应的Table不存在！");
	}

	public Reference getReference(String id) throws Exception {
		for (Reference reference : references) {
			if (id.equals(reference.getAttributeId())) {
				return reference;
			}
		}
		throw new Exception("Id为：" + id + "对应的Reference不存在！");
	}
}
