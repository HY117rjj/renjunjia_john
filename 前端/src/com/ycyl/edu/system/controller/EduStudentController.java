package com.ycyl.edu.system.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import com.ycyl.edu.bean.SessionInfo;
import com.ycyl.edu.system.entity.EduLog;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduStudentDetails;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.entity.EduUser;
import com.ycyl.edu.system.service.EduLogService;
import com.ycyl.edu.system.service.EduStudentService;
import com.ycyl.edu.system.service.EduUserService;
import com.ycyl.edu.util.DateUtil;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.MD5;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.SimManagerUtil;
import com.ycyl.edu.util.StringUtil;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/student")
public class EduStudentController {
	
	@Autowired
	private EduStudentService eduStudentService;
	
	@Autowired
	private EduUserService eduUserService;
	
	@Autowired
	private EduLogService eduLogService;
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception  {
		String sql = this.getWhereSql(request);
		if (page == null || page <= 0) {
			page = 1;
		}
		if (rows == null || rows <= 0) {
			rows = 10;
		}

		Page p = new Page();
		p.setNumPerPage(rows);
		p.setPageNum(page);
		
		//得到要查询列表的总行数
		int totalRows = eduStudentService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduStudent> pd = new PageData<EduStudent>();
		List<EduStudent> list = eduStudentService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduStudent>());
		}
		
		return new ModelAndView("system/admin/admin_student").addObject("pd", pd).addObject("name", request.getParameter("name"));
	}
	
	@RequestMapping(value = "/removeStudent")
	public ModelAndView removeStudent(Long id) throws Exception{
		Json json = null;
		try {
			eduStudentService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editStudent")
	public ModelAndView editStudent(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduStudent student = new EduStudent();
		if(id != null){
			student = eduStudentService.getEduStudentById(id);
		}
		model.put("student",student);
		model.put("xyzc", ApplicationConstants.STD_MAP.get("Posttechnology"));
		return new ModelAndView("system/admin/admin_student_edit", model);
	}
	
	@RequestMapping(value = "/editPersonalData")
	public ModelAndView editPersonalData(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduStudent student = new EduStudent();
		if(id != null){
			student = eduStudentService.getEduStudentById(id);
		}
		model.put("student",student);
		model.put("xyzc", ApplicationConstants.STD_MAP.get("Posttechnology"));
		return new ModelAndView("system/admin/admin_personal_data", model);
	}
	
	@RequestMapping(value = "/editPersonalDataFP")
	public ModelAndView editPersonalDataFP(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduStudent student = new EduStudent();
		if(id != null){
			student = eduStudentService.getEduStudentById(id);
		}
		model.put("student",student);
		model.put("xyzc", ApplicationConstants.STD_MAP.get("Posttechnology"));
		return new ModelAndView("edu/frontpage/personal", model);
	}
	
	@RequestMapping(value = "/editPersonalDataRegister")
	public ModelAndView editPersonalDataRegister() throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("xyzc", ApplicationConstants.STD_MAP.get("Posttechnology"));
		return new ModelAndView("edu/frontpage/register", model);
	}
	
	@RequestMapping(value = "/saveStudent")
	public ModelAndView saveStudent(HttpServletRequest request, HttpServletResponse response, EduStudent student) throws Exception{
		Json json = null;
		try {
			if(student.getUserName() == null){
				student.setUserName(student.getIdcard());
			}
			if(student.getUserPass() == null){
//				student.setUserPass(new MD5().getStrByMD5("000000"));
			}
			
			EduStudent user = new EduStudent();
			SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
			if(sessionInfo != null){
				if("B".equals(sessionInfo.getSimManager())){
					EduLog log = new EduLog();
					String name = sessionInfo.getName();
					log.setName(name);
					log.setUserName(sessionInfo.getLoginName());
					String simManager = sessionInfo.getSimManager();
					log.setSimManager(simManager);
					
					String action = "";
					if(student.getId() != null){
						user = eduStudentService.getEduStudentById(student.getId());
						String roleBefore = user.getRole();
						String roleAfter = student.getRole();
						if(StringUtil.isEmpyOrNull(roleBefore) && !StringUtil.isEmpyOrNull(roleAfter)){
							action = "进行授权";
						}else if(!StringUtil.isEmpyOrNull(roleBefore) && !StringUtil.isEmpyOrNull(roleAfter)){
							action = "修改授权";
						}else if(!StringUtil.isEmpyOrNull(roleBefore) && StringUtil.isEmpyOrNull(roleAfter)){
							action = "撤销授权";
						}
						
						user.setSimManager(student.getSimManager());
						user.setRole(student.getRole());
						user.setState(student.getState());
						if(student.getUserPass() == null){
							user.setUserPass(new MD5().getStrByMD5(student.getUserPass()));
						}
					}
					
					String content = SimManagerUtil.getSimManagerName(simManager) + "：" + name + action + "系统管理员：" + student.getName() + "的账号权限。";
					log.setContent(content);
					log.setRecordTime(new Timestamp(new Date().getTime()));
					eduLogService.saveOrUpdate(log);
				}
			}
			
			if(user.getId() == null){
				user = student;
			}
			
			eduStudentService.saveOrUpdate(user);
			json = new Json(Json.STAE_CODE_SUCCESS, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "保存失败");
		}
//		return list(request, response, 0, 0);
		return new ModelAndView("redirect:/student/list.do");
	}
	
	@RequestMapping(value = "/savePersonalData")
	public ModelAndView savePersonalData(HttpServletRequest request, HttpServletResponse response, EduStudent student) throws Exception{
		Json json = null;
		try {
			if(student.getUserName() == null){
				student.setUserName(student.getIdcard());
			}
			if(student.getUserPass() == null){
				student.setUserPass(new MD5().getStrByMD5("000000"));
			}else{
				student.setUserPass(new MD5().getStrByMD5(student.getUserPass()));
			}
			eduStudentService.saveOrUpdate(student);
			json = new Json(Json.STAE_CODE_SUCCESS, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "保存失败");
		}
		return editPersonalData(student.getId());
	}
	
	@RequestMapping(value = "/savePersonalDataFP")
	public ModelAndView savePersonalDataFP(HttpServletRequest request, HttpServletResponse response, EduStudent student) throws Exception{
		Json json = null;
		try {
			if(student.getUserName() == null){
				student.setUserName(student.getIdcard());
			}
			if(student.getUserPass() == null){
				student.setUserPass(new MD5().getStrByMD5("000000"));
			}else{
				student.setUserPass(new MD5().getStrByMD5(student.getUserPass()));
			}
			eduStudentService.saveOrUpdate(student);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return editPersonalDataFP(student.getId());
	}
	
	@RequestMapping(value = "/savePersonalDataRegister")
	public ModelAndView savePersonalDataRegister(HttpServletRequest request, HttpServletResponse response, EduStudent student) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		Json json = null;
		
		try {
			String userName = student.getUserName();
			Boolean isDupcate = eduStudentService.isDupcateUserName(student);
			json = new Json(Json.STAE_CODE_SUCCESS, "学号已存在，请重试！");
			if(isDupcate){
				model.put("student",student);
				model.put("xyzc", ApplicationConstants.STD_MAP.get("Posttechnology"));
				model.put("msg", json);
				model.put("isDupcate", "1");
				return new ModelAndView("edu/frontpage/register", model);
			}
			
			if(student.getUserPass() == null){
				student.setUserPass(new MD5().getStrByMD5("000000"));
			}else{
				student.setUserPass(new MD5().getStrByMD5(student.getUserPass()));
			}
			student.setState("0");// 教师审核后才能登陆
			EduUser eduUser = new EduUser();
			eduUser.setIdcard(student.getIdcard());
			eduUser.setName(student.getName());
			eduUser.setCharge(0.0);
			eduUser.setSignTime(new Timestamp(new Date().getTime()));
			eduUser.setSignTime_(DateUtil.getCurrentDate());
			eduStudentService.saveOrUpdate(student);
			eduUserService.saveOrUpdate(eduUser);
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "注册失败");
		}
		return new ModelAndView("system/admin/admin_login");
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduStudent where 1=1";
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
		if(sessionInfo != null){
			if("B".equals(sessionInfo.getSimManager())){
				sql += " and simManager = 'A'";
			}
		}
		
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and (name like '%" + name.trim() + "%' or idcard like '%" + name.trim() + "%')";
		}
		return sql;
	}
	
	@RequestMapping(value = "/listDetails")
	public ModelAndView listDetails(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception  {
		String sql = this.getDetailsWhereSql(request);
		if (page == null || page <= 0) {
			page = 1;
		}
		if (rows == null || rows <= 0) {
			rows = 10;
		}

		Page p = new Page();
		p.setNumPerPage(rows);
		p.setPageNum(page);
		
		//得到要查询列表的总行数
		int totalRows = eduStudentService.getTotalDetailsRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduStudentDetails> pd = new PageData<EduStudentDetails>();
		sql +=" order by serialNumber,id";
		List<EduStudentDetails> list = eduStudentService.getCurrentPageDetailsList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduStudentDetails>());
		}
		
		return new ModelAndView("system/admin/admin_student_details").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeStudentDetails")
	public ModelAndView removeStudentDetails(Long id) throws Exception{
		Json json = null;
		try {
			eduStudentService.deleteDetails(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editStudentDetails")
	public ModelAndView editStudentDetails(Long id, Long sn) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduStudentDetails studentDetails = new EduStudentDetails();
		if(id != null){
			studentDetails = eduStudentService.getEduStudentDetailsById(id);
			if(sn == null){
				sn = studentDetails.getSerialNumber();
			}
		}else{
			if(sn != null){
				EduStudent student = eduStudentService.getEduStudentById(sn);
				studentDetails.setName(student.getName());
				studentDetails.setIdcard(student.getIdcard());
			}
		}
		model.put("sn",sn);
		model.put("studentDetails",studentDetails);
		model.put("xyzc", ApplicationConstants.STD_MAP.get("Posttechnology"));
		return new ModelAndView("system/admin/admin_student_details_edit", model);
	}
	
	@RequestMapping(value = "/saveStudentDetails")
	public ModelAndView saveStudentDetails(HttpServletRequest request, HttpServletResponse response, EduStudentDetails studentDetails) throws Exception{
		Json json = null;
		try {
			eduStudentService.saveOrUpdateDetails(studentDetails);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return listDetails(request, response, 0, 0);
	}
	
	public String getDetailsWhereSql(HttpServletRequest request){
		String sql = "from EduStudentDetails where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		String sn = request.getParameter("sn");
		if(sn != null && !"".equals(sn)){
			sql += " and serialNumber = '" + sn.trim() + "'";
		}
		return sql;
	}
}
