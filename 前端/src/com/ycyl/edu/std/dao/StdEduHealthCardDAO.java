package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdEduHealthCard;

@SuppressWarnings("all")
public interface StdEduHealthCardDAO {

	public abstract void save(StdEduHealthCard transientInstance);

	public abstract void delete(StdEduHealthCard persistentInstance);

	public abstract StdEduHealthCard findById(java.math.BigDecimal id);

	public abstract List findByExample(StdEduHealthCard instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdEduHealthCard merge(StdEduHealthCard detachedInstance);

	public abstract void attachDirty(StdEduHealthCard instance);

	public abstract void attachClean(StdEduHealthCard instance);

}