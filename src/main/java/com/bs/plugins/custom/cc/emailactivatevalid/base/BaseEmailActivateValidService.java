package com.bs.plugins.custom.cc.emailactivatevalid.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.emailactivatevalid.entity.EmailActivateValid;
import com.bs.plugins.custom.cc.emailactivatevalid.dao.IEmailActivateValidDao;

public class BaseEmailActivateValidService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEmailActivateValidDao emailActivateValidDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailActivateValidDao.insert(emailActivateValid);
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
	public ResultData modify(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailActivateValidDao.updateById(emailActivateValid);
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
	public ResultData modifyById(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailActivateValidDao.updateById(emailActivateValid);
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
	public ResultData modifyComplete(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailActivateValidDao.updateCompleteById(emailActivateValid);
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
	public ResultData delete(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailActivateValidDao.delete(emailActivateValid);
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
	public ResultData deleteById(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailActivateValidDao.deleteById(emailActivateValid);
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
			Integer result = emailActivateValidDao.deleteAll();
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
	public ResultData single(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			EmailActivateValid emailActivateValidTemp = emailActivateValidDao.selectOneById(emailActivateValid);
			if (emailActivateValidTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailActivateValid", emailActivateValidTemp);
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
	public ResultData list(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			List<EmailActivateValid> emailActivateValidList = emailActivateValidDao.selectList(emailActivateValid);
			if (emailActivateValidList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailActivateValidList", emailActivateValidList);
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
	public ResultData paginated(EmailActivateValid emailActivateValid){
		ResultData resultData = new ResultData();
		try {
			List<EmailActivateValid> emailActivateValidList = emailActivateValidDao.selectPaginatedList(emailActivateValid);
			Long emailActivateValidCount = emailActivateValidDao.getCount(emailActivateValid);
			if (emailActivateValidList != null){
				long record = emailActivateValidCount == null?0:emailActivateValidCount;
				int pageCount = (int) Math.ceil(record / (double) emailActivateValid.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", emailActivateValid.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", emailActivateValidList);
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
	
	public IEmailActivateValidDao getEmailActivateValidDao() {
		return emailActivateValidDao;
	}

	public void setEmailActivateValidDao(IEmailActivateValidDao emailActivateValidDao) {
		this.emailActivateValidDao = emailActivateValidDao;
	}
}
