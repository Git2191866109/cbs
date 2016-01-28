package com.bs.plugins.custom.tc.spvrechargerecords.service;

import com.bs.core.service.IBaseService;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.plugins.custom.tc.spvrechargerecords.entity.SpvRechargeRecords;
import com.bs.plugins.custom.tc.spvrechargerecords.base.BaseSpvRechargeRecordsService;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class SpvRechargeRecordsService extends BaseSpvRechargeRecordsService<SpvRechargeRecords> {

	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			List<SpvRechargeRecords> spvRechargeRecordsList = this.getSpvRechargeRecordsDao().selectPaginatedNewList(spvRechargeRecords);
			Long spvRechargeRecordsCount = this.getSpvRechargeRecordsDao().getNewCount(spvRechargeRecords);
			if (spvRechargeRecordsList != null){
				long record = spvRechargeRecordsCount == null?0:spvRechargeRecordsCount;
				int pageCount = (int) Math.ceil(record / (double) spvRechargeRecords.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", spvRechargeRecords.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", spvRechargeRecordsList);
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
	 * @returnr
	 */
	public ResultData spvrechargeIndex(SpvRechargeRecords spvRechargeRecords){
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
	public ResultData spvRechargeRecordsIndex(SpvRechargeRecords spvRechargeRecords){
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
	public ResultData jumpModify(SpvRechargeRecords spvRechargeRecords){
		ResultData resultData = new ResultData();
		try {
			resultData.addObject("spvRechargeRecords",this.getSpvRechargeRecordsDao().selectOneById(spvRechargeRecords));
			resultData.setViewName("tc/accounting/spvrecharge_detail");
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	/**跳转到创建页**/
	public ResultData jumpCreate(SpvRechargeRecords spvRechargeRecords){
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
	public ResultData jumpList(SpvRechargeRecords spvRechargeRecords){
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
	public ResultData jumpPaginated(SpvRechargeRecords spvRechargeRecords){
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
