package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduLectureAppointment;

@SuppressWarnings("all")
public interface EduLectureService {
	
	public Integer getTotalRows(String filter);
	
	public List<EduLecture> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduLecture getEduLectureById(Long id);
	
	public void saveOrUpdate(EduLecture lecture);
	
	public void delete(Long id);
	
	public void saveOrUpdateLectureAppointment(EduLectureAppointment lectureAppointment);
	
	public EduLectureAppointment getEduLectureAppointmentBySn(Long sn, String idcard);
	
	public Integer getTotalAppointmentRows(String filter);

	public List<EduLectureAppointment> getCurrentPageAppointmentList(final String filter, final int starRow, final int maxRow);
	
	public void saveNetworkFlow(String ip);

}