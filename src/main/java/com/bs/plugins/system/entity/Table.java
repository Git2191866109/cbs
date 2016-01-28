package com.bs.plugins.system.entity;

import java.util.ArrayList;

public class Table  extends Entity{
	private static final long serialVersionUID = 4547407442411860629L;
	public String attributeId;
	private String objectId;
	private String name;
	private String code;
	private User user;
	private String comment ;
	private ArrayList<Column> columns = new ArrayList<Column>();
	private ArrayList<Key> keys = new ArrayList<Key>();
	private Key primaryKey;
	private ArrayList<Index> indexs = new ArrayList<Index>();
	private String creationDate;
	private String creator;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		user.addTable(this);
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ArrayList<Column> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<Column> columns) {
		this.columns = columns;
		for (Column column : columns) {
			column.setTable(this);
		}
	}

	public ArrayList<Key> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<Key> keys) {
		this.keys = keys;
	}

	public Key getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Key primaryKey) {
		this.primaryKey = primaryKey;
	}

	public ArrayList<Index> getIndexs() {
		return indexs;
	}

	public void setIndexs(ArrayList<Index> indexs) {
		this.indexs = indexs;
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

	public void addColumn(Column column) {
		columns.add(column);
		column.setTable(this);
	}

	public void addKey(Key key) {
		keys.add(key);
	}

	public void addIndex(Index index) {
		indexs.add(index);
	}

	public Column getColumn(String id) throws Exception {
		for (Column column : columns) {
			if (id.equals(column.getAttributeId())) {
				return column;
			}
		}
		throw new Exception("Id为：" + id + "对应的列不存在！");
	}

	public Key getKey(String id) throws Exception {
		for (Key key : keys) {
			if (id.equals(key.getAttributeId())) {
				return key;
			}
		}
		throw new Exception("Id为：" + id + "对应的Key不存在！");
	}
}
