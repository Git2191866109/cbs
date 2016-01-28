package com.bs.plugins.custom.eb.educationconfigure.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.eb.educationconfigure.entity.EducationConfigure;
import com.bs.plugins.custom.eb.educationconfigure.dao.IEducationConfigureDao;

public class BaseEducationConfigureService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IEducationConfigureDao educationConfigureDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationConfigureDao.insert(educationConfigure);
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
	public ResultData modify(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationConfigureDao.updateById(educationConfigure);
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
	public ResultData modifyById(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationConfigureDao.updateById(educationConfigure);
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
	public ResultData modifyComplete(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationConfigureDao.updateCompleteById(educationConfigure);
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
	public ResultData delete(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationConfigureDao.delete(educationConfigure);
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
	public ResultData deleteById(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			Integer result = educationConfigureDao.deleteById(educationConfigure);
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
			Integer result = educationConfigureDao.deleteAll();
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
	public ResultData single(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			EducationConfigure educationConfigureTemp = educationConfigureDao.selectOneById(educationConfigure);
			if (educationConfigureTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("educationConfigure", educationConfigureTemp);
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
	public ResultData list(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			List<EducationConfigure> educationConfigureList = educationConfigureDao.selectList(educationConfigure);
			if (educationConfigureList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("educationConfigureList", educationConfigureList);
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
	public ResultData paginated(EducationConfigure educationConfigure){
		ResultData resultData = new ResultData();
		try {
			List<EducationConfigure> educationConfigureList = educationConfigureDao.selectPaginatedList(educationConfigure);
			Long educationConfigureCount = educationConfigureDao.getCount(educationConfigure);
			if (educationConfigureList != null){
				long record = educationConfigureCount == null?0:educationConfigureCount;
				int pageCount = (int) Math.ceil(record / (double) educationConfigure.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", educationConfigure.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", educationConfigureList);
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
	
	public IEducationConfigureDao getEducationConfigureDao() {
		return educationConfigureDao;
	}

	public void setEducationConfigureDao(IEducationConfigureDao educationConfigureDao) {
		this.educationConfigureDao = educationConfigureDao;
	}
}
