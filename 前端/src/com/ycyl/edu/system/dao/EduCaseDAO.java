package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduCase;

@SuppressWarnings("all")
public interface EduCaseDAO extends IBaseDao {

	public abstract void save(EduCase transientInstance);

	public abstract void delete(EduCase persistentInstance);

	public abstract EduCase findById(Long id);

	public abstract List findByExample(EduCase instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduCase merge(EduCase detachedInstance);

	public abstract void attachDirty(EduCase instance);

	public abstract void attachClean(EduCase instance);

}