package com.bs.plugins.custom.cc.bankcardbinding.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.bankcardbinding.entity.BankCardBinding;
import com.bs.plugins.custom.cc.bankcardbinding.dao.IBankCardBindingDao;

public class BaseBankCardBindingService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IBankCardBindingDao bankCardBindingDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardBindingDao.insert(bankCardBinding);
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
	public ResultData modify(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardBindingDao.updateById(bankCardBinding);
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
	public ResultData modifyById(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardBindingDao.updateById(bankCardBinding);
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
	public ResultData modifyComplete(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardBindingDao.updateCompleteById(bankCardBinding);
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
	public ResultData delete(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardBindingDao.delete(bankCardBinding);
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
	public ResultData deleteById(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			Integer result = bankCardBindingDao.deleteById(bankCardBinding);
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
			Integer result = bankCardBindingDao.deleteAll();
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
	public ResultData single(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			BankCardBinding bankCardBindingTemp = bankCardBindingDao.selectOneById(bankCardBinding);
			if (bankCardBindingTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("bankCardBinding", bankCardBindingTemp);
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
	public ResultData list(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			List<BankCardBinding> bankCardBindingList = bankCardBindingDao.selectList(bankCardBinding);
			if (bankCardBindingList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("bankCardBindingList", bankCardBindingList);
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
	public ResultData paginated(BankCardBinding bankCardBinding){
		ResultData resultData = new ResultData();
		try {
			List<BankCardBinding> bankCardBindingList = bankCardBindingDao.selectPaginatedList(bankCardBinding);
			Long bankCardBindingCount = bankCardBindingDao.getCount(bankCardBinding);
			if (bankCardBindingList != null){
				long record = bankCardBindingCount == null?0:bankCardBindingCount;
				int pageCount = (int) Math.ceil(record / (double) bankCardBinding.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", bankCardBinding.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", bankCardBindingList);
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
	
	public IBankCardBindingDao getBankCardBindingDao() {
		return bankCardBindingDao;
	}

	public void setBankCardBindingDao(IBankCardBindingDao bankCardBindingDao) {
		this.bankCardBindingDao = bankCardBindingDao;
	}
}
