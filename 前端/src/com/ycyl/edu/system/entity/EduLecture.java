package com.ycyl.edu.system.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * EduLecture entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduLecture implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private Long serialNumber;
	private String organizationId;
	private String organization;
	private String idcard;
	private String name;
	private String subject;
	private String major;
	private String icd;
	private String title;
	private String summary;
	private String nature;
	private String modality;
	private Timestamp teachingTime;
	private Integer duration;
	private Double charge;
	private String teachingTime_;
	
	// Constructors

	/** default constructor */
	public EduLecture() {
	}

	/** minimal constructor */
	public EduLecture(Long id, String organizationId, String idcard) {
		this.id = id;
		this.organizationId = organizationId;
		this.idcard = idcard;
	}

	/** full constructor */
	public EduLecture(Long id, String organizationId,
			String organization, String idcard, String name, String subject,
			String major, String icd, String title, String summary,
			String nature, String modality, Timestamp teachingTime,
			Integer duration, Double charge) {
		this.id = id;
		this.organizationId = organizationId;
		this.organization = organization;
		this.idcard = idcard;
		this.name = name;
		this.subject = subject;
		this.major = major;
		this.icd = icd;
		this.title = title;
		this.summary = summary;
		this.nature = nature;
		this.modality = modality;
		this.teachingTime = teachingTime;
		this.duration = duration;
		this.charge = charge;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getModality() {
		return this.modality;
	}

	public void setModality(String modality) {
		this.modality = modality;
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

}