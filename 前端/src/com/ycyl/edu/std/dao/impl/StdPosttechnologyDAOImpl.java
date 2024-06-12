package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdPosttechnologyDAO;
import com.ycyl.edu.std.entity.StdPosttechnology;

/**
 	* A data access object (DAO) providing persistence and search support for StdPosttechnology entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdPosttechnology
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdPosttechnologyDAOImpl extends HibernateDaoSupport implements StdPosttechnologyDAO  {
		 private static final Log log = LogFactory.getLog(StdPosttechnologyDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#save(com.ycyl.edu.std.entity.StdPosttechnology)
	 */
    @Override
	public void save(StdPosttechnology transientInstance) {
        log.debug("saving StdPosttechnology instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#delete(com.ycyl.edu.std.entity.StdPosttechnology)
	 */
	@Override
	public void delete(StdPosttechnology persistentInstance) {
        log.debug("deleting StdPosttechnology instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdPosttechnology findById( java.math.BigDecimal id) {
        log.debug("getting StdPosttechnology instance with id: " + id);
        try {
            StdPosttechnology instance = (StdPosttechnology) getHibernateTemplate()
                    .get("StdPosttechnology", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#findByExample(com.ycyl.edu.std.entity.StdPosttechnology)
	 */
    @Override
	public List findByExample(StdPosttechnology instance) {
        log.debug("finding StdPosttechnology instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdPosttechnology instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdPosttechnology as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdPosttechnology instances");
		try {
			String queryString = "from StdPosttechnology";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#merge(com.ycyl.edu.std.entity.StdPosttechnology)
	 */
    @Override
	public StdPosttechnology merge(StdPosttechnology detachedInstance) {
        log.debug("merging StdPosttechnology instance");
        try {
            StdPosttechnology result = (StdPosttechnology) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#attachDirty(com.ycyl.edu.std.entity.StdPosttechnology)
	 */
    @Override
	public void attachDirty(StdPosttechnology instance) {
        log.debug("attaching dirty StdPosttechnology instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdPosttechnologyDAO#attachClean(com.ycyl.edu.std.entity.StdPosttechnology)
	 */
    @Override
	public void attachClean(StdPosttechnology instance) {
        log.debug("attaching clean StdPosttechnology instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdPosttechnologyDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdPosttechnologyDAO) ctx.getBean("StdPosttechnologyDAO");
	}
}