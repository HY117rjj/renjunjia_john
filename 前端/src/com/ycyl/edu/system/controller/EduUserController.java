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
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduStudentDetails;
import com.ycyl.edu.system.entity.EduUser;
import com.ycyl.edu.system.entity.EduUserDetails;
import com.ycyl.edu.system.service.EduUserService;
import com.ycyl.edu.util.DateUtil;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/eduser")
public class EduUserController {
	
	@Autowired
	private EduUserService eduUserService;
	
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
		int totalRows = eduUserService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduUser> pd = new PageData<EduUser>();
		List<EduUser> list = eduUserService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduUser>());
		}
		
		return new ModelAndView("system/admin/admin_eduser").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeEduUser")
	public ModelAndView removeEduUser(Long id) throws Exception{
		Json json = null;
		try {
			eduUserService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editEduUser")
	public ModelAndView editEduUser(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduUser eduUser = new EduUser();
		if(id != null){
			eduUser = eduUserService.getEduUserById(id);
		}
		model.put("eduser",eduUser);
		model.put("zyxk", ApplicationConstants.STD_MAP.get("ConsultationSubject"));
		model.put("zlkm", ApplicationConstants.STD_MAP.get("EducationalMajor"));
		return new ModelAndView("system/admin/admin_eduser_edit", model);
	}
	
	@RequestMapping(value = "/saveEduUser")
	public ModelAndView saveEduUser(HttpServletRequest request, HttpServletResponse response, EduUser eduUser) throws Exception{
		Json json = null;
		try {
			if(eduUser.getSignTime() == null){
				eduUser.setSignTime(new Timestamp(new Date().getTime()));
				eduUser.setSignTime_(DateUtil.date2Str(new Date()));
			}
			if(eduUser.getCharge() != null && eduUser.getCharge() <= 0){
//				eduUser.setCharge(0.0);
			}else{
				eduUser.setCharge(0.0);
			}
			eduUserService.saveOrUpdate(eduUser);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return list(request, response, 0, 0);
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduUser where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
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
		int totalRows = eduUserService.getTotalDetailsRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduUserDetails> pd = new PageData<EduUserDetails>();
		List<EduUserDetails> list = eduUserService.getCurrentPageDetailsList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduUserDetails>());
		}
		
		return new ModelAndView("system/admin/admin_eduser_details").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeEduUserDetails")
	public ModelAndView removeEduUserDetails(Long id) throws Exception{
		Json json = null;
		try {
			eduUserService.deleteDetails(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editEduUserDetails")
	public ModelAndView editEduUserDetails(Long id, Long sn) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduUserDetails eduUserDetails = new EduUserDetails();
		if(id != null){
			eduUserDetails = eduUserService.getEduUserDetailsById(id);
			if(sn == null){
				sn = eduUserDetails.getSerialNumber();
			}
		}else{
			if(sn != null){
				EduUser eduUser = eduUserService.getEduUserById(sn);
				eduUserDetails.setName(eduUser.getName());
				eduUserDetails.setIdcard(eduUser.getIdcard());
			}
		}
		model.put("eduserDetails", eduUserDetails);
		model.put("sn", sn);
		model.put("zyxk", ApplicationConstants.STD_MAP.get("ConsultationSubject"));
		model.put("zlkm", ApplicationConstants.STD_MAP.get("EducationalMajor"));
		return new ModelAndView("system/admin/admin_eduser_details_edit", model);
	}
	
	@RequestMapping(value = "/saveEduUserDetails")
	public ModelAndView saveEduUserDetails(HttpServletRequest request, HttpServletResponse response, EduUserDetails eduUserDetails) throws Exception{
		Json json = null;
		try {
			eduUserService.saveOrUpdateDetails(eduUserDetails);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return listDetails(request, response, 0, 0);
	}
	
	public String getDetailsWhereSql(HttpServletRequest request){
		String sql = "from EduUserDetails where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
}
