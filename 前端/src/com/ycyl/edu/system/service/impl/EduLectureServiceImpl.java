package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduLectureAppointmentDAO;
import com.ycyl.edu.system.dao.EduLectureAutonomyDAO;
import com.ycyl.edu.system.dao.EduLectureDAO;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduLectureAppointment;
import com.ycyl.edu.system.service.EduLectureService;
import com.ycyl.edu.util.ListUtil;

@SuppressWarnings("all")
@Data
public class EduLectureServiceImpl implements EduLectureService{

	private EduLectureDAO eduLectureDao;
	
	private EduLectureAppointmentDAO eduLectureAppointmentDao;
	
	private EduLectureAutonomyDAO eduLectureAutonomyDao;
	
	public Integer getTotalRows(String filter){
		return eduLectureDao.getResultNum(filter);
	}
	
	@Override
	public List<EduLecture> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduLecture> list;
		try{
			list = eduLectureDao.findByPage(filter + " order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduLecture getEduLectureById(Long id){
		return eduLectureDao.findById(id);
	}
	
	public void saveOrUpdate(EduLecture lecture){
		eduLectureDao.saveOrUpdate(lecture);
	}
	
	public void delete(Long id){
		eduLectureDao.delete(eduLectureDao.findById(id));
	}
	
	public void saveOrUpdateLectureAppointment(EduLectureAppointment lectureAppointment){
		eduLectureDao.saveOrUpdate(lectureAppointment);
	}
	
	public EduLectureAppointment getEduLectureAppointmentBySn(Long sn, String idcard){
		List<EduLectureAppointment> list = eduLectureAppointmentDao.findByHql("from EduLectureAppointment where serialNumber = " + sn + " and appointmentIdcard = '" + idcard + "'");
		if(!ListUtil.isNullOrSizeZero(list)){
			return list.get(0);
		}
		return null;
	}
	
	public Integer getTotalAppointmentRows(String filter){
		return eduLectureAppointmentDao.getResultNum(filter);
	}

	@Override
	public List<EduLectureAppointment> getCurrentPageAppointmentList(final String filter, final int starRow, final int maxRow) {
		List<EduLectureAppointment> list;
		try{
			list = eduLectureAppointmentDao.findByPage(filter+" order by appointmentTime_ desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public void saveNetworkFlow(String ip){
		eduLectureAppointmentDao.executeSql("insert into EDU_NETWORK_FLOW(id, ip, time) values (HIBERNATE_SEQUENCE.nextval, '" + ip + "', sysdate)");
	}
}