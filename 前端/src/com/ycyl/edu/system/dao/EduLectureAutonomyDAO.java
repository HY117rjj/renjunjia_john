package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduLectureAutonomy;

@SuppressWarnings("all")
public interface EduLectureAutonomyDAO extends IBaseDao{

	public abstract void save(EduLectureAutonomy transientInstance);

	public abstract void delete(EduLectureAutonomy persistentInstance);

	public abstract EduLectureAutonomy findById(Long id);

	public abstract List findByExample(EduLectureAutonomy instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduLectureAutonomy merge(EduLectureAutonomy detachedInstance);

	public abstract void attachDirty(EduLectureAutonomy instance);

	public abstract void attachClean(EduLectureAutonomy instance);

}