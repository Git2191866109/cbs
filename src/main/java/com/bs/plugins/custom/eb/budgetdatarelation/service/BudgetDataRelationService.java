package com.bs.plugins.custom.eb.budgetdatarelation.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.eb.budgetdatarelation.entity.BudgetDataRelation;
import com.bs.plugins.custom.eb.budgetdatarelation.base.BaseBudgetDataRelationService;

@Service
public class BudgetDataRelationService extends BaseBudgetDataRelationService<BudgetDataRelation> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData budgetDataRelationIndex(BudgetDataRelation budgetDataRelation){
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
	public ResultData jumpModify(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(BudgetDataRelation budgetDataRelation){
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
	public ResultData jumpPaginated(BudgetDataRelation budgetDataRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
}
