package com.bs.plugins.custom.tc.rechargerecords.service;

import com.bs.core.service.IBaseService;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.tc.rechargerecords.entity.RechargeRecords;
import com.bs.plugins.custom.tc.rechargerecords.base.BaseRechargeRecordsService;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class RechargeRecordsService extends BaseRechargeRecordsService<RechargeRecords> {

	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			List<RechargeRecords> rechargeRecordsList = this.getRechargeRecordsDao().selectPaginatedNewList(rechargeRecords);
			Long rechargeRecordsCount =  this.getRechargeRecordsDao().getNewCount(rechargeRecords);
			if (rechargeRecordsList != null){
				long record = rechargeRecordsCount == null?0:rechargeRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) rechargeRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", rechargeRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", rechargeRecordsList);
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
	public ResultData rechargeIndex(RechargeRecords rechargeRecords){
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
	public ResultData rechargeRecordsIndex(RechargeRecords rechargeRecords){
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
	public ResultData jumpModify(RechargeRecords rechargeRecords){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("rechargeRecords",this.getRechargeRecordsDao().selectOneById(rechargeRecords));
			resultData.setViewName("tc/accounting/recharge_detail");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(RechargeRecords rechargeRecords){
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
	public ResultData jumpList(RechargeRecords rechargeRecords){
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
	public ResultData jumpPaginated(RechargeRecords rechargeRecords){
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
