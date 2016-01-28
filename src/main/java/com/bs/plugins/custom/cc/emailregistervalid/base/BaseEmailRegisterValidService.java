package com.bs.plugins.custom.cc.emailregistervalid.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.emailregistervalid.entity.EmailRegisterValid;
import com.bs.plugins.custom.cc.emailregistervalid.dao.IEmailRegisterValidDao;

public class BaseEmailRegisterValidService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEmailRegisterValidDao emailRegisterValidDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailRegisterValidDao.insert(emailRegisterValid);
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
	public ResultData modify(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailRegisterValidDao.updateById(emailRegisterValid);
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
	public ResultData modifyById(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailRegisterValidDao.updateById(emailRegisterValid);
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
	public ResultData delete(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailRegisterValidDao.delete(emailRegisterValid);
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
	public ResultData deleteById(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			Integer result = emailRegisterValidDao.deleteById(emailRegisterValid);
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
			Integer result = emailRegisterValidDao.deleteAll();
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
	public ResultData single(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			EmailRegisterValid emailRegisterValidTemp = emailRegisterValidDao.selectOneById(emailRegisterValid);
			if (emailRegisterValidTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailRegisterValid", emailRegisterValidTemp);
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
	public ResultData list(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			List<EmailRegisterValid> emailRegisterValidList = emailRegisterValidDao.selectList(emailRegisterValid);
			if (emailRegisterValidList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("emailRegisterValidList", emailRegisterValidList);
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
	public ResultData paginated(EmailRegisterValid emailRegisterValid){
		ResultData resultData = new ResultData();
		try {
			List<EmailRegisterValid> emailRegisterValidList = emailRegisterValidDao.selectPaginatedList(emailRegisterValid);
			Long emailRegisterValidCount = emailRegisterValidDao.getCount(emailRegisterValid);
			if (emailRegisterValidList != null){
				long record = emailRegisterValidCount == null?0:emailRegisterValidCount;
				int pageCount = (int) Math.ceil(record / (double) emailRegisterValid.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", emailRegisterValid.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", emailRegisterValidList);
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
	
	public IEmailRegisterValidDao getEmailRegisterValidDao() {
		return emailRegisterValidDao;
	}

	public void setEmailRegisterValidDao(IEmailRegisterValidDao emailRegisterValidDao) {
		this.emailRegisterValidDao = emailRegisterValidDao;
	}
}
