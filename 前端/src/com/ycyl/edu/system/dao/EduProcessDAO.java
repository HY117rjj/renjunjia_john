package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduProcess;

@SuppressWarnings("all")
public interface EduProcessDAO extends IBaseDao {

	public abstract void save(EduProcess transientInstance);

	public abstract void delete(EduProcess persistentInstance);

	public abstract EduProcess findById(Long id);

	public abstract List findByExample(EduProcess instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduProcess merge(EduProcess detachedInstance);

	public abstract void attachDirty(EduProcess instance);

	public abstract void attachClean(EduProcess instance);

}