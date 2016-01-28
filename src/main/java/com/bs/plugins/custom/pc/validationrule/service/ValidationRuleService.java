package com.bs.plugins.custom.pc.validationrule.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.pc.validationrule.entity.ValidationRule;
import com.bs.plugins.custom.pc.validationrule.base.BaseValidationRuleService;

@Service
public class ValidationRuleService extends BaseValidationRuleService<ValidationRule> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData validationRuleIndex(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(ValidationRule validationRule){
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
	public ResultData jumpCreate(ValidationRule validationRule){
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
	public ResultData jumpList(ValidationRule validationRule){
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
	public ResultData jumpPaginated(ValidationRule validationRule){
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
