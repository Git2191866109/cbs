package com.bs.plugins.custom.cc.accountinfo.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.accountinfo.entity.AccountInfo;
import com.bs.plugins.custom.cc.accountinfo.dao.IAccountInfoDao;

public class BaseAccountInfoService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAccountInfoDao accountInfoDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountInfoDao.insert(accountInfo);
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
	public ResultData modify(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountInfoDao.updateById(accountInfo);
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
	public ResultData modifyById(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountInfoDao.updateById(accountInfo);
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
	public ResultData delete(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountInfoDao.delete(accountInfo);
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
	public ResultData deleteById(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = accountInfoDao.deleteById(accountInfo);
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
			Integer result = accountInfoDao.deleteAll();
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
	public ResultData single(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			AccountInfo accountInfoTemp = accountInfoDao.selectOneById(accountInfo);
			if (accountInfoTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("accountInfo", accountInfoTemp);
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
	public ResultData list(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			List<AccountInfo> accountInfoList = accountInfoDao.selectList(accountInfo);
			if (accountInfoList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("accountInfoList", accountInfoList);
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
	public ResultData paginated(AccountInfo accountInfo){
		ResultData resultData = new ResultData();
		try {
			List<AccountInfo> accountInfoList = accountInfoDao.selectPaginatedList(accountInfo);
			Long accountInfoCount = accountInfoDao.getCount(accountInfo);
			if (accountInfoList != null){
				long record = accountInfoCount == null?0:accountInfoCount;
				int pageCount = (int) Math.ceil(record / (double) accountInfo.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", accountInfo.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", accountInfoList);
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
	
	public IAccountInfoDao getAccountInfoDao() {
		return accountInfoDao;
	}

	public void setAccountInfoDao(IAccountInfoDao accountInfoDao) {
		this.accountInfoDao = accountInfoDao;
	}
}
