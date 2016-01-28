package com.bs.plugins.custom.pc.validationrule.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.validationrule.entity.ValidationRule;
import com.bs.plugins.custom.pc.validationrule.dao.IValidationRuleDao;

public class BaseValidationRuleService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IValidationRuleDao validationRuleDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			Integer result = validationRuleDao.insert(validationRule);
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
	public ResultData modify(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			Integer result = validationRuleDao.updateById(validationRule);
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
	public ResultData modifyById(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			Integer result = validationRuleDao.updateById(validationRule);
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
	public ResultData modifyComplete(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			Integer result = validationRuleDao.updateCompleteById(validationRule);
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
	public ResultData delete(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			Integer result = validationRuleDao.delete(validationRule);
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
	public ResultData deleteById(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			Integer result = validationRuleDao.deleteById(validationRule);
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
			Integer result = validationRuleDao.deleteAll();
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
	public ResultData single(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			ValidationRule validationRuleTemp = validationRuleDao.selectOneById(validationRule);
			if (validationRuleTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("validationRule", validationRuleTemp);
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
	public ResultData list(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			List<ValidationRule> validationRuleList = validationRuleDao.selectList(validationRule);
			if (validationRuleList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("validationRuleList", validationRuleList);
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
	public ResultData paginated(ValidationRule validationRule){
		ResultData resultData = new ResultData();
		try {
			List<ValidationRule> validationRuleList = validationRuleDao.selectPaginatedList(validationRule);
			Long validationRuleCount = validationRuleDao.getCount(validationRule);
			if (validationRuleList != null){
				long record = validationRuleCount == null?0:validationRuleCount;
				int pageCount = (int) Math.ceil(record / (double) validationRule.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", validationRule.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", validationRuleList);
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
	
	public IValidationRuleDao getValidationRuleDao() {
		return validationRuleDao;
	}

	public void setValidationRuleDao(IValidationRuleDao validationRuleDao) {
		this.validationRuleDao = validationRuleDao;
	}
}
