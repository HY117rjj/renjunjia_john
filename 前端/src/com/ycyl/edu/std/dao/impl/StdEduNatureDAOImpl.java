package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdEduNatureDAO;
import com.ycyl.edu.std.entity.StdEduNature;

/**
 	* A data access object (DAO) providing persistence and search support for StdEduNature entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdEduNature
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdEduNatureDAOImpl extends HibernateDaoSupport implements StdEduNatureDAO  {
		 private static final Log log = LogFactory.getLog(StdEduNatureDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#save(com.ycyl.edu.std.entity.StdEduNature)
	 */
    @Override
	public void save(StdEduNature transientInstance) {
        log.debug("saving StdEduNature instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#delete(com.ycyl.edu.std.entity.StdEduNature)
	 */
	@Override
	public void delete(StdEduNature persistentInstance) {
        log.debug("deleting StdEduNature instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdEduNature findById( java.math.BigDecimal id) {
        log.debug("getting StdEduNature instance with id: " + id);
        try {
            StdEduNature instance = (StdEduNature) getHibernateTemplate()
                    .get("StdEduNature", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#findByExample(com.ycyl.edu.std.entity.StdEduNature)
	 */
    @Override
	public List findByExample(StdEduNature instance) {
        log.debug("finding StdEduNature instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdEduNature instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdEduNature as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdEduNature instances");
		try {
			String queryString = "from StdEduNature";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#merge(com.ycyl.edu.std.entity.StdEduNature)
	 */
    @Override
	public StdEduNature merge(StdEduNature detachedInstance) {
        log.debug("merging StdEduNature instance");
        try {
            StdEduNature result = (StdEduNature) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#attachDirty(com.ycyl.edu.std.entity.StdEduNature)
	 */
    @Override
	public void attachDirty(StdEduNature instance) {
        log.debug("attaching dirty StdEduNature instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduNatureDAO#attachClean(com.ycyl.edu.std.entity.StdEduNature)
	 */
    @Override
	public void attachClean(StdEduNature instance) {
        log.debug("attaching clean StdEduNature instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdEduNatureDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdEduNatureDAO) ctx.getBean("StdEduNatureDAO");
	}
}