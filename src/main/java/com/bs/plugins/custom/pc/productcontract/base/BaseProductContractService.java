package com.bs.plugins.custom.pc.productcontract.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.productcontract.entity.ProductContract;
import com.bs.plugins.custom.pc.productcontract.dao.IProductContractDao;

public class BaseProductContractService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IProductContractDao productContractDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractDao.insert(productContract);
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
	public ResultData modify(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractDao.updateById(productContract);
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
	public ResultData modifyById(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractDao.updateById(productContract);
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
	public ResultData modifyComplete(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractDao.updateCompleteById(productContract);
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
	public ResultData delete(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractDao.delete(productContract);
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
	public ResultData deleteById(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			Integer result = productContractDao.deleteById(productContract);
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
			Integer result = productContractDao.deleteAll();
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
	public ResultData single(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			ProductContract productContractTemp = productContractDao.selectOneById(productContract);
			if (productContractTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productContract", productContractTemp);
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
	public ResultData list(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			List<ProductContract> productContractList = productContractDao.selectList(productContract);
			if (productContractList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productContractList", productContractList);
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
	public ResultData paginated(ProductContract productContract){
		ResultData resultData = new ResultData();
		try {
			List<ProductContract> productContractList = productContractDao.selectPaginatedList(productContract);
			Long productContractCount = productContractDao.getCount(productContract);
			if (productContractList != null){
				long record = productContractCount == null?0:productContractCount;
				int pageCount = (int) Math.ceil(record / (double) productContract.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productContract.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", productContractList);
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
	
	public IProductContractDao getProductContractDao() {
		return productContractDao;
	}

	public void setProductContractDao(IProductContractDao productContractDao) {
		this.productContractDao = productContractDao;
	}
}
