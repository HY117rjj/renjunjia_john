package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduCoursewareDAO;
import com.ycyl.edu.system.entity.EduCourseware;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduCourseware entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduCourseware
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduCoursewareDAOImpl extends BaseDao implements EduCoursewareDAO {
	private static final Log log = LogFactory.getLog(EduCoursewareDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#save(com.ycyl.edu.system.entity.EduCourseware)
	 */
	@Override
	public void save(EduCourseware transientInstance) {
		log.debug("saving EduCourseware instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#delete(com.ycyl.edu.system.entity.EduCourseware)
	 */
	@Override
	public void delete(EduCourseware persistentInstance) {
		log.debug("deleting EduCourseware instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduCourseware findById(Long id) {
		log.debug("getting EduCourseware instance with id: " + id);
		try {
			EduCourseware instance = (EduCourseware) getHibernateTemplate()
					.get("com.ycyl.edu.system.entity.EduCourseware", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#findByExample(com.ycyl.edu.system.entity.EduCourseware)
	 */
	@Override
	public List findByExample(EduCourseware instance) {
		log.debug("finding EduCourseware instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduCourseware instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EduCourseware as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduCourseware instances");
		try {
			String queryString = "from EduCourseware";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#merge(com.ycyl.edu.system.entity.EduCourseware)
	 */
	@Override
	public EduCourseware merge(EduCourseware detachedInstance) {
		log.debug("merging EduCourseware instance");
		try {
			EduCourseware result = (EduCourseware) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#attachDirty(com.ycyl.edu.system.entity.EduCourseware)
	 */
	@Override
	public void attachDirty(EduCourseware instance) {
		log.debug("attaching dirty EduCourseware instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareDAO#attachClean(com.ycyl.edu.system.entity.EduCourseware)
	 */
	@Override
	public void attachClean(EduCourseware instance) {
		log.debug("attaching clean EduCourseware instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduCoursewareDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EduCoursewareDAO) ctx.getBean("EduCoursewareDAO");
	}
}