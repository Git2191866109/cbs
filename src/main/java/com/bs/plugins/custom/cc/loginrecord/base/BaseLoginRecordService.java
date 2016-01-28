package com.bs.plugins.custom.cc.loginrecord.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.loginrecord.entity.LoginRecord;
import com.bs.plugins.custom.cc.loginrecord.dao.ILoginRecordDao;

public class BaseLoginRecordService<T extends Entity> implements IBaseService {
	
	@Autowired
	private ILoginRecordDao loginRecordDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			Integer result = loginRecordDao.insert(loginRecord);
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
	public ResultData modify(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			Integer result = loginRecordDao.updateById(loginRecord);
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
	public ResultData modifyById(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			Integer result = loginRecordDao.updateById(loginRecord);
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
	public ResultData modifyComplete(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			Integer result = loginRecordDao.updateCompleteById(loginRecord);
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
	public ResultData delete(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			Integer result = loginRecordDao.delete(loginRecord);
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
	public ResultData deleteById(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			Integer result = loginRecordDao.deleteById(loginRecord);
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
			Integer result = loginRecordDao.deleteAll();
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
	public ResultData single(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			LoginRecord loginRecordTemp = loginRecordDao.selectOneById(loginRecord);
			if (loginRecordTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("loginRecord", loginRecordTemp);
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
	public ResultData list(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			List<LoginRecord> loginRecordList = loginRecordDao.selectList(loginRecord);
			if (loginRecordList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("loginRecordList", loginRecordList);
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
	public ResultData paginated(LoginRecord loginRecord){
		ResultData resultData = new ResultData();
		try {
			List<LoginRecord> loginRecordList = loginRecordDao.selectPaginatedList(loginRecord);
			Long loginRecordCount = loginRecordDao.getCount(loginRecord);
			if (loginRecordList != null){
				long record = loginRecordCount == null?0:loginRecordCount;
				int pageCount = (int) Math.ceil(record / (double) loginRecord.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", loginRecord.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", loginRecordList);
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
	
	public ILoginRecordDao getLoginRecordDao() {
		return loginRecordDao;
	}

	public void setLoginRecordDao(ILoginRecordDao loginRecordDao) {
		this.loginRecordDao = loginRecordDao;
	}
}
