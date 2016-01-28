package com.bs.plugins.custom.cc.bankcardchangeapply.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.bankcardchangeapply.entity.BankCardChangeApply;
import com.bs.plugins.custom.cc.bankcardchangeapply.dao.IBankCardChangeApplyDao;

public class BaseBankCardChangeApplyService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBankCardChangeApplyDao bankCardChangeApplyDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardChangeApplyDao.insert(bankCardChangeApply);
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
	public ResultData modify(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardChangeApplyDao.updateById(bankCardChangeApply);
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
	public ResultData modifyById(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardChangeApplyDao.updateById(bankCardChangeApply);
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
	public ResultData modifyComplete(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardChangeApplyDao.updateCompleteById(bankCardChangeApply);
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
	public ResultData delete(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardChangeApplyDao.delete(bankCardChangeApply);
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
	public ResultData deleteById(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardChangeApplyDao.deleteById(bankCardChangeApply);
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
			Integer result = bankCardChangeApplyDao.deleteAll();
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
	public ResultData single(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			BankCardChangeApply bankCardChangeApplyTemp = bankCardChangeApplyDao.selectOneById(bankCardChangeApply);
			if (bankCardChangeApplyTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("bankCardChangeApply", bankCardChangeApplyTemp);
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
	public ResultData list(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			List<BankCardChangeApply> bankCardChangeApplyList = bankCardChangeApplyDao.selectList(bankCardChangeApply);
			if (bankCardChangeApplyList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("bankCardChangeApplyList", bankCardChangeApplyList);
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
	public ResultData paginated(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			List<BankCardChangeApply> bankCardChangeApplyList = bankCardChangeApplyDao.selectPaginatedList(bankCardChangeApply);
			Long bankCardChangeApplyCount = bankCardChangeApplyDao.getCount(bankCardChangeApply);
			if (bankCardChangeApplyList != null){
				long record = bankCardChangeApplyCount == null?0:bankCardChangeApplyCount;
				int pageCount = (int) Math.ceil(record / (double) bankCardChangeApply.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", bankCardChangeApply.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", bankCardChangeApplyList);
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
	
	public IBankCardChangeApplyDao getBankCardChangeApplyDao() {
		return bankCardChangeApplyDao;
	}

	public void setBankCardChangeApplyDao(IBankCardChangeApplyDao bankCardChangeApplyDao) {
		this.bankCardChangeApplyDao = bankCardChangeApplyDao;
	}
}
