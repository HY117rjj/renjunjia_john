package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdEduNature;

@SuppressWarnings("all")
public interface StdEduNatureDAO {

	public abstract void save(StdEduNature transientInstance);

	public abstract void delete(StdEduNature persistentInstance);

	public abstract StdEduNature findById(java.math.BigDecimal id);

	public abstract List findByExample(StdEduNature instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdEduNature merge(StdEduNature detachedInstance);

	public abstract void attachDirty(StdEduNature instance);

	public abstract void attachClean(StdEduNature instance);

}