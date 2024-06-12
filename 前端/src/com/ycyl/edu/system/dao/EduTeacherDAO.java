package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduTeacher;

@SuppressWarnings("all")
public interface EduTeacherDAO extends IBaseDao{

	public abstract void save(EduTeacher transientInstance);

	public abstract void delete(EduTeacher persistentInstance);

	public abstract EduTeacher findById(Long id);

	public abstract List findByExample(EduTeacher instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduTeacher merge(EduTeacher detachedInstance);

	public abstract void attachDirty(EduTeacher instance);

	public abstract void attachClean(EduTeacher instance);

}