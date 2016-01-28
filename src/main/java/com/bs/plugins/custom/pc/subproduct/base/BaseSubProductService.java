package com.bs.plugins.custom.pc.subproduct.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.subproduct.entity.SubProduct;
import com.bs.plugins.custom.pc.subproduct.dao.ISubProductDao;

public class BaseSubProductService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISubProductDao subProductDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = subProductDao.insert(subProduct);
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
	public ResultData modify(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = subProductDao.updateById(subProduct);
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
	public ResultData modifyById(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = subProductDao.updateById(subProduct);
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
	public ResultData modifyComplete(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = subProductDao.updateCompleteById(subProduct);
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
	public ResultData delete(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = subProductDao.delete(subProduct);
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
	public ResultData deleteById(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = subProductDao.deleteById(subProduct);
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
			Integer result = subProductDao.deleteAll();
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
	public ResultData single(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			SubProduct subProductTemp = subProductDao.selectOneById(subProduct);
			if (subProductTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subProduct", subProductTemp);
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
	public ResultData list(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			List<SubProduct> subProductList = subProductDao.selectList(subProduct);
			if (subProductList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("subProductList", subProductList);
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
	public ResultData paginated(SubProduct subProduct){
		ResultData resultData = new ResultData();
		try {
			List<SubProduct> subProductList = subProductDao.selectPaginatedList(subProduct);
			Long subProductCount = subProductDao.getCount(subProduct);
			if (subProductList != null){
				long record = subProductCount == null?0:subProductCount;
				int pageCount = (int) Math.ceil(record / (double) subProduct.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", subProduct.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", subProductList);
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
	
	public ISubProductDao getSubProductDao() {
		return subProductDao;
	}

	public void setSubProductDao(ISubProductDao subProductDao) {
		this.subProductDao = subProductDao;
	}
}
