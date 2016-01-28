package com.bs.plugins.custom.pc.productcontractrelation.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.productcontractrelation.entity.ProductContractRelation;
import com.bs.plugins.custom.pc.productcontractrelation.dao.IProductContractRelationDao;

public class BaseProductContractRelationService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IProductContractRelationDao productContractRelationDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ProductContractRelation productContractRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractRelationDao.insert(productContractRelation);
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
	public ResultData delete(ProductContractRelation productContractRelation){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractRelationDao.delete(productContractRelation);
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
			Integer result = productContractRelationDao.deleteAll();
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(ProductContractRelation productContractRelation){
		ResultData resultData = new ResultData();
		try {
			List<ProductContractRelation> productContractRelationList = productContractRelationDao.selectList(productContractRelation);
			if (productContractRelationList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productContractRelationList", productContractRelationList);
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
	public ResultData paginated(ProductContractRelation productContractRelation){
		ResultData resultData = new ResultData();
		try {
			List<ProductContractRelation> productContractRelationList = productContractRelationDao.selectPaginatedList(productContractRelation);
			Long productContractRelationCount = productContractRelationDao.getCount(productContractRelation);
			if (productContractRelationList != null){
				long record = productContractRelationCount == null?0:productContractRelationCount;
				int pageCount = (int) Math.ceil(record / (double) productContractRelation.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productContractRelation.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", productContractRelationList);
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
	
	public IProductContractRelationDao getProductContractRelationDao() {
		return productContractRelationDao;
	}

	public void setProductContractRelationDao(IProductContractRelationDao productContractRelationDao) {
		this.productContractRelationDao = productContractRelationDao;
	}
}
