package com.ycyl.edu.base;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

@SuppressWarnings("all")
public interface IBaseDao {
	
	public void saveOrUpdate(Object obj);

	public void merge(Object obj);

	public void deleteObject(Object obj);

	public List findByExample(Object obj);

	public Object findById(final Class objclass, final java.io.Serializable id);

	public List findBySql(String sql);

	public List findByHql(String sql);

	public List findByRealSql(String sql);

	public List findByPage(final String filter, final int starRow, final int maxRow);

	public List findByPage(final String filter, final int starRow, final int maxRow, final Map args);

	public int getResultNum(final String filter);

	public int getResultNum(final String filter, final Map args);

	public List findByPageUseSql(final String filter, final int starRow, final int maxRow);

	public int getResultNumUseSql(final String filter);

	public int executeSql(String sql);

	public int executeHql(String sql);

	public Object findByHqlId(final Class objclass, final java.io.Serializable id);

	public List findPageByCriteria(final DetachedCriteria detachedCriteria, final int starRow, final int pageSize);

	public List findAllByCriteria(final DetachedCriteria detachedCriteria);

	public int getCountByCriteria(final DetachedCriteria detachedCriteria);

	public List findByPageUseSql(final String filter, final int starRow, final int maxRow, final Map args);

	public int getResultNumUseSql(final String filter, final Map args);

	public void flush();

	public void clear();
}