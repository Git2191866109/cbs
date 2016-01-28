package com.bs.plugins.custom.eb.itemfieldcollectvalue.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.itemfieldcollectvalue.entity.ItemFieldCollectValue;
import com.bs.plugins.custom.eb.itemfieldcollectvalue.dao.IItemFieldCollectValueDao;

public class BaseItemFieldCollectValueService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IItemFieldCollectValueDao itemFieldCollectValueDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldCollectValueDao.insert(itemFieldCollectValue);
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
	public ResultData modify(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldCollectValueDao.updateById(itemFieldCollectValue);
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
	public ResultData modifyById(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldCollectValueDao.updateById(itemFieldCollectValue);
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
	public ResultData delete(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldCollectValueDao.delete(itemFieldCollectValue);
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
	public ResultData deleteById(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			Integer result = itemFieldCollectValueDao.deleteById(itemFieldCollectValue);
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
			Integer result = itemFieldCollectValueDao.deleteAll();
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
	public ResultData single(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			ItemFieldCollectValue itemFieldCollectValueTemp = itemFieldCollectValueDao.selectOneById(itemFieldCollectValue);
			if (itemFieldCollectValueTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("itemFieldCollectValue", itemFieldCollectValueTemp);
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
	public ResultData list(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			List<ItemFieldCollectValue> itemFieldCollectValueList = itemFieldCollectValueDao.selectList(itemFieldCollectValue);
			if (itemFieldCollectValueList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("itemFieldCollectValueList", itemFieldCollectValueList);
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
	public ResultData paginated(ItemFieldCollectValue itemFieldCollectValue){
		ResultData resultData = new ResultData();
		try {
			List<ItemFieldCollectValue> itemFieldCollectValueList = itemFieldCollectValueDao.selectPaginatedList(itemFieldCollectValue);
			Long itemFieldCollectValueCount = itemFieldCollectValueDao.getCount(itemFieldCollectValue);
			if (itemFieldCollectValueList != null){
				long record = itemFieldCollectValueCount == null?0:itemFieldCollectValueCount;
				int pageCount = (int) Math.ceil(record / (double) itemFieldCollectValue.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", itemFieldCollectValue.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", itemFieldCollectValueList);
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
	
	public IItemFieldCollectValueDao getItemFieldCollectValueDao() {
		return itemFieldCollectValueDao;
	}

	public void setItemFieldCollectValueDao(IItemFieldCollectValueDao itemFieldCollectValueDao) {
		this.itemFieldCollectValueDao = itemFieldCollectValueDao;
	}
}
