package com.bs.plugins.custom.eb.educationmode.service;

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
import com.bs.plugins.custom.eb.educationmode.base.BaseEducationModeService;
import com.bs.plugins.custom.eb.educationmode.dao.IEducationModeDao;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;
import com.bs.plugins.custom.eb.growstages.dao.IGrowStagesDao;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;

@Service
public class EducationModeService extends BaseEducationModeService<EducationMode> {
	
	@Autowired
	private IGrowStagesDao iGrowStagesDao;
	@Autowired
	private IEducationModeDao iEducationModeDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData modeIndex(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			List<GrowStages> growStagesList = iGrowStagesDao.selectList(null);
			resultData.addObject("growStagesList", growStagesList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			educationMode = super.getEducationModeDao().selectOneById(educationMode);
			resultData.addObject("educationMode", educationMode);
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			//add your code
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(EducationMode educationMode){
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
	public ResultData jumpPaginated(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData paginated(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			List<EducationMode> educationModeList = super.getEducationModeDao().selectPaginatedByGrowStageIdList(educationMode);
			Long educationModeCount = super.getEducationModeDao().getCount(educationMode);
			if (educationModeList != null){
				long record = educationModeCount == null?0:educationModeCount;
				int pageCount = (int) Math.ceil(record / (double) educationMode.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", educationMode.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", educationModeList);
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
	public ResultData getEducationMode(EducationMode educationMode){

		educationMode.setGrowStagesId(educationMode.getId());
		educationMode.setId(null);
		List<Map<String, Object>> allListGrowStages = getTreeEducationMode(educationMode);
		String json=JSONArray.toJSONString(allListGrowStages);
		ResultData rd=new ResultData();
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("i", json);
		System.out.println(json);
		rd.setResultMap(m);
		return rd;
		
	}

	public List<Map<String, Object>> getTreeEducationMode(EducationMode educationMode){
		List<Map<String,Object>> allListGrowStages=new ArrayList<Map<String,Object>>();
		
		try{
		System.out.println("111111111111111111");
		List<EducationMode> listEducationMode=iEducationModeDao.getEducationMode(educationMode);
		for(EducationMode g:listEducationMode){
			Map<String,Object> growStageMap = new HashMap<String,Object>();
			growStageMap.put("name",g.getName());
			growStageMap.put("id",g.getId());
			growStageMap.put("isParent", "false");
			growStageMap.put("pId",educationMode.getGrowStagesId());
			growStageMap.put("level", educationMode.getGrowStagesId());
			allListGrowStages.add(growStageMap);
		}
		}catch(Exception e){
			System.out.println("报错"+e.getMessage());
			e.printStackTrace();
		}return allListGrowStages;
	}
}
