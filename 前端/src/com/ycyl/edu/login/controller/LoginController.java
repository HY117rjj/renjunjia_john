package com.ycyl.edu.login.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.bean.SessionInfo;
import com.ycyl.edu.login.service.LoginService;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduLog;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.service.EduCoursewareService;
import com.ycyl.edu.system.service.EduLectureService;
import com.ycyl.edu.system.service.EduLogService;
import com.ycyl.edu.system.service.EduTeacherService;
import com.ycyl.edu.util.DateUtil;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.SimManagerUtil;
import com.ycyl.edu.util.StringUtil;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EduCoursewareService eduCoursewareService;
	
	@Autowired
	private EduTeacherService eduTeacherService;
	
	@Autowired
	private EduLectureService eduLectureService;
	
	@Autowired
	private EduLogService eduLogService;
	
	@RequestMapping(value="systemlogin")
	public String systemlogin(){
		return "system/admin/admin_login";
	}
	
	@RequestMapping(value = "/systemLoading")
	public ModelAndView systemLoading(@RequestParam("user") String userName, @RequestParam("password")String password, @RequestParam("admin")String admin, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Json json = new Json();
		try {
			EduStudent user = loginService.checkUser(userName, password, admin);
			if (user != null) {
				request.getSession().setAttribute("user", user);		
				Cookie codecookie = new Cookie("userName", user.getUserName());				
    			codecookie.setMaxAge(1000000000);			
    			response.addCookie(codecookie);
    			ArrayList<String> resourceAllList = new ArrayList<String>();
    			ArrayList<String> resourceList = new ArrayList<String>();
    			resourceAllList.add("/teacher/list.do");
    			resourceAllList.add("/courseware/list.do");
    			resourceAllList.add("/lecture/list.do");
    			resourceAllList.add("/project/list.do");
    			resourceAllList.add("/student/list.do");
    			resourceAllList.add("/eduser/list.do");
    			resourceAllList.add("/chair/list.do");
    			resourceAllList.add("/demand/list.do");
    			resourceAllList.add("/telecast/list.do");
    			resourceAllList.add("/demand/listHE.do");
    			if("1".equals(admin)){// 管理员
    				resourceList.add("/teacher/list.do");
    				resourceList.add("/courseware/list.do");
    				resourceList.add("/lecture/list.do");
    				resourceList.add("/project/list.do");
    				resourceList.add("/student/list.do");
    				resourceList.add("/eduser/list.do");
    			}else if("2".equals(admin)){// 学员
    				resourceList.add("/chair/list.do");
    				resourceList.add("/telecast/list.do");
    			}else if("3".equals(admin)){// 游客
    				resourceList.add("/demand/list.do");
    				resourceList.add("/demand/listHE.do");
    				resourceList.add("/telecast/list.do");
    			}
    				
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setId(user.getId());
				sessionInfo.setLoginName(user.getUserName());
				sessionInfo.setName(user.getName());
				sessionInfo.setSimManager(user.getSimManager());
				sessionInfo.setRole(user.getRole());
				request.getSession().setAttribute("sessionInfo", sessionInfo);
				sessionInfo.setResourceAllList(resourceAllList);
				sessionInfo.setResourceList(resourceList);

				json.setStatusCode(Json.STAE_CODE_SUCCESS);
				json.setMessage("登陆成功！");	
				
				if("0".equals(user.getState())){
					json.setStatusCode(Json.STAE_CODE_ERROR);
					json.setMessage("此用户已被管理员限制登录！");
					if("2".equals(admin) || "3".equals(admin)){
						return new ModelAndView("login").addObject("msg", json).addObject("loginFailure", "1");
					}
					return new ModelAndView("system/admin/admin_login").addObject("msg", json).addObject("loginFailure", "1");
				}else{
					if("2".equals(admin) || "3".equals(admin)){
						return index(request.getSession());
//						return new ModelAndView("edu/frontpage/index").addObject("msg", json);
					}
					
					EduLog log = new EduLog();
					String name = user.getName();
					log.setName(name);
					log.setUserName(user.getUserName());
					String simManager = user.getSimManager();
					log.setSimManager(simManager);
					String content = SimManagerUtil.getSimManagerName(simManager) + "：" + name + "，在 " + DateUtil.dateTime2Str(new Date()) + " " + "登录系统。";
					log.setContent(content);
					log.setRecordTime(new Timestamp(new Date().getTime()));
					eduLogService.saveOrUpdate(log);
					return new ModelAndView("system/admin/admin_index").addObject("msg", json);
				}
			} else{
				json.setStatusCode(Json.STAE_CODE_ERROR);
				json.setMessage("用户名不存在或者密码错误！");
				if("2".equals(admin) || "3".equals(admin)){
					return new ModelAndView("login").addObject("msg", json).addObject("loginFailure", "1");
				}
				return new ModelAndView("system/admin/admin_login").addObject("msg", json).addObject("loginFailure", "1");
			}
		} catch (Exception e) {			
			json.setStatusCode(Json.STAE_CODE_ERROR);
			json.setMessage("数据库连接出错！请检查你的网络或者联系数据库管理员！");
			e.printStackTrace();
		}
		if("2".equals(admin) || "3".equals(admin)){
			return new ModelAndView("login").addObject("msg", json).addObject("loginFailure", "1");
		}
//		String msg = JsonUtil.toJson(json);
		return new ModelAndView("system/admin/admin_login").addObject("msg", json).addObject("loginFailure", "1");
	}
	
	@RequestMapping(value="login")
	public String login(){
//		return "login";
		return "system/admin/admin_login";
	}
	
	@RequestMapping(value="systemindex")
	public String systemindex(){
		return "system/admin/admin_index";
	}
	
	@RequestMapping(value="index")
	@SuppressWarnings("all")
	public ModelAndView index(HttpSession session){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, String> subjectMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("SubjectMap").get(0);
//		String sql = "from EduCourseware where coverImage is not null and addressLink is not null and nvl(onDemandCharge, 0) = 0 order by stickyPosts,id desc";
		String sql = "from EduCourseware where coverImage is not null and addressLink is not null and release = 0 order by stickyPosts,id desc";
		List<EduCourseware> list = eduCoursewareService.getCurrentPageList(sql, 0, 8);	
		for(EduCourseware cw : list){
//			cw.setSubject(subjectMap.get(cw.getSubject()));
			String teachingTime_ = cw.getTeachingTime_();
			if(!StringUtil.isEmpyOrNull(teachingTime_)){
				cw.setTeachingTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
			}
		}
		
		List list2 = (List<Object[]>)eduTeacherService.findTeacherForFrontPage();
		
		String sql3 = "from EduLecture order by teachingTime_ desc";
		List<EduLecture> list3 = eduLectureService.getCurrentPageList(sql3, 0, 6);	
		for(EduLecture lec : list3){
			String teachingTime_ = lec.getTeachingTime_();
			if(!StringUtil.isEmpyOrNull(teachingTime_)){
				lec.setTeachingTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
			}
		}
		
		model.put("courseware", list);
		model.put("teacher", list2);
		model.put("lecture", list3);
		model.put("random", (int)(Math.random() * list2.size()));
		session.setAttribute("teacher", list2);
		model.put("image", ApplicationConstants.STD_MAP.get("ImageBasic"));
		return new ModelAndView("edu/frontpage/index", model);
	}
	
	@RequestMapping(value="moreVideo")
	@SuppressWarnings("all")
	public ModelAndView moreVideo(HttpSession session){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, String> subjectMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("SubjectMap").get(0);
//		String sql = "from EduCourseware where coverImage is not null and addressLink is not null and nvl(onDemandCharge, 0) = 0 order by stickyPosts,id desc";
		String sql = "from EduCourseware where coverImage is not null and addressLink is not null and release = 0 order by stickyPosts,id desc";
		List<EduCourseware> list = eduCoursewareService.getMoreVideoList(sql);
		for(EduCourseware cw : list){
//			cw.setSubject(subjectMap.get(cw.getSubject()));
			String teachingTime_ = cw.getTeachingTime_();
			if(!StringUtil.isEmpyOrNull(teachingTime_)){
				cw.setTeachingTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
			}
		}
		
//		List list2 = (List<Object[]>)eduTeacherService.findTeacherForFrontPage();
//		
//		String sql3 = "from EduLecture order by id desc";
//		List<EduLecture> list3 = eduLectureService.getCurrentPageList(sql3, 0, 6);	
//		for(EduLecture lec : list3){
//			String teachingTime_ = lec.getTeachingTime_();
//			if(!StringUtil.isEmpyOrNull(teachingTime_)){
//				lec.setTeachingTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
//			}
//		}
		
		model.put("courseware", list);
//		model.put("teacher", list2);
//		model.put("lecture", list3);
		return new ModelAndView("edu/frontpage/index_more_video", model);
	}
	
	@RequestMapping(value="moreTeacher")
	@SuppressWarnings("all")
	public ModelAndView moreTeacher(HttpSession session){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, String> subjectMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("SubjectMap").get(0);
//		String sql = "from EduCourseware where coverImage is not null and addressLink is not null and nvl(onDemandCharge, 0) = 0 order by stickyPosts,id desc";
		String sql = "from EduCourseware where coverImage is not null and addressLink is not null and release = 0 order by stickyPosts,id desc";
//		List<EduCourseware> list = eduCoursewareService.getMoreVideoList(sql);
//		for(EduCourseware cw : list){
////			cw.setSubject(subjectMap.get(cw.getSubject()));
//			String teachingTime_ = cw.getTeachingTime_();
//			if(!StringUtil.isEmpyOrNull(teachingTime_)){
//				cw.setTeachingTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
//			}
//		}
		
		List list2 = (List<Object[]>)eduTeacherService.findTeacherForFrontPage();
		
//		String sql3 = "from EduLecture order by id desc";
//		List<EduLecture> list3 = eduLectureService.getCurrentPageList(sql3, 0, 6);	
//		for(EduLecture lec : list3){
//			String teachingTime_ = lec.getTeachingTime_();
//			if(!StringUtil.isEmpyOrNull(teachingTime_)){
//				lec.setTeachingTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
//			}
//		}
		
//		model.put("courseware", list);
		model.put("teacher", list2);
//		model.put("lecture", list3);
		return new ModelAndView("edu/frontpage/index_more_teacher", model);
	}
	
	@RequestMapping(value="systemlogout")
	public String systemlogout(HttpSession session){
		session.invalidate();
		return "system/admin/admin_login";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.invalidate();
//		return "login";
		return "system/admin/admin_login";
	}
	
}