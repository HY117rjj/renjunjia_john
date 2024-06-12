package com.ycyl.edu.system.controller;

import java.util.ArrayList;
import java.util.Dictionary;
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
import com.ycyl.edu.system.entity.EduProject;
import com.ycyl.edu.system.service.EduCoursewareService;
import com.ycyl.edu.system.service.EduProjectService;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/project")
public class EduProjectController {
	
	@Autowired
	private EduProjectService eduProjectService;
	
	@Autowired
	private EduCoursewareService eduCoursewareService;
	
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
		int totalRows = eduProjectService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduProject> pd = new PageData<EduProject>();
		List<EduProject> list = eduProjectService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduProject>());
		}
		
		return new ModelAndView("system/admin/admin_project").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeProject")
	public ModelAndView removeProject(Long id) throws Exception{
		Json json = null;
		try {
			eduProjectService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editProject")
	public ModelAndView editProject(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduProject project = new EduProject();
		if(id != null){
			project = eduProjectService.getEduProjectById(id);
		}
		model.put("project",project);
		model.put("kj", this.getEduCWForPro());
		return new ModelAndView("system/admin/admin_project_edit", model);
	}
	
	@RequestMapping(value = "/saveProject")
	public ModelAndView saveProject(HttpServletRequest request, HttpServletResponse response, EduProject project) throws Exception{
		Json json = null;
		try {
			eduProjectService.saveOrUpdate(project);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return list(request, response, 0, 0);
	}
	
	public List<com.ycyl.edu.util.Dictionary> getEduCWForPro(){
		return eduCoursewareService.getEduCWForPro();
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduProject where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
}
