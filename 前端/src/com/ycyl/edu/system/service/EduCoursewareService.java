package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.std.entity.StdDrug;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduCoursewareMessage;

@SuppressWarnings("all")
public interface EduCoursewareService {

	public Integer getTotalRows(String filter);
	
	public List<EduCourseware> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public Integer getMessageTotalRows(String filter);
	
	public List<EduCoursewareMessage> getMessageCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public List<EduCourseware> getMoreVideoList(final String filter);
	
	public EduCourseware getEduCoursewareById(Long id);
	
	public void saveOrUpdate(EduCourseware cw);
	
	public void delete(Long id);
	
	public EduCoursewareMessage getEduCoursewareMessageById(Long id);
	
	public void saveOrUpdateMessage(EduCoursewareMessage cw);
	
	public void deleteMessage(Long id);
	
	public List<com.ycyl.edu.util.Dictionary> getEduCWForPro();
	
	public List<StdDrug> getStdDrugList();
	
}