package com.bs.plugins.custom.sc.tablecolumn.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.sc.table.entity.Table;
import com.bs.plugins.custom.sc.tableindex.entity.TableIndex;	
import java.util.ArrayList;

public class BaseTableColumn extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**表主键-**/
	private Long tableId;
	/**数据库对象ID-**/
	private String objectId;
	/**字段代码-**/
	private String code;
	/**字段名称-**/
	private String name;
	/**显示名称-**/
	private String showName;
	/**默认值-**/
	private String defaultValue;
	/**字段数据类型-访问IP：系统用户远端访问的IP地址。**/
	private String dataType;
	/**字段长度-**/
	private Integer length;
	/**创建时间-**/
	private Long creationDate;
	/**修改时间-**/
	private Long modificationDate;
	/**字段说明-**/
	private String comment;
	/**表信息存储表**/
	private Table table;
	/**表索引信息存储表**/
	private ArrayList<TableIndex> tableIndexs;

	public BaseTableColumn() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
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
	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
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
	
	public Table getTable () {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	public ArrayList<TableIndex> getTableIndex () {
		return tableIndexs;
	}

	public void setTableIndex(ArrayList<TableIndex> tableIndexs) {
		this.tableIndexs = tableIndexs;
	}	
}
