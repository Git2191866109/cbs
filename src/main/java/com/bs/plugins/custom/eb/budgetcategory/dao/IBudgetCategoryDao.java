package com.bs.plugins.custom.eb.budgetcategory.dao;

import java.util.List;

import com.bs.plugins.custom.eb.budgetcategory.base.BaseBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;

public interface IBudgetCategoryDao extends BaseBudgetCategoryDao<BudgetCategory>{

	public List<BudgetCategory> getBudgetCategory(BudgetCategory db);
}
