package com.ycyl.edu.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ycyl.edu.std.dao.StdDrugDAO;
import com.ycyl.edu.std.entity.StdDrug;
import com.ycyl.edu.system.dao.EduCoursewareDAO;
import com.ycyl.edu.system.dao.EduCoursewareMessageDAO;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduCoursewareMessage;
import com.ycyl.edu.system.service.EduCoursewareService;
import com.ycyl.edu.util.Dictionary;

@SuppressWarnings("all")
@Data
public class EduCoursewareServiceImpl implements EduCoursewareService{

	public EduCoursewareDAO eduCoursewareDao;
	
	public EduCoursewareMessageDAO eduCoursewareMessageDao;
	
	public StdDrugDAO stdDrugDao;

	public EduCoursewareDAO getEduCoursewareDao() {
		return eduCoursewareDao;
	}

	public void setEduCoursewareDao(EduCoursewareDAO eduCoursewareDao) {
		this.eduCoursewareDao = eduCoursewareDao;
	}
	
	public Integer getTotalRows(String filter){
		return eduCoursewareDao.getResultNum(filter);
	}
	
	@Override
	public List<EduCourseware> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduCourseware> list;
		try{
			list = eduCoursewareDao.findByPage(filter + " order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public Integer getMessageTotalRows(String filter){
		return eduCoursewareMessageDao.getResultNum(filter);
	}
	
	@Override
	public List<EduCoursewareMessage> getMessageCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduCoursewareMessage> list;
		try{
			list = eduCoursewareMessageDao.findByPage(filter + " order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	@Override
	public List<EduCourseware> getMoreVideoList(final String filter) {
		List<EduCourseware> list;
		try{
			list = eduCoursewareDao.findByHql(filter + " order by id desc");
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduCourseware getEduCoursewareById(Long id){
		return eduCoursewareDao.findById(id);
	}
	
	public void saveOrUpdate(EduCourseware cw){
		eduCoursewareDao.saveOrUpdate(cw);
	}
	
	public void delete(Long id){
		eduCoursewareDao.delete(eduCoursewareDao.findById(id));
	}
	
	public EduCoursewareMessage getEduCoursewareMessageById(Long id){
		return eduCoursewareMessageDao.findById(id);
	}
	
	public void saveOrUpdateMessage(EduCoursewareMessage cw){
		eduCoursewareMessageDao.saveOrUpdate(cw);
	}
	
	public void deleteMessage(Long id){
		eduCoursewareMessageDao.delete(eduCoursewareMessageDao.findById(id));
	}
	
	public List<com.ycyl.edu.util.Dictionary> getEduCWForPro(){
		List<com.ycyl.edu.util.Dictionary> listDic = new ArrayList<>();
		Dictionary dic;
		List<EduCourseware> list = eduCoursewareDao.findByHql("from EduCourseware");
		for(EduCourseware cw : list){
			dic = new Dictionary();
			dic.setCode(cw.getId()+"");
			dic.setName(cw.getTitle()+"["+cw.getName()+"]");
			listDic.add(dic);
		}
		return listDic;
	}
	
	@Override
	public List<StdDrug> getStdDrugList() {
		List<StdDrug> list;
		try{
			list = stdDrugDao.findByHql("from StdDrug where  level_ = 3 order by code");
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
}