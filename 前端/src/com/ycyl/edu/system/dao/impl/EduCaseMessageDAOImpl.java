package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduCaseMessageDAO;
import com.ycyl.edu.system.entity.EduCaseMessage;

/**
 	* A data access object (DAO) providing persistence and search support for EduCaseMessage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .EduCaseMessage
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class EduCaseMessageDAOImpl extends BaseDao implements EduCaseMessageDAO  {
	private static final Log log = LogFactory.getLog(EduCaseMessageDAOImpl.class);

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#save(com.ycyl.edu.system.entity.EduCaseMessage)
	 */
    @Override
	public void save(EduCaseMessage transientInstance) {
        log.debug("saving EduCaseMessage instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#delete(com.ycyl.edu.system.entity.EduCaseMessage)
	 */
	@Override
	public void delete(EduCaseMessage persistentInstance) {
        log.debug("deleting EduCaseMessage instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public EduCaseMessage findById(Long id) {
        log.debug("getting EduCaseMessage instance with id: " + id);
        try {
            EduCaseMessage instance = (EduCaseMessage) getHibernateTemplate()
                    .get("com.ycyl.edu.system.entity.EduCaseMessage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#findByExample(com.ycyl.edu.system.entity.EduCaseMessage)
	 */
    @Override
	public List findByExample(EduCaseMessage instance) {
        log.debug("finding EduCaseMessage instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EduCaseMessage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EduCaseMessage as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduCaseMessage instances");
		try {
			String queryString = "from EduCaseMessage";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#merge(com.ycyl.edu.system.entity.EduCaseMessage)
	 */
    @Override
	public EduCaseMessage merge(EduCaseMessage detachedInstance) {
        log.debug("merging EduCaseMessage instance");
        try {
            EduCaseMessage result = (EduCaseMessage) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#attachDirty(com.ycyl.edu.system.entity.EduCaseMessage)
	 */
    @Override
	public void attachDirty(EduCaseMessage instance) {
        log.debug("attaching dirty EduCaseMessage instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCaseMessageDAO#attachClean(com.ycyl.edu.system.entity.EduCaseMessage)
	 */
    @Override
	public void attachClean(EduCaseMessage instance) {
        log.debug("attaching clean EduCaseMessage instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EduCaseMessageDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EduCaseMessageDAO) ctx.getBean("EduCaseMessageDAO");
	}
}