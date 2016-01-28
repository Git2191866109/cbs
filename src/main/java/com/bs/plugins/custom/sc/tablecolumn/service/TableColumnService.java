package com.bs.plugins.custom.sc.tablecolumn.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.sc.tablecolumn.entity.TableColumn;
import com.bs.plugins.custom.sc.tablecolumn.base.BaseTableColumnService;

@Service
public class TableColumnService extends BaseTableColumnService<TableColumn> {
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData tableColumnIndex(TableColumn tableColumn){
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
	public ResultData jumpModify(TableColumn tableColumn){
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
	public ResultData jumpCreate(TableColumn tableColumn){
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
	public ResultData jumpList(TableColumn tableColumn){
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
	public ResultData jumpPaginated(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;	
	}
	
	public ResultData paginated(TableColumn tableColumn){
		ResultData resultData = new ResultData();
		try {
			List<TableColumn> tableColumnList = super.getTableColumnDao().selectItemFieldList(tableColumn);
			Long tableColumnCount = super.getTableColumnDao().getCount(tableColumn);
			if (tableColumnList != null){
				long record = tableColumnCount == null?0:tableColumnCount;
				int pageCount = (int) Math.ceil(record / (double) tableColumn.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", tableColumn.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", tableColumnList);
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
	
}
