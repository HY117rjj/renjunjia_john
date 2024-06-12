package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.std.entity.StdDrug;
import com.ycyl.edu.system.entity.EduCase;
import com.ycyl.edu.system.entity.EduCaseMessage;

@SuppressWarnings("all")
public interface EduCaseService {

	public Integer getTotalRows(String filter);
	
	public List<EduCase> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public Integer getMessageTotalRows(String filter);
	
	public List<EduCaseMessage> getMessageCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public List<EduCase> getMoreVideoList(final String filter);
	
	public EduCase getEduCaseById(Long id);
	
	public void saveOrUpdate(EduCase cw);
	
	public void delete(Long id);
	
	public EduCaseMessage getEduCaseMessageById(Long id);
	
	public void saveOrUpdateMessage(EduCaseMessage cw);
	
	public void deleteMessage(Long id);
	
	public List<com.ycyl.edu.util.Dictionary> getEduCWForPro();
	
	public List<StdDrug> getStdDrugList();
	
}