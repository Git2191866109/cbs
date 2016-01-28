package com.bs.plugins.custom.es.emailsent.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.es.emailsent.entity.EmailSent;
import com.bs.plugins.custom.es.emailsent.dao.IEmailSentDao;

public class BaseEmailSentService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEmailSentDao emailSentDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSentDao.insert(emailSent);
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
	public ResultData modify(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSentDao.updateById(emailSent);
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
	public ResultData modifyById(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSentDao.updateById(emailSent);
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
	public ResultData modifyComplete(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSentDao.updateCompleteById(emailSent);
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
	public ResultData delete(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSentDao.delete(emailSent);
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
	public ResultData deleteById(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSentDao.deleteById(emailSent);
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
			Integer result = emailSentDao.deleteAll();
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
	public ResultData single(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			EmailSent emailSentTemp = emailSentDao.selectOneById(emailSent);
			if (emailSentTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailSent", emailSentTemp);
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
	public ResultData list(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			List<EmailSent> emailSentList = emailSentDao.selectList(emailSent);
			if (emailSentList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailSentList", emailSentList);
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
	public ResultData paginated(EmailSent emailSent){
		ResultData resultData = new ResultData();
		try {
			List<EmailSent> emailSentList = emailSentDao.selectPaginatedList(emailSent);
			Long emailSentCount = emailSentDao.getCount(emailSent);
			if (emailSentList != null){
				long record = emailSentCount == null?0:emailSentCount;
				int pageCount = (int) Math.ceil(record / (double) emailSent.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", emailSent.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", emailSentList);
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
	
	public IEmailSentDao getEmailSentDao() {
		return emailSentDao;
	}

	public void setEmailSentDao(IEmailSentDao emailSentDao) {
		this.emailSentDao = emailSentDao;
	}
}
