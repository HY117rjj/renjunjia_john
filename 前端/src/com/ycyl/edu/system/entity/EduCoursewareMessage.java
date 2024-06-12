package com.ycyl.edu.system.entity;

import java.sql.Timestamp;

import lombok.Data;


/**
 * EduCoursewareMessage entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduCoursewareMessage  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = -7718188039416428038L;
	private Long id;
	private Long serialNumber;
	private String courseware;
	private String organizationId;
	private String organization;
	private String messagerName;
	private String messagerTele;
	private String messageContent;
	private Timestamp recordTime;

	// Constructors

    /** default constructor */
    public EduCoursewareMessage() {
    }

    
    /** full constructor */
    public EduCoursewareMessage(Long serialNumber, String organizationId, String organization, String messagerName, String messagerTele, String messageContent, Timestamp recordTime) {
        this.serialNumber = serialNumber;
        this.organizationId = organizationId;
        this.organization = organization;
        this.messagerName = messagerName;
        this.messagerTele = messagerTele;
        this.messageContent = messageContent;
        this.recordTime = recordTime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getSerialNumber() {
        return this.serialNumber;
    }
    
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOrganizationId() {
        return this.organizationId;
    }
    
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganization() {
        return this.organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMessagerName() {
        return this.messagerName;
    }
    
    public void setMessagerName(String messagerName) {
        this.messagerName = messagerName;
    }

    public String getMessagerTele() {
        return this.messagerTele;
    }
    
    public void setMessagerTele(String messagerTele) {
        this.messagerTele = messagerTele;
    }

    public String getMessageContent() {
        return this.messageContent;
    }
    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getRecordTime() {
        return this.recordTime;
    }
    
    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }
   








}