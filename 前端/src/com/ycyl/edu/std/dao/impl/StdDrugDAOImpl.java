package com.ycyl.edu.std.dao.impl;
// default package

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.std.dao.StdDrugDAO;
import com.ycyl.edu.std.entity.StdDrug;

/**
 	* A data access object (DAO) providing persistence and search support for StdDrug entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdDrug
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdDrugDAOImpl extends BaseDao implements StdDrugDAO  {
		 private static final Log log = LogFactory.getLog(StdDrugDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#save(com.ycyl.edu.std.entity.StdDrug)
	 */
    @Override
	public void save(StdDrug transientInstance) {
        log.debug("saving StdDrug instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#delete(com.ycyl.edu.std.entity.StdDrug)
	 */
	@Override
	public void delete(StdDrug persistentInstance) {
        log.debug("deleting StdDrug instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdDrug findById( java.math.BigDecimal id) {
        log.debug("getting StdDrug instance with id: " + id);
        try {
            StdDrug instance = (StdDrug) getHibernateTemplate()
                    .get("StdDrug", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#findByExample(com.ycyl.edu.std.entity.StdDrug)
	 */
    @Override
	public List findByExample(StdDrug instance) {
        log.debug("finding StdDrug instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdDrug instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdDrug as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdDrug instances");
		try {
			String queryString = "from StdDrug";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#merge(com.ycyl.edu.std.entity.StdDrug)
	 */
    @Override
	public StdDrug merge(StdDrug detachedInstance) {
        log.debug("merging StdDrug instance");
        try {
            StdDrug result = (StdDrug) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#attachDirty(com.ycyl.edu.std.entity.StdDrug)
	 */
    @Override
	public void attachDirty(StdDrug instance) {
        log.debug("attaching dirty StdDrug instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdDrugDAO#attachClean(com.ycyl.edu.std.entity.StdDrug)
	 */
    @Override
	public void attachClean(StdDrug instance) {
        log.debug("attaching clean StdDrug instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdDrugDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdDrugDAO) ctx.getBean("StdDrugDAO");
	}
}