package com.ycyl.edu.system.entity;

import java.sql.Timestamp;


/**
 * EduNotice entity. @author MyEclipse Persistence Tools
 */
public class EduNotice  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 262580914232552097L;
	// Fields

	private Long id;
	private String title;
	private String content;
	private Timestamp noticeTime;
	private String promulgator;
	
	private Timestamp teachingTime;
	private String teachingTime_;

    // Constructors

    /** default constructor */
    public EduNotice() {
    }

    
    /** full constructor */
    public EduNotice(String title, String content, Timestamp noticeTime, String promulgator) {
        this.title = title;
        this.content = content;
        this.noticeTime = noticeTime;
        this.promulgator = promulgator;
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

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getNoticeTime() {
        return this.noticeTime;
    }
    
    public void setNoticeTime(Timestamp noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getPromulgator() {
        return this.promulgator;
    }
    
    public void setPromulgator(String promulgator) {
        this.promulgator = promulgator;
    }


	public Timestamp getTeachingTime() {
		return teachingTime;
	}


	public void setTeachingTime(Timestamp teachingTime) {
		this.teachingTime = teachingTime;
	}


	public String getTeachingTime_() {
		return teachingTime_;
	}


	public void setTeachingTime_(String teachingTime_) {
		this.teachingTime_ = teachingTime_;
	}
   

}