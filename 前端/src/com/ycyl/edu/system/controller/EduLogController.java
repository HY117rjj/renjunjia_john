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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ycyl.edu.bean.SessionInfo;
import com.ycyl.edu.system.entity.EduLog;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.service.EduLogService;
import com.ycyl.edu.util.DateUtil;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.SimManagerUtil;
import com.ycyl.edu.util.StringUtil;
import com.ycyl.edu.util.UUIDGenerator;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/log")
@Data
public class EduLogController {
	
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
		int totalRows = eduLogService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduLog> pd = new PageData<EduLog>();
		List<EduLog> list = eduLogService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduLog>());
		}
		
		return new ModelAndView("system/admin/admin_log").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeLog")
	public ModelAndView removeLog(Long id) throws Exception{
		Json json = null;
		try {
			eduLogService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editLog")
	public ModelAndView editLog(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduLog notice = new EduLog();
		if(id != null){
			notice = eduLogService.getEduLogById(id);
		}
		model.put("notice",notice);
		return new ModelAndView("system/admin/admin_log_edit", model);
	}
	
	@RequestMapping(value = "/saveLog")
	public ModelAndView saveLog(HttpServletRequest request, HttpServletResponse response, EduLog log) throws Exception{
		Json json = null;
		try {
			EduStudent user = (EduStudent)request.getSession().getAttribute("user");
			log.setRecordTime(new Timestamp(new Date().getTime()));
			eduLogService.saveOrUpdate(log);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return list(request, response, 0, 0);
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduLog where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	@RequestMapping(value = "/listLogFile")
	public ModelAndView listLogFile(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception  {
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
		int totalRows = 1;
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduLog> pd = new PageData<EduLog>();
		List<EduLog> list = new ArrayList<EduLog>();	
		
		String logFile = "";
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
		if(sessionInfo != null){
			if("A".equals(sessionInfo.getSimManager())){
				EduLog log = new EduLog();
				String name = sessionInfo.getName();
				log.setName(name);
				log.setUserName(sessionInfo.getLoginName());
				String simManager = sessionInfo.getSimManager();
				log.setSimManager(simManager);
				
				String role = sessionInfo.getRole();
				
				String action = "";
				
				if("role1".equals(role)){
					action =  "将X文件填入系统";
				}else if("role2".equals(role)){
					action =  "修改X文件";
				}else if("role3".equals(role)){
					action =  "删除X文件";
				}else {
					action =  "提交审批操作X文件";
				}

				String content = SimManagerUtil.getSimManagerName(simManager) + "：" + name + "，在 " + DateUtil.dateTime2Str(new Date()) + " " + action + "。";
				logFile = content;
				log.setContent(content);
				list.add(log);
				log.setRecordTime(new Timestamp(new Date().getTime()));
				eduLogService.saveOrUpdate(log);
			}
		}
		
		pd.setTotal(totalRows);
		pd.setTotalPage(p.getTotalPage());
		pd.setRows(list);
		
		return new ModelAndView("system/admin/admin_log_file").addObject("pd", pd);
	}
}
