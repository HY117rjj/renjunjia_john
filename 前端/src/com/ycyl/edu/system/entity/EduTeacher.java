package com.ycyl.edu.system.entity;


/**
 * EduTeacher entity. @author MyEclipse Persistence Tools
 */

public class EduTeacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 549329076826180321L;
	private Long id;
	private String idcard;
	private String name;
	private String teachingSign;
	private String subject;
	private String major;
	private Double basicCharge;
	private String research;

	// Constructors

	/** default constructor */
	public EduTeacher() {
	}

	/** minimal constructor */
	public EduTeacher(Long id, String idcard) {
		this.id = id;
		this.idcard = idcard;
	}

	/** full constructor */
	public EduTeacher(Long id, String idcard, String name,
			String teachingSign, String subject, String major,
			Double basicCharge, String research) {
		this.id = id;
		this.idcard = idcard;
		this.name = name;
		this.teachingSign = teachingSign;
		this.subject = subject;
		this.major = major;
		this.basicCharge = basicCharge;
		this.research = research;
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

	public String getTeachingSign() {
		return this.teachingSign;
	}

	public void setTeachingSign(String teachingSign) {
		this.teachingSign = teachingSign;
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

	public Double getBasicCharge() {
		return this.basicCharge;
	}

	public void setBasicCharge(Double basicCharge) {
		this.basicCharge = basicCharge;
	}

	public String getResearch() {
		return this.research;
	}

	public void setResearch(String research) {
		this.research = research;
	}

}