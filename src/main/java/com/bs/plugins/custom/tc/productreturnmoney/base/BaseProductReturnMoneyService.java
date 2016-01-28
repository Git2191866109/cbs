package com.bs.plugins.custom.tc.productreturnmoney.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.productreturnmoney.entity.ProductReturnMoney;
import com.bs.plugins.custom.tc.productreturnmoney.dao.IProductReturnMoneyDao;

public class BaseProductReturnMoneyService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IProductReturnMoneyDao productReturnMoneyDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = productReturnMoneyDao.insert(productReturnMoney);
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
	public ResultData modify(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = productReturnMoneyDao.updateById(productReturnMoney);
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
	public ResultData modifyById(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = productReturnMoneyDao.updateById(productReturnMoney);
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
	public ResultData modifyComplete(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = productReturnMoneyDao.updateCompleteById(productReturnMoney);
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
	public ResultData delete(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = productReturnMoneyDao.delete(productReturnMoney);
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
	public ResultData deleteById(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			Integer result = productReturnMoneyDao.deleteById(productReturnMoney);
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
			Integer result = productReturnMoneyDao.deleteAll();
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
	public ResultData single(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			ProductReturnMoney productReturnMoneyTemp = productReturnMoneyDao.selectOneById(productReturnMoney);
			if (productReturnMoneyTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productReturnMoney", productReturnMoneyTemp);
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
	public ResultData list(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			List<ProductReturnMoney> productReturnMoneyList = productReturnMoneyDao.selectList(productReturnMoney);
			if (productReturnMoneyList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("productReturnMoneyList", productReturnMoneyList);
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
	public ResultData paginated(ProductReturnMoney productReturnMoney){
		ResultData resultData = new ResultData();
		try {
			List<ProductReturnMoney> productReturnMoneyList = productReturnMoneyDao.selectPaginatedList(productReturnMoney);
			Long productReturnMoneyCount = productReturnMoneyDao.getCount(productReturnMoney);
			if (productReturnMoneyList != null){
				long record = productReturnMoneyCount == null?0:productReturnMoneyCount;
				int pageCount = (int) Math.ceil(record / (double) productReturnMoney.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", productReturnMoney.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", productReturnMoneyList);
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
	
	public IProductReturnMoneyDao getProductReturnMoneyDao() {
		return productReturnMoneyDao;
	}

	public void setProductReturnMoneyDao(IProductReturnMoneyDao productReturnMoneyDao) {
		this.productReturnMoneyDao = productReturnMoneyDao;
	}
}
