package com.bs.plugins.custom.eb.educationmode.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.educationmode.entity.EducationMode;
import com.bs.plugins.custom.eb.educationmode.dao.IEducationModeDao;

public class BaseEducationModeService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEducationModeDao educationModeDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationModeDao.insert(educationMode);
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
	public ResultData modify(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationModeDao.updateById(educationMode);
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
	public ResultData modifyById(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationModeDao.updateById(educationMode);
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
	public ResultData modifyComplete(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationModeDao.updateCompleteById(educationMode);
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
	public ResultData delete(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationModeDao.delete(educationMode);
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
	public ResultData deleteById(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationModeDao.deleteById(educationMode);
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
			Integer result = educationModeDao.deleteAll();
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
	public ResultData single(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			EducationMode educationModeTemp = educationModeDao.selectOneById(educationMode);
			if (educationModeTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("educationMode", educationModeTemp);
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
	public ResultData list(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			List<EducationMode> educationModeList = educationModeDao.selectList(educationMode);
			if (educationModeList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("educationModeList", educationModeList);
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
	public ResultData paginated(EducationMode educationMode){
		ResultData resultData = new ResultData();
		try {
			List<EducationMode> educationModeList = educationModeDao.selectPaginatedList(educationMode);
			Long educationModeCount = educationModeDao.getCount(educationMode);
			if (educationModeList != null){
				long record = educationModeCount == null?0:educationModeCount;
				int pageCount = (int) Math.ceil(record / (double) educationMode.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", educationMode.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", educationModeList);
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
	
	public IEducationModeDao getEducationModeDao() {
		return educationModeDao;
	}

	public void setEducationModeDao(IEducationModeDao educationModeDao) {
		this.educationModeDao = educationModeDao;
	}
}
