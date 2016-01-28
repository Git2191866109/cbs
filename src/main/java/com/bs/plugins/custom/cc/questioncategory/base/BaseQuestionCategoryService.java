package com.bs.plugins.custom.cc.questioncategory.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.questioncategory.entity.QuestionCategory;
import com.bs.plugins.custom.cc.questioncategory.dao.IQuestionCategoryDao;

public class BaseQuestionCategoryService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IQuestionCategoryDao questionCategoryDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionCategoryDao.insert(questionCategory);
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
	public ResultData modify(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionCategoryDao.updateById(questionCategory);
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
	public ResultData modifyById(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionCategoryDao.updateById(questionCategory);
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
	public ResultData modifyComplete(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionCategoryDao.updateCompleteById(questionCategory);
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
	public ResultData delete(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionCategoryDao.delete(questionCategory);
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
	public ResultData deleteById(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionCategoryDao.deleteById(questionCategory);
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
			Integer result = questionCategoryDao.deleteAll();
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
	public ResultData single(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			QuestionCategory questionCategoryTemp = questionCategoryDao.selectOneById(questionCategory);
			if (questionCategoryTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("questionCategory", questionCategoryTemp);
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
	public ResultData list(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			List<QuestionCategory> questionCategoryList = questionCategoryDao.selectList(questionCategory);
			if (questionCategoryList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("questionCategoryList", questionCategoryList);
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
	public ResultData paginated(QuestionCategory questionCategory){
		ResultData resultData = new ResultData();
		try {
			List<QuestionCategory> questionCategoryList = questionCategoryDao.selectPaginatedList(questionCategory);
			Long questionCategoryCount = questionCategoryDao.getCount(questionCategory);
			if (questionCategoryList != null){
				long record = questionCategoryCount == null?0:questionCategoryCount;
				int pageCount = (int) Math.ceil(record / (double) questionCategory.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", questionCategory.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", questionCategoryList);
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
	
	public IQuestionCategoryDao getQuestionCategoryDao() {
		return questionCategoryDao;
	}

	public void setQuestionCategoryDao(IQuestionCategoryDao questionCategoryDao) {
		this.questionCategoryDao = questionCategoryDao;
	}
}
