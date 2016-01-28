package com.bs.plugins.custom.pc.attributedataconfig.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.attributedataconfig.entity.AttributeDataConfig;
import com.bs.plugins.custom.pc.attributedataconfig.dao.IAttributeDataConfigDao;

public class BaseAttributeDataConfigService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAttributeDataConfigDao attributeDataConfigDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDataConfigDao.insert(attributeDataConfig);
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
	public ResultData modify(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDataConfigDao.updateById(attributeDataConfig);
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
	public ResultData modifyById(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDataConfigDao.updateById(attributeDataConfig);
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
	public ResultData modifyComplete(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDataConfigDao.updateCompleteById(attributeDataConfig);
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
	public ResultData delete(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDataConfigDao.delete(attributeDataConfig);
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
	public ResultData deleteById(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDataConfigDao.deleteById(attributeDataConfig);
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
			Integer result = attributeDataConfigDao.deleteAll();
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
	public ResultData single(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			AttributeDataConfig attributeDataConfigTemp = attributeDataConfigDao.selectOneById(attributeDataConfig);
			if (attributeDataConfigTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("attributeDataConfig", attributeDataConfigTemp);
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
	public ResultData list(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			List<AttributeDataConfig> attributeDataConfigList = attributeDataConfigDao.selectList(attributeDataConfig);
			if (attributeDataConfigList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("attributeDataConfigList", attributeDataConfigList);
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
	public ResultData paginated(AttributeDataConfig attributeDataConfig){
		ResultData resultData = new ResultData();
		try {
			List<AttributeDataConfig> attributeDataConfigList = attributeDataConfigDao.selectPaginatedList(attributeDataConfig);
			Long attributeDataConfigCount = attributeDataConfigDao.getCount(attributeDataConfig);
			if (attributeDataConfigList != null){
				long record = attributeDataConfigCount == null?0:attributeDataConfigCount;
				int pageCount = (int) Math.ceil(record / (double) attributeDataConfig.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", attributeDataConfig.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", attributeDataConfigList);
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
	
	public IAttributeDataConfigDao getAttributeDataConfigDao() {
		return attributeDataConfigDao;
	}

	public void setAttributeDataConfigDao(IAttributeDataConfigDao attributeDataConfigDao) {
		this.attributeDataConfigDao = attributeDataConfigDao;
	}
}
