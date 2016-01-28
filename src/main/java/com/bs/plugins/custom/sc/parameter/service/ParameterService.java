package com.bs.plugins.custom.sc.parameter.service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.sc.parameter.base.BaseParameterService;
import com.bs.plugins.custom.sc.parameter.dao.IParameterDao;
import com.bs.plugins.custom.sc.parameter.entity.Parameter;
import com.bs.plugins.custom.sc.parametercategory.dao.IParameterCategoryDao;
import com.bs.plugins.custom.sc.parametercategory.entity.ParameterCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class ParameterService extends BaseParameterService<Parameter> {
	@Autowired
	private IParameterCategoryDao iParameterCategoryDao;
	@Autowired
	private IParameterDao parameterDao;
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData globalparameterIndex(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			List<ParameterCategory> parameterCategoryList = iParameterCategoryDao.selectList(null);
			resultData.addObject("parameterCategoryList", parameterCategoryList);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}

	/**跳转到修改页**/
	public ResultData jumpModify(Parameter parameter){
		ResultData resultData = new ResultData();
		try {
			parameter = super.getParameterDao().selectOneById(parameter);
			resultData.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		resultData.addObject("parameter",parameter);
		return resultData;
	}

	/**跳转到创建页**/
	public ResultData jumpCreate(Parameter parameter){
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
	public ResultData jumpList(Parameter parameter){
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
	public ResultData jumpPaginated(Parameter parameter){
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
	 * 自定义分页
	 */
	public ResultData paginated(Parameter Parameter){
		ResultData resultData = new ResultData();
		try {
			List<Parameter> ParameterList = super.getParameterDao().selectPaginatedByParameterCategoryIdList(Parameter);
			Long ParameterCount = super.getParameterDao().getCount(Parameter);
			if (ParameterList != null){
				long record = ParameterCount == null?0:ParameterCount;
				int pageCount = (int) Math.ceil(record / (double) Parameter.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", Parameter.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", ParameterList);
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


	public Parameter selectByCode(String code){
		return parameterDao.selectByCode(code);
	}

}
