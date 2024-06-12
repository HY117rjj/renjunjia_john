package com.ycyl.edu.system.entity;

import java.sql.Timestamp;


/**
 * EduCaseMessage entity. @author MyEclipse Persistence Tools
 */

public class EduCaseMessage  implements java.io.Serializable {


    // Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long serialNumber;
	private String idcard;
	private String name;
	private String caseContent;
	private String messagerName;
	private String messageContent;
	private Timestamp recordTime;

	// Constructors

    /** default constructor */
    public EduCaseMessage() {
    }

    
    /** full constructor */
    public EduCaseMessage(Long serialNumber, String idcard, String name, String caseContent, String messagerName, String messageContent, Timestamp recordTime) {
        this.serialNumber = serialNumber;
        this.idcard = idcard;
        this.name = name;
        this.caseContent = caseContent;
        this.messagerName = messagerName;
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

    public String getIdcard() {
        return this.idcard;
    }
    
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCaseContent() {
        return this.caseContent;
    }
    
    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    public String getMessagerName() {
        return this.messagerName;
    }
    
    public void setMessagerName(String messagerName) {
        this.messagerName = messagerName;
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