package com.ycyl.edu.system.controller;

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
import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduLectureAppointment;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.service.EduLectureService;
import com.ycyl.edu.system.service.EduTeacherService;
import com.ycyl.edu.util.Dictionary;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.StringUtil;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/lecture")
public class EduLectureController {
	
	@Autowired
	private EduLectureService eduLectureService;
	
	@Autowired
	private EduTeacherService eduTeacherService;
	
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
		int totalRows = eduLectureService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduLecture> pd = new PageData<EduLecture>();
		List<EduLecture> list = eduLectureService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduLecture>());
		}
		
		return new ModelAndView("system/admin/admin_lecture").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeLecture")
	public ModelAndView removeLecture(Long id) throws Exception{
		Json json = null;
		try {
			eduLectureService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editLecture")
	public ModelAndView editLecture(Long id, Long sn) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduLecture lecture = new EduLecture();
		if(id != null){
			lecture = eduLectureService.getEduLectureById(id);
			if(sn == null){
				sn = lecture.getSerialNumber();
			}
		}else{
			if(sn != null){
				EduTeacher teacher = eduTeacherService.getEduTeacherById(sn);
				lecture.setName(teacher.getName());
				lecture.setIdcard(teacher.getIdcard());
				lecture.setSubject(teacher.getSubject());
				lecture.setMajor(teacher.getMajor());
			}
		}
		model.put("sn",sn);
		model.put("cw",lecture);
		model.put("zyxk", ApplicationConstants.STD_MAP.get("ConsultationSubject"));
		model.put("zlkm", ApplicationConstants.STD_MAP.get("EducationalMajor"));
		model.put("kclx", ApplicationConstants.STD_MAP.get("EduNature"));
		model.put("skxs", ApplicationConstants.STD_MAP.get("EduModality"));
		return new ModelAndView("system/admin/admin_lecture_edit", model);
	}
	
	@RequestMapping(value = "/saveLecture")
	public ModelAndView saveLecture(HttpServletRequest request, HttpServletResponse response, EduLecture lecture) throws Exception{
		Json json = null;
		try {
			eduLectureService.saveOrUpdate(lecture);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return list(request, response, 0, 0);
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduLecture where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	@RequestMapping(value = "/listAppointment")
	public ModelAndView listAppointment1(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception  {
		String sql = this.getAppointment1WhereSql(request);
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
		int totalRows = eduLectureService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduLecture> pd = new PageData<EduLecture>();
		List<EduLecture> list = eduLectureService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduLecture>());
		}
		
		return new ModelAndView("system/admin/admin_lecture_appoint_1").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/listAppointment2")
	public ModelAndView listAppointment2(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String sql = this.getAppointment2WhereSql(request);
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
		int totalRows = eduLectureService.getTotalAppointmentRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduLectureAppointment> pd = new PageData<EduLectureAppointment>();
		List<EduLectureAppointment> list = eduLectureService.getCurrentPageAppointmentList(sql, p.getStarRow(), p.getMaxRow());
		EduLecture eduLecture;
		for(EduLectureAppointment appointment : list){
			String teachingTime_ = appointment.getAppointmentTime_();
			if(!StringUtil.isEmpyOrNull(teachingTime_)){
				appointment.setAppointmentTime_(teachingTime_.length()>=10 ? teachingTime_.substring(0, 10) : teachingTime_);
			}
			eduLecture = eduLectureService.getEduLectureById(appointment.getSerialNumber());
			if(eduLecture != null){
				appointment.setTeacher(eduLecture.getName());
				appointment.setTitle(eduLecture.getTitle());
			}
		}
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduLectureAppointment>());
		}
		
		model.put("pd", pd);
		return new ModelAndView("system/admin/admin_lecture_appoint_2", model);
	}
	
	public String getAppointment1WhereSql(HttpServletRequest request){
		String sql = "from EduLecture t1 where 1=1 and exists(select 1 from EduLectureAppointment t2 where t1.id = t2.serialNumber)";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	public String getAppointment2WhereSql(HttpServletRequest request){
		String sql = "from EduLectureAppointment where 1=1";
		
		String serialNumber = request.getParameter("sn");
		if (serialNumber != null && !"".equals(serialNumber)) {
			sql += " and serialNumber = '" + serialNumber + "'";
		}
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
}
