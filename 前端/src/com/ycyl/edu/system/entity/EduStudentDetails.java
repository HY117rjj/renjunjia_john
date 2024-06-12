package com.ycyl.edu.system.entity;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import com.ycyl.edu.util.DateUtil;

/**
 * EduStudentDetails entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduStudentDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long serialNumber;
	private String courseware;
	private String idcard;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Date signTime;
	private String eligibility;
	
	private String signTime_;

	// Constructors

	/** default constructor */
	public EduStudentDetails() {
	}

	/** minimal constructor */
	public EduStudentDetails(Long id, Long serialNumber) {
		this.id = id;
		this.serialNumber = serialNumber;
	}

	/** full constructor */
	public EduStudentDetails(Long id, Long serialNumber,
			String courseware, String idcard, String name, Timestamp signTime,
			String eligibility) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.courseware = courseware;
		this.idcard = idcard;
		this.name = name;
		this.signTime = signTime;
		this.eligibility = eligibility;
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

	public String getCourseware() {
		return this.courseware;
	}

	public void setCourseware(String courseware) {
		this.courseware = courseware;
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

	public Date getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
		this.signTime_ = DateUtil.dateTime2Str(signTime);
	}

	public String getEligibility() {
		return this.eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getSignTime_() {
		return signTime_;
	}

	public void setSignTime_(String signTime_) {
		this.signTime_ = signTime_;
//		this.signTime = new Timestamp(DateUtil.str2Date(signTime_).getTime());
	}

}