package com.bs.plugins.custom.eb.educationgoal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.eb.budgetcategory.dao.IBudgetCategoryDao;
import com.bs.plugins.custom.eb.budgetitem.dao.IBudgetItemDao;
import com.bs.plugins.custom.eb.educationconfigure.entity.EducationConfigure;
import com.bs.plugins.custom.eb.educationgoal.base.BaseEducationGoalService;
import com.bs.plugins.custom.eb.educationgoal.entity.EducationGoal;
import com.bs.plugins.custom.eb.educationmode.dao.IEducationModeDao;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;
import com.bs.plugins.custom.eb.goalitemrelation.dao.IGoalItemRelationDao;
import com.bs.plugins.custom.eb.goalitemrelation.entity.GoalItemRelation;
import com.bs.plugins.custom.eb.growstages.dao.IGrowStagesDao;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;
import com.bs.plugins.custom.eb.modeitemrelation.dao.IModeItemRelationDao;

@Service
public class EducationGoalService extends BaseEducationGoalService<EducationGoal> {
	
	@Autowired
	private IModeItemRelationDao iModelItemRelationDao;
	
	@Autowired
	private IBudgetItemDao iBudgetItemDao;
	
	@Autowired
	private IBudgetCategoryDao iBudgetCategoryDao;
	
	@Autowired
	private IGrowStagesDao iGrowStagesDao;
	
	@Autowired
	private IEducationModeDao iEducationModeDao;
	
	@Autowired
	private IGoalItemRelationDao iGoalItemRelationDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData goalIndex(EducationGoal educationGoal){
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
	public ResultData jumpModify(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			educationGoal = super.getEducationGoalDao().selectOneById(educationGoal);
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("educationGoal", educationGoal);
		return resultData;
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData jumpZtreeList(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			String inputTypeItemIdStr = "";
			List<GrowStages> growStagesList = iGrowStagesDao.selectList(null);
			List<Map<String,Object>> treeList = new ArrayList<Map<String,Object>>();
			GoalItemRelation relation = new GoalItemRelation();
			relation.setEduGoalId(educationGoal.getId());
			List<GoalItemRelation> goalItemRelationList =  iGoalItemRelationDao.selectList(relation);
			
			for(GrowStages temp : growStagesList){
				Map<String,Object> growStagesMap = new HashMap<String,Object>();
				growStagesMap.put("id", temp.getId()+"_growStagesId");
				growStagesMap.put("pId",0);
				growStagesMap.put("name", temp.getName());
				growStagesMap.put("open", true);
				growStagesMap.put("nocheck", true);
				treeList.add(growStagesMap);
			}
			
			List<EducationMode> educationModelist = iEducationModeDao.selectList(null);
			for(EducationMode temp : educationModelist){
				Map<String,Object> budgetItemMap = new HashMap<String,Object>();
				budgetItemMap.put("id", temp.getGrowStagesId()+"_"+temp.getId());
				budgetItemMap.put("pId",temp.getGrowStagesId()+"_growStagesId");
				budgetItemMap.put("name", temp.getName());
				budgetItemMap.put("open", true);
				budgetItemMap.put("check", true);
				
				for(int i = 0; i< goalItemRelationList.size() ; i++){
					if(goalItemRelationList.get(i).getEduModeId() == temp.getId() && goalItemRelationList.get(i).getGrowStagesId() == temp.getGrowStagesId()){
						budgetItemMap.put("checked", true);
					}
					
				}
				
				treeList.add(budgetItemMap);
			}
			
			//转json格式在页面树形展示
			String json = JSONArray.toJSONString(treeList).toString();
			resultData.addObject("treeJsonData", json);
			educationGoal = super.getEducationGoalDao().selectOneById(educationGoal);
			resultData.addObject("educationGoal", educationGoal);
			//回显下拉框
			resultData.addObject("inputTypeItemIdStr", inputTypeItemIdStr);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到列表**/
	public ResultData jumpList(EducationGoal educationGoal){
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
	public ResultData jumpPaginated(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			List<EducationGoal> educationGoalList = super.getEducationGoalDao().selectListByid(educationGoal);
			List<EducationGoal> educationConfig=super.getEducationGoalDao().selectEducationConfigure(educationGoal);
			if(educationConfig.size()>0){
				EducationGoal eg=educationConfig.get(0);
				for(EducationGoal forCon:educationGoalList){
					for(EducationConfigure forConfig:eg.getEducationConfigure()){
						if(forCon.getArr()!=null&&"true".equals(forCon.getArr())){
							continue;
						}
						if(forConfig.getEduGoalId_vice()==forCon.getId()){//主
							forCon.setArr("true");
							
						}else{
							forCon.setArr("false");
						}
					}
					
				}
			}
			Long educationGoalCount = super.getEducationGoalDao().getCount(educationGoal);
			if (educationGoalList != null){
				long record = educationGoalCount == null?0:educationGoalCount;
				int pageCount = (int) Math.ceil(record / (double) educationGoal.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", educationGoal.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", educationGoalList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			}
			else{
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData setting(EducationGoal educationGoal){
		ResultData resultData = new ResultData();
		try {
			//再次修改需先删除
			GoalItemRelation goal = new GoalItemRelation();
			goal.setEduGoalId(educationGoal.getId());
			iGoalItemRelationDao.delete(goal);
			
			String arr = educationGoal.getArr();
			String[] arrIds = arr.split(",");
			String[] ids;
			for(int i = 0;i<arrIds.length;i++){
				GoalItemRelation goalItemRelation = new GoalItemRelation();
				ids = arrIds[i].split("_");
				goalItemRelation.setGrowStagesId(Long.valueOf(ids[0]));
				goalItemRelation.setEduModeId(Long.valueOf(ids[1]));
				goalItemRelation.setIsInland(educationGoal.getIsInland());
				goalItemRelation.setEduGoalId(educationGoal.getId());
				//批量存关系表
				iGoalItemRelationDao.insert(goalItemRelation);
			}
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
}
