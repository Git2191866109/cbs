package com.bs.plugins.custom.cc.questionanswer.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.questionanswer.entity.QuestionAnswer;
import com.bs.plugins.custom.cc.questionanswer.dao.IQuestionAnswerDao;

public class BaseQuestionAnswerService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IQuestionAnswerDao questionAnswerDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionAnswerDao.insert(questionAnswer);
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
	public ResultData modify(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionAnswerDao.updateById(questionAnswer);
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
	public ResultData modifyById(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionAnswerDao.updateById(questionAnswer);
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
	public ResultData modifyComplete(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionAnswerDao.updateCompleteById(questionAnswer);
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
	public ResultData delete(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionAnswerDao.delete(questionAnswer);
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
	public ResultData deleteById(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			Integer result = questionAnswerDao.deleteById(questionAnswer);
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
			Integer result = questionAnswerDao.deleteAll();
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
	public ResultData single(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			QuestionAnswer questionAnswerTemp = questionAnswerDao.selectOneById(questionAnswer);
			if (questionAnswerTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("questionAnswer", questionAnswerTemp);
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
	public ResultData list(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			List<QuestionAnswer> questionAnswerList = questionAnswerDao.selectList(questionAnswer);
			if (questionAnswerList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("questionAnswerList", questionAnswerList);
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
	public ResultData paginated(QuestionAnswer questionAnswer){
		ResultData resultData = new ResultData();
		try {
			List<QuestionAnswer> questionAnswerList = questionAnswerDao.selectPaginatedList(questionAnswer);
			Long questionAnswerCount = questionAnswerDao.getCount(questionAnswer);
			if (questionAnswerList != null){
				long record = questionAnswerCount == null?0:questionAnswerCount;
				int pageCount = (int) Math.ceil(record / (double) questionAnswer.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", questionAnswer.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", questionAnswerList);
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
	
	public IQuestionAnswerDao getQuestionAnswerDao() {
		return questionAnswerDao;
	}

	public void setQuestionAnswerDao(IQuestionAnswerDao questionAnswerDao) {
		this.questionAnswerDao = questionAnswerDao;
	}
}
