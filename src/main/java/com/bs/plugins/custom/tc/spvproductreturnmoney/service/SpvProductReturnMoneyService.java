package com.bs.plugins.custom.tc.spvproductreturnmoney.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.tc.spvproductreturnmoney.entity.SpvProductReturnMoney;
import com.bs.plugins.custom.tc.spvproductreturnmoney.base.BaseSpvProductReturnMoneyService;

@Service
public class SpvProductReturnMoneyService extends BaseSpvProductReturnMoneyService<SpvProductReturnMoney> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData spvProductReturnMoneyIndex(SpvProductReturnMoney spvProductReturnMoney){
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
	public ResultData jumpModify(SpvProductReturnMoney spvProductReturnMoney){
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
	public ResultData jumpCreate(SpvProductReturnMoney spvProductReturnMoney){
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
	public ResultData jumpList(SpvProductReturnMoney spvProductReturnMoney){
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
	public ResultData jumpPaginated(SpvProductReturnMoney spvProductReturnMoney){
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
