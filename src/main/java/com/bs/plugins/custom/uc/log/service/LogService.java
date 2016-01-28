package com.bs.plugins.custom.uc.log.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.uc.log.base.BaseLogService;
import com.bs.plugins.custom.uc.log.dao.ILogDao;
import com.bs.plugins.custom.uc.log.entity.Log;
import com.bs.plugins.custom.uc.user.entity.User;

@Service
public class LogService extends BaseLogService<Log> {
	
	private static Logger logger = LoggerFactory.getLogger(LogService.class);
	
	@Autowired
	private ILogDao logDao;
	
	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData logIndex(Log log){
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
	public ResultData jumpModify(Log log){
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
	public ResultData jumpCreate(Log log){
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
	public ResultData jumpList(Log log){
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
	public ResultData jumpPaginated(Log log){
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
	 * 自定义记录操作日志
	 * @param log
	 * @return
	 */
	public ResultData save(Log log){
		ResultData resultData = new ResultData();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			if(currentUser != null){
				Object obj = currentUser.getPrincipal();
				if (obj instanceof User){
					User user = (User) obj;
					String  isLog = log.getIsLog() == null ? "0" :log.getIsLog();
					if (isLog.equals("1") || isLog.equals("true")){
						logger.debug("==>start record operation log.");
						String operation = log.getOperation();
						if (operation.indexOf("create") >= 0){
							//创建操作
							log.setType("1");
						}
						else if (operation.indexOf("save") >= 0){
							//创建操作
							log.setType("1");
						}
						else if (operation.indexOf("modify") >= 0){
							//修改操作
							log.setType("2");
						}
						else if (operation.indexOf("update") >= 0){
							//修改操作
							log.setType("2");
						}
						else if (operation.indexOf("delete") >= 0){
							//删除操作
							log.setType("3");
						}
						else{
							//除标准操作外的任何其他操作
							log.setType("4");
						}
						logger.debug("==>log content is:" + log.getLogContent());
						log.setUserId(user.getId());
						log.setUserAccount(user.getAccount());
						log.setUserName(user.getName());
						log.setContent(log.getLogContent());
						log.setAccessIP(log.getAccessIp());
						int result = super.getLogDao().insert(log);
						if (result > 0){
							logger.debug("==>record operation log success.");
						}
						else{
							logger.debug("==>record operation log fail.");
						}
					}
				}
			}
			
				
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}
	
	
	/**
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginatedByCondition(Log log){
		ResultData resultData = new ResultData();
		try {
			List<Log> logList = logDao.selectPaginatedListByCondition(log);
			Long logCount = logDao.getCountByCondition(log);
			if (logList != null){
				long record = logCount == null?0:logCount;
				int pageCount = (int) Math.ceil(record / (double) log.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", log.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", logList);
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
