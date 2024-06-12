package com.ycyl.edu.frontpage.controller;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.frontpage.service.EduChairService;
import com.ycyl.edu.system.entity.EduLecture;
import com.ycyl.edu.system.entity.EduLectureAppointment;
import com.ycyl.edu.system.entity.EduNotice;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduStudentDetails;
import com.ycyl.edu.system.service.EduLectureService;
import com.ycyl.edu.system.service.EduStudentService;
import com.ycyl.edu.util.Dictionary;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.StringUtil;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/chair")
public class EduChairController {
	
	@Autowired
	private EduChairService eduChairService;
	
	@Autowired
	private EduLectureService eduLectureService;
	
	@Autowired
	private EduStudentService eduStudentService;
	
	private String type;//1.专业学科（subject）、2.临床专业（major）、3.疾病分类（icd）、4.讲授教师（Name）栏目
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduChairService.getAllCSTypeCode(type);
		if("1".equals(type)){//1.专业学科（subject）
			typeName = "专业学科";
			Map<String, String> subjectMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("SubjectMap").get(0);
			for(String code : csTypeCode){
				List<String> tempCodes = new ArrayList<>();
				List<Dictionary> tempDics = new ArrayList<>();
				tempCodes = this.getDicDatas(code, new ArrayList<String>(), 3);
				for(int i = tempCodes.size()-1; i >=0; i--){
					String tempCode = tempCodes.get(i);
					if(!csAllTypeCode.contains(tempCode)){
						csAllTypeCode.add(tempCode);
					}
				}
				if(!csAllTypeCode.contains(code)){
					csAllTypeCode.add(code);
				}
			}
			
			for(String typeCode : csAllTypeCode){
				String typeCodeName = subjectMap.get(typeCode);
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCodeName);
				if(typeCode.length() == 2){
					dic.setDataList(new ArrayList<Dictionary>());
					dicdata.add(dic);
				}else if(typeCode.length() == 5){
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							dic.setDataList(new ArrayList<Dictionary>());
							dic2.getDataList().add(dic);
							break;
						}
					}
				}else{
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							for(Dictionary dic3 : dic2.getDataList()){
								if(dic3.getCode().equals(typeCode.substring(0, 5))){
									dic3.getDataList().add(dic);
									break;
								}
							}
						}
					}
				}
			}
		}else if("2".equals(type)){//2.临床专业（major）
			typeName = "临床专业";
			Map<String, String> majorMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("MajorMap").get(0);
			for(String code : csTypeCode){
				List<String> tempCodes = new ArrayList<>();
				List<Dictionary> tempDics = new ArrayList<>();
				tempCodes = this.getDicDatas(code, new ArrayList<String>(), 2);
				for(int i = tempCodes.size()-1; i >=0; i--){
					String tempCode = tempCodes.get(i);
					if(!csAllTypeCode.contains(tempCode)){
						csAllTypeCode.add(tempCode);
					}
				}
				if(!csAllTypeCode.contains(code)){
					csAllTypeCode.add(code);
				}
			}
			
			for(String typeCode : csAllTypeCode){
				String typeCodeName = majorMap.get(typeCode);
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCodeName);
				if(typeCode.length() == 2){
					dic.setDataList(new ArrayList<Dictionary>());
					dicdata.add(dic);
				}else if(typeCode.length() == 4){
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							dic.setDataList(new ArrayList<Dictionary>());
							dic2.getDataList().add(dic);
							break;
						}
					}
				}else{
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							for(Dictionary dic3 : dic2.getDataList()){
								if(dic3.getCode().equals(typeCode.substring(0, 4))){
									dic3.getDataList().add(dic);
									break;
								}
							}
						}
					}
				}
			}
			
		}else if("3".equals(type)){//3.疾病分类（icd）
			typeName = "疾病分类";
			Map<String, String> diseaseMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("DiseaseMap").get(0);
			for(String typeCode : csTypeCode){
				if(typeCode.contains(",")){
					for(String tc : typeCode.split(",")){
						dic = new Dictionary();
						dic.setCode(tc);
						dic.setName(diseaseMap.get(tc));
						dicdata.add(dic);	
					}
				}else{
					dic = new Dictionary();
					dic.setCode(typeCode);
					dic.setName(diseaseMap.get(typeCode));
					dicdata.add(dic);
				}
			}
			
			for (int i = 0; i < dicdata.size(); i++){//外循环是循环的次数
                for (int j = dicdata.size() - 1 ; j > i; j--){//内循环是 外循环一次比较的次数
                    if (dicdata.get(i).getCode().equals(dicdata.get(j).getCode()) || dicdata.get(j).getCode().length() != 3){
                    	dicdata.remove(j);
                    }
                }
            }
			
		}else{//4.讲授教师（Name）
			typeName = "讲授教师";
			for(String typeCode : csTypeCode){
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCode);
				dicdata.add(dic);
			}
		}
		/***********************分页显示课件****************************/
		String code = request.getParameter("code");
		String sql = this.getWhereSql(request, code, type);
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("type", type);
		model.put("typeName", typeName);
		model.put("code", code);
		model.put("pd", pd);
		return new ModelAndView("edu/frontpage/chair", model);
	}
	
	@RequestMapping(value = "/listCourse")
	public ModelAndView listCourse(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduChairService.getAllCSTypeCode(type);
		if("1".equals(type)){//1.专业学科（subject）
			typeName = "专业学科";
			Map<String, String> subjectMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("SubjectMap").get(0);
			for(String code : csTypeCode){
				List<String> tempCodes = new ArrayList<>();
				List<Dictionary> tempDics = new ArrayList<>();
				tempCodes = this.getDicDatas(code, new ArrayList<String>(), 3);
				for(int i = tempCodes.size()-1; i >=0; i--){
					String tempCode = tempCodes.get(i);
					if(!csAllTypeCode.contains(tempCode)){
						csAllTypeCode.add(tempCode);
					}
				}
				if(!csAllTypeCode.contains(code)){
					csAllTypeCode.add(code);
				}
			}
			
			for(String typeCode : csAllTypeCode){
				String typeCodeName = subjectMap.get(typeCode);
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCodeName);
				if(typeCode.length() == 2){
					dic.setDataList(new ArrayList<Dictionary>());
					dicdata.add(dic);
				}else if(typeCode.length() == 5){
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							dic.setDataList(new ArrayList<Dictionary>());
							dic2.getDataList().add(dic);
							break;
						}
					}
				}else{
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							for(Dictionary dic3 : dic2.getDataList()){
								if(dic3.getCode().equals(typeCode.substring(0, 5))){
									dic3.getDataList().add(dic);
									break;
								}
							}
						}
					}
				}
			}
		}else if("2".equals(type)){//2.临床专业（major）
			typeName = "临床专业";
			Map<String, String> majorMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("MajorMap").get(0);
			for(String code : csTypeCode){
				List<String> tempCodes = new ArrayList<>();
				List<Dictionary> tempDics = new ArrayList<>();
				tempCodes = this.getDicDatas(code, new ArrayList<String>(), 2);
				for(int i = tempCodes.size()-1; i >=0; i--){
					String tempCode = tempCodes.get(i);
					if(!csAllTypeCode.contains(tempCode)){
						csAllTypeCode.add(tempCode);
					}
				}
				if(!csAllTypeCode.contains(code)){
					csAllTypeCode.add(code);
				}
			}
			
			for(String typeCode : csAllTypeCode){
				String typeCodeName = majorMap.get(typeCode);
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCodeName);
				if(typeCode.length() == 2){
					dic.setDataList(new ArrayList<Dictionary>());
					dicdata.add(dic);
				}else if(typeCode.length() == 4){
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							dic.setDataList(new ArrayList<Dictionary>());
							dic2.getDataList().add(dic);
							break;
						}
					}
				}else{
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							for(Dictionary dic3 : dic2.getDataList()){
								if(dic3.getCode().equals(typeCode.substring(0, 4))){
									dic3.getDataList().add(dic);
									break;
								}
							}
						}
					}
				}
			}
			
		}else if("3".equals(type)){//3.疾病分类（icd）
			typeName = "疾病分类";
			Map<String, String> diseaseMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("DiseaseMap").get(0);
			for(String typeCode : csTypeCode){
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(diseaseMap.get(typeCode));
				dicdata.add(dic);
			}
			
		}else{//4.讲授教师（Name）
			typeName = "讲授教师";
			for(String typeCode : csTypeCode){
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCode);
				dicdata.add(dic);
			}
		}
		/***********************分页显示课件****************************/
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("pd", pd);
		model.put("type", type);
		return new ModelAndView("edu/frontpage/chair_course", model);
	}
	
	@RequestMapping(value = "/listAppointment")
	public ModelAndView listAppointment(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduChairService.getAllCSTypeCode(type);
		if("1".equals(type)){//1.专业学科（subject）
			typeName = "专业学科";
			Map<String, String> subjectMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("SubjectMap").get(0);
			for(String code : csTypeCode){
				List<String> tempCodes = new ArrayList<>();
				List<Dictionary> tempDics = new ArrayList<>();
				tempCodes = this.getDicDatas(code, new ArrayList<String>(), 3);
				for(int i = tempCodes.size()-1; i >=0; i--){
					String tempCode = tempCodes.get(i);
					if(!csAllTypeCode.contains(tempCode)){
						csAllTypeCode.add(tempCode);
					}
				}
				if(!csAllTypeCode.contains(code)){
					csAllTypeCode.add(code);
				}
			}
			
			for(String typeCode : csAllTypeCode){
				String typeCodeName = subjectMap.get(typeCode);
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCodeName);
				if(typeCode.length() == 2){
					dic.setDataList(new ArrayList<Dictionary>());
					dicdata.add(dic);
				}else if(typeCode.length() == 5){
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							dic.setDataList(new ArrayList<Dictionary>());
							dic2.getDataList().add(dic);
							break;
						}
					}
				}else{
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							for(Dictionary dic3 : dic2.getDataList()){
								if(dic3.getCode().equals(typeCode.substring(0, 5))){
									dic3.getDataList().add(dic);
									break;
								}
							}
						}
					}
				}
			}
		}else if("2".equals(type)){//2.临床专业（major）
			typeName = "临床专业";
			Map<String, String> majorMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("MajorMap").get(0);
			for(String code : csTypeCode){
				List<String> tempCodes = new ArrayList<>();
				List<Dictionary> tempDics = new ArrayList<>();
				tempCodes = this.getDicDatas(code, new ArrayList<String>(), 2);
				for(int i = tempCodes.size()-1; i >=0; i--){
					String tempCode = tempCodes.get(i);
					if(!csAllTypeCode.contains(tempCode)){
						csAllTypeCode.add(tempCode);
					}
				}
				if(!csAllTypeCode.contains(code)){
					csAllTypeCode.add(code);
				}
			}
			
			for(String typeCode : csAllTypeCode){
				String typeCodeName = majorMap.get(typeCode);
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCodeName);
				if(typeCode.length() == 2){
					dic.setDataList(new ArrayList<Dictionary>());
					dicdata.add(dic);
				}else if(typeCode.length() == 4){
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							dic.setDataList(new ArrayList<Dictionary>());
							dic2.getDataList().add(dic);
							break;
						}
					}
				}else{
					for(Dictionary dic2 : dicdata){
						if(dic2.getCode().equals(typeCode.substring(0, 2))){
							for(Dictionary dic3 : dic2.getDataList()){
								if(dic3.getCode().equals(typeCode.substring(0, 4))){
									dic3.getDataList().add(dic);
									break;
								}
							}
						}
					}
				}
			}
			
		}else if("3".equals(type)){//3.疾病分类（icd）
			typeName = "疾病分类";
			Map<String, String> diseaseMap = (Map<String, String>) ApplicationConstants.STD_MAP.get("DiseaseMap").get(0);
			for(String typeCode : csTypeCode){
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(diseaseMap.get(typeCode));
				dicdata.add(dic);
			}
			
		}else{//4.讲授教师（Name）
			typeName = "讲授教师";
			for(String typeCode : csTypeCode){
				dic = new Dictionary();
				dic.setCode(typeCode);
				dic.setName(typeCode);
				dicdata.add(dic);
			}
		}
		/***********************分页显示课件****************************/
		String sql = this.getAppointmentWhereSql(request);
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("pd", pd);
		model.put("type", type);
		return new ModelAndView("edu/frontpage/chair_appoint", model);
	}
	
	/**
	 * 不包含自己逆序排列
	 * 例：04.01.02
	 * 返回：[04.01, 04]
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 上午8:46:33 2017-1-26 
	 * @see com.ycyl.edu.frontpage.controller.EduDemandController.java#getDicDatas()  
	 *
	 * @param code
	 * @param codes
	 * @return
	 */
	private List<String> getDicDatas(String code, List<String> codes, Integer len){
		int length = code.length();
		while(length > 2){
			String substring = code.substring(0, length - len);
			codes.add(substring);
			return getDicDatas(substring, codes, len);
		}
		return codes;
	}
	
	public String getWhereSql(HttpServletRequest request, String code, String type){
		String sql = "from EduLecture where 1=1";
		
		if (code != null && !"".equals(code)) {
			String field = "";
			if("1".equals(type)){//1.专业学科（subject）
				field = "SUBJECT ";
			}else if("2".equals(type)){//2.临床专业（major）
				field = "MAJOR ";
			}else if("3".equals(type)){//3.疾病分类（icd）
				field = "ICD ";
			}else{//4.讲授教师（Name）
				field = "NAME ";
			}
			sql += " and "+field+" = '" + code.trim() + "'";
		}
		
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	public String getDetailsWhereSql(HttpServletRequest request){
		EduStudent user = (EduStudent)request.getSession().getAttribute("user");
		String sql = "from EduStudentDetails where 1=1 and idcard = '" + user.getIdcard() + "' ";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	public String getAppointmentWhereSql(HttpServletRequest request){
		EduStudent user = (EduStudent)request.getSession().getAttribute("user");
		String sql = "from EduLectureAppointment where 1=1 and appointmentIdcard = '" + user.getIdcard() + "' ";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}

	@RequestMapping(value = "/chairLecture")
	public void chairLecture(HttpServletRequest request, HttpServletResponse response, long id){
		EduLecture eduLecture = eduLectureService.getEduLectureById(id);
		List<Json> list = new ArrayList<>();
		Json json = new Json();
		if(eduLecture != null){
			EduStudent user = (EduStudent) request.getSession().getAttribute("user");	
			EduLectureAppointment appointment = eduLectureService.getEduLectureAppointmentBySn(id, user.getIdcard());
			if(appointment != null){
				appointment.setAppointmentTime(new Timestamp(new Date().getTime()));
				appointment.setAppointmentTime_(eduLecture.getTeachingTime_());
				eduLectureService.saveOrUpdateLectureAppointment(appointment);
			}else{
				appointment = new EduLectureAppointment();
				appointment.setSerialNumber(id);
				appointment.setAppointmentIdcard(user.getIdcard());
				appointment.setAppointmentName(user.getName());
				appointment.setOrganization(user.getEduDesignation());
				appointment.setOrganizationId(user.getEduId());
				appointment.setWatch("1");
				appointment.setAppointmentTime(new Timestamp(new Date().getTime()));
				appointment.setAppointmentTime_(eduLecture.getTeachingTime_());
				eduLectureService.saveOrUpdateLectureAppointment(appointment);
			}
		}
		
		json.setStatusCode(Json.STAE_CODE_SUCCESS);
		json.setMessage("预约成功！");
		list.add(json);
		
		HashMap<String, List<Json>> jsonData = new HashMap<String, List<Json>>();
		jsonData.put("json", list);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(jsonData);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(jsonStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/networkFlow")
	public void networkFlow(HttpServletRequest request, HttpServletResponse response, String ip){
		List<Json> list = new ArrayList<>();
		Json json = new Json();
		
		eduLectureService.saveNetworkFlow(ip);
		
		json.setStatusCode(Json.STAE_CODE_SUCCESS);
		json.setMessage("保存成功！");
		list.add(json);
		
		HashMap<String, List<Json>> jsonData = new HashMap<String, List<Json>>();
		jsonData.put("json", list);
		Gson gson = new Gson();
		String jsonStr = gson.toJson(jsonData);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(jsonStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
