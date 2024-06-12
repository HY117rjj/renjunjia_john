package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduLectureDAO;
import com.ycyl.edu.system.entity.EduLecture;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduLecture entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduLecture
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduLectureDAOImpl extends BaseDao implements EduLectureDAO {
	private static final Log log = LogFactory.getLog(EduLectureDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#save(com.ycyl.edu.system.entity.EduLecture)
	 */
	@Override
	public void save(EduLecture transientInstance) {
		log.debug("saving EduLecture instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#delete(com.ycyl.edu.system.entity.EduLecture)
	 */
	@Override
	public void delete(EduLecture persistentInstance) {
		log.debug("deleting EduLecture instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduLecture findById(Long id) {
		log.debug("getting EduLecture instance with id: " + id);
		try {
			EduLecture instance = (EduLecture) getHibernateTemplate().get(
					"com.ycyl.edu.system.entity.EduLecture", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#findByExample(com.ycyl.edu.system.entity.EduLecture)
	 */
	@Override
	public List findByExample(EduLecture instance) {
		log.debug("finding EduLecture instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduLecture instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EduLecture as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduLecture instances");
		try {
			String queryString = "from EduLecture";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#merge(com.ycyl.edu.system.entity.EduLecture)
	 */
	@Override
	public EduLecture merge(EduLecture detachedInstance) {
		log.debug("merging EduLecture instance");
		try {
			EduLecture result = (EduLecture) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#attachDirty(com.ycyl.edu.system.entity.EduLecture)
	 */
	@Override
	public void attachDirty(EduLecture instance) {
		log.debug("attaching dirty EduLecture instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureDAO#attachClean(com.ycyl.edu.system.entity.EduLecture)
	 */
	@Override
	public void attachClean(EduLecture instance) {
		log.debug("attaching clean EduLecture instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduLectureDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EduLectureDAO) ctx.getBean("EduLectureDAO");
	}
}