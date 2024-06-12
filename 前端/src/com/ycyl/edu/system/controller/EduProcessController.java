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
import com.ycyl.edu.system.entity.EduProcess;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.service.EduLogService;
import com.ycyl.edu.system.service.EduProcessService;
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
@RequestMapping(value="/process")
@Data
public class EduProcessController {
	
	@Autowired
	private EduProcessService eduProcessService;
	
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
		int totalRows = eduProcessService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduProcess> pd = new PageData<EduProcess>();
		List<EduProcess> list = eduProcessService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduProcess>());
		}
		
		return new ModelAndView("system/admin/admin_process").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeProcess")
	public ModelAndView removeProcess(Long id) throws Exception{
		Json json = null;
		try {
			eduProcessService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editProcess")
	public ModelAndView editProcess(HttpServletRequest request, HttpServletResponse response, Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduProcess process = new EduProcess();
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
		
		if(id != null){
			process = eduProcessService.getEduProcessById(id);
		}
		
		if("A".equals(sessionInfo.getSimManager())){
			process.setSystemUserName(sessionInfo.getLoginName());
			process.setSystemName(sessionInfo.getName());
		}else if("B".equals(sessionInfo.getSimManager())){
			process.setSecurityUserName(sessionInfo.getLoginName());
			process.setSecurityName(sessionInfo.getName());
		}
		
		model.put("process",process);
		return new ModelAndView("system/admin/admin_process_edit", model);
	}
	
	@RequestMapping(value = "/saveProcess")
	public ModelAndView saveProcess(HttpServletRequest request, HttpServletResponse response, EduProcess process) throws Exception{
		Json json = null;
		try {
			EduStudent user = (EduStudent)request.getSession().getAttribute("user");
			SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
			
			if(sessionInfo != null){
				EduLog log = new EduLog();
				String name = sessionInfo.getName();
				log.setName(name);
				log.setUserName(sessionInfo.getLoginName());
				String simManager = sessionInfo.getSimManager();
				log.setSimManager(simManager);
				String content = SimManagerUtil.getSimManagerName(simManager) + "：" + name + "，在 " + DateUtil.dateTime2Str(new Date());
				
				if("A".equals(sessionInfo.getSimManager())){
					content = content + "，申请：『" + process.getContent() + "』。";
				}else if("B".equals(sessionInfo.getSimManager())){
					content = content + "，" + process.getConclusion() + process.getSystemName() + "：『" + process.getContent() + "』的申请。";
				}else {
					content = "，进行了流程审批操作。";
				}
				
				log.setContent(content);
				log.setRecordTime(new Timestamp(new Date().getTime()));
				eduLogService.saveOrUpdate(log);
			}
			
			process.setRecordTime(new Timestamp(new Date().getTime()));
			eduProcessService.saveOrUpdate(process);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
//		return list(request, response, 0, 0);
		return new ModelAndView("redirect:/process/list.do");
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduProcess where 1=1";
		
		SessionInfo sessionInfo = (SessionInfo)request.getSession().getAttribute("sessionInfo");
		if(sessionInfo != null){
			String simManager = sessionInfo.getSimManager();
			if("A".equals(simManager)){
				sql += " and systemUserName = '" + sessionInfo.getLoginName() + "'";
			}
		}
		
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		
		return sql;
	}
}
