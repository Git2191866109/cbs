package com.bs.plugins.custom.cc.feedback.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.cc.feedback.entity.Feedback;
import com.bs.plugins.custom.cc.feedback.dao.IFeedbackDao;

public class BaseFeedbackService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IFeedbackDao feedbackDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Integer result = feedbackDao.insert(feedback);
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
	public ResultData modify(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Integer result = feedbackDao.updateById(feedback);
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
	public ResultData modifyById(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Integer result = feedbackDao.updateById(feedback);
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
	public ResultData modifyComplete(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Integer result = feedbackDao.updateCompleteById(feedback);
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
	public ResultData delete(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Integer result = feedbackDao.delete(feedback);
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
	public ResultData deleteById(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Integer result = feedbackDao.deleteById(feedback);
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
			Integer result = feedbackDao.deleteAll();
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
	public ResultData single(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			Feedback feedbackTemp = feedbackDao.selectOneById(feedback);
			if (feedbackTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("feedback", feedbackTemp);
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
	public ResultData list(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			List<Feedback> feedbackList = feedbackDao.selectList(feedback);
			if (feedbackList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("feedbackList", feedbackList);
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
	public ResultData paginated(Feedback feedback){
		ResultData resultData = new ResultData();
		try {
			List<Feedback> feedbackList = feedbackDao.selectPaginatedList(feedback);
			Long feedbackCount = feedbackDao.getCount(feedback);
			if (feedbackList != null){
				long record = feedbackCount == null?0:feedbackCount;
				int pageCount = (int) Math.ceil(record / (double) feedback.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", feedback.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", feedbackList);
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
	
	public IFeedbackDao getFeedbackDao() {
		return feedbackDao;
	}

	public void setFeedbackDao(IFeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}
}
