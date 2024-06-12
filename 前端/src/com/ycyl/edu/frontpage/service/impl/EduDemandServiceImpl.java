package com.ycyl.edu.frontpage.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.ycyl.edu.frontpage.service.EduDemandService;
import com.ycyl.edu.system.dao.EduCoursewareDAO;
import com.ycyl.edu.system.dao.EduUserDAO;
import com.ycyl.edu.system.dao.EduUserDetailsDAO;
import com.ycyl.edu.system.entity.EduCourseware;

@SuppressWarnings("all")
@Data
public class EduDemandServiceImpl implements EduDemandService{

	public EduCoursewareDAO eduCoursewareDao;
	public EduUserDAO eduUserDao;
	public EduUserDetailsDAO eduUserDetailsDao;
	
	public List<String> getAllCSTypeCode(String type){
		StringBuffer sql = new StringBuffer("select distinct ");
		String field = "";
		if("1".equals(type)){//1.专业学科（subject）
			field = "SUBJECT ";
		}else if("2".equals(type)){//2.临床专业（major）
			field = "MAJOR ";
		}else if("3".equals(type)){//3.疾病分类（icd）
			field = "ICD ";
		}else{//4.讲授教师（Name）
			field = "NAME ";
		}
		sql.append(field);
		sql.append("from EDU_COURSEWARE ");
		sql.append("where ").append(field).append(" is not null and ADDRESS_LINK is not null ");
		sql.append("order by ").append(field);
		List<String> csidList = new ArrayList<>();
		List<Object> csids = eduCoursewareDao.findByRealSql(sql.toString());
		for(Object obj : csids){
			csidList.add(obj.toString());
		}
		return csidList;
	}
	
	public List<String> getAllCSHETypeCode(String type){
		StringBuffer sql = new StringBuffer("select distinct ");
		String field = "";
		if("1".equals(type)){//1.专业学科（subject）
			field = "SUBJECT ";
		}else if("2".equals(type)){//2.临床专业（major）
			field = "MAJOR ";
		}else if("3".equals(type)){//3.疾病分类（icd）
			field = "ICD ";
		}else{//4.讲授教师（Name）
			field = "NAME ";
		}
		sql.append(field);
		sql.append("from EDU_COURSEWARE where NATURE = 1 ");
		sql.append("and ").append(field).append(" is not null and ADDRESS_LINK is not null ");
		sql.append("order by ").append(field);
		List<String> csidList = new ArrayList<>();
		List<Object> csids = eduCoursewareDao.findByRealSql(sql.toString());
		for(Object obj : csids){
			csidList.add(obj.toString());
		}
		return csidList;
	}
}