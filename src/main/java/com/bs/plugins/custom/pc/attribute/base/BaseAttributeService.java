package com.bs.plugins.custom.pc.attribute.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.attribute.entity.Attribute;
import com.bs.plugins.custom.pc.attribute.dao.IAttributeDao;

public class BaseAttributeService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAttributeDao attributeDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDao.insert(attribute);
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
	public ResultData modify(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDao.updateById(attribute);
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
	public ResultData modifyById(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDao.updateById(attribute);
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
	public ResultData modifyComplete(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDao.updateCompleteById(attribute);
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
	public ResultData delete(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDao.delete(attribute);
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
	public ResultData deleteById(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Integer result = attributeDao.deleteById(attribute);
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
			Integer result = attributeDao.deleteAll();
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
	public ResultData single(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			Attribute attributeTemp = attributeDao.selectOneById(attribute);
			if (attributeTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("attribute", attributeTemp);
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
	public ResultData list(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			List<Attribute> attributeList = attributeDao.selectList(attribute);
			if (attributeList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("attributeList", attributeList);
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
	public ResultData paginated(Attribute attribute){
		ResultData resultData = new ResultData();
		try {
			List<Attribute> attributeList = attributeDao.selectPaginatedList(attribute);
			Long attributeCount = attributeDao.getCount(attribute);
			if (attributeList != null){
				long record = attributeCount == null?0:attributeCount;
				int pageCount = (int) Math.ceil(record / (double) attribute.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", attribute.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", attributeList);
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
	
	public IAttributeDao getAttributeDao() {
		return attributeDao;
	}

	public void setAttributeDao(IAttributeDao attributeDao) {
		this.attributeDao = attributeDao;
	}
}
