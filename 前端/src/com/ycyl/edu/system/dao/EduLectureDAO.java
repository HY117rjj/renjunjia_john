package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduLecture;

@SuppressWarnings("all")
public interface EduLectureDAO extends IBaseDao{

	public abstract void save(EduLecture transientInstance);

	public abstract void delete(EduLecture persistentInstance);

	public abstract EduLecture findById(Long id);

	public abstract List findByExample(EduLecture instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduLecture merge(EduLecture detachedInstance);

	public abstract void attachDirty(EduLecture instance);

	public abstract void attachClean(EduLecture instance);

}