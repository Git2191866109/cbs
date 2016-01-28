package com.bs.plugins.custom.sc.dictionarycategory.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.sc.dictionarycategory.entity.DictionaryCategory;
import com.bs.plugins.custom.sc.dictionarycategory.dao.IDictionaryCategoryDao;

public class BaseDictionaryCategoryService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IDictionaryCategoryDao dictionaryCategoryDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryCategoryDao.insert(dictionaryCategory);
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
	public ResultData modify(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryCategoryDao.updateById(dictionaryCategory);
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
	public ResultData modifyById(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryCategoryDao.updateById(dictionaryCategory);
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
	public ResultData modifyComplete(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryCategoryDao.updateCompleteById(dictionaryCategory);
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
	public ResultData delete(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryCategoryDao.delete(dictionaryCategory);
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
	public ResultData deleteById(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = dictionaryCategoryDao.deleteById(dictionaryCategory);
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
			Integer result = dictionaryCategoryDao.deleteAll();
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
	public ResultData single(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			DictionaryCategory dictionaryCategoryTemp = dictionaryCategoryDao.selectOneById(dictionaryCategory);
			if (dictionaryCategoryTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("dictionaryCategory", dictionaryCategoryTemp);
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
	public ResultData list(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			List<DictionaryCategory> dictionaryCategoryList = dictionaryCategoryDao.selectList(dictionaryCategory);
			if (dictionaryCategoryList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("dictionaryCategoryList", dictionaryCategoryList);
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
	public ResultData paginated(DictionaryCategory dictionaryCategory){
		ResultData resultData = new ResultData();
		try {
			List<DictionaryCategory> dictionaryCategoryList = dictionaryCategoryDao.selectPaginatedList(dictionaryCategory);
			Long dictionaryCategoryCount = dictionaryCategoryDao.getCount(dictionaryCategory);
			if (dictionaryCategoryList != null){
				long record = dictionaryCategoryCount == null?0:dictionaryCategoryCount;
				int pageCount = (int) Math.ceil(record / (double) dictionaryCategory.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", dictionaryCategory.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", dictionaryCategoryList);
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
	
	public IDictionaryCategoryDao getDictionaryCategoryDao() {
		return dictionaryCategoryDao;
	}

	public void setDictionaryCategoryDao(IDictionaryCategoryDao dictionaryCategoryDao) {
		this.dictionaryCategoryDao = dictionaryCategoryDao;
	}
}
