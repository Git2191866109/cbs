package com.bs.plugins.custom.sc.parametercategory.service;

import com.bs.core.service.IBaseService;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.sc.parametercategory.entity.ParameterCategory;
import com.bs.plugins.custom.sc.parametercategory.base.BaseParameterCategoryService;

@Service
public class ParameterCategoryService extends BaseParameterCategoryService<ParameterCategory> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData parametercategoryIndex(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
			resultData.setStatus(IBaseService.FAIL);
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			parameterCategory = super.getParameterCategoryDao().selectOneById(parameterCategory);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("parameterCategory", parameterCategory);
		return resultData;
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(ParameterCategory parameterCategory){
		ResultData resultData = new ResultData();
		try {
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(ParameterCategory parameterCategory){
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
	public ResultData jumpPaginated(ParameterCategory parameterCategory){
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
