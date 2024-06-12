package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdEducationalMajor;

@SuppressWarnings("all")
public interface StdEducationalMajorDAO {

	public abstract void save(StdEducationalMajor transientInstance);

	public abstract void delete(StdEducationalMajor persistentInstance);

	public abstract StdEducationalMajor findById(java.math.BigDecimal id);

	public abstract List findByExample(StdEducationalMajor instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdEducationalMajor merge(StdEducationalMajor detachedInstance);

	public abstract void attachDirty(StdEducationalMajor instance);

	public abstract void attachClean(StdEducationalMajor instance);
	
	public List findAll2();

}