package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduProcessDAO;
import com.ycyl.edu.system.entity.EduProcess;

/**
 	* A data access object (DAO) providing persistence and search support for EduProcess entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .EduProcess
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class EduProcessDAOImpl extends BaseDao implements EduProcessDAO  {
	private static final Log log = LogFactory.getLog(EduProcessDAOImpl.class);
	
	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#save(com.ycyl.edu.system.entity.EduProcess)
	 */
    @Override
	public void save(EduProcess transientInstance) {
        log.debug("saving EduProcess instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#delete(com.ycyl.edu.system.entity.EduProcess)
	 */
	@Override
	public void delete(EduProcess persistentInstance) {
        log.debug("deleting EduProcess instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#findById(java.lang.Long)
	 */
    @Override
	public EduProcess findById(Long id) {
        log.debug("getting EduProcess instance with id: " + id);
        try {
            EduProcess instance = (EduProcess) getHibernateTemplate()
                    .get("com.ycyl.edu.system.entity.EduProcess", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#findByExample(com.ycyl.edu.system.entity.EduProcess)
	 */
    @Override
	public List findByExample(EduProcess instance) {
        log.debug("finding EduProcess instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EduProcess instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EduProcess as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduProcess instances");
		try {
			String queryString = "from EduProcess";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#merge(com.ycyl.edu.system.entity.EduProcess)
	 */
    @Override
	public EduProcess merge(EduProcess detachedInstance) {
        log.debug("merging EduProcess instance");
        try {
            EduProcess result = (EduProcess) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#attachDirty(com.ycyl.edu.system.entity.EduProcess)
	 */
    @Override
	public void attachDirty(EduProcess instance) {
        log.debug("attaching dirty EduProcess instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduProcessDAO#attachClean(com.ycyl.edu.system.entity.EduProcess)
	 */
    @Override
	public void attachClean(EduProcess instance) {
        log.debug("attaching clean EduProcess instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EduProcessDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EduProcessDAO) ctx.getBean("EduProcessDAO");
	}
}