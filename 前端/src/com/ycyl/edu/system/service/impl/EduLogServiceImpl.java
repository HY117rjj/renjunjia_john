package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduLogDAO;
import com.ycyl.edu.system.entity.EduLog;
import com.ycyl.edu.system.service.EduLogService;

@SuppressWarnings("all")
@Data
public class EduLogServiceImpl implements EduLogService{

	private EduLogDAO eduLogDao;
	
	public Integer getTotalRows(String filter){
		return eduLogDao.getResultNum(filter);
	}
	
	@Override
	public List<EduLog> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduLog> list;
		try{
			list = eduLogDao.findByPage(filter+" order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduLog getEduLogById(Long id){
		return eduLogDao.findById(id);
	}
	
	public void saveOrUpdate(EduLog log){
		eduLogDao.saveOrUpdate(log);
	}
	
	public void delete(Long id){
		eduLogDao.delete(eduLogDao.findById(id));
	}
}