package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduLogDAO;
import com.ycyl.edu.system.entity.EduLog;

/**
 	* A data access object (DAO) providing persistence and search support for EduLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .EduLog
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class EduLogDAOImpl extends BaseDao implements EduLogDAO  {
	private static final Log log = LogFactory.getLog(EduLogDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#save(com.ycyl.edu.system.entity.EduLog)
	 */
    @Override
	public void save(EduLog transientInstance) {
        log.debug("saving EduLog instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#delete(com.ycyl.edu.system.entity.EduLog)
	 */
	@Override
	public void delete(EduLog persistentInstance) {
        log.debug("deleting EduLog instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public EduLog findById(Long id) {
        log.debug("getting EduLog instance with id: " + id);
        try {
            EduLog instance = (EduLog) getHibernateTemplate()
                    .get("EduLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#findByExample(com.ycyl.edu.system.entity.EduLog)
	 */
    @Override
	public List findByExample(EduLog instance) {
        log.debug("finding EduLog instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EduLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EduLog as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduLog instances");
		try {
			String queryString = "from EduLog";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#merge(com.ycyl.edu.system.entity.EduLog)
	 */
    @Override
	public EduLog merge(EduLog detachedInstance) {
        log.debug("merging EduLog instance");
        try {
            EduLog result = (EduLog) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#attachDirty(com.ycyl.edu.system.entity.EduLog)
	 */
    @Override
	public void attachDirty(EduLog instance) {
        log.debug("attaching dirty EduLog instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduLogDAO#attachClean(com.ycyl.edu.system.entity.EduLog)
	 */
    @Override
	public void attachClean(EduLog instance) {
        log.debug("attaching clean EduLog instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EduLogDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EduLogDAO) ctx.getBean("EduLogDAO");
	}
}