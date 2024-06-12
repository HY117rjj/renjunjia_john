package com.ycyl.edu.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.system.entity.EduTeacher;
import com.ycyl.edu.system.service.EduTeacherService;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/teacher")
public class EduTeacherController {
	
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
		int totalRows = eduTeacherService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduTeacher> pd = new PageData<EduTeacher>();
		List<EduTeacher> list = eduTeacherService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduTeacher>());
		}
		
		return new ModelAndView("system/admin/admin_teacher").addObject("pd", pd).addObject("seach",request.getParameter("seach"));
	}
	
	@RequestMapping(value = "/removeTeacher")
	public ModelAndView removeTeacher(Long id) throws Exception{
		Json json = null;
		try {
			eduTeacherService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editTeacher")
	public ModelAndView editTeacher(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduTeacher teacher = new EduTeacher();
		if(id != null){
			teacher = eduTeacherService.getEduTeacherById(id);
		}
		model.put("teacher",teacher);
		model.put("zyxk", ApplicationConstants.STD_MAP.get("ConsultationSubject"));
		model.put("zlkm", ApplicationConstants.STD_MAP.get("EducationalMajor"));
		return new ModelAndView("system/admin/admin_teacher_edit", model);
	}
	
	@RequestMapping(value = "/saveTeacher")
	public ModelAndView saveTeacher(HttpServletRequest request, HttpServletResponse response, EduTeacher teacher) throws Exception{
		Json json = null;
		try {
			eduTeacherService.saveOrUpdate(teacher);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return list(request, response, 0, 0);
	}
	
	@RequestMapping(value = "/getAvailableTeacher")
	public void getAvailableTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<Object[]> teacList = eduTeacherService.getAllAvailableTeacher();
		String strings[] = new String[teacList.size()];
		String str = "";
		int i = 0;
		for(Object[] obj : teacList){
			strings[i] = obj[0]+" "+obj[1] + " "+obj[2];
			i++;
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("d", strings);
		jsonObject.put("n", ApplicationConstants.STD_MAP.get("DiseaseString").get(0));
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
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduTeacher where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		String type = request.getParameter("type");
		String seach = request.getParameter("seach");
		if(seach != null){
//			seach = URLDecoder.decode(seach, "UTF-8");
			if (type != null && !"".equals(type)) {
				if("1".equals(type)){
					if (seach != null && !"".equals(seach)) {
						sql += " and name like '" + seach.trim() + "%'";
					}
				}else if("2".equals(type)){
					if (seach != null && !"".equals(seach)) {
						sql += " and idcard like '" + seach.trim() + "%'";
					}
				}else{
					sql += " and (idcard like '" + seach.trim() + "%' or name like '" + seach.trim() + "%')";
				}
			}
		}
		return sql;
	}
}
