package com.ycyl.edu.system.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.system.entity.EduNotice;

@SuppressWarnings("all")
public interface EduNoticeDAO extends IBaseDao{

	public abstract void save(EduNotice transientInstance);

	public abstract void delete(EduNotice persistentInstance);

	public abstract EduNotice findById(Long id);

	public abstract List findByExample(EduNotice instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract EduNotice merge(EduNotice detachedInstance);

	public abstract void attachDirty(EduNotice instance);

	public abstract void attachClean(EduNotice instance);

}