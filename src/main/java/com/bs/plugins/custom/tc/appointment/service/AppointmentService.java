package com.bs.plugins.custom.tc.appointment.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.core.entity.ResultData;
import com.bs.core.service.IBaseService;
import com.bs.plugins.custom.tc.appointment.entity.Appointment;
import com.bs.plugins.custom.tc.appointment.base.BaseAppointmentService;
import com.bs.plugins.custom.tc.appointment.dao.IAppointmentDao;

@Service
public class AppointmentService extends BaseAppointmentService<Appointment> {


	@Autowired
	private IAppointmentDao appointmentDao;


	/**
	 * 跳转功能首页
	 * @param entity
	 * @return
	 */
	public ResultData appointmentIndex(Appointment appointment){
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
	public ResultData jumpModify(Appointment appointment){
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
	public ResultData jumpCreate(Appointment appointment){
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
	public ResultData jumpList(Appointment appointment){
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
	public ResultData jumpPaginated(Appointment appointment){
		ResultData resultData = new ResultData();
		try {
			//add your code
		} catch (Exception e) {
			resultData.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return resultData;
	}


	public ResultData selectAppointments(Appointment appointment){
		ResultData rd = new ResultData();
		try {
			List<Appointment> selectAppointments = appointmentDao.selectAppointments(appointment);
			Integer selectAppointmentsCount = appointmentDao.selectAppointmentsCount(appointment);
			long record = selectAppointmentsCount == null?0:selectAppointmentsCount;
			int pageCount = (int) Math.ceil(record / (double) appointment.getRows());
			Map<String, Object> gridMap = new Hashtable<String, Object>();
			gridMap.put("page", appointment.getPage());
			gridMap.put("total", pageCount);
			gridMap.put("records", record);
			gridMap.put("rows", selectAppointments);
			rd.setResultMap(gridMap);
			rd.setStatus(IBaseService.SUCCESS);
		} catch (Exception e) {
			rd.setStatusException(e.getMessage());
			e.printStackTrace();
		}
		return rd;

	}
}
