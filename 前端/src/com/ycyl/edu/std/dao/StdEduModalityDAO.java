package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdEduModality;

@SuppressWarnings("all")
public interface StdEduModalityDAO {

	public abstract void save(StdEduModality transientInstance);

	public abstract void delete(StdEduModality persistentInstance);

	public abstract StdEduModality findById(java.math.BigDecimal id);

	public abstract List findByExample(StdEduModality instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdEduModality merge(StdEduModality detachedInstance);

	public abstract void attachDirty(StdEduModality instance);

	public abstract void attachClean(StdEduModality instance);

}