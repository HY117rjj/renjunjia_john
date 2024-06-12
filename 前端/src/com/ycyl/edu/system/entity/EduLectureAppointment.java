package com.ycyl.edu.system.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * EduLectureAppointment entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduLectureAppointment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2738565831860966694L;
	private Long id;
	private Long serialNumber;
	private String organizationId;
	private String organization;
	private String appointmentName;
	private String appointmentTele;
	private String watch;
	private Timestamp appointmentTime;
	private Timestamp ratificationTime;
	
	private String appointmentTime_;
	private String ratificationTime_;
	
	private String appointmentIdcard;
	
	private String teacher;
	private String title;

	// Constructors

	/** default constructor */
	public EduLectureAppointment() {
	}

	/** minimal constructor */
	public EduLectureAppointment(Long id, Long serialNumber,
			String organizationId, String watch) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.organizationId = organizationId;
		this.watch = watch;
	}

	/** full constructor */
	public EduLectureAppointment(Long id, Long serialNumber,
			String organizationId, String organization, String appointmentName,
			String appointmentTele, String watch, Timestamp appointmentTime,
			Timestamp ratificationTime) {
		this.id = id;
		this.serialNumber = serialNumber;
		this.organizationId = organizationId;
		this.organization = organization;
		this.appointmentName = appointmentName;
		this.appointmentTele = appointmentTele;
		this.watch = watch;
		this.appointmentTime = appointmentTime;
		this.ratificationTime = ratificationTime;
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

	public Timestamp getAppointmentTime() {
		return this.appointmentTime;
	}

	public void setAppointmentTime(Timestamp appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Timestamp getRatificationTime() {
		return this.ratificationTime;
	}

	public void setRatificationTime(Timestamp ratificationTime) {
		this.ratificationTime = ratificationTime;
	}

}