package com.ycyl.edu.frontpage.controller;

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

import com.sun.jmx.snmp.Timestamp;
import com.ycyl.edu.bean.ApplicationConstants;
import com.ycyl.edu.frontpage.service.EduDemandService;
import com.ycyl.edu.system.entity.EduCourseware;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.entity.EduUser;
import com.ycyl.edu.system.entity.EduUserDetails;
import com.ycyl.edu.system.service.EduCoursewareService;
import com.ycyl.edu.system.service.EduUserService;
import com.ycyl.edu.util.DateUtil;
import com.ycyl.edu.util.Dictionary;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/demand")
public class EduDemandController {
	
	@Autowired
	private EduDemandService eduDemandService;
	
	@Autowired
	private EduCoursewareService eduCoursewareService;
	
	@Autowired
	private EduUserService eduUserService;
	
	private String type;//1.专业学科（subject）、2.临床专业（major）、3.疾病分类（icd）、4.讲授教师（Name）栏目
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduDemandService.getAllCSTypeCode(type);
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("type", type);
		model.put("typeName", typeName);
		model.put("code", code);
		model.put("pd", pd);
		return new ModelAndView("edu/frontpage/demand", model);
	}
	
	@RequestMapping(value = "/listForFrontPage")
	public ModelAndView listForFrontPage(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduDemandService.getAllCSTypeCode(type);
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("type", type);
		model.put("typeName", typeName);
		model.put("code", code);
		model.put("pd", pd);
		return new ModelAndView("edu/frontpage/demand_fp", model);
	}
	
	@RequestMapping(value = "/listCourse")
	public ModelAndView listCourse(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduDemandService.getAllCSTypeCode(type);
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("pd", pd);
		model.put("type", type);
		return new ModelAndView("edu/frontpage/demand_course", model);
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
		String sql = "from EduCourseware where 1=1 and addressLink is not null";
		
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
			if("3".equals(type)){
				sql += " and "+field+" like '%" + code.trim() + "%'";
			}else{
				sql += " and "+field+" = '" + code.trim() + "'";
			}
		}
		
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	/**
	 * 健康教育 nature = 1
	 * 
	 * @author: KAY E-mail：gaochangkai@21cn.com
	 * @version: Created on 下午2:44:29 2017-1-30 
	 * @see com.ycyl.edu.frontpage.controller.EduDemandController.java#listHE()  
	 *
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/listHE")
	public ModelAndView listHE(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		String typeName = "";
		Dictionary dic = new Dictionary();
		List<Dictionary> dicdata = new ArrayList<>();
		List<String> csAllTypeCode = new ArrayList<String>();
		type = request.getParameter("type");
		List<String> csTypeCode = eduDemandService.getAllCSHETypeCode(type);
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
		String code = request.getParameter("code");
		String sql = this.getWhereHeSql(request, code, type);
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
		/***********************分页显示课件****************************/
		
		model.put("dicdata", dicdata);
		model.put("type", type);
		model.put("typeName", typeName);
		model.put("code", code);
		model.put("pd", pd);
		return new ModelAndView("edu/frontpage/demand_he", model);
	}
	
	public String getWhereHeSql(HttpServletRequest request, String code, String type){
		String sql = "from EduCourseware where 1=1 and nature = 1 and addressLink is not null";
		
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
		String sql = "from EduUserDetails where 1=1 and idcard = '" + user.getIdcard() + "' ";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	@RequestMapping(value = {"/demandCourseware", "/demandCoursewareForFrontPage"})
	public ModelAndView demandCourseware(HttpServletRequest request, HttpServletResponse response, Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduStudent user = (EduStudent)request.getSession().getAttribute("user");
		if(user == null){// 首页进入的
			user = new EduStudent();
			user.setId(0L);
			user.setName("游客");
			user.setIdcard("370123198708162915");
		}
		EduCourseware courseware = eduCoursewareService.getEduCoursewareById(id);
		Long cwId = courseware.getId();
		EduUserDetails details = eduUserService.getEduUserDetailsById(cwId);
		if(details == null){
			details = new EduUserDetails();
			Long userId = user.getId();
			details.setSerialNumber(userId);
			details.setIdcard(user.getIdcard());
			details.setName(user.getName());
			details.setCourseware(cwId+"");
			details.setSignTime(new Date());
			Double onDemandCharge = courseware.getOnDemandCharge() == null ? 0.0 : courseware.getOnDemandCharge();
			details.setCharge(onDemandCharge);
			details.setComplete("0");
			if(onDemandCharge > 0){
				EduUser eduUser = eduUserService.getEduUserById(userId);
				eduUser.setCharge(eduUser.getCharge()-onDemandCharge);
				details.setComplete("1");
				eduUserService.saveOrUpdate(eduUser);
			}
		}else{
			details.setSignTime(new Date());// 多次进去点播课程，更新播放时间
		}
		eduUserService.saveOrUpdateDetails(details);
		model.put("videoPath", courseware.getAddressLink());
		return new ModelAndView("edu/frontpage/videoPlayer", model);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
