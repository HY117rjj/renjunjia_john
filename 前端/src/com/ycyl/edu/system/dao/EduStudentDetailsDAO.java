package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduStudentDetails;

@SuppressWarnings("all")
public interface EduStudentDetailsDAO extends IBaseDao{

	public abstract void save(EduStudentDetails transientInstance);

	public abstract void delete(EduStudentDetails persistentInstance);

	public abstract EduStudentDetails findById(Long id);

	public abstract List findByExample(EduStudentDetails instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduStudentDetails merge(EduStudentDetails detachedInstance);

	public abstract void attachDirty(EduStudentDetails instance);

	public abstract void attachClean(EduStudentDetails instance);

}