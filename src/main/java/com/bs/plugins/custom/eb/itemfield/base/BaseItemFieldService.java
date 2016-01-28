package com.bs.plugins.custom.eb.itemfield.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.itemfield.entity.ItemField;
import com.bs.plugins.custom.eb.itemfield.dao.IItemFieldDao;

public class BaseItemFieldService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IItemFieldDao itemFieldDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldDao.insert(itemField);
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
	public ResultData modify(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldDao.updateById(itemField);
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
	public ResultData modifyById(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldDao.updateById(itemField);
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
	public ResultData modifyComplete(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldDao.updateCompleteById(itemField);
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
	public ResultData delete(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldDao.delete(itemField);
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
	public ResultData deleteById(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldDao.deleteById(itemField);
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
			Integer result = itemFieldDao.deleteAll();
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
	public ResultData single(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			ItemField itemFieldTemp = itemFieldDao.selectOneById(itemField);
			if (itemFieldTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("itemField", itemFieldTemp);
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
	public ResultData list(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			List<ItemField> itemFieldList = itemFieldDao.selectList(itemField);
			if (itemFieldList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("itemFieldList", itemFieldList);
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
	public ResultData paginated(ItemField itemField){
		ResultData resultData = new ResultData();
		try {
			List<ItemField> itemFieldList = itemFieldDao.selectPaginatedList(itemField);
			Long itemFieldCount = itemFieldDao.getCount(itemField);
			if (itemFieldList != null){
				long record = itemFieldCount == null?0:itemFieldCount;
				int pageCount = (int) Math.ceil(record / (double) itemField.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", itemField.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", itemFieldList);
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
	
	public IItemFieldDao getItemFieldDao() {
		return itemFieldDao;
	}

	public void setItemFieldDao(IItemFieldDao itemFieldDao) {
		this.itemFieldDao = itemFieldDao;
	}
}
