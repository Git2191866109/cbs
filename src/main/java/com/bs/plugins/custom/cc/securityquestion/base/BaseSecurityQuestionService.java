package com.bs.plugins.custom.cc.securityquestion.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.securityquestion.entity.SecurityQuestion;
import com.bs.plugins.custom.cc.securityquestion.dao.ISecurityQuestionDao;

public class BaseSecurityQuestionService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ISecurityQuestionDao securityQuestionDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			Integer result = securityQuestionDao.insert(securityQuestion);
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
	public ResultData modify(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			Integer result = securityQuestionDao.updateById(securityQuestion);
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
	public ResultData modifyById(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			Integer result = securityQuestionDao.updateById(securityQuestion);
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
	public ResultData modifyComplete(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			Integer result = securityQuestionDao.updateCompleteById(securityQuestion);
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
	public ResultData delete(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			Integer result = securityQuestionDao.delete(securityQuestion);
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
	public ResultData deleteById(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			Integer result = securityQuestionDao.deleteById(securityQuestion);
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
			Integer result = securityQuestionDao.deleteAll();
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
	public ResultData single(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			SecurityQuestion securityQuestionTemp = securityQuestionDao.selectOneById(securityQuestion);
			if (securityQuestionTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("securityQuestion", securityQuestionTemp);
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
	public ResultData list(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			List<SecurityQuestion> securityQuestionList = securityQuestionDao.selectList(securityQuestion);
			if (securityQuestionList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("securityQuestionList", securityQuestionList);
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
	public ResultData paginated(SecurityQuestion securityQuestion){
		ResultData resultData = new ResultData();
		try {
			List<SecurityQuestion> securityQuestionList = securityQuestionDao.selectPaginatedList(securityQuestion);
			Long securityQuestionCount = securityQuestionDao.getCount(securityQuestion);
			if (securityQuestionList != null){
				long record = securityQuestionCount == null?0:securityQuestionCount;
				int pageCount = (int) Math.ceil(record / (double) securityQuestion.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", securityQuestion.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", securityQuestionList);
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
	
	public ISecurityQuestionDao getSecurityQuestionDao() {
		return securityQuestionDao;
	}

	public void setSecurityQuestionDao(ISecurityQuestionDao securityQuestionDao) {
		this.securityQuestionDao = securityQuestionDao;
	}
}
