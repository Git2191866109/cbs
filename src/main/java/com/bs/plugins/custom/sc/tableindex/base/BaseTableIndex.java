package com.bs.plugins.custom.sc.tableindex.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.tablecolumn.entity.TableColumn;

public class BaseTableIndex extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**字段信息表主键-**/
	private Long columnId;
	/**数据库对象ID-**/
	private String objectId;
	/**表代码-**/
	private String code;
	/**表名称-**/
	private String name;
	/**创建时间-**/
	private Long creationDate;
	/**修改时间-**/
	private Long modificationDate;
	/**字段说明-**/
	private String comment;
	/**表结构存储表**/
	private TableColumn tableColumn;

	public BaseTableIndex() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
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
	
	public TableColumn getTableColumn () {
		return tableColumn;
	}

	public void setTableColumn(TableColumn tableColumn) {
		this.tableColumn = tableColumn;
	}
}
