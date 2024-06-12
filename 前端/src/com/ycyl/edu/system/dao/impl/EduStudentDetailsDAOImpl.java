package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduStudentDetailsDAO;
import com.ycyl.edu.system.entity.EduStudentDetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduStudentDetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduStudentDetails
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduStudentDetailsDAOImpl extends BaseDao implements EduStudentDetailsDAO {
	private static final Log log = LogFactory
			.getLog(EduStudentDetailsDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#save(com.ycyl.edu.system.entity.EduStudentDetails)
	 */
	@Override
	public void save(EduStudentDetails transientInstance) {
		log.debug("saving EduStudentDetails instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#delete(com.ycyl.edu.system.entity.EduStudentDetails)
	 */
	@Override
	public void delete(EduStudentDetails persistentInstance) {
		log.debug("deleting EduStudentDetails instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduStudentDetails findById(Long id) {
		log.debug("getting EduStudentDetails instance with id: " + id);
		try {
			EduStudentDetails instance = (EduStudentDetails) getHibernateTemplate()
					.get("com.ycyl.edu.system.entity.EduStudentDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#findByExample(com.ycyl.edu.system.entity.EduStudentDetails)
	 */
	@Override
	public List findByExample(EduStudentDetails instance) {
		log.debug("finding EduStudentDetails instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduStudentDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EduStudentDetails as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduStudentDetails instances");
		try {
			String queryString = "from EduStudentDetails";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#merge(com.ycyl.edu.system.entity.EduStudentDetails)
	 */
	@Override
	public EduStudentDetails merge(EduStudentDetails detachedInstance) {
		log.debug("merging EduStudentDetails instance");
		try {
			EduStudentDetails result = (EduStudentDetails) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#attachDirty(com.ycyl.edu.system.entity.EduStudentDetails)
	 */
	@Override
	public void attachDirty(EduStudentDetails instance) {
		log.debug("attaching dirty EduStudentDetails instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDetailsDAO#attachClean(com.ycyl.edu.system.entity.EduStudentDetails)
	 */
	@Override
	public void attachClean(EduStudentDetails instance) {
		log.debug("attaching clean EduStudentDetails instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduStudentDetailsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EduStudentDetailsDAO) ctx.getBean("EduStudentDetailsDAO");
	}
}