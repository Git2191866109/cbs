package com.bs.plugins.custom.cc.securityquestion.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.cc.securityquestion.entity.SecurityQuestion;
import com.bs.plugins.custom.cc.securityquestion.base.BaseSecurityQuestionService;

@Service
public class SecurityQuestionService extends BaseSecurityQuestionService<SecurityQuestion> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData securityQuestionIndex(SecurityQuestion securityQuestion){
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
	public ResultData jumpModify(SecurityQuestion securityQuestion){
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
	public ResultData jumpCreate(SecurityQuestion securityQuestion){
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
	public ResultData jumpList(SecurityQuestion securityQuestion){
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
	public ResultData jumpPaginated(SecurityQuestion securityQuestion){
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
