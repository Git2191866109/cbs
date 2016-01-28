package com.bs.plugins.custom.pc.structurekindrelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.structurekindrelation.entity.StructureKindRelation;
import com.bs.plugins.custom.pc.structurekindrelation.dao.IStructureKindRelationDao;

public class BaseStructureKindRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IStructureKindRelationDao structureKindRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(StructureKindRelation structureKindRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureKindRelationDao.insert(structureKindRelation);
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
	public ResultData delete(StructureKindRelation structureKindRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureKindRelationDao.delete(structureKindRelation);
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
			Integer result = structureKindRelationDao.deleteAll();
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
	public ResultData list(StructureKindRelation structureKindRelation){
		ResultData resultData = new ResultData();
		try {
			List<StructureKindRelation> structureKindRelationList = structureKindRelationDao.selectList(structureKindRelation);
			if (structureKindRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("structureKindRelationList", structureKindRelationList);
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
	public ResultData paginated(StructureKindRelation structureKindRelation){
		ResultData resultData = new ResultData();
		try {
			List<StructureKindRelation> structureKindRelationList = structureKindRelationDao.selectPaginatedList(structureKindRelation);
			Long structureKindRelationCount = structureKindRelationDao.getCount(structureKindRelation);
			if (structureKindRelationList != null){
				long record = structureKindRelationCount == null?0:structureKindRelationCount;
				int pageCount = (int) Math.ceil(record / (double) structureKindRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", structureKindRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", structureKindRelationList);
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
	
	public IStructureKindRelationDao getStructureKindRelationDao() {
		return structureKindRelationDao;
	}

	public void setStructureKindRelationDao(IStructureKindRelationDao structureKindRelationDao) {
		this.structureKindRelationDao = structureKindRelationDao;
	}
}
