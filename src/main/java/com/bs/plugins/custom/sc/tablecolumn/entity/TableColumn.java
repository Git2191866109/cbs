package com.bs.plugins.custom.sc.tablecolumn.entity;

import com.bs.plugins.custom.sc.tablecolumn.base.BaseTableColumn;

public class TableColumn extends BaseTableColumn {

	private static final long serialVersionUID = 1L;

	public TableColumn() {
	}
	
	private String ids[];
	
	public String[] getIds() {
		return ids;
	}
	public void setIds(String ids[]) {
		this.ids = ids;
	}
}
