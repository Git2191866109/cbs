package com.bs.plugins.custom.tc.withdrawcashrecords.service;

import com.bs.core.service.IBaseService;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.tc.withdrawcashrecords.entity.WithdrawCashRecords;
import com.bs.plugins.custom.tc.withdrawcashrecords.base.BaseWithdrawCashRecordsService;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class WithdrawCashRecordsService extends BaseWithdrawCashRecordsService<WithdrawCashRecords> {

	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			List<WithdrawCashRecords> withdrawCashRecordsList = this.getWithdrawCashRecordsDao().selectPaginatedNewList(withdrawCashRecords);
			Long withdrawCashRecordsCount =  this.getWithdrawCashRecordsDao().getNewCount(withdrawCashRecords);
			if (withdrawCashRecordsList != null){
				long record = withdrawCashRecordsCount == null?0:withdrawCashRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) withdrawCashRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", withdrawCashRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", withdrawCashRecordsList);
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

	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData withdrawIndex(WithdrawCashRecords withdrawCashRecords){
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
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData withdrawCashRecordsIndex(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	/**跳转到修改页**/
	public ResultData jumpModify(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("withdrawCashRecords",this.getWithdrawCashRecordsDao().selectOneById(withdrawCashRecords));
			resultData.setViewName("tc/accounting/withdraw_detail");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(WithdrawCashRecords withdrawCashRecords){
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
	public ResultData jumpList(WithdrawCashRecords withdrawCashRecords){
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
	public ResultData jumpPaginated(WithdrawCashRecords withdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
}
