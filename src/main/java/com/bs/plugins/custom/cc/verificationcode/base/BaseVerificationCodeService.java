package com.bs.plugins.custom.cc.verificationcode.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.verificationcode.entity.VerificationCode;
import com.bs.plugins.custom.cc.verificationcode.dao.IVerificationCodeDao;

public class BaseVerificationCodeService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IVerificationCodeDao verificationCodeDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			Integer result = verificationCodeDao.insert(verificationCode);
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
	public ResultData modify(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			Integer result = verificationCodeDao.updateById(verificationCode);
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
	public ResultData modifyById(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			Integer result = verificationCodeDao.updateById(verificationCode);
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
	public ResultData modifyComplete(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			Integer result = verificationCodeDao.updateCompleteById(verificationCode);
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
	public ResultData delete(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			Integer result = verificationCodeDao.delete(verificationCode);
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
	public ResultData deleteById(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			Integer result = verificationCodeDao.deleteById(verificationCode);
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
			Integer result = verificationCodeDao.deleteAll();
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
	public ResultData single(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			VerificationCode verificationCodeTemp = verificationCodeDao.selectOneById(verificationCode);
			if (verificationCodeTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("verificationCode", verificationCodeTemp);
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
	public ResultData list(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			List<VerificationCode> verificationCodeList = verificationCodeDao.selectList(verificationCode);
			if (verificationCodeList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("verificationCodeList", verificationCodeList);
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
	public ResultData paginated(VerificationCode verificationCode){
		ResultData resultData = new ResultData();
		try {
			List<VerificationCode> verificationCodeList = verificationCodeDao.selectPaginatedList(verificationCode);
			Long verificationCodeCount = verificationCodeDao.getCount(verificationCode);
			if (verificationCodeList != null){
				long record = verificationCodeCount == null?0:verificationCodeCount;
				int pageCount = (int) Math.ceil(record / (double) verificationCode.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", verificationCode.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", verificationCodeList);
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
	
	public IVerificationCodeDao getVerificationCodeDao() {
		return verificationCodeDao;
	}

	public void setVerificationCodeDao(IVerificationCodeDao verificationCodeDao) {
		this.verificationCodeDao = verificationCodeDao;
	}
}
