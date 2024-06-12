package com.ycyl.edu.system.entity;

import java.sql.Timestamp;


/**
 * EduLog entity. @author MyEclipse Persistence Tools
 */

public class EduLog  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String idcard;
	private String userName;
	private String name;
	private String content;
	private String simManager;
	private Timestamp recordTime;

	// Constructors

	/** default constructor */
    public EduLog() {
    }

	/** minimal constructor */
    public EduLog(String idcard) {
        this.idcard = idcard;
    }
    
    /** full constructor */
    public EduLog(String idcard, String userName, String name, String content, String simManager, Timestamp recordTime) {
        this.idcard = idcard;
        this.userName = userName;
        this.name = name;
        this.content = content;
        this.simManager = simManager;
        this.recordTime = recordTime;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getIdcard() {
        return this.idcard;
    }
    
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getSimManager() {
        return this.simManager;
    }
    
    public void setSimManager(String simManager) {
        this.simManager = simManager;
    }

    public Timestamp getRecordTime() {
        return this.recordTime;
    }
    
    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }
   








}