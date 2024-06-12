package com.ycyl.edu.std.entity;

import java.math.BigDecimal;


/**
 * StdEduRelease entity. @author MyEclipse Persistence Tools
 */

public class StdEduRelease  implements java.io.Serializable {


	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8636601317457188836L;
	private BigDecimal id;
	private BigDecimal parentid;
	private String attributues;
	private String code;
	private String indexcode;
	private String name;
	private String shortname;
	private String nameen;
	private String stopedflag;
	private String comment;


    // Constructors

    /** default constructor */
    public StdEduRelease() {
    }

    
    /** full constructor */
    public StdEduRelease(BigDecimal parentid, String attributues, String code, String indexcode, String name, String shortname, String nameen, String stopedflag, String comment) {
        this.parentid = parentid;
        this.attributues = attributues;
        this.code = code;
        this.indexcode = indexcode;
        this.name = name;
        this.shortname = shortname;
        this.nameen = nameen;
        this.stopedflag = stopedflag;
        this.comment = comment;
    }

   
    // Property accessors

    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getParentid() {
        return this.parentid;
    }
    
    public void setParentid(BigDecimal parentid) {
        this.parentid = parentid;
    }

    public String getAttributues() {
        return this.attributues;
    }
    
    public void setAttributues(String attributues) {
        this.attributues = attributues;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getIndexcode() {
        return this.indexcode;
    }
    
    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return this.shortname;
    }
    
    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getNameen() {
        return this.nameen;
    }
    
    public void setNameen(String nameen) {
        this.nameen = nameen;
    }

    public String getStopedflag() {
        return this.stopedflag;
    }
    
    public void setStopedflag(String stopedflag) {
        this.stopedflag = stopedflag;
    }

    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
   








}