package com.bs.plugins.custom.cc.feedback.dao;

import java.util.List;

import com.bs.plugins.custom.cc.feedback.base.BaseFeedbackDao;
import com.bs.plugins.custom.cc.feedback.entity.Feedback;

public interface IFeedbackDao extends BaseFeedbackDao<Feedback>{

	List<Feedback> paginated(Feedback feedback);

}
