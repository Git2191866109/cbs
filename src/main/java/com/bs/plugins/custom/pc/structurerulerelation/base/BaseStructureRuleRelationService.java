package com.bs.plugins.custom.pc.structurerulerelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.structurerulerelation.entity.StructureRuleRelation;
import com.bs.plugins.custom.pc.structurerulerelation.dao.IStructureRuleRelationDao;

public class BaseStructureRuleRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IStructureRuleRelationDao structureRuleRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(StructureRuleRelation structureRuleRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureRuleRelationDao.insert(structureRuleRelation);
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
	public ResultData delete(StructureRuleRelation structureRuleRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureRuleRelationDao.delete(structureRuleRelation);
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
			Integer result = structureRuleRelationDao.deleteAll();
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(StructureRuleRelation structureRuleRelation){
		ResultData resultData = new ResultData();
		try {
			List<StructureRuleRelation> structureRuleRelationList = structureRuleRelationDao.selectList(structureRuleRelation);
			if (structureRuleRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("structureRuleRelationList", structureRuleRelationList);
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
	public ResultData paginated(StructureRuleRelation structureRuleRelation){
		ResultData resultData = new ResultData();
		try {
			List<StructureRuleRelation> structureRuleRelationList = structureRuleRelationDao.selectPaginatedList(structureRuleRelation);
			Long structureRuleRelationCount = structureRuleRelationDao.getCount(structureRuleRelation);
			if (structureRuleRelationList != null){
				long record = structureRuleRelationCount == null?0:structureRuleRelationCount;
				int pageCount = (int) Math.ceil(record / (double) structureRuleRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", structureRuleRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", structureRuleRelationList);
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
	
	public IStructureRuleRelationDao getStructureRuleRelationDao() {
		return structureRuleRelationDao;
	}

	public void setStructureRuleRelationDao(IStructureRuleRelationDao structureRuleRelationDao) {
		this.structureRuleRelationDao = structureRuleRelationDao;
	}
}
