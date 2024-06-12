package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdConsultationSubjectDAO;
import com.ycyl.edu.std.entity.StdConsultationSubject;

/**
 	* A data access object (DAO) providing persistence and search support for StdConsultationSubject entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdConsultationSubject
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdConsultationSubjectDAOImpl extends HibernateDaoSupport implements StdConsultationSubjectDAO  {
		 private static final Log log = LogFactory.getLog(StdConsultationSubjectDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#save(com.ycyl.edu.std.entity.StdConsultationSubject)
	 */
    @Override
	public void save(StdConsultationSubject transientInstance) {
        log.debug("saving StdConsultationSubject instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#delete(com.ycyl.edu.std.entity.StdConsultationSubject)
	 */
	@Override
	public void delete(StdConsultationSubject persistentInstance) {
        log.debug("deleting StdConsultationSubject instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdConsultationSubject findById( java.math.BigDecimal id) {
        log.debug("getting StdConsultationSubject instance with id: " + id);
        try {
            StdConsultationSubject instance = (StdConsultationSubject) getHibernateTemplate()
                    .get("StdConsultationSubject", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#findByExample(com.ycyl.edu.std.entity.StdConsultationSubject)
	 */
    @Override
	public List findByExample(StdConsultationSubject instance) {
        log.debug("finding StdConsultationSubject instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdConsultationSubject instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdConsultationSubject as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdConsultationSubject instances");
		try {
			String queryString = "from StdConsultationSubject where length(code) > 2";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#findAll()
	 */
	@Override
	public List findAll2() {
		log.debug("finding all StdConsultationSubject instances");
		try {
			String queryString = "from StdConsultationSubject";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#merge(com.ycyl.edu.std.entity.StdConsultationSubject)
	 */
    @Override
	public StdConsultationSubject merge(StdConsultationSubject detachedInstance) {
        log.debug("merging StdConsultationSubject instance");
        try {
            StdConsultationSubject result = (StdConsultationSubject) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#attachDirty(com.ycyl.edu.std.entity.StdConsultationSubject)
	 */
    @Override
	public void attachDirty(StdConsultationSubject instance) {
        log.debug("attaching dirty StdConsultationSubject instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdConsultationSubjectDAO#attachClean(com.ycyl.edu.std.entity.StdConsultationSubject)
	 */
    @Override
	public void attachClean(StdConsultationSubject instance) {
        log.debug("attaching clean StdConsultationSubject instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdConsultationSubjectDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdConsultationSubjectDAO) ctx.getBean("StdConsultationSubjectDAO");
	}
}