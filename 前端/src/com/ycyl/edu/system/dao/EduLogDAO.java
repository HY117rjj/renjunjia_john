package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduLog;

@SuppressWarnings("all")
public interface EduLogDAO extends IBaseDao {

	public abstract void save(EduLog transientInstance);

	public abstract void delete(EduLog persistentInstance);

	public abstract EduLog findById(Long id);

	public abstract List findByExample(EduLog instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduLog merge(EduLog detachedInstance);

	public abstract void attachDirty(EduLog instance);

	public abstract void attachClean(EduLog instance);

}