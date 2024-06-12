package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduCaseDAO;
import com.ycyl.edu.system.entity.EduCase;

/**
 	* A data access object (DAO) providing persistence and search support for EduCase entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .EduCase
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class EduCaseDAOImpl extends BaseDao implements EduCaseDAO  {
	private static final Log log = LogFactory.getLog(EduCaseDAOImpl.class);

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#save(com.ycyl.edu.system.entity.EduCase)
	 */
    @Override
	public void save(EduCase transientInstance) {
        log.debug("saving EduCase instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#delete(com.ycyl.edu.system.entity.EduCase)
	 */
	@Override
	public void delete(EduCase persistentInstance) {
        log.debug("deleting EduCase instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public EduCase findById(Long id) {
        log.debug("getting EduCase instance with id: " + id);
        try {
            EduCase instance = (EduCase) getHibernateTemplate()
                    .get("com.ycyl.edu.system.entity.EduCase", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#findByExample(com.ycyl.edu.system.entity.EduCase)
	 */
    @Override
	public List findByExample(EduCase instance) {
        log.debug("finding EduCase instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EduCase instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EduCase as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduCase instances");
		try {
			String queryString = "from EduCase";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#merge(com.ycyl.edu.system.entity.EduCase)
	 */
    @Override
	public EduCase merge(EduCase detachedInstance) {
        log.debug("merging EduCase instance");
        try {
            EduCase result = (EduCase) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#attachDirty(com.ycyl.edu.system.entity.EduCase)
	 */
    @Override
	public void attachDirty(EduCase instance) {
        log.debug("attaching dirty EduCase instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseDAO#attachClean(com.ycyl.edu.system.entity.EduCase)
	 */
    @Override
	public void attachClean(EduCase instance) {
        log.debug("attaching clean EduCase instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EduCaseDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EduCaseDAO) ctx.getBean("EduCaseDAO");
	}
}