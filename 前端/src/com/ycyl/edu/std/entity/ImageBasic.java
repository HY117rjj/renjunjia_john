package com.ycyl.edu.std.entity;

import java.sql.Timestamp;


/**
 * ImageBasic entity. @author MyEclipse Persistence Tools
 */

public class ImageBasic  implements java.io.Serializable {


	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7645878408511724273L;
	private Long id;
	private String title;
	private String titleIp;
	private String titlePath;
	private Timestamp uploadTime;
	private String system;
	private String presentationMode;
	private String hospital;
	private Timestamp startTime;
	private Timestamp endTime;
	private String stopedflag;
	private String remarks;

	// Constructors

    /** default constructor */
    public ImageBasic() {
    }

    
    /** full constructor */
    public ImageBasic(String title, String titleIp, String titlePath, Timestamp uploadTime, String system, String presentationMode, String hospital, Timestamp startTime, Timestamp endTime, String stopedflag, String remarks) {
        this.title = title;
        this.titleIp = titleIp;
        this.titlePath = titlePath;
        this.uploadTime = uploadTime;
        this.system = system;
        this.presentationMode = presentationMode;
        this.hospital = hospital;
        this.startTime = startTime;
        this.endTime = endTime;
        this.stopedflag = stopedflag;
        this.remarks = remarks;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleIp() {
        return this.titleIp;
    }
    
    public void setTitleIp(String titleIp) {
        this.titleIp = titleIp;
    }

    public String getTitlePath() {
        return this.titlePath;
    }
    
    public void setTitlePath(String titlePath) {
        this.titlePath = titlePath;
    }

    public Timestamp getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getSystem() {
        return this.system;
    }
    
    public void setSystem(String system) {
        this.system = system;
    }

    public String getPresentationMode() {
        return this.presentationMode;
    }
    
    public void setPresentationMode(String presentationMode) {
        this.presentationMode = presentationMode;
    }

    public String getHospital() {
        return this.hospital;
    }
    
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStopedflag() {
        return this.stopedflag;
    }
    
    public void setStopedflag(String stopedflag) {
        this.stopedflag = stopedflag;
    }

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
   








}