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
import com.ycyl.edu.system.entity.EduCase;
import com.ycyl.edu.system.entity.EduCaseMessage;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.service.EduCaseService;
import com.ycyl.edu.system.service.EduTeacherService;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.StringUtil;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/case")
public class EduCaseWareController {
	
	@Autowired
	private EduTeacherService eduTeacherService;
	
	@Autowired
	private EduCaseService eduCaseService;
	
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
		int totalRows = eduCaseService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduCase> pd = new PageData<EduCase>();
		List<EduCase> list = eduCaseService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduCase>());
		}
		
		return new ModelAndView("system/admin/admin_case").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeCase")
	public ModelAndView removeCase(Long id) throws Exception{
		Json json = null;
		try {
			eduCaseService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editCase")
	public ModelAndView editCase(HttpServletRequest request, Long id, Long sn) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduCase cw = new EduCase();
		if(id != null){
			cw = eduCaseService.getEduCaseById(id);
		}else {
			SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
			if(sessionInfo != null){
				cw.setName(sessionInfo.getName());
			}
		}
		
		model.put("cw",cw);
		model.put("sn",sn);
		return new ModelAndView("system/admin/admin_case_edit", model);
	}
	
	@RequestMapping(value = "/saveCase")
	public ModelAndView saveCase(HttpServletRequest request, HttpServletResponse response, EduCase cw) throws Exception{
		Json json = null;
		try {
			cw.setRecordTime(new Timestamp(new Date().getTime()));
			eduCaseService.saveOrUpdate(cw);
			json = new Json(Json.STAE_CODE_SUCCESS, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "保存失败");
		}
		return list(request, response, 0, 0);
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduCase where 1=1";
		
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
		int totalRows = eduCaseService.getMessageTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduCaseMessage> pd = new PageData<EduCaseMessage>();
		List<EduCaseMessage> list = eduCaseService.getMessageCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduCaseMessage>());
		}
		
		return new ModelAndView("system/admin/admin_casemessage").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeCaseMessage")
	public ModelAndView removeCaseMessage(Long id) throws Exception{
		Json json = null;
		try {
			eduCaseService.deleteMessage(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/addCaseMessage")
	public ModelAndView addCaseMessage(HttpServletRequest request, Long serialNumber, String caseContent) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduCaseMessage cw = new EduCaseMessage();
		cw.setSerialNumber(serialNumber);
		
		if(serialNumber != null){
			EduCase eduCase = eduCaseService.getEduCaseById(serialNumber);
			cw.setIdcard(eduCase.getIdcard());
			cw.setName(eduCase.getName());
			cw.setCaseContent(eduCase.getCaseContent());
		}
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
		if(sessionInfo != null){
			cw.setMessagerName(sessionInfo.getName());
		}
		
		model.put("cw",cw);
		return new ModelAndView("system/admin/admin_casemessage_edit", model);
	}
	
	@RequestMapping(value = "/editCaseMessage")
	public ModelAndView editCaseMessage(HttpServletRequest request, Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduCaseMessage cw = new EduCaseMessage();
		if(id != null){
			cw = eduCaseService.getEduCaseMessageById(id);
		}else {
			SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
			if(sessionInfo != null){
				cw.setMessagerName(sessionInfo.getName());
			}
		}
		
		model.put("cw",cw);
		return new ModelAndView("system/admin/admin_casemessage_edit", model);
	}
	
	@RequestMapping(value = "/saveCaseMessage")
	public ModelAndView saveCaseMessage(HttpServletRequest request, HttpServletResponse response, EduCaseMessage cw) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		Json json = null;
		try {
			SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
			if(sessionInfo != null){
				cw.setMessagerName(sessionInfo.getName());
//				request.setAttribute("messagerName", sessionInfo.getName());
			}
			cw.setRecordTime(new Timestamp(new Date().getTime()));
			eduCaseService.saveOrUpdateMessage(cw);
			json = new Json(Json.STAE_CODE_SUCCESS, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "保存失败");
		}
		model.put("cw",cw);
		
//		return new ModelAndView("system/admin/admin_casemessage_edit", model);
//		return listMessage(request, response, 0, 0);
		model.put("serialNumber", cw.getSerialNumber());
		return new ModelAndView("redirect:/case/listMessage.do", model);
	}
	
	public String getMessageWhereSql(HttpServletRequest request){
		String sql = "from EduCaseMessage where 1=1";
		
		String serialNumber = request.getParameter("serialNumber");
		if (serialNumber != null && !"".equals(serialNumber)) {
			sql += " and serialNumber = " + serialNumber + "";
		}
		
		String caseContent = request.getParameter("caseContent");
		if (caseContent != null && !"".equals(caseContent)) {
			sql += " and caseContent = '" + caseContent.trim() + "'";
		}
		
		String messagerName = request.getParameter("messagerName");
		if (messagerName != null && !"".equals(messagerName)) {
			sql += " and messagerName = '" + messagerName.trim() + "'";
		}
		return sql;
	}
}
