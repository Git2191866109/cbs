package com.bs.plugins.custom.eb.budgetitem.dao;

import java.util.List;

import com.bs.plugins.custom.eb.budgetitem.base.BaseBudgetItemDao;
import com.bs.plugins.custom.eb.budgetitem.entity.BudgetItem;

public interface IBudgetItemDao extends BaseBudgetItemDao<BudgetItem>{
	
	public List<BudgetItem> selectPaginatedByCategoryIdList(BudgetItem budgetItem) throws Exception;
	
	public Long getCountByCategoryId(BudgetItem budgetItem) throws Exception;
	
	public Long selectSubLevel(BudgetItem budgetItem) throws Exception;
	public List<BudgetItem> getBudgetItemOne(BudgetItem budgetItem) throws Exception;
	public List<BudgetItem> getBudgetItemTwo(BudgetItem budgetItem) throws Exception;
}
