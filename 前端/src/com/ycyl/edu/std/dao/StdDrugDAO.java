package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.base.IBaseDao;
import com.ycyl.edu.std.entity.StdDrug;

@SuppressWarnings("all")
public interface StdDrugDAO extends IBaseDao{

	public abstract void save(StdDrug transientInstance);

	public abstract void delete(StdDrug persistentInstance);

	public abstract StdDrug findById(java.math.BigDecimal id);

	public abstract List findByExample(StdDrug instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdDrug merge(StdDrug detachedInstance);

	public abstract void attachDirty(StdDrug instance);

	public abstract void attachClean(StdDrug instance);

}