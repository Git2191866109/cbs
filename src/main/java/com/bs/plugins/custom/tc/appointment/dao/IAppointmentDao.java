package com.bs.plugins.custom.tc.appointment.dao;

import java.util.List;

import com.bs.plugins.custom.tc.appointment.base.BaseAppointmentDao;
import com.bs.plugins.custom.tc.appointment.entity.Appointment;

public interface IAppointmentDao extends BaseAppointmentDao<Appointment>{

	public List<Appointment> selectAppointments(Appointment appointment);

	public Integer selectAppointmentsCount(Appointment appointment);

}
