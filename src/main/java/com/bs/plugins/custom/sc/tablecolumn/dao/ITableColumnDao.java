package com.bs.plugins.custom.sc.tablecolumn.dao;

import java.util.List;

import com.bs.plugins.custom.sc.tablecolumn.base.BaseTableColumnDao;
import com.bs.plugins.custom.sc.tablecolumn.entity.TableColumn;

public interface ITableColumnDao extends BaseTableColumnDao<TableColumn>{
	
	public List<TableColumn> selectListByIds(TableColumn tableColumn) throws Exception;
	
	public List<TableColumn> selectItemFieldList(TableColumn tableColumn) throws Exception;
}
