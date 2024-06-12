package com.ycyl.edu.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ycyl.edu.std.dao.StdDrugDAO;
import com.ycyl.edu.std.entity.StdDrug;
import com.ycyl.edu.system.dao.EduCaseDAO;
import com.ycyl.edu.system.dao.EduCaseMessageDAO;
import com.ycyl.edu.system.dao.EduCaseDAO;
import com.ycyl.edu.system.dao.EduCaseMessageDAO;
import com.ycyl.edu.system.entity.EduCase;
import com.ycyl.edu.system.entity.EduCaseMessage;
import com.ycyl.edu.system.service.EduCaseService;
import com.ycyl.edu.util.Dictionary;

@SuppressWarnings("all")
@Data
public class EduCaseServiceImpl implements EduCaseService{

	public EduCaseDAO eduCaseDao;
	
	public EduCaseMessageDAO eduCaseMessageDao;
	
	public StdDrugDAO stdDrugDao;
	
	public EduCaseDAO getEduCaseDao() {
		return eduCaseDao;
	}

	public void setEduCaseDao(EduCaseDAO eduCaseDao) {
		this.eduCaseDao = eduCaseDao;
	}
	
	public Integer getTotalRows(String filter){
		return eduCaseDao.getResultNum(filter);
	}
	
	@Override
	public List<EduCase> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduCase> list;
		try{
			list = eduCaseDao.findByPage(filter + " order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public Integer getMessageTotalRows(String filter){
		return eduCaseMessageDao.getResultNum(filter);
	}
	
	@Override
	public List<EduCaseMessage> getMessageCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduCaseMessage> list;
		try{
			list = eduCaseMessageDao.findByPage(filter + " order by id desc", starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	@Override
	public List<EduCase> getMoreVideoList(final String filter) {
		List<EduCase> list;
		try{
			list = eduCaseDao.findByHql(filter + " order by id desc");
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduCase getEduCaseById(Long id){
		return eduCaseDao.findById(id);
	}
	
	public void saveOrUpdate(EduCase cw){
		eduCaseDao.saveOrUpdate(cw);
	}
	
	public void delete(Long id){
		eduCaseDao.delete(eduCaseDao.findById(id));
	}
	
	public EduCaseMessage getEduCaseMessageById(Long id){
		return eduCaseMessageDao.findById(id);
	}
	
	public void saveOrUpdateMessage(EduCaseMessage cw){
		eduCaseMessageDao.saveOrUpdate(cw);
	}
	
	public void deleteMessage(Long id){
		eduCaseMessageDao.delete(eduCaseMessageDao.findById(id));
	}
	
	public List<com.ycyl.edu.util.Dictionary> getEduCWForPro(){
		List<com.ycyl.edu.util.Dictionary> listDic = new ArrayList<>();
		Dictionary dic;
		List<EduCase> list = eduCaseDao.findByHql("from EduCase");
		for(EduCase cw : list){
			dic = new Dictionary();
			dic.setCode(cw.getId()+"");
			dic.setName(cw.getCaseContent()+"["+cw.getName()+"]");
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