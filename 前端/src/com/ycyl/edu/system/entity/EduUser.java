package com.ycyl.edu.system.entity;

import java.sql.Timestamp;

import lombok.Data;

/**
 * EduUser entity. @author MyEclipse Persistence Tools
 */
@Data
public class EduUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4677395230135644988L;
	private Long id;
	private String idcard;
	private String name;
	private Timestamp signTime;
	private Double charge;
	
	private String signTime_;

	// Constructors

	/** default constructor */
	public EduUser() {
	}

	/** minimal constructor */
	public EduUser(Long id, String idcard) {
		this.id = id;
		this.idcard = idcard;
	}

	/** full constructor */
	public EduUser(Long id, String idcard, String name,
			Timestamp signTime, Double charge) {
		this.id = id;
		this.idcard = idcard;
		this.name = name;
		this.signTime = signTime;
		this.charge = charge;
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

	public Timestamp getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Timestamp signTime) {
		this.signTime = signTime;
	}

	public Double getCharge() {
		return this.charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

}