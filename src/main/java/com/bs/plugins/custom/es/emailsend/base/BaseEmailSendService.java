package com.bs.plugins.custom.es.emailsend.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.es.emailsend.entity.EmailSend;
import com.bs.plugins.custom.es.emailsend.dao.IEmailSendDao;

public class BaseEmailSendService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEmailSendDao emailSendDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSendDao.insert(emailSend);
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
	public ResultData modify(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSendDao.updateById(emailSend);
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
	public ResultData modifyById(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSendDao.updateById(emailSend);
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
	public ResultData modifyComplete(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSendDao.updateCompleteById(emailSend);
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
	public ResultData delete(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSendDao.delete(emailSend);
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
	public ResultData deleteById(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailSendDao.deleteById(emailSend);
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
			Integer result = emailSendDao.deleteAll();
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
	public ResultData single(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			EmailSend emailSendTemp = emailSendDao.selectOneById(emailSend);
			if (emailSendTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailSend", emailSendTemp);
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
	public ResultData list(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			List<EmailSend> emailSendList = emailSendDao.selectList(emailSend);
			if (emailSendList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailSendList", emailSendList);
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
	public ResultData paginated(EmailSend emailSend){
		ResultData resultData = new ResultData();
		try {
			List<EmailSend> emailSendList = emailSendDao.selectPaginatedList(emailSend);
			Long emailSendCount = emailSendDao.getCount(emailSend);
			if (emailSendList != null){
				long record = emailSendCount == null?0:emailSendCount;
				int pageCount = (int) Math.ceil(record / (double) emailSend.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", emailSend.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", emailSendList);
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
	
	public IEmailSendDao getEmailSendDao() {
		return emailSendDao;
	}

	public void setEmailSendDao(IEmailSendDao emailSendDao) {
		this.emailSendDao = emailSendDao;
	}
}
