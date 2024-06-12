package com.ycyl.edu.system.service.impl;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduStudentDAO;
import com.ycyl.edu.system.dao.EduStudentDetailsDAO;
import com.ycyl.edu.system.entity.EduLectureAppointment;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduStudentDetails;
import com.ycyl.edu.system.service.EduStudentService;

@SuppressWarnings("all")
@Data
public class EduStudentServiceImpl implements EduStudentService{

	private EduStudentDAO eduStudentDao;
	
	private EduStudentDetailsDAO eduStudentDetailsDao;
	
	public Integer getTotalRows(String filter){
		return eduStudentDao.getResultNum(filter);
	}

	@Override
	public List<EduStudent> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduStudent> list;
		try{
			list = eduStudentDao.findByPage(filter, starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduStudent getEduStudentById(Long id){
		return eduStudentDao.findById(id);
	}
	
	public void saveOrUpdate(EduStudent student){
		eduStudentDao.saveOrUpdate(student);
	}
	
	public void delete(Long id){
		eduStudentDao.delete(eduStudentDao.findById(id));
//		eduStudentDao.executeHql("delete from EduStudentDetails where serialNumber = " + id);
	}
	
	public Integer getTotalDetailsRows(String filter){
		return eduStudentDetailsDao.getResultNum(filter);
	}

	@Override
	public List<EduStudentDetails> getCurrentPageDetailsList(final String filter, final int starRow, final int maxRow) {
		List<EduStudentDetails> list;
		try{
			list = eduStudentDetailsDao.findByPage(filter, starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduStudentDetails getEduStudentDetailsById(Long id){
		return eduStudentDetailsDao.findById(id);
	}
	
	public void saveOrUpdateDetails(EduStudentDetails studentDetails){
		eduStudentDetailsDao.saveOrUpdate(studentDetails);
	}
	
	public void deleteDetails(Long id){
		eduStudentDetailsDao.executeHql("delete from EduStudentDetails where serialNumber = " + id);
	}
	
	public Boolean isDupcateUserName(EduStudent student){
		List<EduStudent> list = eduStudentDao.findByHql("from EduStudent where userName = '" + student.getUserName() + "'");
		if(list != null && list.size() > 0 && list.get(0) != null){
			return true;
		}
		return false;
	}
	
}