package com.bs.plugins.custom.sc.costlevel.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.sc.costlevel.entity.CostLevel;
import com.bs.plugins.custom.sc.costlevel.base.BaseCostLevelService;

@Service
public class CostLevelService extends BaseCostLevelService<CostLevel> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData costLevelIndex(CostLevel costLevel){
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
	public ResultData jumpModify(CostLevel costLevel){
		ResultData resultData = new ResultData();
		try {
			costLevel = super.getCostLevelDao().selectOneById(costLevel);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("costLevel", costLevel);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(CostLevel costLevel){
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
	public ResultData jumpList(CostLevel costLevel){
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
	public ResultData jumpPaginated(CostLevel costLevel){
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
