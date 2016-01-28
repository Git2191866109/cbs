package com.bs.plugins.custom.pc.productattributeconfig.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.productattributeconfig.entity.ProductAttributeConfig;
import com.bs.plugins.custom.pc.productattributeconfig.dao.IProductAttributeConfigDao;

public class BaseProductAttributeConfigService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IProductAttributeConfigDao productAttributeConfigDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAttributeConfigDao.insert(productAttributeConfig);
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
	public ResultData modify(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAttributeConfigDao.updateById(productAttributeConfig);
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
	public ResultData modifyById(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAttributeConfigDao.updateById(productAttributeConfig);
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
	public ResultData modifyComplete(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAttributeConfigDao.updateCompleteById(productAttributeConfig);
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
	public ResultData delete(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAttributeConfigDao.delete(productAttributeConfig);
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
	public ResultData deleteById(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			Integer result = productAttributeConfigDao.deleteById(productAttributeConfig);
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
			Integer result = productAttributeConfigDao.deleteAll();
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
	public ResultData single(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			ProductAttributeConfig productAttributeConfigTemp = productAttributeConfigDao.selectOneById(productAttributeConfig);
			if (productAttributeConfigTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productAttributeConfig", productAttributeConfigTemp);
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
	public ResultData list(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			List<ProductAttributeConfig> productAttributeConfigList = productAttributeConfigDao.selectList(productAttributeConfig);
			if (productAttributeConfigList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productAttributeConfigList", productAttributeConfigList);
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
	public ResultData paginated(ProductAttributeConfig productAttributeConfig){
		ResultData resultData = new ResultData();
		try {
			List<ProductAttributeConfig> productAttributeConfigList = productAttributeConfigDao.selectPaginatedList(productAttributeConfig);
			Long productAttributeConfigCount = productAttributeConfigDao.getCount(productAttributeConfig);
			if (productAttributeConfigList != null){
				long record = productAttributeConfigCount == null?0:productAttributeConfigCount;
				int pageCount = (int) Math.ceil(record / (double) productAttributeConfig.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productAttributeConfig.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", productAttributeConfigList);
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
	
	public IProductAttributeConfigDao getProductAttributeConfigDao() {
		return productAttributeConfigDao;
	}

	public void setProductAttributeConfigDao(IProductAttributeConfigDao productAttributeConfigDao) {
		this.productAttributeConfigDao = productAttributeConfigDao;
	}
}
