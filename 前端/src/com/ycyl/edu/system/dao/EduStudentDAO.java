package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduStudent;

@SuppressWarnings("all")
public interface EduStudentDAO extends IBaseDao{

	public abstract void save(EduStudent transientInstance);

	public abstract void delete(EduStudent persistentInstance);

	public abstract EduStudent findById(Long id);

	public abstract List findByExample(EduStudent instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduStudent merge(EduStudent detachedInstance);

	public abstract void attachDirty(EduStudent instance);

	public abstract void attachClean(EduStudent instance);

}