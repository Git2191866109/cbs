package com.bs.plugins.custom.tc.bankbasicinfo.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.bankbasicinfo.entity.BankBasicInfo;
import com.bs.plugins.custom.tc.bankbasicinfo.dao.IBankBasicInfoDao;

public class BaseBankBasicInfoService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBankBasicInfoDao bankBasicInfoDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankBasicInfoDao.insert(bankBasicInfo);
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
	public ResultData modify(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankBasicInfoDao.updateById(bankBasicInfo);
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
	public ResultData modifyById(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankBasicInfoDao.updateById(bankBasicInfo);
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
	public ResultData modifyComplete(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankBasicInfoDao.updateCompleteById(bankBasicInfo);
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
	public ResultData delete(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankBasicInfoDao.delete(bankBasicInfo);
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
	public ResultData deleteById(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankBasicInfoDao.deleteById(bankBasicInfo);
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
			Integer result = bankBasicInfoDao.deleteAll();
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
	public ResultData single(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			BankBasicInfo bankBasicInfoTemp = bankBasicInfoDao.selectOneById(bankBasicInfo);
			if (bankBasicInfoTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("bankBasicInfo", bankBasicInfoTemp);
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
	public ResultData list(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			List<BankBasicInfo> bankBasicInfoList = bankBasicInfoDao.selectList(bankBasicInfo);
			if (bankBasicInfoList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("bankBasicInfoList", bankBasicInfoList);
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
	public ResultData paginated(BankBasicInfo bankBasicInfo){
		ResultData resultData = new ResultData();
		try {
			List<BankBasicInfo> bankBasicInfoList = bankBasicInfoDao.selectPaginatedList(bankBasicInfo);
			Long bankBasicInfoCount = bankBasicInfoDao.getCount(bankBasicInfo);
			if (bankBasicInfoList != null){
				long record = bankBasicInfoCount == null?0:bankBasicInfoCount;
				int pageCount = (int) Math.ceil(record / (double) bankBasicInfo.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", bankBasicInfo.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", bankBasicInfoList);
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
	
	public IBankBasicInfoDao getBankBasicInfoDao() {
		return bankBasicInfoDao;
	}

	public void setBankBasicInfoDao(IBankBasicInfoDao bankBasicInfoDao) {
		this.bankBasicInfoDao = bankBasicInfoDao;
	}
}
