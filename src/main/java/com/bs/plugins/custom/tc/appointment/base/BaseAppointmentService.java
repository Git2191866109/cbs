package com.bs.plugins.custom.tc.appointment.base;

import java.util.List;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bs.core.entity.Entity;
import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.core.initialize.InitializeData;
import com.bs.plugins.custom.tc.appointment.entity.Appointment;
import com.bs.plugins.custom.tc.appointment.dao.IAppointmentDao;

public class BaseAppointmentService<T extends Entity> implements IBaseService {
	
	@Autowired
	private IAppointmentDao appointmentDao;
	
	@Autowired
	private InitializeData initializeData;
	
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public ResultData create(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.insert(appointment);
			if (result > 0){
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
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modify(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.updateById(appointment);
			if (result > 0){
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
	 * 修改
	 * @param entity
	 * @return
	 */
	public ResultData modifyById(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.updateById(appointment);
			if (result > 0){
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
	 * 修改(完全修改)
	 * @param entity
	 * @return
	 */
	public ResultData modifyComplete(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.updateCompleteById(appointment);
			if (result > 0){
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
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData delete(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.delete(appointment);
			if (result > 0){
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
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteById(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.deleteById(appointment);
			if (result > 0){
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
	 * 删除
	 * @param entity
	 * @return
	 */
	public ResultData deleteAll(){
		ResultData resultData = new ResultData();
		try {
			Integer result = appointmentDao.deleteAll();
			if (result > 0){
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
	 * 查询单条数据
	 * @param entity
	 * @return
	*/
	public ResultData single(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			Appointment appointmentTemp = appointmentDao.selectOneById(appointment);
			if (appointmentTemp != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("appointment", appointmentTemp);
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
	 * 查询列表
	 * @param entity
	 * @return
	 */
	public ResultData list(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			List<Appointment> appointmentList = appointmentDao.selectList(appointment);
			if (appointmentList != null){
				resultData.setStatus(IBaseService.SUCCESS);
				resultData.addObject("appointmentList", appointmentList);
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
	 * 查询分页列表
	 * @param entity
	 * @return
	 */
	public ResultData paginated(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			List<Appointment> appointmentList = appointmentDao.selectPaginatedList(appointment);
			Long appointmentCount = appointmentDao.getCount(appointment);
			if (appointmentList != null){
				long record = appointmentCount == null?0:appointmentCount;
				int pageCount = (int) Math.ceil(record / (double) appointment.getRows());
				Map<String, Object> gridMap = new Hashtable<String, Object>();
				gridMap.put("page", appointment.getPage());
				gridMap.put("total", pageCount);
				gridMap.put("records", record);
				gridMap.put("rows", appointmentList);
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
	
	
	@Override
	public void afterPropertiesSet() throws Exception {

	}
	
	public InitializeData getInitializeData() {
		return initializeData;
	}

	public void setInitializeData(InitializeData initializeData) {
		this.initializeData = initializeData;
	}
	
	public IAppointmentDao getAppointmentDao() {
		return appointmentDao;
	}

	public void setAppointmentDao(IAppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}
}
