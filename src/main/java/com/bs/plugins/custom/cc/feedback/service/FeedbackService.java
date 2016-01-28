package com.bs.plugins.custom.cc.feedback.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.cc.feedback.base.BaseFeedbackService;
import com.bs.plugins.custom.cc.feedback.entity.Feedback;

@Service
public class FeedbackService extends BaseFeedbackService<Feedback> {

	/**
	 * 跳转功能首页
	 * 
	 * @param entity
	 * @return
	 */
	public ResultData feedbackqueryIndex(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			// add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/** 跳转到修改页 **/
	public ResultData jumpModify(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			feedback = super.getFeedbackDao().selectOneById(feedback);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
			resultData.setStatus(IBaseService.FAIL);
		}
		resultData.addObject("feedback", feedback);
		return resultData;	
	}
	
	/** 跳转到详情页 **/
	public ResultData jumpDetail(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			feedback = super.getFeedbackDao().selectOneById(feedback);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("feedback", feedback);
		return resultData;	
	}
	

	/** 跳转到创建页 **/
	public ResultData jumpCreate(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			// add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/** 跳转到列表 **/
	public ResultData jumpList(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			// add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/** 跳转到分页列表 **/
	public ResultData jumpPaginated(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			// add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	/**
	 * 分页
	 */
	public ResultData paginated(Feedback feedback) {
		ResultData resultData = new ResultData();
		try {
			List<Feedback> feedbackList = super.getFeedbackDao().paginated(feedback);
			Long growStagesCount = super.getFeedbackDao().getCount(feedback);
			if (feedbackList != null) {
				long record = growStagesCount == null ? 0 : growStagesCount;
				int pageCount = (int) Math.ceil(record/ (double) feedback.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", feedback.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", feedbackList);
				resultData.setResultMap(gridMap);
				resultData.setStatus(IBaseService.SUCCESS);
			} else {
				resultData.setStatus(IBaseService.FAIL);
			}
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
}
