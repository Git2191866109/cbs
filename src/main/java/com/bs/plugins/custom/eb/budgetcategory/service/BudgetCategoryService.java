package com.bs.plugins.custom.eb.budgetcategory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.eb.budgetcategory.base.BaseBudgetCategoryService;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetcategory.entity.BudgetCategory;

@Service
public class BudgetCategoryService extends BaseBudgetCategoryService<BudgetCategory> {
	@Autowired
	private  IBudgetCategoryDao iBudgetCategoryDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData categoryIndex(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
			budgetCategory = super.getBudgetCategoryDao().selectOneById(budgetCategory);
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("budgetCategory", budgetCategory);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
		resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**得到一级树**/
	public ResultData getBudgetCategory(BudgetCategory budgetCategory){
		ResultData resultData = new ResultData();
		try {
		List<Map<String, Object>> lBudgetCategory = getTreeCategory();
		String bud=JSONObject.toJSONString(lBudgetCategory);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("childNodes", bud);
		resultData.setResultMap(result);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}

	private List<Map<String, Object>> getTreeCategory() {
		BudgetCategory bc=new BudgetCategory();
		List<BudgetCategory> lbc=iBudgetCategoryDao.getBudgetCategory(bc);
		List<Map<String, Object>> lBudgetCategory=new ArrayList<Map<String, Object>>();
		for(BudgetCategory b:lbc){
			iBudgetCategoryDao.getBudgetCategory(b);
			
			
			Map<String, Object> mBudgetCategory=new HashMap<String, Object>();
			mBudgetCategory.put("name", b.getName());
			mBudgetCategory.put("parentId", b.getId());
			mBudgetCategory.put("id", b.getId());
			mBudgetCategory.put("isParent", true);
			lBudgetCategory.add(mBudgetCategory);
			}
		return lBudgetCategory;
	}
}
