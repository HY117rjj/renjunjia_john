package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduUserDetailsDAO;
import com.ycyl.edu.system.entity.EduUserDetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduUserDetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduUserDetails
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduUserDetailsDAOImpl extends BaseDao implements EduUserDetailsDAO {
	private static final Log log = LogFactory.getLog(EduUserDetailsDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#save(com.ycyl.edu.system.entity.EduUserDetails)
	 */
	@Override
	public void save(EduUserDetails transientInstance) {
		log.debug("saving EduUserDetails instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#delete(com.ycyl.edu.system.entity.EduUserDetails)
	 */
	@Override
	public void delete(EduUserDetails persistentInstance) {
		log.debug("deleting EduUserDetails instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduUserDetails findById(Long id) {
		log.debug("getting EduUserDetails instance with id: " + id);
		try {
			EduUserDetails instance = (EduUserDetails) getHibernateTemplate()
					.get("com.ycyl.edu.system.entity.EduUserDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#findByExample(com.ycyl.edu.system.entity.EduUserDetails)
	 */
	@Override
	public List findByExample(EduUserDetails instance) {
		log.debug("finding EduUserDetails instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduUserDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EduUserDetails as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduUserDetails instances");
		try {
			String queryString = "from EduUserDetails";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#merge(com.ycyl.edu.system.entity.EduUserDetails)
	 */
	@Override
	public EduUserDetails merge(EduUserDetails detachedInstance) {
		log.debug("merging EduUserDetails instance");
		try {
			EduUserDetails result = (EduUserDetails) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#attachDirty(com.ycyl.edu.system.entity.EduUserDetails)
	 */
	@Override
	public void attachDirty(EduUserDetails instance) {
		log.debug("attaching dirty EduUserDetails instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduUserDetailsDAO#attachClean(com.ycyl.edu.system.entity.EduUserDetails)
	 */
	@Override
	public void attachClean(EduUserDetails instance) {
		log.debug("attaching clean EduUserDetails instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduUserDetailsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EduUserDetailsDAO) ctx.getBean("EduUserDetailsDAO");
	}
}