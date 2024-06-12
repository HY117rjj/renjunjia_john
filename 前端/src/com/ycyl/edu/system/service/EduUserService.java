package com.ycyl.edu.system.service;

import java.util.List;

import com.ycyl.edu.system.entity.EduUser;
import com.ycyl.edu.system.entity.EduUserDetails;

@SuppressWarnings("all")
public interface EduUserService {

	public Integer getTotalRows(String filter);
	
	public List<EduUser> getCurrentPageList(final String filter, final int starRow, final int maxRow);
	
	public EduUser getEduUserById(Long id);
	
	public void saveOrUpdate(EduUser eduUser);
	
	public void delete(Long id);
	
	public Integer getTotalDetailsRows(String filter);
	
	public List<EduUserDetails> getCurrentPageDetailsList(final String filter, final int starRow, final int maxRow);
	
	public EduUserDetails getEduUserDetailsById(Long id);
	
	public void saveOrUpdateDetails(EduUserDetails eduUserDetails);
	
	public void deleteDetails(Long id);
	
	public EduUserDetails getUserDetails(Long cursewareId);
}