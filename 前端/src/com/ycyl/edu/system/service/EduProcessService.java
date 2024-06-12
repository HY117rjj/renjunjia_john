package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduProcess;

@SuppressWarnings("all")
public interface EduProcessService {

	public Integer getTotalRows(String filter);
	
	public List<EduProcess> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduProcess getEduProcessById(Long id);
	
	public void saveOrUpdate(EduProcess log);
	
	public void delete(Long id);
}