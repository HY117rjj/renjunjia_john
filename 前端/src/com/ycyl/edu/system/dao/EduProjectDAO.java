package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduProject;

@SuppressWarnings("all")
public interface EduProjectDAO extends IBaseDao{

	public abstract void save(EduProject transientInstance);

	public abstract void delete(EduProject persistentInstance);

	public abstract EduProject findById(Long id);

	public abstract List findByExample(EduProject instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduProject merge(EduProject detachedInstance);

	public abstract void attachDirty(EduProject instance);

	public abstract void attachClean(EduProject instance);

}