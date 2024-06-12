package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdEduModalityDAO;
import com.ycyl.edu.std.entity.StdEduModality;

/**
 	* A data access object (DAO) providing persistence and search support for StdEduModality entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdEduModality
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdEduModalityDAOImpl extends HibernateDaoSupport implements StdEduModalityDAO  {
		 private static final Log log = LogFactory.getLog(StdEduModalityDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#save(com.ycyl.edu.std.entity.StdEduModality)
	 */
    @Override
	public void save(StdEduModality transientInstance) {
        log.debug("saving StdEduModality instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#delete(com.ycyl.edu.std.entity.StdEduModality)
	 */
	@Override
	public void delete(StdEduModality persistentInstance) {
        log.debug("deleting StdEduModality instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdEduModality findById( java.math.BigDecimal id) {
        log.debug("getting StdEduModality instance with id: " + id);
        try {
            StdEduModality instance = (StdEduModality) getHibernateTemplate()
                    .get("StdEduModality", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#findByExample(com.ycyl.edu.std.entity.StdEduModality)
	 */
    @Override
	public List findByExample(StdEduModality instance) {
        log.debug("finding StdEduModality instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdEduModality instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdEduModality as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdEduModality instances");
		try {
			String queryString = "from StdEduModality";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#merge(com.ycyl.edu.std.entity.StdEduModality)
	 */
    @Override
	public StdEduModality merge(StdEduModality detachedInstance) {
        log.debug("merging StdEduModality instance");
        try {
            StdEduModality result = (StdEduModality) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#attachDirty(com.ycyl.edu.std.entity.StdEduModality)
	 */
    @Override
	public void attachDirty(StdEduModality instance) {
        log.debug("attaching dirty StdEduModality instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduModalityDAO#attachClean(com.ycyl.edu.std.entity.StdEduModality)
	 */
    @Override
	public void attachClean(StdEduModality instance) {
        log.debug("attaching clean StdEduModality instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdEduModalityDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdEduModalityDAO) ctx.getBean("StdEduModalityDAO");
	}
}