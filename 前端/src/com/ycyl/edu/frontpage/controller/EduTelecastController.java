package com.ycyl.edu.frontpage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.frontpage.service.EduTelecastService;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.service.EduCoursewareService;
import com.ycyl.edu.system.service.EduTeacherService;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/telecast")
public class EduTelecastController {
	
	@Autowired
	private EduTelecastService eduTelecastService;
	
}
