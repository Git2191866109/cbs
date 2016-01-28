package com.bs.plugins.custom.sm.businesssend.dao;

import java.util.List;

import com.bs.plugins.custom.sm.businesssend.base.BaseBusinessSendDao;
import com.bs.plugins.custom.sm.businesssend.entity.BusinessSend;

public interface IBusinessSendDao extends BaseBusinessSendDao<BusinessSend>{

	public List<BusinessSend> selectNotSends(BusinessSend bs);
	
	public Integer updateBySid(BusinessSend bs); 
	
	public List<BusinessSend> selectSents(BusinessSend bs); 
	
	public List<BusinessSend> selectSupplementSends(BusinessSend bs);
	
	public List<BusinessSend> selectAllSms(BusinessSend bs);
	
	public Long getAllSmsCount(BusinessSend bs); // 分页总条数
	
	public Long selectWaitSubmitCount(BusinessSend bs);
	
	public Long selectSubmitSuccessCount(BusinessSend bs);

	public Long selectSuccessSendCount(BusinessSend bs);
	
	public Long  selectSuccessSubmitNotSendCount(BusinessSend bs);
	
}
