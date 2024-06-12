package com.ycyl.edu.system.entity;


/**
 * EduProject entity. @author MyEclipse Persistence Tools
 */

public class EduProject implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -140227688121988794L;
	private Long id;
	private String eduId;
	private String eduDesignation;
	private String summary;
	private String courseware;
	private Integer creditHour;

	// Constructors

	/** default constructor */
	public EduProject() {
	}

	/** minimal constructor */
	public EduProject(Long id, String eduId) {
		this.id = id;
		this.eduId = eduId;
	}

	/** full constructor */
	public EduProject(Long id, String eduId, String eduDesignation,
			String summary, String courseware, Integer creditHour) {
		this.id = id;
		this.eduId = eduId;
		this.eduDesignation = eduDesignation;
		this.summary = summary;
		this.courseware = courseware;
		this.creditHour = creditHour;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEduId() {
		return this.eduId;
	}

	public void setEduId(String eduId) {
		this.eduId = eduId;
	}

	public String getEduDesignation() {
		return this.eduDesignation;
	}

	public void setEduDesignation(String eduDesignation) {
		this.eduDesignation = eduDesignation;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCourseware() {
		return this.courseware;
	}

	public void setCourseware(String courseware) {
		this.courseware = courseware;
	}

	public Integer getCreditHour() {
		return this.creditHour;
	}

	public void setCreditHour(Integer creditHour) {
		this.creditHour = creditHour;
	}

}