package com.ycyl.edu.std.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.std.dao.StdDiseaseDAO;
import com.ycyl.edu.std.entity.StdDisease;

/**
 	* A data access object (DAO) providing persistence and search support for StdDisease entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdDisease
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdDiseaseDAOImpl extends BaseDao implements StdDiseaseDAO  {
		 private static final Log log = LogFactory.getLog(StdDiseaseDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#save(com.ycyl.edu.std.entity.StdDisease)
	 */
    @Override
	public void save(StdDisease transientInstance) {
        log.debug("saving StdDisease instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#delete(com.ycyl.edu.std.entity.StdDisease)
	 */
	@Override
	public void delete(StdDisease persistentInstance) {
        log.debug("deleting StdDisease instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdDisease findById( java.math.BigDecimal id) {
        log.debug("getting StdDisease instance with id: " + id);
        try {
            StdDisease instance = (StdDisease) getHibernateTemplate()
                    .get("StdDisease", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#findByExample(com.ycyl.edu.std.entity.StdDisease)
	 */
    @Override
	public List findByExample(StdDisease instance) {
        log.debug("finding StdDisease instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdDisease instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdDisease as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdDisease instances");
		try {
			String queryString = "from StdDisease where attributes = '20'";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#merge(com.ycyl.edu.std.entity.StdDisease)
	 */
    @Override
	public StdDisease merge(StdDisease detachedInstance) {
        log.debug("merging StdDisease instance");
        try {
            StdDisease result = (StdDisease) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#attachDirty(com.ycyl.edu.std.entity.StdDisease)
	 */
    @Override
	public void attachDirty(StdDisease instance) {
        log.debug("attaching dirty StdDisease instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDiseaseDAO#attachClean(com.ycyl.edu.std.entity.StdDisease)
	 */
    @Override
	public void attachClean(StdDisease instance) {
        log.debug("attaching clean StdDisease instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdDiseaseDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdDiseaseDAO) ctx.getBean("StdDiseaseDAO");
	}
}