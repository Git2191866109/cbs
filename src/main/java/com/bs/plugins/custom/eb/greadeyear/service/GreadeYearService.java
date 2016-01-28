package com.bs.plugins.custom.eb.greadeyear.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.eb.greadeyear.entity.GreadeYear;
import com.bs.plugins.custom.eb.greadeyear.base.BaseGreadeYearService;
import com.bs.plugins.custom.eb.growstages.dao.IGrowStagesDao;
import com.bs.plugins.custom.eb.growstages.entity.GrowStages;

@Service
public class GreadeYearService extends BaseGreadeYearService<GreadeYear> {
	
	@Autowired
	private IGrowStagesDao iGrowStagesDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData greadeIndex(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			List<GrowStages> growStagesList = iGrowStagesDao.selectList(null);
			resultData.addObject("growStageList", growStagesList);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			greadeYear = super.getGreadeYearDao().selectOneById(greadeYear);
			resultData.addObject("greadeYear", greadeYear);
			resultData.setStatus(SUCCESS);
		} catch (Exception e) {
			resultData.setStatus(FAIL);
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(GreadeYear greadeYear){
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
	public ResultData jumpList(GreadeYear greadeYear){
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
	public ResultData jumpPaginated(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData paginated(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			List<GreadeYear> greadeYearList = super.getGreadeYearDao().selectPaginatedListOrderByGreade(greadeYear);
			Long greadeYearCount = super.getGreadeYearDao().getCount(greadeYear);
			if (greadeYearList != null){
				long record = greadeYearCount == null?0:greadeYearCount;
				int pageCount = (int) Math.ceil(record / (double) greadeYear.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", greadeYear.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", greadeYearList);
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
	
	public ResultData create(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = super.getGreadeYearDao().insert(greadeYear);
			if (result > 0){
				greadeYear = super.getGreadeYearDao().selectMinAndMaxYearByGrowStageId(greadeYear);
				
				GrowStages growStages = new GrowStages();
				growStages.setId(greadeYear.getGrowStageId());
				growStages.setStartAge(greadeYear.getStartYear());
				growStages.setEndAge(greadeYear.getEndYear());
				
				Integer count =  iGrowStagesDao.updateById(growStages);
				if(count > 0){
					resultData.setStatus(IBaseService.SUCCESS);
				}else{
					resultData.setStatus(IBaseService.FAIL);
				}
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
	
	public ResultData modify(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = super.getGreadeYearDao().updateById(greadeYear);
			if (result > 0){
				greadeYear = super.getGreadeYearDao().selectMinAndMaxYearByGrowStageId(greadeYear);
				
				GrowStages growStages = new GrowStages();
				growStages.setId(greadeYear.getGrowStageId());
				growStages.setStartAge(greadeYear.getStartYear());
				growStages.setEndAge(greadeYear.getEndYear());
				
				Integer count =  iGrowStagesDao.updateById(growStages);
				if(count > 0){
					resultData.setStatus(IBaseService.SUCCESS);
				}else{
					resultData.setStatus(IBaseService.FAIL);
				}
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
	
	public ResultData delete(GreadeYear greadeYear){
		ResultData resultData = new ResultData();
		try {
			Integer result = super.getGreadeYearDao().delete(greadeYear);
			if (result > 0){
				greadeYear = super.getGreadeYearDao().selectMinAndMaxYearByGrowStageId(greadeYear);
				
				GrowStages growStages = new GrowStages();
				growStages.setId(greadeYear.getGrowStageId());
				growStages.setStartAge(greadeYear.getStartYear());
				growStages.setEndAge(greadeYear.getEndYear());
				
				Integer count =  iGrowStagesDao.updateById(growStages);
				if(count > 0){
					resultData.setStatus(IBaseService.SUCCESS);
				}else{
					resultData.setStatus(IBaseService.FAIL);
				}
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
}
