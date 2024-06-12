package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduLog;
import com.ycyl.edu.system.entity.EduProject;

@SuppressWarnings("all")
public interface EduLogService {

	public Integer getTotalRows(String filter);
	
	public List<EduLog> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduLog getEduLogById(Long id);
	
	public void saveOrUpdate(EduLog log);
	
	public void delete(Long id);
}