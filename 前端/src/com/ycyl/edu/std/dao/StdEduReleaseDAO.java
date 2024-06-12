package com.ycyl.edu.std.dao;

import java.util.List;

import com.ycyl.edu.std.entity.StdEduRelease;

@SuppressWarnings("all")
public interface StdEduReleaseDAO {

	// property constants
	public static final String ATTRIBUTUES = "attributues";
	public static final String CODE = "code";
	public static final String INDEXCODE = "indexcode";
	public static final String NAME = "name";
	public static final String SHORTNAME = "shortname";
	public static final String NAMEEN = "nameen";
	public static final String STOPEDFLAG = "stopedflag";
	public static final String COMMENT = "comment";

	public abstract void save(StdEduRelease transientInstance);

	public abstract void delete(StdEduRelease persistentInstance);

	public abstract StdEduRelease findById(java.math.BigDecimal id);

	public abstract List findByExample(StdEduRelease instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAttributues(Object attributues);

	public abstract List findByCode(Object code);

	public abstract List findByIndexcode(Object indexcode);

	public abstract List findByName(Object name);

	public abstract List findByShortname(Object shortname);

	public abstract List findByNameen(Object nameen);

	public abstract List findByStopedflag(Object stopedflag);

	public abstract List findByComment(Object comment);

	public abstract List findAll();

	public abstract StdEduRelease merge(StdEduRelease detachedInstance);

	public abstract void attachDirty(StdEduRelease instance);

	public abstract void attachClean(StdEduRelease instance);

}