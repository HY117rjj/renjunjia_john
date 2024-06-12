package com.ycyl.edu.base;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("all")
public class BaseDao extends HibernateDaoSupport implements IBaseDao {
	private final Log log = LogFactory.getLog(this.getClass());

	public void save(Object obj) {
		try {
			this.getHibernateTemplate().save(obj);
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Object obj) {
		try {
			this.getHibernateTemplate().saveOrUpdate(obj);
		} catch (RuntimeException re) {
			log.error("saveOrUpdate failed", re);
			throw re;
		}
	}

	public void merge(Object obj) {
		try {
			this.getHibernateTemplate().merge(obj);
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void deleteObject(Object obj) {
		try {
			getHibernateTemplate().delete(obj);
		} catch (RuntimeException re) {
			log.error("deleteObject failed", re);
			throw re;
		}
	}

	public List findByExample(Object obj) {
		try {
			return getHibernateTemplate().findByExample(obj);
		} catch (RuntimeException re) {
			log.error("findByExample failed", re);
			throw re;
		}
	}

	public Object findById(final Class objclass, final java.io.Serializable id) {
		Object obj = getHibernateTemplate().get(objclass, id);
		return obj;
	}

	public List findBySql(String sql) {
		try {
			return getHibernateTemplate().find(sql);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHql(String sql) {
		try {

			Session session = this.getSession();
			Query query = session.createQuery(sql);
			List list = query.list();

			return list;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}

	}

	public Object findByHqlId(final Class objclass, final java.io.Serializable id) {
		try {

			Session session = this.getSession();
			Object obj = session.get(objclass, id);

			return obj;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}

	}

	public List findByRealSql(String sql) {
		try {
			final String fsql = sql;
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createSQLQuery(fsql);
					List list = query.list();
					return list;
				}
			});
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByPage(final String filter, final int starRow, final int maxRow) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createQuery(filter);
					query.setFirstResult(starRow);
					query.setMaxResults(maxRow);
					List list = query.list();
					return list;
				}
			});
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByPage(final String filter, final int starRow, final int maxRow, final Map args) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createQuery(filter);
					query.setFirstResult(starRow);
					query.setMaxResults(maxRow);
					if (args != null && !args.isEmpty()) {
						query.setProperties(args);
					}
					List list = query.list();
					return list;
				}
			});
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int getResultNum(final String filter) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createQuery(filter);
					List list = query.list();
					return list;
				}
			}).size();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int getResultNum(final String filter, final Map args) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createQuery(filter);
					if (args != null && !args.isEmpty()) {
						query.setProperties(args);
					}
					List list = query.list();
					return list;
				}
			}).size();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByPageUseSql(final String filter, final int starRow,
			final int maxRow) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createSQLQuery(filter);
					query.setFirstResult(starRow);
					query.setMaxResults(maxRow);
					List list = query.list();
					return list;
				}
			});
		} catch (RuntimeException re) {
			log.error("sql=" + filter, re);
			throw re;
		}
	}

	public int getResultNumUseSql(final String filter) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createSQLQuery(filter);
					List list = query.list();
					return list;
				}
			}).size();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByPageUseSql(final String filter, final int starRow, final int maxRow, final Map args) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createSQLQuery(filter);
					query.setFirstResult(starRow);
					query.setMaxResults(maxRow);
					if (args != null && !args.isEmpty()) {
						query.setProperties(args);
					}
					List list = query.list();
					return list;
				}
			});
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public int getResultNumUseSql(final String filter, final Map args) {
		try {
			return getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session s) throws HibernateException, SQLException {
					Query query = s.createSQLQuery(filter);
					if (args != null && !args.isEmpty()) {
						query.setProperties(args);
					}
					List list = query.list();
					return list;
				}
			}).size();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 * @return List
	 */
	public int executeSql(String sql) {
		try {
			final String fsql = sql;
			Integer res = (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session s) throws HibernateException, SQLException {
							Query query = s.createSQLQuery(fsql);
							int i = query.executeUpdate();
							return new Integer(i);
						}
					});
			return res.intValue();
		} catch (RuntimeException re) {
			log.error("executeSql(" + sql + ")", re);
			throw re;
		}
	}

	public int executeHql(String sql) {
		try {
			final String fsql = sql;
			Integer res = (Integer) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session s) throws HibernateException, SQLException {
							Query query = s.createQuery(fsql);
							int i = query.executeUpdate();
							return new Integer(i);
						}
					});
			return res.intValue();
		} catch (RuntimeException re) {
			log.error("executeHql(" + sql + ")", re);
			throw re;
		}
	}

	// 根据条件进行查询、分页
	public List findPageByCriteria(final DetachedCriteria detachedCriteria, final int starRow, final int pageSize) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria
						.getExecutableCriteria(session);
				criteria.setMaxResults(pageSize);
				criteria.setFirstResult(starRow);
				return criteria.list();
			}
		});
	}

	// 根据查询条件查询所有所有记录
	public List findAllByCriteria(final DetachedCriteria detachedCriteria) {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				return criteria.list();
			}
		});
	}

	// 获得 符合查询条件的记录数目
	public int getCountByCriteria(final DetachedCriteria detachedCriteria) {
		Integer count = (Integer) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException {
						Criteria criteria = detachedCriteria.getExecutableCriteria(session);
						Object obj = criteria.setProjection(Projections.rowCount()).uniqueResult();
						criteria.setProjection(null);
						return obj;
					}
				});
		return count.intValue();
	}

	public void flush() {
		log.debug("flush ...");
		try {
			getHibernateTemplate().flush();
			log.debug("find  successful");
		} catch (RuntimeException re) {
			log.error("flush instance failed", re);
			throw re;
		}
	}

	public void clear() {
		log.debug("flush ...");
		try {
			getHibernateTemplate().clear();
			log.debug("find  successful");
		} catch (RuntimeException re) {
			log.error("flush instance failed", re);
			throw re;
		}
	}
}
