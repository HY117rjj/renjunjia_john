package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduUser;

@SuppressWarnings("all")
public interface EduUserDAO extends IBaseDao{

	public abstract void save(EduUser transientInstance);

	public abstract void delete(EduUser persistentInstance);

	public abstract EduUser findById(Long id);

	public abstract List findByExample(EduUser instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduUser merge(EduUser detachedInstance);

	public abstract void attachDirty(EduUser instance);

	public abstract void attachClean(EduUser instance);

}