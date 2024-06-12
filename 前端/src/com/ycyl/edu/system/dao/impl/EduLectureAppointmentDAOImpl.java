package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduLectureAppointmentDAO;
import com.ycyl.edu.system.entity.EduLectureAppointment;

/**
 * A data access object (DAO) providing persistence and search support for
 * EduLectureAppointment entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ycyl.edu.system.entity.EduLectureAppointment
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("all")
public class EduLectureAppointmentDAOImpl extends BaseDao implements EduLectureAppointmentDAO {
	private static final Log log = LogFactory
			.getLog(EduLectureAppointmentDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#save(com.ycyl.edu.system.entity.EduLectureAppointment)
	 */
	@Override
	public void save(EduLectureAppointment transientInstance) {
		log.debug("saving EduLectureAppointment instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#delete(com.ycyl.edu.system.entity.EduLectureAppointment)
	 */
	@Override
	public void delete(EduLectureAppointment persistentInstance) {
		log.debug("deleting EduLectureAppointment instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#findById(java.math.BigDecimal)
	 */
	@Override
	public EduLectureAppointment findById(Long id) {
		log.debug("getting EduLectureAppointment instance with id: " + id);
		try {
			EduLectureAppointment instance = (EduLectureAppointment) getHibernateTemplate()
					.get("com.ycyl.edu.system.entity.EduLectureAppointment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#findByExample(com.ycyl.edu.system.entity.EduLectureAppointment)
	 */
	@Override
	public List findByExample(EduLectureAppointment instance) {
		log.debug("finding EduLectureAppointment instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EduLectureAppointment instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from EduLectureAppointment as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduLectureAppointment instances");
		try {
			String queryString = "from EduLectureAppointment";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#merge(com.ycyl.edu.system.entity.EduLectureAppointment)
	 */
	@Override
	public EduLectureAppointment merge(EduLectureAppointment detachedInstance) {
		log.debug("merging EduLectureAppointment instance");
		try {
			EduLectureAppointment result = (EduLectureAppointment) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#attachDirty(com.ycyl.edu.system.entity.EduLectureAppointment)
	 */
	@Override
	public void attachDirty(EduLectureAppointment instance) {
		log.debug("attaching dirty EduLectureAppointment instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLectureAppointmentDAO#attachClean(com.ycyl.edu.system.entity.EduLectureAppointment)
	 */
	@Override
	public void attachClean(EduLectureAppointment instance) {
		log.debug("attaching clean EduLectureAppointment instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EduLectureAppointmentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (EduLectureAppointmentDAO) ctx
				.getBean("EduLectureAppointmentDAO");
	}
}