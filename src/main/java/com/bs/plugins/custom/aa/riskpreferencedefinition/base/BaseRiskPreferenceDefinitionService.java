package com.bs.plugins.custom.aa.riskpreferencedefinition.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.aa.riskpreferencedefinition.entity.RiskPreferenceDefinition;
import com.bs.plugins.custom.aa.riskpreferencedefinition.dao.IRiskPreferenceDefinitionDao;

public class BaseRiskPreferenceDefinitionService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IRiskPreferenceDefinitionDao riskPreferenceDefinitionDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.insert(riskPreferenceDefinition);
			if (result > 0){
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
		
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modify(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.updateById(riskPreferenceDefinition);
			if (result > 0){
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
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modifyById(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.updateById(riskPreferenceDefinition);
			if (result > 0){
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
	/**
	 * 修改(完全修改)
	 * @param entity
	 * @return
	 */
	public ResultData modifyComplete(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.updateCompleteById(riskPreferenceDefinition);
			if (result > 0){
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

	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.delete(riskPreferenceDefinition);
			if (result > 0){
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
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteById(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.deleteById(riskPreferenceDefinition);
			if (result > 0){
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
	
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteAll(){
		ResultData resultData = new ResultData();
		try {
			Integer result = riskPreferenceDefinitionDao.deleteAll();
			if (result > 0){
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
	
	/**
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public ResultData single(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			RiskPreferenceDefinition riskPreferenceDefinitionTemp = riskPreferenceDefinitionDao.selectOneById(riskPreferenceDefinition);
			if (riskPreferenceDefinitionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("riskPreferenceDefinition", riskPreferenceDefinitionTemp);
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
	
	/**
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			List<RiskPreferenceDefinition> riskPreferenceDefinitionList = riskPreferenceDefinitionDao.selectList(riskPreferenceDefinition);
			if (riskPreferenceDefinitionList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("riskPreferenceDefinitionList", riskPreferenceDefinitionList);
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
	
	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(RiskPreferenceDefinition riskPreferenceDefinition){
		ResultData resultData = new ResultData();
		try {
			List<RiskPreferenceDefinition> riskPreferenceDefinitionList = riskPreferenceDefinitionDao.selectPaginatedList(riskPreferenceDefinition);
			Long riskPreferenceDefinitionCount = riskPreferenceDefinitionDao.getCount(riskPreferenceDefinition);
			if (riskPreferenceDefinitionList != null){
				long record = riskPreferenceDefinitionCount == null?0:riskPreferenceDefinitionCount;
				int pageCount = (int) Math.ceil(record / (double) riskPreferenceDefinition.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", riskPreferenceDefinition.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", riskPreferenceDefinitionList);
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
	
	
	@Override
	public void afterPropertiesSet() throws Exception {

	}
	
	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}
	
	public IRiskPreferenceDefinitionDao getRiskPreferenceDefinitionDao() {
		return riskPreferenceDefinitionDao;
	}

	public void setRiskPreferenceDefinitionDao(IRiskPreferenceDefinitionDao riskPreferenceDefinitionDao) {
		this.riskPreferenceDefinitionDao = riskPreferenceDefinitionDao;
	}
}
