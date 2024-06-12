package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduLectureAutonomyDAO;
import com.ycyl.edu.system.entity.EduLectureAutonomy;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduLectureAutonomy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduLectureAutonomy
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduLectureAutonomyDAOImpl extends BaseDao implements EduLectureAutonomyDAO {
	private static final Log log = LogFactory
			.getLog(EduLectureAutonomyDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#save(com.ycyl.edu.system.entity.EduLectureAutonomy)
	 */
	@Override
	public void save(EduLectureAutonomy transientInstance) {
		log.debug("saving EduLectureAutonomy instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#delete(com.ycyl.edu.system.entity.EduLectureAutonomy)
	 */
	@Override
	public void delete(EduLectureAutonomy persistentInstance) {
		log.debug("deleting EduLectureAutonomy instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduLectureAutonomy findById(Long id) {
		log.debug("getting EduLectureAutonomy instance with id: " + id);
		try {
			EduLectureAutonomy instance = (EduLectureAutonomy) getHibernateTemplate()
					.get("com.ycyl.edu.system.entity.EduLectureAutonomy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#findByExample(com.ycyl.edu.system.entity.EduLectureAutonomy)
	 */
	@Override
	public List findByExample(EduLectureAutonomy instance) {
		log.debug("finding EduLectureAutonomy instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduLectureAutonomy instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EduLectureAutonomy as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduLectureAutonomy instances");
		try {
			String queryString = "from EduLectureAutonomy";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#merge(com.ycyl.edu.system.entity.EduLectureAutonomy)
	 */
	@Override
	public EduLectureAutonomy merge(EduLectureAutonomy detachedInstance) {
		log.debug("merging EduLectureAutonomy instance");
		try {
			EduLectureAutonomy result = (EduLectureAutonomy) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#attachDirty(com.ycyl.edu.system.entity.EduLectureAutonomy)
	 */
	@Override
	public void attachDirty(EduLectureAutonomy instance) {
		log.debug("attaching dirty EduLectureAutonomy instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAutonomyDAO#attachClean(com.ycyl.edu.system.entity.EduLectureAutonomy)
	 */
	@Override
	public void attachClean(EduLectureAutonomy instance) {
		log.debug("attaching clean EduLectureAutonomy instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduLectureAutonomyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EduLectureAutonomyDAO) ctx.getBean("EduLectureAutonomyDAO");
	}
}