package com.bs.plugins.custom.eb.educationconfigure.service;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.eb.educationconfigure.base.BaseEducationConfigureService;
import com.bs.plugins.custom.eb.educationconfigure.entity.EducationConfigure;

@Service
public class EducationConfigureService extends BaseEducationConfigureService<EducationConfigure> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData educationConfigureIndex(EducationConfigure educationConfigure){
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
	public ResultData jumpModify(EducationConfigure educationConfigure){
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
	public ResultData jumpCreate(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try{
			//删除所有的关系
			if(educationConfigure.getEduGoalId_master()!=null){
					super.getEducationConfigureDao().deleteAllByeducationId(educationConfigure);
					//截取字符开始存贮
					//添加自身数据
					educationConfigure.setIds(educationConfigure.getIds()+educationConfigure.getEduGoalId_master());
					String [] goalid=educationConfigure.getIds().split(",");
					for(String id:goalid){
						educationConfigure.setEduGoalId_vice(Long.parseLong(id));
						super.getEducationConfigureDao().insert(educationConfigure);
					}
			}//添加所有的关系
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			//add your code1
			resultData.addObject("educationConfigure", educationConfigure);
			
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(EducationConfigure educationConfigure){
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
