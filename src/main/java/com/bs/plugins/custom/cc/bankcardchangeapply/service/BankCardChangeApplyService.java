package com.bs.plugins.custom.cc.bankcardchangeapply.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.cc.bankcardchangeapply.entity.BankCardChangeApply;
import com.bs.plugins.custom.cc.bankcardchangeapply.base.BaseBankCardChangeApplyService;
import com.bs.plugins.custom.cc.member.entity.Member;

@Service
public class BankCardChangeApplyService extends BaseBankCardChangeApplyService<BankCardChangeApply> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData bankCardChangeApplyIndex(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到列表**/
	public ResultData jumpList(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}	
	
	/**跳转到分页列表**/
	public ResultData jumpPaginated(BankCardChangeApply bankCardChangeApply){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	/**
	 * 分页
	 */
	public ResultData paginated(BankCardChangeApply bankCardChangeApply) {
		ResultData resultData = new ResultData();
		try {
			List<BankCardChangeApply> feedbackList = super.getBankCardChangeApplyDao().selectAllPaginatedList(bankCardChangeApply);
			Long growStagesCount = super.getBankCardChangeApplyDao().getCount(bankCardChangeApply);
			if (feedbackList != null) {
				long record = growStagesCount == null ? 0 : growStagesCount;
				int pageCount = (int) Math.ceil(record/ (double) bankCardChangeApply.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", bankCardChangeApply.getPage());
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
