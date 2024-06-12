package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduTeacherDAO;
import com.ycyl.edu.system.entity.EduTeacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduTeacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduTeacher
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduTeacherDAOImpl extends BaseDao implements EduTeacherDAO {
	private static final Log log = LogFactory.getLog(EduTeacherDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#save(com.ycyl.edu.system.entity.EduTeacher)
	 */
	@Override
	public void save(EduTeacher transientInstance) {
		log.debug("saving EduTeacher instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#delete(com.ycyl.edu.system.entity.EduTeacher)
	 */
	@Override
	public void delete(EduTeacher persistentInstance) {
		log.debug("deleting EduTeacher instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduTeacher findById(Long id) {
		log.debug("getting EduTeacher instance with id: " + id);
		try {
			EduTeacher instance = (EduTeacher) getHibernateTemplate().get(
					"com.ycyl.edu.system.entity.EduTeacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#findByExample(com.ycyl.edu.system.entity.EduTeacher)
	 */
	@Override
	public List findByExample(EduTeacher instance) {
		log.debug("finding EduTeacher instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduTeacher instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EduTeacher as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduTeacher instances");
		try {
			String queryString = "from EduTeacher";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#merge(com.ycyl.edu.system.entity.EduTeacher)
	 */
	@Override
	public EduTeacher merge(EduTeacher detachedInstance) {
		log.debug("merging EduTeacher instance");
		try {
			EduTeacher result = (EduTeacher) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#attachDirty(com.ycyl.edu.system.entity.EduTeacher)
	 */
	@Override
	public void attachDirty(EduTeacher instance) {
		log.debug("attaching dirty EduTeacher instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduTeacherDAO#attachClean(com.ycyl.edu.system.entity.EduTeacher)
	 */
	@Override
	public void attachClean(EduTeacher instance) {
		log.debug("attaching clean EduTeacher instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduTeacherDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EduTeacherDAO) ctx.getBean("EduTeacherDAO");
	}
}