package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdPosttechnology;

@SuppressWarnings("all")
public interface StdPosttechnologyDAO {

	public abstract void save(StdPosttechnology transientInstance);

	public abstract void delete(StdPosttechnology persistentInstance);

	public abstract StdPosttechnology findById(java.math.BigDecimal id);

	public abstract List findByExample(StdPosttechnology instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdPosttechnology merge(StdPosttechnology detachedInstance);

	public abstract void attachDirty(StdPosttechnology instance);

	public abstract void attachClean(StdPosttechnology instance);

}