package com.ycyl.edu.listener;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.std.entity.ImageBasic;
import com.ycyl.edu.std.entity.StdConsultationSubject;
import com.ycyl.edu.std.entity.StdEduForm;
import com.ycyl.edu.std.service.StdService;
import com.ycyl.edu.util.ListUtil;

public class MyContextListener implements ServletContextListener {

    // 服务器启动时调用
    public void contextInitialized(ServletContextEvent arg0) {
    	ApplicationConstants.START_DATE = new Date();//记录启动时间
      	ServletContext context = arg0.getServletContext();
      	WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
      	StdService stdService = (StdService)wc.getBean("stdService");
        
//      List<StdConsultationSubject> stdConsultationSubjectList = stdService.getAllStdConsultationSubjects();
//      List<StdPosttechnology> stdPosttechnologyList = stdService.getAllStdPosttechnologys();
//    	List<StdEducationalMajor> stdEducationalMajorList = stdService.getAllStdEducationalMajors();
//    	List<StdEduNature> stdEduNatureList = stdService.getAllStdEduNatures();
//    	List<StdEduModality> stdEduModalityList = stdService.getAllStdEduModalitys();
//    	List<StdDisease> stdDiseaseList = stdService.getAllStdDiseases();
//    	
    	List<StdEduForm> stdEduFormList = stdService.getAllStdEduForms();
//    	
//    	List<StdEduHealthCard> stdHealthCardList = stdService.getAllStdEduHealthCards();
//    	
    	List<StdConsultationSubject> stdConsultationSubject2List = stdService.getAllStdConsultationSubject2s();
     	Map<String, String> stdConsultationSubject2Map = new HashMap<>();
    	for(StdConsultationSubject subject : stdConsultationSubject2List){
    		stdConsultationSubject2Map.put(subject.getCode(), subject.getName());
     	}
//    	List<StdEducationalMajor> stdEducationalMajor2List = stdService.getAllStdEducationalMajor2s();
//    	Map<String, String> stdEducationalMajor2Map = new HashMap<>();
//    	for(StdEducationalMajor major : stdEducationalMajor2List){
//    		stdEducationalMajor2Map.put(major.getCode(), major.getName());
//     	}
//    	
//    	Map<String, String> stdDiseaseList2Map = new HashMap<>();
//    	for(StdDisease disease : stdDiseaseList){
//    		stdDiseaseList2Map.put(disease.getCode(), disease.getName());
//     	}
//    	
//    	List<StdEduRelease> stdEduReleaseList = stdService.getAllStdEduReleases();
//    	
//    	ApplicationConstants.STD_MAP.put("ConsultationSubject", stdConsultationSubjectList);
//    	ApplicationConstants.STD_MAP.put("Posttechnology", stdPosttechnologyList);
//    	ApplicationConstants.STD_MAP.put("EducationalMajor", stdEducationalMajorList);
//    	ApplicationConstants.STD_MAP.put("EduNature", stdEduNatureList);
//    	ApplicationConstants.STD_MAP.put("EduModality", stdEduModalityList);
//    	ApplicationConstants.STD_MAP.put("Disease", stdDiseaseList);
//    	
    	ArrayList<Map<String, String>> subject2List = new ArrayList<Map<String, String>>();
    	subject2List.add(stdConsultationSubject2Map);
//    	ArrayList<Map<String, String>> major2List = new ArrayList<Map<String, String>>();
//    	major2List.add(stdEducationalMajor2Map);
//    	ArrayList<Map<String, String>> disease2List = new ArrayList<Map<String, String>>();
//    	disease2List.add(stdDiseaseList2Map);
    	ApplicationConstants.STD_MAP.put("SubjectMap", subject2List);
//    	ApplicationConstants.STD_MAP.put("MajorMap", major2List);
//    	ApplicationConstants.STD_MAP.put("DiseaseMap", disease2List);
//    	
    	ApplicationConstants.STD_MAP.put("Form", stdEduFormList);
//    	
//    	ApplicationConstants.STD_MAP.put("HealthCard", stdHealthCardList);
//    	
//    	String strings[] = new String[stdDiseaseList.size()];
//		int i = 0;
//		for(StdDisease disease : stdDiseaseList){
//			strings[i] = disease.getCode()+" "+disease.getName()+" "+disease.getIndexcode();
//			i++;
//		}
//		ArrayList<String[]> disease3List = new ArrayList<String[]>();
//		disease3List.add(strings);
//		ApplicationConstants.STD_MAP.put("DiseaseString", disease3List);
//		
//		ApplicationConstants.STD_MAP.put("Release", stdEduReleaseList);
//		
		List<ImageBasic> imageBasics = stdService.getAllImageBasics();
		
		if(!ListUtil.isNullOrSizeZero(imageBasics) && imageBasics.size() > 8){
			imageBasics = imageBasics.subList(0, 8);
		}
		
		ApplicationConstants.STD_MAP.put("ImageBasic", imageBasics);
    }

    // 服务停止时调用
    public void contextDestroyed(ServletContextEvent arg0) {
        // 清空结果也可以保存
        ApplicationConstants.START_DATE = null;
        ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;
    }

}
