package com.ycyl.edu.system.entity;

import lombok.Getter;
import lombok.Setter;


/**
 * EduStudent entity. @author MyEclipse Persistence Tools
 */
@Setter @Getter
public class EduStudent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4395909158576721991L;
	private Long id;
	private String eduId;
	private String eduDesignation;
	private String name;
	private String technology;
	private String userName;
	private String userPass;
	private String idcard;
	private Integer creditHour;
	
	private String admin;// 系统管理员
	private String state;// 账号状态
	
	private String simManager;// A-系统管理员 B-安全保密管理员 C-安全审计人员
	private String role;// role1-新建 role2-修改 role3-删除

	// Constructors

	/** default constructor */
	public EduStudent() {
	}

	/** minimal constructor */
	public EduStudent(Long id, String eduId) {
		this.id = id;
		this.eduId = eduId;
	}

	/** full constructor */
	public EduStudent(Long id, String eduId, String eduDesignation,
			String name, String technology, String userName, String userPass,
			String idcard, Integer creditHour) {
		this.id = id;
		this.eduId = eduId;
		this.eduDesignation = eduDesignation;
		this.name = name;
		this.technology = technology;
		this.userName = userName;
		this.userPass = userPass;
		this.idcard = idcard;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getCreditHour() {
		return this.creditHour;
	}

	public void setCreditHour(Integer creditHour) {
		this.creditHour = creditHour;
	}

}