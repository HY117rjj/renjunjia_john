package com.ycyl.edu.std.service.impl;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.ycyl.edu.base.BaseDao;
import com.ycyl.edu.std.dao.StdConsultationSubjectDAO;
import com.ycyl.edu.std.dao.StdDiseaseDAO;
import com.ycyl.edu.std.dao.StdEduFormDAO;
import com.ycyl.edu.std.dao.StdEduHealthCardDAO;
import com.ycyl.edu.std.dao.StdEduModalityDAO;
import com.ycyl.edu.std.dao.StdEduNatureDAO;
import com.ycyl.edu.std.dao.StdEduReleaseDAO;
import com.ycyl.edu.std.dao.StdEducationalMajorDAO;
import com.ycyl.edu.std.dao.StdPosttechnologyDAO;
import com.ycyl.edu.std.entity.ImageBasic;
import com.ycyl.edu.std.entity.StdConsultationSubject;
import com.ycyl.edu.std.entity.StdDisease;
import com.ycyl.edu.std.entity.StdEduForm;
import com.ycyl.edu.std.entity.StdEduHealthCard;
import com.ycyl.edu.std.entity.StdEduModality;
import com.ycyl.edu.std.entity.StdEduNature;
import com.ycyl.edu.std.entity.StdEduRelease;
import com.ycyl.edu.std.entity.StdEducationalMajor;
import com.ycyl.edu.std.entity.StdPosttechnology;
import com.ycyl.edu.std.service.StdService;

@SuppressWarnings("all")
@Setter @Getter
public class StdServiceImpl implements StdService {
	
	public StdDiseaseDAO stdDiseaseDao;
	public StdConsultationSubjectDAO stdConsultationSubjectDao;
	public StdPosttechnologyDAO stdPosttechnologyDao;
	public StdEducationalMajorDAO stdEducationalMajorDao;
	public StdEduNatureDAO stdEduNatureDao;
	public StdEduModalityDAO stdEduModalityDao;
	
	public StdEduFormDAO stdEduFormDao;
	
	public StdEduHealthCardDAO stdEduHealthCardDao;
	
	public StdEduReleaseDAO stdEduReleaseDAO;
	
	public List<StdConsultationSubject> getAllStdConsultationSubjects(){
		return stdConsultationSubjectDao.findAll();
	}
	
	public List<StdPosttechnology> getAllStdPosttechnologys(){
		return stdPosttechnologyDao.findAll();
	}
	
	public List<StdEducationalMajor> getAllStdEducationalMajors(){
		return stdEducationalMajorDao.findAll();
	}
	
	public List<StdEduNature> getAllStdEduNatures(){
		return stdEduNatureDao.findAll();
	}
	
	public List<StdEduModality> getAllStdEduModalitys(){
		return stdEduModalityDao.findAll();
	}
	
	public List<StdDisease> getAllStdDiseases(){
		return stdDiseaseDao.findAll();
	}
	
	public List<StdConsultationSubject> getAllStdConsultationSubject2s(){
		return stdConsultationSubjectDao.findAll2();
	}
	
	public List<StdEducationalMajor> getAllStdEducationalMajor2s(){
		return stdEducationalMajorDao.findAll2();
	}
	
	public List<StdEduForm> getAllStdEduForms(){
		return stdEduFormDao.findAll();
	}
	
	public List<StdEduHealthCard> getAllStdEduHealthCards(){
		return stdEduHealthCardDao.findAll();
	}
	
	public List<StdEduRelease> getAllStdEduReleases(){
		return stdEduReleaseDAO.findAll();
	}
	
	public List<ImageBasic> getAllImageBasics(){
		return stdDiseaseDao.findByHql("from ImageBasic where system = '0030' and nvl(stopedflag, 0) = 0 order by id desc");
	}
}