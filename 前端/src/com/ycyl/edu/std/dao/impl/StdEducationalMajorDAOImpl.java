package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdEducationalMajorDAO;
import com.ycyl.edu.std.entity.StdEducationalMajor;

/**
 	* A data access object (DAO) providing persistence and search support for StdEducationalMajor entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdEducationalMajor
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdEducationalMajorDAOImpl extends HibernateDaoSupport implements StdEducationalMajorDAO  {
		 private static final Log log = LogFactory.getLog(StdEducationalMajorDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#save(com.ycyl.edu.std.entity.StdEducationalMajor)
	 */
    @Override
	public void save(StdEducationalMajor transientInstance) {
        log.debug("saving StdEducationalMajor instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#delete(com.ycyl.edu.std.entity.StdEducationalMajor)
	 */
	@Override
	public void delete(StdEducationalMajor persistentInstance) {
        log.debug("deleting StdEducationalMajor instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdEducationalMajor findById( java.math.BigDecimal id) {
        log.debug("getting StdEducationalMajor instance with id: " + id);
        try {
            StdEducationalMajor instance = (StdEducationalMajor) getHibernateTemplate()
                    .get("StdEducationalMajor", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#findByExample(com.ycyl.edu.std.entity.StdEducationalMajor)
	 */
    @Override
	public List findByExample(StdEducationalMajor instance) {
        log.debug("finding StdEducationalMajor instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdEducationalMajor instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdEducationalMajor as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdEducationalMajor instances");
		try {
			String queryString = "from StdEducationalMajor where code like '10____%'";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#findAll()
	 */
	@Override
	public List findAll2() {
		log.debug("finding all StdEducationalMajor instances");
		try {
			String queryString = "from StdEducationalMajor";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#merge(com.ycyl.edu.std.entity.StdEducationalMajor)
	 */
    @Override
	public StdEducationalMajor merge(StdEducationalMajor detachedInstance) {
        log.debug("merging StdEducationalMajor instance");
        try {
            StdEducationalMajor result = (StdEducationalMajor) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#attachDirty(com.ycyl.edu.std.entity.StdEducationalMajor)
	 */
    @Override
	public void attachDirty(StdEducationalMajor instance) {
        log.debug("attaching dirty StdEducationalMajor instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEducationalMajorDAO#attachClean(com.ycyl.edu.std.entity.StdEducationalMajor)
	 */
    @Override
	public void attachClean(StdEducationalMajor instance) {
        log.debug("attaching clean StdEducationalMajor instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdEducationalMajorDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdEducationalMajorDAO) ctx.getBean("StdEducationalMajorDAO");
	}
}