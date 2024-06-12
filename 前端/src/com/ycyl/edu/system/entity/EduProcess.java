package com.ycyl.edu.system.entity;

import java.sql.Timestamp;


/**
 * EduProcess entity. @author MyEclipse Persistence Tools
 */

public class EduProcess  implements java.io.Serializable {


	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String systemUserName;
	private String systemName;
	private String securityUserName;
	private String securityName;
	private String content;
	private String conclusion;
	private Timestamp recordTime;

	// Constructors

    /** default constructor */
    public EduProcess() {
    }

    
    /** full constructor */
    public EduProcess(String systemUserName, String systemName, String securityUserName, String securityName, String content, String conclusion, Timestamp recordTime) {
        this.systemUserName = systemUserName;
        this.systemName = systemName;
        this.securityUserName = securityUserName;
        this.securityName = securityName;
        this.content = content;
        this.conclusion = conclusion;
        this.recordTime = recordTime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemUserName() {
        return this.systemUserName;
    }
    
    public void setSystemUserName(String systemUserName) {
        this.systemUserName = systemUserName;
    }

    public String getSystemName() {
        return this.systemName;
    }
    
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSecurityUserName() {
        return this.securityUserName;
    }
    
    public void setSecurityUserName(String securityUserName) {
        this.securityUserName = securityUserName;
    }

    public String getSecurityName() {
        return this.securityName;
    }
    
    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getConclusion() {
        return this.conclusion;
    }
    
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Timestamp getRecordTime() {
        return this.recordTime;
    }
    
    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }
   








}