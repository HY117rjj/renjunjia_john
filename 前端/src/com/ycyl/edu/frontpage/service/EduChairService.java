package com.ycyl.edu.frontpage.service;

import java.util.List;

import lombok.Data;

import com.ycyl.edu.system.dao.EduCoursewareDAO;
import com.ycyl.edu.system.dao.EduUserDAO;
import com.ycyl.edu.system.dao.EduUserDetailsDAO;

@SuppressWarnings("all")
public interface EduChairService {
	
	public List<String> getAllCSTypeCode(String type);
}