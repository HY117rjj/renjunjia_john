package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduTeacher;

@SuppressWarnings("all")
public interface EduTeacherService {

	public Integer getTotalRows(String filter);
	
	public List<EduTeacher> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public void delete(Long id);
	
	public EduTeacher getEduTeacherById(Long id);
	
	public void saveOrUpdate(EduTeacher teacher);
	
	public List<Object[]> getAllAvailableTeacher();
	
	public List findTeacherForFrontPage();
}