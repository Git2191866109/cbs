package com.bs.plugins.custom.sc.dictionary.entity;

import com.bs.plugins.custom.sc.dictionary.base.BaseDictionary;
import org.hibernate.validator.constraints.NotEmpty;

public class Dictionary extends BaseDictionary {

	private static final long serialVersionUID = 1L;

	public Dictionary() {
	}
	/**值-值**/
	@NotEmpty
	private String value;
	/**名称-名称**/
	@NotEmpty
	private String name;

	private String remark;

	/**数据表名称-**/
	private String tableName;
	/**Key字段-**/
	private String keyColumn;
	/**Value字段-**/
	private String valueColumn;
	/**扩展字段-**/
	private String extColumn;
	/**条件-**/
	private String condition;




	/**Value字段-**/
	private int isDynamic;


	public int getIsDynamic() {
		return isDynamic;
	}

	public void setIsDynamic(int isDynamic) {
		this.isDynamic = isDynamic;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getExtColumn() {
		return extColumn;
	}

	public void setExtColumn(String extColumn) {
		this.extColumn = extColumn;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
