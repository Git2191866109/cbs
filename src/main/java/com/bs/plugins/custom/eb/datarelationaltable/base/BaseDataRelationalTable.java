package com.bs.plugins.custom.eb.datarelationaltable.base;

import com.bs.core.entity.Entity;

import com.bs.plugins.custom.eb.itemfield.entity.ItemField;

public class BaseDataRelationalTable extends Entity {

	private static final long serialVersionUID = 1L;
	
	/**主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long id;
	/**预算项字段主键ID-操作日志主键ID：操作日志记录表主键。**/
	private Long itemFieldId;
	/**表名称-**/
	private String name;
	/**表中文名称-**/
	private String chineseName;
	/**Key字段-**/
	private String keyColumn;
	/**Value字段-**/
	private String valueColumn;
	/**展示方式-1：下拉框 2：输入框 3：单选 4：复选 5：文本**/
	private Integer showType;
	/**预算项目字段名称信息存储表**/
	private ItemField itemField;

	public BaseDataRelationalTable() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemFieldId() {
		return itemFieldId;
	}

	public void setItemFieldId(Long itemFieldId) {
		this.itemFieldId = itemFieldId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getKeyColumn() {
		return keyColumn;
	}

	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}
	public String getValueColumn() {
		return valueColumn;
	}

	public void setValueColumn(String valueColumn) {
		this.valueColumn = valueColumn;
	}
	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}
	
	public ItemField getItemField () {
		return itemField;
	}

	public void setItemField(ItemField itemField) {
		this.itemField = itemField;
	}
}
