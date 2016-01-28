package com.bs.plugins.custom.pc.contracttemplate.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.pc.contracttemplate.entity.ContractTemplate;
import com.bs.plugins.custom.pc.contracttemplate.dao.IContractTemplateDao;

public class BaseContractTemplateService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IContractTemplateDao contractTemplateDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			Integer result = contractTemplateDao.insert(contractTemplate);
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
	public ResultData modify(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			Integer result = contractTemplateDao.updateById(contractTemplate);
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
	public ResultData modifyById(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			Integer result = contractTemplateDao.updateById(contractTemplate);
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
	public ResultData modifyComplete(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			Integer result = contractTemplateDao.updateCompleteById(contractTemplate);
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
	public ResultData delete(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			Integer result = contractTemplateDao.delete(contractTemplate);
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
	public ResultData deleteById(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			Integer result = contractTemplateDao.deleteById(contractTemplate);
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
			Integer result = contractTemplateDao.deleteAll();
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
	public ResultData single(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			ContractTemplate contractTemplateTemp = contractTemplateDao.selectOneById(contractTemplate);
			if (contractTemplateTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("contractTemplate", contractTemplateTemp);
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
	public ResultData list(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			List<ContractTemplate> contractTemplateList = contractTemplateDao.selectList(contractTemplate);
			if (contractTemplateList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("contractTemplateList", contractTemplateList);
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
	public ResultData paginated(ContractTemplate contractTemplate){
		ResultData resultData = new ResultData();
		try {
			List<ContractTemplate> contractTemplateList = contractTemplateDao.selectPaginatedList(contractTemplate);
			Long contractTemplateCount = contractTemplateDao.getCount(contractTemplate);
			if (contractTemplateList != null){
				long record = contractTemplateCount == null?0:contractTemplateCount;
				int pageCount = (int) Math.ceil(record / (double) contractTemplate.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", contractTemplate.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", contractTemplateList);
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
	
	public IContractTemplateDao getContractTemplateDao() {
		return contractTemplateDao;
	}

	public void setContractTemplateDao(IContractTemplateDao contractTemplateDao) {
		this.contractTemplateDao = contractTemplateDao;
	}
}
