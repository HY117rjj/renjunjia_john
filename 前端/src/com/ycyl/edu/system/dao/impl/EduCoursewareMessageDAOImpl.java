package com.ycyl.edu.system.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.system.dao.EduCoursewareMessageDAO;
import com.ycyl.edu.system.entity.EduCoursewareMessage;

/**
  * A data access object (DAO) providing persistence and search support for EduCoursewareMessage entities.
  * Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
  * @see .EduCoursewareMessage
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class EduCoursewareMessageDAOImpl extends BaseDao implements EduCoursewareMessageDAO  {
	private static final Log log = LogFactory.getLog(EduCoursewareMessageDAOImpl.class);
	
	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#save(com.ycyl.edu.system.entity.EduCoursewareMessage)
	 */
    @Override
	public void save(EduCoursewareMessage transientInstance) {
        log.debug("saving EduCoursewareMessage instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#delete(com.ycyl.edu.system.entity.EduCoursewareMessage)
	 */
	@Override
	public void delete(EduCoursewareMessage persistentInstance) {
        log.debug("deleting EduCoursewareMessage instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public EduCoursewareMessage findById(Long id) {
        log.debug("getting EduCoursewareMessage instance with id: " + id);
        try {
            EduCoursewareMessage instance = (EduCoursewareMessage) getHibernateTemplate()
                    .get("com.ycyl.edu.system.entity.EduCoursewareMessage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#findByExample(com.ycyl.edu.system.entity.EduCoursewareMessage)
	 */
    @Override
	public List findByExample(EduCoursewareMessage instance) {
        log.debug("finding EduCoursewareMessage instance by example");
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
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding EduCoursewareMessage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EduCoursewareMessage as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all EduCoursewareMessage instances");
		try {
			String queryString = "from EduCoursewareMessage";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#merge(com.ycyl.edu.system.entity.EduCoursewareMessage)
	 */
    @Override
	public EduCoursewareMessage merge(EduCoursewareMessage detachedInstance) {
        log.debug("merging EduCoursewareMessage instance");
        try {
            EduCoursewareMessage result = (EduCoursewareMessage) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#attachDirty(com.ycyl.edu.system.entity.EduCoursewareMessage)
	 */
    @Override
	public void attachDirty(EduCoursewareMessage instance) {
        log.debug("attaching dirty EduCoursewareMessage instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.system.dao.impl.EduCoursewareMessageDAO#attachClean(com.ycyl.edu.system.entity.EduCoursewareMessage)
	 */
    @Override
	public void attachClean(EduCoursewareMessage instance) {
        log.debug("attaching clean EduCoursewareMessage instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static EduCoursewareMessageDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (EduCoursewareMessageDAO) ctx.getBean("EduCoursewareMessageDAO");
	}
}