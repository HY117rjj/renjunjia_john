package com.ycyl.edu.system.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.bean.SessionInfo;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduCoursewareMessage;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.service.EduCoursewareService;
import com.ycyl.edu.system.service.EduTeacherService;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.StringUtil;
import com.ycyl.edu.util.UUIDGenerator;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/courseware")
public class EduCourseWareController {
	
	@Autowired
	private EduCoursewareService eduCoursewareService;
	
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
		int totalRows = eduCoursewareService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduCourseware> pd = new PageData<EduCourseware>();
		List<EduCourseware> list = eduCoursewareService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduCourseware>());
		}
		
		return new ModelAndView("system/admin/admin_courseware").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeCourseware")
	public ModelAndView removeCourseware(Long id) throws Exception{
		Json json = null;
		try {
			eduCoursewareService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editCourseware")
	public ModelAndView editCourseware(HttpServletRequest request, Long id, Long sn) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduCourseware cw = new EduCourseware();
		if(id != null){
			cw = eduCoursewareService.getEduCoursewareById(id);
			if(sn == null){
				sn = cw.getSerialNumber();
			}
		}else{
			if(sn != null){
				EduTeacher teacher = eduTeacherService.getEduTeacherById(sn);
				cw.setName(teacher.getName());
				cw.setIdcard(teacher.getIdcard());
				cw.setSubject(teacher.getSubject());
				cw.setMajor(teacher.getMajor());
			}
		}
		/*******************清空上次上传记录*************************/
		request.getSession().setAttribute("imageUUID", "");
		request.getSession().setAttribute("videoUUID", "");
		request.getSession().setAttribute("docUUID", "");
		
		model.put("cw",cw);
		model.put("sn",sn);
		model.put("ypfl", eduCoursewareService.getStdDrugList());
		model.put("zyxk", ApplicationConstants.STD_MAP.get("ConsultationSubject"));
		model.put("zlkm", ApplicationConstants.STD_MAP.get("EducationalMajor"));
		model.put("kclx", ApplicationConstants.STD_MAP.get("EduNature"));
		model.put("cxxs", ApplicationConstants.STD_MAP.get("Form"));
		model.put("jkjy", ApplicationConstants.STD_MAP.get("HealthCard"));
		model.put("fbdx", ApplicationConstants.STD_MAP.get("Release"));
		return new ModelAndView("system/admin/admin_courseware_edit", model);
	}
	
	@RequestMapping(value = "/uploading")
	public void uploading(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Json json = null;
		String prifix = "";
		try {
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;

			List<MultipartFile> files = mRequest.getFiles("file");
//			String uploadDir = request.getSession().getServletContext().getRealPath("/") + "\\Media\\";
			String uploadDir = "S:\\Media\\";
			File file = new File(uploadDir);
			if (!file.exists()) {
				file.mkdirs();
			}

			String fileName = null;
			for (MultipartFile mFile : files) {
				fileName = mFile.getOriginalFilename();
				if (fileName == "") {
					break;
				}
				prifix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
				String storeName = UUIDGenerator.getUUID()+prifix; // 上传后新文件名
				if(".png".equals(prifix) || ".jpg".equals(prifix)){
					uploadDir += "Image\\";
					request.getSession().setAttribute("imageUUID", "Image\\" + storeName);
				}else if(prifix.startsWith(".doc") || ".pdf".equals(prifix) || prifix.startsWith(".ppt") ){
					uploadDir += "Docment\\";
					request.getSession().setAttribute("docUUID", "Docment\\" + storeName);
				}else if(prifix.startsWith(".mp4") || prifix.startsWith(".wmv")){
					uploadDir += "Video\\";
					request.getSession().setAttribute("videoUUID", "Video\\" + storeName);
				}else {
					uploadDir += "Other\\";
					request.getSession().setAttribute("videoUUID", "Other\\" + storeName);
				}
				String noZipName = uploadDir + storeName;
				BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(noZipName));
				FileCopyUtils.copy(mFile.getInputStream(), outputStream);
			}
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", true);
			JSONObject dataObject = new JSONObject();
			dataObject.put("id", UUIDGenerator.getUUID());
			jsonObject.put("data", dataObject);
			jsonObject.put("message", "操作成功");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(jsonObject.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
	}
	
	@RequestMapping(value = "/saveCourseware")
	public ModelAndView saveCourseware(HttpServletRequest request, HttpServletResponse response, EduCourseware cw) throws Exception{
		Json json = null;
		try {
			String imageUUID = (String)request.getSession().getAttribute("imageUUID");
			String videoUUID = (String)request.getSession().getAttribute("videoUUID");
			String docUUID = (String)request.getSession().getAttribute("docUUID");
			if(!StringUtil.isEmpyOrNull(imageUUID)){
				cw.setCoverImage(imageUUID);
			}
			if(!StringUtil.isEmpyOrNull(videoUUID)){
				cw.setAddressLink(videoUUID);
			}
			if(!StringUtil.isEmpyOrNull(docUUID)){
				cw.setAttachmentLink(docUUID);
			}
			eduCoursewareService.saveOrUpdate(cw);
			json = new Json(Json.STAE_CODE_SUCCESS, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "保存失败");
		}
		return list(request, response, 0, 0);
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduCourseware where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	/***********************************7.6.1 课程实训系统留言数据表****************************************/
	
	@RequestMapping(value = "/listMessage")
	public ModelAndView listMessage(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception  {
		String sql = this.getMessageWhereSql(request);
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
		int totalRows = eduCoursewareService.getMessageTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduCoursewareMessage> pd = new PageData<EduCoursewareMessage>();
		List<EduCoursewareMessage> list = eduCoursewareService.getMessageCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduCoursewareMessage>());
		}
		
		return new ModelAndView("system/admin/admin_coursewaremessage").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeCoursewareMessage")
	public ModelAndView removeCoursewareMessage(Long id) throws Exception{
		Json json = null;
		try {
			eduCoursewareService.deleteMessage(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/addCoursewareMessage")
	public ModelAndView addCoursewareMessage(HttpServletRequest request, Long serialNumber, String title) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduCoursewareMessage cw = new EduCoursewareMessage();
		cw.setSerialNumber(serialNumber);
		cw.setCourseware(title);
		
		model.put("cw",cw);
		return new ModelAndView("system/admin/admin_coursewaremessage_edit", model);
	}
	
	@RequestMapping(value = "/editCoursewareMessage")
	public ModelAndView editCoursewareMessage(HttpServletRequest request, Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduCoursewareMessage cw = new EduCoursewareMessage();
		if(id != null){
			cw = eduCoursewareService.getEduCoursewareMessageById(id);
		}
		
		model.put("cw",cw);
		return new ModelAndView("system/admin/admin_coursewaremessage_edit", model);
	}
	
	@RequestMapping(value = "/saveCoursewareMessage")
	public ModelAndView saveCoursewareMessage(HttpServletRequest request, HttpServletResponse response, EduCoursewareMessage cw) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		Json json = null;
		try {
			SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
			if(sessionInfo != null){
				cw.setOrganization(sessionInfo.getDwmc());
				cw.setMessagerName(sessionInfo.getName());
//				request.setAttribute("messagerName", sessionInfo.getName());
			}
			cw.setRecordTime(new Timestamp(new Date().getTime()));
			eduCoursewareService.saveOrUpdateMessage(cw);
			json = new Json(Json.STAE_CODE_SUCCESS, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "保存失败");
		}
		model.put("cw",cw);
		return new ModelAndView("system/admin/admin_coursewaremessage_edit", model);
//		return listMessage(request, response, 0, 0);
	}
	
	public String getMessageWhereSql(HttpServletRequest request){
		String sql = "from EduCoursewareMessage where 1=1";
		String courseware = request.getParameter("courseware");
		if (courseware != null && !"".equals(courseware)) {
			sql += " and courseware = '" + courseware.trim() + "'";
		}
		
		String messagerName = request.getParameter("messagerName");
		if (messagerName != null && !"".equals(messagerName)) {
			sql += " and messagerName = '" + messagerName.trim() + "'";
		}
		return sql;
	}
}
