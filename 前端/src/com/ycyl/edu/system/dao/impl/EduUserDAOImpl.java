package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduUserDAO;
import com.ycyl.edu.system.entity.EduUser;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduUser
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduUserDAOImpl extends BaseDao implements EduUserDAO {
	private static final Log log = LogFactory.getLog(EduUserDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#save(com.ycyl.edu.system.entity.EduUser)
	 */
	@Override
	public void save(EduUser transientInstance) {
		log.debug("saving EduUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#delete(com.ycyl.edu.system.entity.EduUser)
	 */
	@Override
	public void delete(EduUser persistentInstance) {
		log.debug("deleting EduUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduUser findById(Long id) {
		log.debug("getting EduUser instance with id: " + id);
		try {
			EduUser instance = (EduUser) getHibernateTemplate().get(
					"com.ycyl.edu.system.entity.EduUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#findByExample(com.ycyl.edu.system.entity.EduUser)
	 */
	@Override
	public List findByExample(EduUser instance) {
		log.debug("finding EduUser instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EduUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduUser instances");
		try {
			String queryString = "from EduUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#merge(com.ycyl.edu.system.entity.EduUser)
	 */
	@Override
	public EduUser merge(EduUser detachedInstance) {
		log.debug("merging EduUser instance");
		try {
			EduUser result = (EduUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#attachDirty(com.ycyl.edu.system.entity.EduUser)
	 */
	@Override
	public void attachDirty(EduUser instance) {
		log.debug("attaching dirty EduUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDAO#attachClean(com.ycyl.edu.system.entity.EduUser)
	 */
	@Override
	public void attachClean(EduUser instance) {
		log.debug("attaching clean EduUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EduUserDAO) ctx.getBean("EduUserDAO");
	}
}