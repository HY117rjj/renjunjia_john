package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.std.entity.StdDisease;

@SuppressWarnings("all")
public interface StdDiseaseDAO extends IBaseDao{

	public abstract void save(StdDisease transientInstance);

	public abstract void delete(StdDisease persistentInstance);

	public abstract StdDisease findById(java.math.BigDecimal id);

	public abstract List findByExample(StdDisease instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdDisease merge(StdDisease detachedInstance);

	public abstract void attachDirty(StdDisease instance);

	public abstract void attachClean(StdDisease instance);

}