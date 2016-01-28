package com.bs.plugins.custom.pc.structureconfig.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.structureconfig.entity.StructureConfig;
import com.bs.plugins.custom.pc.structureconfig.dao.IStructureConfigDao;

public class BaseStructureConfigService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IStructureConfigDao structureConfigDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureConfigDao.insert(structureConfig);
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
	public ResultData modify(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureConfigDao.updateById(structureConfig);
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
	public ResultData modifyById(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureConfigDao.updateById(structureConfig);
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
	public ResultData modifyComplete(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureConfigDao.updateCompleteById(structureConfig);
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
	public ResultData delete(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureConfigDao.delete(structureConfig);
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
	public ResultData deleteById(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = structureConfigDao.deleteById(structureConfig);
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
			Integer result = structureConfigDao.deleteAll();
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
	public ResultData single(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			StructureConfig structureConfigTemp = structureConfigDao.selectOneById(structureConfig);
			if (structureConfigTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("structureConfig", structureConfigTemp);
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
	public ResultData list(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			List<StructureConfig> structureConfigList = structureConfigDao.selectList(structureConfig);
			if (structureConfigList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("structureConfigList", structureConfigList);
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
	public ResultData paginated(StructureConfig structureConfig){
		ResultData resultData = new ResultData();
		try {
			List<StructureConfig> structureConfigList = structureConfigDao.selectPaginatedList(structureConfig);
			Long structureConfigCount = structureConfigDao.getCount(structureConfig);
			if (structureConfigList != null){
				long record = structureConfigCount == null?0:structureConfigCount;
				int pageCount = (int) Math.ceil(record / (double) structureConfig.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", structureConfig.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", structureConfigList);
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
	
	public IStructureConfigDao getStructureConfigDao() {
		return structureConfigDao;
	}

	public void setStructureConfigDao(IStructureConfigDao structureConfigDao) {
		this.structureConfigDao = structureConfigDao;
	}
}
