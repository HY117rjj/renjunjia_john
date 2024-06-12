package com.ycyl.edu.system.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.ycyl.edu.system.dao.EduTeacherDAO;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.service.EduTeacherService;

@SuppressWarnings("all")
@Data
public class EduTeacherServiceImpl implements EduTeacherService{

	private EduTeacherDAO eduTeacherDao;
	
	
	public Integer getTotalRows(String filter){
		return eduTeacherDao.getResultNum(filter);
	}
	
	@Override
	public List<EduTeacher> getCurrentPageList(final String filter, final int starRow, final int maxRow) {
		List<EduTeacher> list;
		try{
			list = eduTeacherDao.findByPage(filter, starRow, maxRow);
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
	
	public EduTeacher getEduTeacherById(Long id){
		return eduTeacherDao.findById(id);
	}
	
	public void saveOrUpdate(EduTeacher teacher){
		eduTeacherDao.saveOrUpdate(teacher);
	}
	
	public void delete(Long id){
		eduTeacherDao.delete(eduTeacherDao.findById(id));
//		eduTeacherDao.executeHql("delete from EduCourseware where serialNumber = " + id); 
//		eduTeacherDao.executeHql("delete from EduLecture where serialNumber = " + id); 
	}
	
	public List<Object[]> getAllAvailableTeacher(){
		StringBuffer sql = new StringBuffer("select distinct IDCARD, NAME, ID ");
		sql.append("from EDU_TEACHER ");
		List<Object[]> teacList = new ArrayList<>();
		List<Object[]> teacs = eduTeacherDao.findByRealSql(sql.toString());
		for(Object[] obj : teacs){
			teacList.add(obj);
		}
		return teacList;
	}
	
	@Override
	public List findTeacherForFrontPage() {
		List list;
		try{
			list = eduTeacherDao.findByRealSql("select idcard, name_, intro_, photourl_ from EDU_TEACHER_FOR_FRONTPAGE");
		} catch (RuntimeException re) {
			throw re;
		}
		return list;
	}
}