package com.ycyl.edu.system.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
import com.ycyl.edu.system.entity.EduNotice;
import com.ycyl.edu.system.entity.EduStudent;
import com.ycyl.edu.system.service.EduNoticeService;
import com.ycyl.edu.util.DateUtil;
import com.ycyl.edu.util.Json;
import com.ycyl.edu.util.JsonUtil;
import com.ycyl.edu.util.Page;
import com.ycyl.edu.util.PageData;
import com.ycyl.edu.util.StringUtil;
import com.ycyl.edu.util.UUIDGenerator;

@SuppressWarnings("all")
@Controller
@RequestMapping(value="/notice")
@Data
public class EduNoticeController {
	
	@Autowired
	private EduNoticeService eduNoticeService;
	
	private File upload; // 文件
	private String uploadContentType; // 文件类型
	private String basePath;
	private String uploadFileName;
	
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
		int totalRows = eduNoticeService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduNotice> pd = new PageData<EduNotice>();
		List<EduNotice> list = eduNoticeService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduNotice>());
		}
		
		return new ModelAndView("system/admin/admin_notice").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/removeNotice")
	public ModelAndView removeNotice(Long id) throws Exception{
		Json json = null;
		try {
			eduNoticeService.delete(id);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return new ModelAndView("msg").addObject("msg",JsonUtil.toJson(json));
	}
	
	@RequestMapping(value = "/editNotice")
	public ModelAndView editNotice(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduNotice notice = new EduNotice();
		if(id != null){
			notice = eduNoticeService.getEduNoticeById(id);
		}
		model.put("notice",notice);
		return new ModelAndView("system/admin/admin_notice_edit", model);
	}
	
	@RequestMapping(value = "/saveNotice")
	public ModelAndView saveNotice(HttpServletRequest request, HttpServletResponse response, EduNotice notice) throws Exception{
		Json json = null;
		try {
			EduStudent user = (EduStudent)request.getSession().getAttribute("user");
			notice.setNoticeTime(new Timestamp(new Date().getTime()));
			if(!StringUtil.isEmpyOrNull(notice.getTeachingTime_()) && notice.getTeachingTime_().length() >= 10){
				notice.setTeachingTime(new Timestamp(DateUtil.str2Date(notice.getTeachingTime_()).getTime()));
			}
			
			notice.setPromulgator(user.getName());
			eduNoticeService.saveOrUpdate(notice);
			json = new Json(Json.STAE_CODE_SUCCESS, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json = new Json(Json.STAE_CODE_ERROR, "删除失败");
		}
		return list(request, response, 0, 0);
	}
	
	@RequestMapping(value = "/getFrontPagelist")
	public void getFrontPagelist(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		String sql = "from EduNotice order by teachingTime desc";
		//得到查询列表的当前页
		List<EduNotice> list = eduNoticeService.getCurrentPageList(sql, 0, 9);	
		
		HashMap<String, List<EduNotice>> jsonData = new HashMap<String, List<EduNotice>>();
		jsonData.put("notice", list);
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
	
	@RequestMapping(value = "/listFP")
	public ModelAndView listFP(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) throws Exception  {
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
		int totalRows = eduNoticeService.getTotalRows(sql);
		p.setTotalResult(totalRows);
		//得到查询列表的当前页
		PageData<EduNotice> pd = new PageData<EduNotice>();
		List<EduNotice> list = eduNoticeService.getCurrentPageList(sql, p.getStarRow(), p.getMaxRow());		
		if(list!= null && list.size()>0){
			pd.setTotal(totalRows);
			pd.setTotalPage(p.getTotalPage());
			pd.setRows(list);
		}else{
			pd.setTotal(0);
			pd.setTotalPage(0);
			pd.setRows(new ArrayList<EduNotice>());
		}
		
		return new ModelAndView("edu/frontpage/notice").addObject("pd", pd);
	}
	
	@RequestMapping(value = "/viewNoticeFrontPage")
	public ModelAndView viewNoticeFrontPage(Long id) throws Exception{
		Map<String, Object> model = new HashMap<String, Object>();
		EduNotice notice = new EduNotice();
		if(id != null){
			notice = eduNoticeService.getEduNoticeById(id);
		}
		model.put("notice",notice);
		return new ModelAndView("edu/frontpage/notice_view", model);
	}
	
	public String getWhereSql(HttpServletRequest request){
		String sql = "from EduNotice where 1=1";
		String name = request.getParameter("name");
		if (name != null && !"".equals(name)) {
			sql += " and name = '" + name.trim() + "'";
		}
		return sql;
	}
	
	@RequestMapping(value = "/uploadNewsImg")
	public void uploadNewsImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		basePath = request.getParameter("basePath");
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = mRequest.getFiles("upload");
		ServletContext sc = request.getSession().getServletContext();
		String uploadDir = sc.getRealPath("/upload");
		File file = new File(uploadDir);
		if (!file.exists()) {
			file.mkdirs();
		}

		String fileName = null;
		String saveFileName = null;
		for (MultipartFile mFile : files) {
			fileName = mFile.getOriginalFilename();
			if (fileName == "") {
				break;
			}
			String prifix = fileName.substring(fileName.lastIndexOf("."));
			saveFileName = UUIDGenerator.getUUID()+prifix; // 上传后新文件名
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadDir + "\\" + saveFileName));
			FileCopyUtils.copy(mFile.getInputStream(), outputStream);
		}
//		if (upload != null) {
//			ServletContext sc = request.getSession().getServletContext();
//			String dataDir = sc.getRealPath("/upload");
//			File saveDir = new File(dataDir);
//			// 没有目录创建一个
//			if (!saveDir.exists()) {
//				saveDir.mkdirs();
//			}
//			String prifix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
//			String saveFileName = UUIDGenerator.getUUID()+prifix; // 上传后新文件名
//			
//			File savedFile = new File(dataDir, saveFileName);
//
//			// 输出到的地方
//			FileOutputStream fom = new FileOutputStream(savedFile);
//			// 获取文件输入流
//			FileInputStream fim = new FileInputStream(upload);
//			FileChannel foc = fom.getChannel();
//			FileChannel fic = fim.getChannel();
//			// 创建缓冲区
//			ByteBuffer buffer = ByteBuffer.allocate(1024);
//			while (true) {
//				// clear方法重设缓冲区，使它可以接受读入的数据
//				buffer.clear();
//				// 从输入通道中将数据读到缓冲区,read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
//				int r = fic.read(buffer);
//				if (r == -1) {
//					break;
//				}
//				// flip方法让缓冲区可以将新读入的数据写入另一个通道
//				buffer.flip();
//				// 从输出通道中将数据写入缓冲区
//				foc.write(buffer);
//			}
//			foc.close();
//			fic.close();
			StringBuilder sb = new StringBuilder();
			sb.append("<script type=\"text/javascript\">\n");
			sb.append("window.parent.CKEDITOR.tools.callFunction(0,'" + basePath + "upload/" + saveFileName + "');\n");
			sb.append("</script>");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(sb.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		}
	}
	
}
