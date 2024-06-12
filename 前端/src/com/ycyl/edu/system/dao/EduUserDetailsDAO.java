package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduUserDetails;

@SuppressWarnings("all")
public interface EduUserDetailsDAO extends IBaseDao{

	public abstract void save(EduUserDetails transientInstance);

	public abstract void delete(EduUserDetails persistentInstance);

	public abstract EduUserDetails findById(Long id);

	public abstract List findByExample(EduUserDetails instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduUserDetails merge(EduUserDetails detachedInstance);

	public abstract void attachDirty(EduUserDetails instance);

	public abstract void attachClean(EduUserDetails instance);

}