package com.bs.plugins.custom.aa.riskpreferencedefinition.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.aa.riskpreferencedefinition.entity.RiskPreferenceDefinition;
import com.bs.plugins.custom.aa.riskpreferencedefinition.base.BaseRiskPreferenceDefinitionService;

@Service
public class RiskPreferenceDefinitionService extends BaseRiskPreferenceDefinitionService<RiskPreferenceDefinition> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData riskPreferenceDefinitionIndex(RiskPreferenceDefinition riskPreferenceDefinition){
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
	public ResultData jumpModify(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("riskPreferenceDefinition", this.getRiskPreferenceDefinitionDao().selectOneById(riskPreferenceDefinition));
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(RiskPreferenceDefinition riskPreferenceDefinition){
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
	public ResultData jumpList(RiskPreferenceDefinition riskPreferenceDefinition){
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
	public ResultData jumpPaginated(RiskPreferenceDefinition riskPreferenceDefinition){
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
