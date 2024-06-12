package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduStudentDAO;
import com.ycyl.edu.system.entity.EduStudent;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduStudent entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduStudent
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduStudentDAOImpl extends BaseDao implements EduStudentDAO {
	private static final Log log = LogFactory.getLog(EduStudentDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#save(com.ycyl.edu.system.entity.EduStudent)
	 */
	@Override
	public void save(EduStudent transientInstance) {
		log.debug("saving EduStudent instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#delete(com.ycyl.edu.system.entity.EduStudent)
	 */
	@Override
	public void delete(EduStudent persistentInstance) {
		log.debug("deleting EduStudent instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduStudent findById(Long id) {
		log.debug("getting EduStudent instance with id: " + id);
		try {
			EduStudent instance = (EduStudent) getHibernateTemplate().get(
					"com.ycyl.edu.system.entity.EduStudent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#findByExample(com.ycyl.edu.system.entity.EduStudent)
	 */
	@Override
	public List findByExample(EduStudent instance) {
		log.debug("finding EduStudent instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduStudent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EduStudent as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduStudent instances");
		try {
			String queryString = "from EduStudent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#merge(com.ycyl.edu.system.entity.EduStudent)
	 */
	@Override
	public EduStudent merge(EduStudent detachedInstance) {
		log.debug("merging EduStudent instance");
		try {
			EduStudent result = (EduStudent) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#attachDirty(com.ycyl.edu.system.entity.EduStudent)
	 */
	@Override
	public void attachDirty(EduStudent instance) {
		log.debug("attaching dirty EduStudent instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduStudentDAO#attachClean(com.ycyl.edu.system.entity.EduStudent)
	 */
	@Override
	public void attachClean(EduStudent instance) {
		log.debug("attaching clean EduStudent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduStudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EduStudentDAO) ctx.getBean("EduStudentDAO");
	}
}