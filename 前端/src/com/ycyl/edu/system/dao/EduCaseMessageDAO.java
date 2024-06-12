package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduCaseMessage;

@SuppressWarnings("all")
public interface EduCaseMessageDAO extends IBaseDao {

	public abstract void save(EduCaseMessage transientInstance);

	public abstract void delete(EduCaseMessage persistentInstance);

	public abstract EduCaseMessage findById(Long id);

	public abstract List findByExample(EduCaseMessage instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduCaseMessage merge(EduCaseMessage detachedInstance);

	public abstract void attachDirty(EduCaseMessage instance);

	public abstract void attachClean(EduCaseMessage instance);

}