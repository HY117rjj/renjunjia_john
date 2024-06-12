package com.ycyl.edu.std.dao.impl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdEduFormDAO;
import com.ycyl.edu.std.entity.StdEduForm;

/**
 	* A data access object (DAO) providing persistence and search support for StdEduForm entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdEduForm
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdEduFormDAOImpl extends HibernateDaoSupport implements StdEduFormDAO  {
		 private static final Log log = LogFactory.getLog(StdEduFormDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#save(com.ycyl.edu.std.entity.StdEduForm)
	 */
    @Override
	public void save(StdEduForm transientInstance) {
        log.debug("saving StdEduForm instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#delete(com.ycyl.edu.std.entity.StdEduForm)
	 */
	@Override
	public void delete(StdEduForm persistentInstance) {
        log.debug("deleting StdEduForm instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdEduForm findById( java.math.BigDecimal id) {
        log.debug("getting StdEduForm instance with id: " + id);
        try {
            StdEduForm instance = (StdEduForm) getHibernateTemplate()
                    .get("StdEduForm", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#findByExample(com.ycyl.edu.std.entity.StdEduForm)
	 */
    @Override
	public List findByExample(StdEduForm instance) {
        log.debug("finding StdEduForm instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdEduForm instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdEduForm as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdEduForm instances");
		try {
			String queryString = "from StdEduForm";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#merge(com.ycyl.edu.std.entity.StdEduForm)
	 */
    @Override
	public StdEduForm merge(StdEduForm detachedInstance) {
        log.debug("merging StdEduForm instance");
        try {
            StdEduForm result = (StdEduForm) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#attachDirty(com.ycyl.edu.std.entity.StdEduForm)
	 */
    @Override
	public void attachDirty(StdEduForm instance) {
        log.debug("attaching dirty StdEduForm instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduFormDAO#attachClean(com.ycyl.edu.std.entity.StdEduForm)
	 */
    @Override
	public void attachClean(StdEduForm instance) {
        log.debug("attaching clean StdEduForm instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdEduFormDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdEduFormDAO) ctx.getBean("StdEduFormDAO");
	}
}