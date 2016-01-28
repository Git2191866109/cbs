package com.bs.plugins.custom.sc.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.sc.school.entity.School;
import com.bs.plugins.custom.sc.school.base.BaseSchoolService;

@Service
public class SchoolService extends BaseSchoolService<School> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData schoolIndex(School school){
		ResultData resultData = new ResultData();
		try {
			List<School> schoolList = super.getSchoolDao().selectPaginatedList(school);
			resultData.addObject("schoolList", schoolList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(School school){
		ResultData resultData = new ResultData();
		try {
			school = super.getSchoolDao().selectOneById(school);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("school", school);
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(School school){
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
	public ResultData jumpList(School school){
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
	public ResultData jumpPaginated(School school){
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
