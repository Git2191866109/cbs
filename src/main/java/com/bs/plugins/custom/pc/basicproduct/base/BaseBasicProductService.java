package com.bs.plugins.custom.pc.basicproduct.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.basicproduct.entity.BasicProduct;
import com.bs.plugins.custom.pc.basicproduct.dao.IBasicProductDao;

public class BaseBasicProductService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBasicProductDao basicProductDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = basicProductDao.insert(basicProduct);
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
	public ResultData modify(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = basicProductDao.updateById(basicProduct);
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
	public ResultData modifyById(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = basicProductDao.updateById(basicProduct);
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
	public ResultData modifyComplete(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = basicProductDao.updateCompleteById(basicProduct);
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
	public ResultData delete(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = basicProductDao.delete(basicProduct);
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
	public ResultData deleteById(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			Integer result = basicProductDao.deleteById(basicProduct);
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
			Integer result = basicProductDao.deleteAll();
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
	public ResultData single(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			BasicProduct basicProductTemp = basicProductDao.selectOneById(basicProduct);
			if (basicProductTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("basicProduct", basicProductTemp);
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
	public ResultData list(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			List<BasicProduct> basicProductList = basicProductDao.selectList(basicProduct);
			if (basicProductList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("basicProductList", basicProductList);
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
	public ResultData paginated(BasicProduct basicProduct){
		ResultData resultData = new ResultData();
		try {
			List<BasicProduct> basicProductList = basicProductDao.selectPaginatedList(basicProduct);
			Long basicProductCount = basicProductDao.getCount(basicProduct);
			if (basicProductList != null){
				long record = basicProductCount == null?0:basicProductCount;
				int pageCount = (int) Math.ceil(record / (double) basicProduct.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", basicProduct.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", basicProductList);
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
	
	public IBasicProductDao getBasicProductDao() {
		return basicProductDao;
	}

	public void setBasicProductDao(IBasicProductDao basicProductDao) {
		this.basicProductDao = basicProductDao;
	}
}
