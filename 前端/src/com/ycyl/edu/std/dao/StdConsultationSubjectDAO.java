package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdConsultationSubject;

@SuppressWarnings("all")
public interface StdConsultationSubjectDAO {

	public abstract void save(StdConsultationSubject transientInstance);

	public abstract void delete(StdConsultationSubject persistentInstance);

	public abstract StdConsultationSubject findById(java.math.BigDecimal id);

	public abstract List findByExample(StdConsultationSubject instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract StdConsultationSubject merge(StdConsultationSubject detachedInstance);

	public abstract void attachDirty(StdConsultationSubject instance);

	public abstract void attachClean(StdConsultationSubject instance);
	
	public List findAll2();

}