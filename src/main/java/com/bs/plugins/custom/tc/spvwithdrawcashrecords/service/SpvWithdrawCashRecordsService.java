package com.bs.plugins.custom.tc.spvwithdrawcashrecords.service;

import com.bs.core.service.IBaseService;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.tc.spvwithdrawcashrecords.entity.SpvWithdrawCashRecords;
import com.bs.plugins.custom.tc.spvwithdrawcashrecords.base.BaseSpvWithdrawCashRecordsService;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class SpvWithdrawCashRecordsService extends BaseSpvWithdrawCashRecordsService<SpvWithdrawCashRecords> {

	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			List<SpvWithdrawCashRecords> spvWithdrawCashRecordsList = this.getSpvWithdrawCashRecordsDao().selectPaginatedNewList(spvWithdrawCashRecords);
			Long spvWithdrawCashRecordsCount = this.getSpvWithdrawCashRecordsDao().getNewCount(spvWithdrawCashRecords);
			if (spvWithdrawCashRecordsList != null){
				long record = spvWithdrawCashRecordsCount == null?0:spvWithdrawCashRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) spvWithdrawCashRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvWithdrawCashRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvWithdrawCashRecordsList);
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
	public ResultData spvwithdrawIndex(SpvWithdrawCashRecords spvWithdrawCashRecords){
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
	public ResultData spvWithdrawCashRecordsIndex(SpvWithdrawCashRecords spvWithdrawCashRecords){
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
	public ResultData jumpModify(SpvWithdrawCashRecords spvWithdrawCashRecords){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("spvWithdrawCashRecords",this.getSpvWithdrawCashRecordsDao().selectOneById(spvWithdrawCashRecords));
			resultData.setViewName("tc/accounting/spvwithdraw_detail");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(SpvWithdrawCashRecords spvWithdrawCashRecords){
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
	public ResultData jumpList(SpvWithdrawCashRecords spvWithdrawCashRecords){
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
	public ResultData jumpPaginated(SpvWithdrawCashRecords spvWithdrawCashRecords){
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
