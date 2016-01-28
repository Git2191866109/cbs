package com.bs.plugins.custom.eb.modeitemrelation.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.eb.modeitemrelation.base.BaseModeItemRelationService;
import com.bs.plugins.custom.eb.modeitemrelation.entity.ModeItemRelation;

@Service
public class ModeItemRelationService extends BaseModeItemRelationService<ModeItemRelation> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData relationIndex(ModeItemRelation modeItemRelation){
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
	public ResultData jumpModify(ModeItemRelation modeItemRelation){
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
	public ResultData jumpCreate(ModeItemRelation modeItemRelation){
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
	public ResultData jumpList(ModeItemRelation modeItemRelation){
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
	public ResultData jumpPaginated(ModeItemRelation modeItemRelation){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	
	public ResultData insertRelationship(ModeItemRelation modeItemRelation) throws Exception{
	    ResultData resultData = new ResultData();
		
		try{
			String [] arr=modeItemRelation.getBudgetItemArray().split(",");
		    super.getModeItemRelationDao().deleteALLByBudgetCategoryId(modeItemRelation);
		    if(!"".equals(modeItemRelation.getBudgetItemArray())){
			   for(String a:arr){
			    	//赋值小项ID
					modeItemRelation.setBudgetItemId(Long.parseLong(a));
					super.getModeItemRelationDao().insert(modeItemRelation);
			   }
		   }
		    Map<String, Object> resultMap =  new HashMap<String, Object>();
		    resultMap.put("succ", true);
		    resultData.setResultMap(resultMap);
		    resultData.setStatus(SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			resultData.setStatusException(e.getMessage());
		    resultData.setStatus(FAIL);
		}
	    return resultData;
	}
	
	

	
}
