package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduNoticeDAO;
import com.ycyl.edu.system.entity.EduNotice;
import com.ycyl.edu.system.service.EduNoticeService;

@SuppressWarnings("all")
@Data
public class EduNoticeServiceImpl implements EduNoticeService{

	private EduNoticeDAO eduNoticeDao;
	
	public Integer getTotalRows(String filter){
		return eduNoticeDao.getResultNum(filter);
	}
	
	@Override
	public List<EduNotice> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduNotice> list;
		try{
			list = eduNoticeDao.findByPage(filter+" order by noticeTime desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduNotice getEduNoticeById(Long id){
		return eduNoticeDao.findById(id);
	}
	
	public void saveOrUpdate(EduNotice notice){
		eduNoticeDao.saveOrUpdate(notice);
	}
	
	public void delete(Long id){
		eduNoticeDao.delete(eduNoticeDao.findById(id));
	}
}