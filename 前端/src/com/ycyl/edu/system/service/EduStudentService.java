package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduLectureAppointment;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduStudentDetails;

@SuppressWarnings("all")
public interface EduStudentService {

	public Integer getTotalRows(String filter);
	
	public List<EduStudent> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduStudent getEduStudentById(Long id);
	
	public void saveOrUpdate(EduStudent student);
	
	public void delete(Long id);
	
	public Integer getTotalDetailsRows(String filter);
	
	public List<EduStudentDetails> getCurrentPageDetailsList(final String filter, final int starRow, final int maxRow);
	
	public EduStudentDetails getEduStudentDetailsById(Long id);
	
	public void saveOrUpdateDetails(EduStudentDetails studentDetails);
	
	public void deleteDetails(Long id);
	
	public Boolean isDupcateUserName(EduStudent student);
	
}