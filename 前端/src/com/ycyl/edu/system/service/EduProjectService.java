package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduProject;

@SuppressWarnings("all")
public interface EduProjectService {

	public Integer getTotalRows(String filter);
	
	public List<EduProject> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduProject getEduProjectById(Long id);
	
	public void saveOrUpdate(EduProject project);
	
	public void delete(Long id);
}