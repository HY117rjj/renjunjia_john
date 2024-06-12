package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduCourseware;

@SuppressWarnings("all")
public interface EduCoursewareDAO extends IBaseDao{

	public abstract void save(EduCourseware transientInstance);

	public abstract void delete(EduCourseware persistentInstance);

	public abstract EduCourseware findById(Long id);

	public abstract List findByExample(EduCourseware instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduCourseware merge(EduCourseware detachedInstance);

	public abstract void attachDirty(EduCourseware instance);

	public abstract void attachClean(EduCourseware instance);

}