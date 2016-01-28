package com.bs.plugins.custom.sc.table.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.tablecolumn.entity.TableColumn;	
import java.util.ArrayList;

public class BaseTable extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**表代码-**/
	private String code;
	/**数据库对象ID-**/
	private String objectId;
	/**表名称-**/
	private String name;
	/**创建时间-**/
	private Long creationDate;
	/**修改时间-**/
	private Long modificationDate;
	/**字段说明-**/
	private String comment;
	/**表结构存储表**/
	private ArrayList<TableColumn> tableColumns;

	public BaseTable() {
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
	
	public ArrayList<TableColumn> getTableColumn () {
		return tableColumns;
	}

	public void setTableColumn(ArrayList<TableColumn> tableColumns) {
		this.tableColumns = tableColumns;
	}	
}
