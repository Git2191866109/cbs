package com.bs.plugins.custom.eb.itemfieldvalue.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.itemfieldvalue.entity.ItemFieldValue;
import com.bs.plugins.custom.eb.itemfieldvalue.dao.IItemFieldValueDao;

public class BaseItemFieldValueService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IItemFieldValueDao itemFieldValueDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldValueDao.insert(itemFieldValue);
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
	public ResultData modify(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldValueDao.updateById(itemFieldValue);
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
	public ResultData modifyById(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldValueDao.updateById(itemFieldValue);
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
	public ResultData modifyComplete(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldValueDao.updateCompleteById(itemFieldValue);
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
	public ResultData delete(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldValueDao.delete(itemFieldValue);
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
	public ResultData deleteById(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldValueDao.deleteById(itemFieldValue);
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
			Integer result = itemFieldValueDao.deleteAll();
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
	public ResultData single(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			ItemFieldValue itemFieldValueTemp = itemFieldValueDao.selectOneById(itemFieldValue);
			if (itemFieldValueTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("itemFieldValue", itemFieldValueTemp);
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
	public ResultData list(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			List<ItemFieldValue> itemFieldValueList = itemFieldValueDao.selectList(itemFieldValue);
			if (itemFieldValueList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("itemFieldValueList", itemFieldValueList);
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
	public ResultData paginated(ItemFieldValue itemFieldValue){
		ResultData resultData = new ResultData();
		try {
			List<ItemFieldValue> itemFieldValueList = itemFieldValueDao.selectPaginatedList(itemFieldValue);
			Long itemFieldValueCount = itemFieldValueDao.getCount(itemFieldValue);
			if (itemFieldValueList != null){
				long record = itemFieldValueCount == null?0:itemFieldValueCount;
				int pageCount = (int) Math.ceil(record / (double) itemFieldValue.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", itemFieldValue.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", itemFieldValueList);
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
	
	public IItemFieldValueDao getItemFieldValueDao() {
		return itemFieldValueDao;
	}

	public void setItemFieldValueDao(IItemFieldValueDao itemFieldValueDao) {
		this.itemFieldValueDao = itemFieldValueDao;
	}
}
