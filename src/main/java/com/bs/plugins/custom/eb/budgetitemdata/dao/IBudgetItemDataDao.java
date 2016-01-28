package com.bs.plugins.custom.eb.budgetitemdata.dao;

import java.util.List;
import java.util.Map;

import com.bs.plugins.custom.eb.budgetitemdata.base.BaseBudgetItemDataDao;
import com.bs.plugins.custom.eb.budgetitemdata.entity.BudgetItemData;

public interface IBudgetItemDataDao extends BaseBudgetItemDataDao<BudgetItemData>{

	public Integer selectListforCount(BudgetItemData budgetItemData);
	public BudgetItemData selectListData(BudgetItemData budgetItemData);
	public List<BudgetItemData> selectListAll(BudgetItemData budgetItemData);
	public int  deleteByParam(BudgetItemData budgetItemData);
	
	public List<BudgetItemData> selectBudgetItemDataListByAreaCode(Map<String,Object> map);
	
	public Integer insertTableByArea(BudgetItemData budgetItemData);
	
	public List<BudgetItemData> selectListOut(BudgetItemData b);
	public void insertOut(BudgetItemData b) ;
	public int updateByIdOut(BudgetItemData b);
	//批量添加
	public int insertBatch(Map<String,Object> m)  ;
}	
