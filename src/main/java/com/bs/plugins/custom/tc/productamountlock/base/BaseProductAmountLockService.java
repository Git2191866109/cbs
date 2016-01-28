package com.bs.plugins.custom.tc.productamountlock.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.productamountlock.entity.ProductAmountLock;
import com.bs.plugins.custom.tc.productamountlock.dao.IProductAmountLockDao;

public class BaseProductAmountLockService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IProductAmountLockDao productAmountLockDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAmountLockDao.insert(productAmountLock);
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
	public ResultData modify(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAmountLockDao.updateById(productAmountLock);
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
	public ResultData modifyById(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAmountLockDao.updateById(productAmountLock);
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
	public ResultData modifyComplete(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAmountLockDao.updateCompleteById(productAmountLock);
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
	public ResultData delete(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAmountLockDao.delete(productAmountLock);
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
	public ResultData deleteById(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAmountLockDao.deleteById(productAmountLock);
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
			Integer result = productAmountLockDao.deleteAll();
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
	public ResultData single(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			ProductAmountLock productAmountLockTemp = productAmountLockDao.selectOneById(productAmountLock);
			if (productAmountLockTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productAmountLock", productAmountLockTemp);
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
	public ResultData list(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			List<ProductAmountLock> productAmountLockList = productAmountLockDao.selectList(productAmountLock);
			if (productAmountLockList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productAmountLockList", productAmountLockList);
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
	public ResultData paginated(ProductAmountLock productAmountLock){
		ResultData resultData = new ResultData();
		try {
			List<ProductAmountLock> productAmountLockList = productAmountLockDao.selectPaginatedList(productAmountLock);
			Long productAmountLockCount = productAmountLockDao.getCount(productAmountLock);
			if (productAmountLockList != null){
				long record = productAmountLockCount == null?0:productAmountLockCount;
				int pageCount = (int) Math.ceil(record / (double) productAmountLock.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productAmountLock.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", productAmountLockList);
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
	
	public IProductAmountLockDao getProductAmountLockDao() {
		return productAmountLockDao;
	}

	public void setProductAmountLockDao(IProductAmountLockDao productAmountLockDao) {
		this.productAmountLockDao = productAmountLockDao;
	}
}
