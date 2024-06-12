package com.ycyl.edu.system.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * EduLectureAutonomy entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduLectureAutonomy implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2099278095000471871L;
	private Long id;
	private String idcard;
	private String name;
	private String appointmentTitle;
	private String summary;
	private String appointmentModality;
	private Integer appointmentDuration;
	private Double appointmentCharge;
	private String organizationId;
	private String organization;
	private String appointmentName;
	private String appointmentTele;
	private String watch;
	private Timestamp ratificationTime;
	private Double ratificationCharge;
	
	private String ratificationTime_;

	// Constructors

	/** default constructor */
	public EduLectureAutonomy() {
	}

	/** full constructor */
	public EduLectureAutonomy(Long id, String idcard, String name,
			String appointmentTitle, String summary,
			String appointmentModality, Integer appointmentDuration,
			Double appointmentCharge, String organizationId,
			String organization, String appointmentName,
			String appointmentTele, String watch, Timestamp ratificationTime,
			Double ratificationCharge) {
		this.id = id;
		this.idcard = idcard;
		this.name = name;
		this.appointmentTitle = appointmentTitle;
		this.summary = summary;
		this.appointmentModality = appointmentModality;
		this.appointmentDuration = appointmentDuration;
		this.appointmentCharge = appointmentCharge;
		this.organizationId = organizationId;
		this.organization = organization;
		this.appointmentName = appointmentName;
		this.appointmentTele = appointmentTele;
		this.watch = watch;
		this.ratificationTime = ratificationTime;
		this.ratificationCharge = ratificationCharge;
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

	public String getAppointmentTitle() {
		return this.appointmentTitle;
	}

	public void setAppointmentTitle(String appointmentTitle) {
		this.appointmentTitle = appointmentTitle;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAppointmentModality() {
		return this.appointmentModality;
	}

	public void setAppointmentModality(String appointmentModality) {
		this.appointmentModality = appointmentModality;
	}

	public Integer getAppointmentDuration() {
		return this.appointmentDuration;
	}

	public void setAppointmentDuration(Integer appointmentDuration) {
		this.appointmentDuration = appointmentDuration;
	}

	public Double getAppointmentCharge() {
		return this.appointmentCharge;
	}

	public void setAppointmentCharge(Double appointmentCharge) {
		this.appointmentCharge = appointmentCharge;
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

	public String getAppointmentName() {
		return this.appointmentName;
	}

	public void setAppointmentName(String appointmentName) {
		this.appointmentName = appointmentName;
	}

	public String getAppointmentTele() {
		return this.appointmentTele;
	}

	public void setAppointmentTele(String appointmentTele) {
		this.appointmentTele = appointmentTele;
	}

	public String getWatch() {
		return this.watch;
	}

	public void setWatch(String watch) {
		this.watch = watch;
	}

	public Timestamp getRatificationTime() {
		return this.ratificationTime;
	}

	public void setRatificationTime(Timestamp ratificationTime) {
		this.ratificationTime = ratificationTime;
	}

	public Double getRatificationCharge() {
		return this.ratificationCharge;
	}

	public void setRatificationCharge(Double ratificationCharge) {
		this.ratificationCharge = ratificationCharge;
	}

}