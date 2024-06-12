package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdEduHealthCardDAO;
import com.ycyl.edu.std.entity.StdEduHealthCard;

/**
 	* A data access object (DAO) providing persistence and search support for StdEduHealthCard entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdEduHealthCard
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdEduHealthCardDAOImpl extends HibernateDaoSupport implements StdEduHealthCardDAO  {
		 private static final Log log = LogFactory.getLog(StdEduHealthCardDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#save(com.ycyl.edu.std.entity.StdEduHealthCard)
	 */
    @Override
	public void save(StdEduHealthCard transientInstance) {
        log.debug("saving StdEduHealthCard instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#delete(com.ycyl.edu.std.entity.StdEduHealthCard)
	 */
	@Override
	public void delete(StdEduHealthCard persistentInstance) {
        log.debug("deleting StdEduHealthCard instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdEduHealthCard findById( java.math.BigDecimal id) {
        log.debug("getting StdEduHealthCard instance with id: " + id);
        try {
            StdEduHealthCard instance = (StdEduHealthCard) getHibernateTemplate()
                    .get("StdEduHealthCard", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#findByExample(com.ycyl.edu.std.entity.StdEduHealthCard)
	 */
    @Override
	public List findByExample(StdEduHealthCard instance) {
        log.debug("finding StdEduHealthCard instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdEduHealthCard instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdEduHealthCard as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdEduHealthCard instances");
		try {
			String queryString = "from StdEduHealthCard";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#merge(com.ycyl.edu.std.entity.StdEduHealthCard)
	 */
    @Override
	public StdEduHealthCard merge(StdEduHealthCard detachedInstance) {
        log.debug("merging StdEduHealthCard instance");
        try {
            StdEduHealthCard result = (StdEduHealthCard) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#attachDirty(com.ycyl.edu.std.entity.StdEduHealthCard)
	 */
    @Override
	public void attachDirty(StdEduHealthCard instance) {
        log.debug("attaching dirty StdEduHealthCard instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduHealthCardDAO#attachClean(com.ycyl.edu.std.entity.StdEduHealthCard)
	 */
    @Override
	public void attachClean(StdEduHealthCard instance) {
        log.debug("attaching clean StdEduHealthCard instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdEduHealthCardDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdEduHealthCardDAO) ctx.getBean("StdEduHealthCardDAO");
	}
}