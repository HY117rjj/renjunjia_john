package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduLectureAppointment;

@SuppressWarnings("all")
public interface EduLectureAppointmentDAO extends IBaseDao{

	public abstract void save(EduLectureAppointment transientInstance);

	public abstract void delete(EduLectureAppointment persistentInstance);

	public abstract EduLectureAppointment findById(Long id);

	public abstract List findByExample(EduLectureAppointment instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduLectureAppointment merge(
			EduLectureAppointment detachedInstance);

	public abstract void attachDirty(EduLectureAppointment instance);

	public abstract void attachClean(EduLectureAppointment instance);

}