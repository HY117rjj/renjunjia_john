package com.ycyl.edu.std.service;

import java.util.List;

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


public interface StdService {

	public List<StdConsultationSubject> getAllStdConsultationSubjects();
	
	public List<StdPosttechnology> getAllStdPosttechnologys();
	
	public List<StdEducationalMajor> getAllStdEducationalMajors();
	
	public List<StdEduNature> getAllStdEduNatures();
	
	public List<StdEduModality> getAllStdEduModalitys();
	
	public List<StdDisease> getAllStdDiseases();
	
	public List<StdConsultationSubject> getAllStdConsultationSubject2s();
	
	public List<StdEducationalMajor> getAllStdEducationalMajor2s();
	
	public List<StdEduForm> getAllStdEduForms();
	
	public List<StdEduHealthCard> getAllStdEduHealthCards();
	
	public List<StdEduRelease> getAllStdEduReleases();
	
	public List<ImageBasic> getAllImageBasics();
}