package com.bs.plugins.custom.sm.businesssent.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.sm.businesssent.entity.BusinessSent;
import com.bs.plugins.custom.sm.businesssent.base.BaseBusinessSentService;

@Service
public class BusinessSentService extends BaseBusinessSentService<BusinessSent> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData businessSentIndex(BusinessSent businessSent){
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
	public ResultData jumpModify(BusinessSent businessSent){
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
	public ResultData jumpCreate(BusinessSent businessSent){
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
	public ResultData jumpList(BusinessSent businessSent){
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
	public ResultData jumpPaginated(BusinessSent businessSent){
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
