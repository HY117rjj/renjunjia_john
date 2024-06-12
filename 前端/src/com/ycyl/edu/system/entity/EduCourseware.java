package com.ycyl.edu.system.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * EduCourseware entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduCourseware implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8197581724691871244L;
	private Long id;
	private Long serialNumber;
	private String idcard;
	private String name;
	private String subject;
	private String major;
	private String icd;
	private String title;
	private String summary;
	private String nature;
	private Timestamp teachingTime;
	private Integer duration;
	private Double charge;
	private Double onDemandCharge;
	private String addressLink;
	
	private String teachingTime_;
	
	private String drug;// 药品分类
	
	private String form;// 呈现形式
	private String content;// 文本格式课件

	private String healthCare;// 健康教育分组
	
	private String coverImage;// 封面
	
	private String attachmentLink;// 附件地址链接
	
	private String release;// 发布对象
	
	private String stickyPosts;// 置顶
	
	// Constructors

	/** default constructor */
	public EduCourseware() {
	}

	/** minimal constructor */
	public EduCourseware(Long id, Long serialNumber, String idcard) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.idcard = idcard;
	}

	/** full constructor */
	public EduCourseware(Long id, Long serialNumber, String idcard,
			String name, String subject, String major, String icd,
			String title, String summary, String nature,
			Timestamp teachingTime, Integer duration, Double charge,
			Double onDemandCharge, String addressLink) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.idcard = idcard;
		this.name = name;
		this.subject = subject;
		this.major = major;
		this.icd = icd;
		this.title = title;
		this.summary = summary;
		this.nature = nature;
		this.teachingTime = teachingTime;
		this.duration = duration;
		this.charge = charge;
		this.onDemandCharge = onDemandCharge;
		this.addressLink = addressLink;
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

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIcd() {
		return this.icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Timestamp getTeachingTime() {
		return this.teachingTime;
	}

	public void setTeachingTime(Timestamp teachingTime) {
		this.teachingTime = teachingTime;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getCharge() {
		return this.charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Double getOnDemandCharge() {
		return this.onDemandCharge;
	}

	public void setOnDemandCharge(Double onDemandCharge) {
		this.onDemandCharge = onDemandCharge;
	}

	public String getAddressLink() {
		return this.addressLink;
	}

	public void setAddressLink(String addressLink) {
		this.addressLink = addressLink;
	}

	public String getTeachingTime_() {
		return teachingTime_;
	}

	public void setTeachingTime_(String teachingTime_) {
		this.teachingTime_ = teachingTime_;
	}

}