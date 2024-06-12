package com.ycyl.edu.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@SuppressWarnings("all")
public class FileOperateUtil {  
    private static final String REALNAME = "realName";  
    private static final String STORENAME = "storeName";  
    private static final String SIZE = "size";  
    private static final String SUFFIX = "suffix";  
    private static final String BODY = "body";
    private static final String CONTENTTYPE = "contentType";  
    private static final String CREATETIME = "createTime";  
    private static final String UPLOADDIR = "\\upload\\";  
    /**
     * 
     * 通过上传的文件返回各文件新文件名，以及原文件名
     * 
     * */
    public static List<Map> returnName( List<Map<String, Object>> result){
    	
    	List <Map> list =new ArrayList<Map>();    	
    	if(result!=null&&!"".equals(result)){
    		for(Map<String, Object> res:result){
    			Map map=new HashMap();
    			 map.put("name", res.get("realName"));
    			 map.put("newname", "/upload/"+res.get("storeName"));
    			 list.add(map);
    		}
    	}
    	return list;
    }
    
    
   public static List<Map> returnName( List<Map<String, Object>> result, String path){
    	
    	List <Map> list =new ArrayList<Map>();    	
    	if(result!=null&&!"".equals(result)){
    		for(Map<String, Object> res:result){
    			Map map=new HashMap();
    			 map.put("name", res.get("realName"));
    			 map.put("newname", "/upload/"+path+"/"+res.get("storeName"));
    			 list.add(map);
    		}
    	}
    	return list;
    }
    
    
    /** 
     * 将上传的文件进行重命名 
     *      
     */  
    private static String rename(String name) {  
  
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));  
        Long random = (long) (Math.random() * now);  
        String fileName = now + "" + random;  
  
        if (name.indexOf(".") != -1) {  
            fileName += name.substring(name.lastIndexOf("."));  
        }  
  
        return fileName;  
    }  
  
    /** 
     * 压缩后的文件名 
     *  
     * @author lyd 
     * @date 2012-3-29 下午6:21:32 
     * @param name 
     * @return 
     */  
    private static String zipName(String name) {  
        String prefix = "";  
        if (name.indexOf(".") != -1) {  
            prefix = name.substring(0, name.lastIndexOf("."));  
        } else {  
            prefix = name;  
        }  
        return prefix + ".zip";  
    }  
  
    /** 
     * 上传文件 
     *       
     */  
    public static List<Map<String, Object>> upload(HttpServletRequest request, String filename) throws Exception {  
  
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();  
  
       MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request; 
       
        
        List<MultipartFile> files = mRequest.getFiles(filename);  
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + FileOperateUtil.UPLOADDIR;  
        File file = new File(uploadDir);    
        if (!file.exists()){ 
            file.mkdir();  
        }  
  
        String fileName = null;          
        for(MultipartFile mFile:files){
        	 //String systemSeparator = File.separator;// 获得系统的分隔符
        	 fileName = mFile.getOriginalFilename();         	  
             String storeName = rename(fileName);  //上传后新文件名   
             String noZipName = uploadDir + storeName;  
             //System.out.println(noZipName);
             String zipName = zipName(noZipName); //压缩后文件名   
             // 上传成为压缩文件   
             ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipName)));  
             outputStream.putNextEntry(new ZipEntry(fileName));  
             outputStream.setEncoding("GBK");     
             FileCopyUtils.copy(mFile.getInputStream(), outputStream);    
             Map<String, Object> map = new HashMap<String, Object>();  
             // 固定参数值对   
             map.put(FileOperateUtil.REALNAME, zipName(fileName));  
             map.put(FileOperateUtil.STORENAME, zipName(storeName));  
             map.put(FileOperateUtil.SIZE, new File(zipName).length());  
             map.put(FileOperateUtil.SUFFIX, "zip");  
             map.put(FileOperateUtil.CONTENTTYPE, "application/octet-stream");  
             map.put(FileOperateUtil.CREATETIME, new Date());  
            
             result.add(map);  
        	
        }
        
        return result;  
    } 
    
    //上传文件不压缩
    public static List<Map<String, Object>>  uploadNoZip(HttpServletRequest request, String filename, String path) throws Exception {  
  	  
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();  
  
       MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request; 
       
        
        List<MultipartFile> files = mRequest.getFiles(filename);  
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + FileOperateUtil.UPLOADDIR +"\\"+path+"\\";  
        File file = new File(uploadDir);    
        if (!file.exists()){ 
            file.mkdir();  
        }  
  
        String fileName = null;          
        for(MultipartFile mFile:files){
        	 //String systemSeparator = File.separator;// 获得系统的分隔符
        	 fileName = mFile.getOriginalFilename();      
        	 if(fileName==""){
        		 break; 
        	 }
             String storeName = rename(fileName);  //上传后新文件名   
             String noZipName = uploadDir + storeName;  
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(noZipName));
             FileCopyUtils.copy(mFile.getInputStream(), outputStream);
             Map<String, Object> map = new HashMap<String, Object>();  
             // 固定参数值对   
             map.put(FileOperateUtil.REALNAME, fileName);  
             map.put(FileOperateUtil.STORENAME, storeName);  
             map.put(FileOperateUtil.SIZE, new File(noZipName).length());    
             map.put(FileOperateUtil.CONTENTTYPE, "application/octet-stream");  
             map.put(FileOperateUtil.CREATETIME, new Date());  
            
             result.add(map);  
        	
        }
        
        return result;  
    }  
    
    /** 
     * 上传图片
     *  
     * @author yuanxm 
     * @date 2014-7-28 下午4:21:32 
     * @return 
     */ 
    public static List<Map<String, Object>>  uploadImg(HttpServletRequest request, String filename,String path) throws Exception {  
    	  
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();  
  
       MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request; 
       
        
        List<MultipartFile> files = mRequest.getFiles(filename);  
        String uploadDir = request.getSession().getServletContext().getRealPath("/") + FileOperateUtil.UPLOADDIR +"\\"+path+"\\";  
        File file = new File(uploadDir);    
        if (!file.exists()){ 
            file.mkdir();  
        }  
  
        String fileName = null;          
        for(MultipartFile mFile:files){
        	 //String systemSeparator = File.separator;// 获得系统的分隔符
        	 fileName = mFile.getOriginalFilename();      
        	 if(fileName==""){
        		 break; 
        	 }
             String storeName = rename(fileName);  //上传后新文件名   
             String noZipName = uploadDir + storeName;  
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(noZipName));           
             FileCopyUtils.copy(mFile.getInputStream(), outputStream);    
             Map<String, Object> map = new HashMap<String, Object>();  
             // 固定参数值对   
             map.put(FileOperateUtil.REALNAME, fileName);  
             map.put(FileOperateUtil.STORENAME, storeName);  
             map.put(FileOperateUtil.SIZE, mFile.getSize());    
             map.put(FileOperateUtil.CONTENTTYPE, "application/octet-stream");  
             map.put(FileOperateUtil.CREATETIME, new Date());  
             map.put(FileOperateUtil.BODY, mFile.getBytes()); //二进制
             result.add(map);  
        	
        }
        
        return result;  
    }  
    /** 
     * 下载 
     *       
     */  
    public static void download(HttpServletRequest request, HttpServletResponse response, String storeName, String contentType, String realName) throws Exception {  
        response.setContentType("text/html;charset=UTF-8");  
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  
        String ctxPath = request.getSession().getServletContext().getRealPath("/"); //+ FileOperateUtil.UPLOADDIR;  
        String downLoadPath = ctxPath + storeName;  
  
        long fileLength = new File(downLoadPath).length();  
  
        response.setContentType(contentType);  
        response.setHeader("Content-disposition", "attachment; filename=" + new String(realName.getBytes(), "ISO8859-1"));        
        response.setHeader("Content-Length", String.valueOf(fileLength));  
  
        bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[8192];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.close();  
    } 
    /**
     * 主要生成csv,用于数据的导出
     * 
     * */
    public static void downloadCsv(HttpServletRequest request,  
            HttpServletResponse response, String storeName, String contentType,  
            String realName,String content) throws Exception {  	
    	    response.setContentType("text/html;charset=UTF-8");  
            request.setCharacterEncoding("UTF-8");  
            BufferedOutputStream bos = null;      
            response.setContentType(contentType);  
            response.setHeader("Content-disposition", "attachment; filename=" + new String(realName.getBytes(), "ISO8859-1"));  
            bos = new BufferedOutputStream(response.getOutputStream());
            bos.write(content.getBytes());
        	bos.flush();
            bos.close();
            
            
    }
    
} 