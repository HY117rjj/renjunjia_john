package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduNotice;
import com.ycyl.edu.system.entity.EduProject;

@SuppressWarnings("all")
public interface EduNoticeService {

	public Integer getTotalRows(String filter);
	
	public List<EduNotice> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduNotice getEduNoticeById(Long id);
	
	public void saveOrUpdate(EduNotice notice);
	
	public void delete(Long id);
}