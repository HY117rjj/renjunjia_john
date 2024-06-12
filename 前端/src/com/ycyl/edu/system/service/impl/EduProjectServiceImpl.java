package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduProjectDAO;
import com.ycyl.edu.system.entity.EduProject;
import com.ycyl.edu.system.service.EduProjectService;

@SuppressWarnings("all")
@Data
public class EduProjectServiceImpl implements EduProjectService{

	private EduProjectDAO eduProjectDao;
	
	public Integer getTotalRows(String filter){
		return eduProjectDao.getResultNum(filter);
	}
	
	@Override
	public List<EduProject> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduProject> list;
		try{
			list = eduProjectDao.findByPage(filter, starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduProject getEduProjectById(Long id){
		return eduProjectDao.findById(id);
	}
	
	public void saveOrUpdate(EduProject project){
		eduProjectDao.saveOrUpdate(project);
	}
	
	public void delete(Long id){
		eduProjectDao.delete(eduProjectDao.findById(id));
	}
}