package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduProjectDAO;
import com.ycyl.edu.system.entity.EduProject;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduProject entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduProject
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduProjectDAOImpl extends BaseDao implements EduProjectDAO {
	private static final Log log = LogFactory.getLog(EduProjectDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#save(com.ycyl.edu.system.entity.EduProject)
	 */
	@Override
	public void save(EduProject transientInstance) {
		log.debug("saving EduProject instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#delete(com.ycyl.edu.system.entity.EduProject)
	 */
	@Override
	public void delete(EduProject persistentInstance) {
		log.debug("deleting EduProject instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduProject findById(Long id) {
		log.debug("getting EduProject instance with id: " + id);
		try {
			EduProject instance = (EduProject) getHibernateTemplate().get(
					"com.ycyl.edu.system.entity.EduProject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#findByExample(com.ycyl.edu.system.entity.EduProject)
	 */
	@Override
	public List findByExample(EduProject instance) {
		log.debug("finding EduProject instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduProject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EduProject as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduProject instances");
		try {
			String queryString = "from EduProject";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#merge(com.ycyl.edu.system.entity.EduProject)
	 */
	@Override
	public EduProject merge(EduProject detachedInstance) {
		log.debug("merging EduProject instance");
		try {
			EduProject result = (EduProject) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#attachDirty(com.ycyl.edu.system.entity.EduProject)
	 */
	@Override
	public void attachDirty(EduProject instance) {
		log.debug("attaching dirty EduProject instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProjectDAO#attachClean(com.ycyl.edu.system.entity.EduProject)
	 */
	@Override
	public void attachClean(EduProject instance) {
		log.debug("attaching clean EduProject instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduProjectDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EduProjectDAO) ctx.getBean("EduProjectDAO");
	}
}