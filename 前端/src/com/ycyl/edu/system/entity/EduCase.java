package com.ycyl.edu.system.entity;

import java.sql.Timestamp;


/**
 * EduCase entity. @author MyEclipse Persistence Tools
 */

public class EduCase  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String idcard;
	private String name;
	private String caseContent;
	private Timestamp recordTime;


    // Constructors

    /** default constructor */
    public EduCase() {
    }

    
    /** full constructor */
    public EduCase(String idcard, String name, String caseContent, Timestamp recordTime) {
        this.idcard = idcard;
        this.name = name;
        this.caseContent = caseContent;
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

    public Timestamp getRecordTime() {
        return this.recordTime;
    }
    
    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }
   








}