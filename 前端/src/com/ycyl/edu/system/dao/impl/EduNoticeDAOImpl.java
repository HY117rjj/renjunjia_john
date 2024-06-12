package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduNoticeDAO;
import com.ycyl.edu.system.entity.EduNotice;

/**
 	* A data access object (DAO) providing persistence and search support for EduNotice entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .EduNotice
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class EduNoticeDAOImpl extends BaseDao implements EduNoticeDAO  {
		 private static final Log log = LogFactory.getLog(EduNoticeDAOImpl.class);
	

	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#save(com.ycyl.edu.system.entity.EduNotice)
	 */
    @Override
	public void save(EduNotice transientInstance) {
        log.debug("saving EduNotice instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#delete(com.ycyl.edu.system.entity.EduNotice)
	 */
	@Override
	public void delete(EduNotice persistentInstance) {
        log.debug("deleting EduNotice instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public EduNotice findById(Long id) {
        log.debug("getting EduNotice instance with id: " + id);
        try {
            EduNotice instance = (EduNotice) getHibernateTemplate()
                    .get("com.ycyl.edu.system.entity.EduNotice", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#findByExample(com.ycyl.edu.system.entity.EduNotice)
	 */
    @Override
	public List findByExample(EduNotice instance) {
        log.debug("finding EduNotice instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EduNotice instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EduNotice as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduNotice instances");
		try {
			String queryString = "from EduNotice";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#merge(com.ycyl.edu.system.entity.EduNotice)
	 */
    @Override
	public EduNotice merge(EduNotice detachedInstance) {
        log.debug("merging EduNotice instance");
        try {
            EduNotice result = (EduNotice) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#attachDirty(com.ycyl.edu.system.entity.EduNotice)
	 */
    @Override
	public void attachDirty(EduNotice instance) {
        log.debug("attaching dirty EduNotice instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduNoticeDAO#attachClean(com.ycyl.edu.system.entity.EduNotice)
	 */
    @Override
	public void attachClean(EduNotice instance) {
        log.debug("attaching clean EduNotice instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EduNoticeDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EduNoticeDAO) ctx.getBean("EduNoticeDAO");
	}
}