package com.ycyl.edu.std.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycyl.edu.std.dao.StdEduReleaseDAO;
import com.ycyl.edu.std.entity.StdEduRelease;

/**
 	* A data access object (DAO) providing persistence and search support for StdEduRelease entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .StdEduRelease
  * @author MyEclipse Persistence Tools 
 */
@SuppressWarnings("all")
public class StdEduReleaseDAOImpl extends HibernateDaoSupport implements StdEduReleaseDAO  {
	private static final Log log = LogFactory.getLog(StdEduReleaseDAOImpl.class);
	
	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#save(com.ycyl.edu.std.entity.StdEduRelease)
	 */
    @Override
	public void save(StdEduRelease transientInstance) {
        log.debug("saving StdEduRelease instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#delete(com.ycyl.edu.std.entity.StdEduRelease)
	 */
	@Override
	public void delete(StdEduRelease persistentInstance) {
        log.debug("deleting StdEduRelease instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findById(java.math.BigDecimal)
	 */
    @Override
	public StdEduRelease findById( java.math.BigDecimal id) {
        log.debug("getting StdEduRelease instance with id: " + id);
        try {
            StdEduRelease instance = (StdEduRelease) getHibernateTemplate()
                    .get("StdEduRelease", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByExample(com.ycyl.edu.std.entity.StdEduRelease)
	 */
    @Override
	public List findByExample(StdEduRelease instance) {
        log.debug("finding StdEduRelease instance by example");
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
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    @Override
	public List findByProperty(String propertyName, Object value) {
      log.debug("finding StdEduRelease instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StdEduRelease as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByAttributues(java.lang.Object)
	 */
	@Override
	public List findByAttributues(Object attributues
	) {
		return findByProperty(ATTRIBUTUES, attributues
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByCode(java.lang.Object)
	 */
	@Override
	public List findByCode(Object code
	) {
		return findByProperty(CODE, code
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByIndexcode(java.lang.Object)
	 */
	@Override
	public List findByIndexcode(Object indexcode
	) {
		return findByProperty(INDEXCODE, indexcode
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByName(java.lang.Object)
	 */
	@Override
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByShortname(java.lang.Object)
	 */
	@Override
	public List findByShortname(Object shortname
	) {
		return findByProperty(SHORTNAME, shortname
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByNameen(java.lang.Object)
	 */
	@Override
	public List findByNameen(Object nameen
	) {
		return findByProperty(NAMEEN, nameen
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByStopedflag(java.lang.Object)
	 */
	@Override
	public List findByStopedflag(Object stopedflag
	) {
		return findByProperty(STOPEDFLAG, stopedflag
		);
	}
	
	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findByComment(java.lang.Object)
	 */
	@Override
	public List findByComment(Object comment
	) {
		return findByProperty(COMMENT, comment
		);
	}
	

	/* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all StdEduRelease instances");
		try {
			String queryString = "from StdEduRelease";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#merge(com.ycyl.edu.std.entity.StdEduRelease)
	 */
    @Override
	public StdEduRelease merge(StdEduRelease detachedInstance) {
        log.debug("merging StdEduRelease instance");
        try {
            StdEduRelease result = (StdEduRelease) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#attachDirty(com.ycyl.edu.std.entity.StdEduRelease)
	 */
    @Override
	public void attachDirty(StdEduRelease instance) {
        log.debug("attaching dirty StdEduRelease instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see com.ycyl.edu.std.dao.impl.StdEduReleaseDAO#attachClean(com.ycyl.edu.std.entity.StdEduRelease)
	 */
    @Override
	public void attachClean(StdEduRelease instance) {
        log.debug("attaching clean StdEduRelease instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StdEduReleaseDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StdEduReleaseDAO) ctx.getBean("StdEduReleaseDAO");
	}
}