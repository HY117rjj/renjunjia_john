package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduProcessDAO;
import com.ycyl.edu.system.entity.EduProcess;
import com.ycyl.edu.system.service.EduProcessService;

@SuppressWarnings("all")
@Data
public class EduProcessServiceImpl implements EduProcessService{

	private EduProcessDAO eduProcessDao;
	
	public Integer getTotalRows(String filter){
		return eduProcessDao.getResultNum(filter);
	}
	
	@Override
	public List<EduProcess> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduProcess> list;
		try{
			list = eduProcessDao.findByPage(filter+" order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduProcess getEduProcessById(Long id){
		return eduProcessDao.findById(id);
	}
	
	public void saveOrUpdate(EduProcess log){
		eduProcessDao.saveOrUpdate(log);
	}
	
	public void delete(Long id){
		eduProcessDao.delete(eduProcessDao.findById(id));
	}
}