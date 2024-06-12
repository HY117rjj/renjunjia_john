package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduCoursewareMessage;

@SuppressWarnings("all")
public interface EduCoursewareMessageDAO extends IBaseDao {

	public abstract void save(EduCoursewareMessage transientInstance);

	public abstract void delete(EduCoursewareMessage persistentInstance);

	public abstract EduCoursewareMessage findById(Long id);

	public abstract List findByExample(EduCoursewareMessage instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduCoursewareMessage merge(EduCoursewareMessage detachedInstance);

	public abstract void attachDirty(EduCoursewareMessage instance);

	public abstract void attachClean(EduCoursewareMessage instance);

}