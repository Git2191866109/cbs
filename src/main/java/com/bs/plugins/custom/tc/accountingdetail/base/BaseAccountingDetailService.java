package com.bs.plugins.custom.tc.accountingdetail.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.accountingdetail.entity.AccountingDetail;
import com.bs.plugins.custom.tc.accountingdetail.dao.IAccountingDetailDao;

public class BaseAccountingDetailService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAccountingDetailDao accountingDetailDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingDetailDao.insert(accountingDetail);
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
	public ResultData modify(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingDetailDao.updateById(accountingDetail);
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
	public ResultData modifyById(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingDetailDao.updateById(accountingDetail);
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
	public ResultData modifyComplete(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingDetailDao.updateCompleteById(accountingDetail);
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
	public ResultData delete(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingDetailDao.delete(accountingDetail);
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
	public ResultData deleteById(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountingDetailDao.deleteById(accountingDetail);
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
			Integer result = accountingDetailDao.deleteAll();
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
	public ResultData single(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			AccountingDetail accountingDetailTemp = accountingDetailDao.selectOneById(accountingDetail);
			if (accountingDetailTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("accountingDetail", accountingDetailTemp);
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
	public ResultData list(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			List<AccountingDetail> accountingDetailList = accountingDetailDao.selectList(accountingDetail);
			if (accountingDetailList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("accountingDetailList", accountingDetailList);
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
	public ResultData paginated(AccountingDetail accountingDetail){
		ResultData resultData = new ResultData();
		try {
			List<AccountingDetail> accountingDetailList = accountingDetailDao.selectPaginatedList(accountingDetail);
			Long accountingDetailCount = accountingDetailDao.getCount(accountingDetail);
			if (accountingDetailList != null){
				long record = accountingDetailCount == null?0:accountingDetailCount;
				int pageCount = (int) Math.ceil(record / (double) accountingDetail.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", accountingDetail.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", accountingDetailList);
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
	
	public IAccountingDetailDao getAccountingDetailDao() {
		return accountingDetailDao;
	}

	public void setAccountingDetailDao(IAccountingDetailDao accountingDetailDao) {
		this.accountingDetailDao = accountingDetailDao;
	}
}
