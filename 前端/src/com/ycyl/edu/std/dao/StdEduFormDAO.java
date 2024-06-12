package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdEduForm;

@SuppressWarnings("all")
public interface StdEduFormDAO {

	public abstract void save(StdEduForm transientInstance);

	public abstract void delete(StdEduForm persistentInstance);

	public abstract StdEduForm findById(java.math.BigDecimal id);

	public abstract List findByExample(StdEduForm instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdEduForm merge(StdEduForm detachedInstance);

	public abstract void attachDirty(StdEduForm instance);

	public abstract void attachClean(StdEduForm instance);

}