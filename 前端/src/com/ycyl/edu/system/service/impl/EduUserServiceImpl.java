package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduUserDAO;
import com.ycyl.edu.system.dao.EduUserDetailsDAO;
import com.ycyl.edu.system.entity.EduUser;
import com.ycyl.edu.system.entity.EduUserDetails;
import com.ycyl.edu.system.service.EduUserService;

@SuppressWarnings("all")
@Data
public class EduUserServiceImpl implements EduUserService{

	private EduUserDAO eduUserDao;
	
	private EduUserDetailsDAO eduUserDetailsDao;
	
	public Integer getTotalRows(String filter){
		return eduUserDao.getResultNum(filter);
	}

	@Override
	public List<EduUser> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduUser> list;
		try{
			list = eduUserDao.findByPage(filter, starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduUser getEduUserById(Long id){
		return eduUserDao.findById(id);
	}
	
	public void saveOrUpdate(EduUser eduUser){
		eduUserDao.saveOrUpdate(eduUser);
	}
	
	public void delete(Long id){
		eduUserDao.delete(eduUserDao.findById(id));
	}
	
	public Integer getTotalDetailsRows(String filter){
		return eduUserDao.getResultNum(filter);
	}

	@Override
	public List<EduUserDetails> getCurrentPageDetailsList(final String filter, final int starRow, final int maxRow) {
		List<EduUserDetails> list;
		try{
			list = eduUserDetailsDao.findByPage(filter, starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduUserDetails getEduUserDetailsById(Long id){
		return eduUserDetailsDao.findById(id);
	}
	
	public void saveOrUpdateDetails(EduUserDetails eduUserDetails){
		eduUserDetailsDao.saveOrUpdate(eduUserDetails);
	}
	
	public void deleteDetails(Long id){
		eduUserDetailsDao.delete(eduUserDetailsDao.findById(id));
	}
	
	@Override
	public EduUserDetails getUserDetails(Long cursewareId) {
		List<EduUserDetails> list;
		try{
			list = eduUserDetailsDao.findByHql("from EduUserDetails where courseware = " + cursewareId);
			if(list != null && list.size() > 0 && list.get(0) != null){
				return list.get(0);
			}
		} catch (RuntimeException re) {
			throw re;
		}
		return null;
	}
}