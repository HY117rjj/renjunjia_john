package com.ycyl.edu.std.entity;

import java.math.BigDecimal;


/**
 * StdEducationalMajor entity. @author MyEclipse Persistence Tools
 */

public class StdEducationalMajor  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3051303456256762743L;
	// Fields

	private BigDecimal id;
	private String accode;
	private String attributes;
	private String code;
	private String comment;
	private Long flag;
	private String indexcode;
	private Long isleaf;
	private Long level;
	private String name;
	private String nameen;
	private String names;
	private String namesen;
	private String parent;
	private BigDecimal parentid;
	private String seqno;
	private String statcode;

    // Constructors

    /** default constructor */
    public StdEducationalMajor() {
    	
    }

    
    /** full constructor */
    public StdEducationalMajor(String accode, String attributes, String code, String comment, Long flag, String indexcode, Long isleaf, Long level, String name, String nameen, String names, String namesen, String parent, BigDecimal parentid, String seqno, String statcode) {
        this.accode = accode;
        this.attributes = attributes;
        this.code = code;
        this.comment = comment;
        this.flag = flag;
        this.indexcode = indexcode;
        this.isleaf = isleaf;
        this.level = level;
        this.name = name;
        this.nameen = nameen;
        this.names = names;
        this.namesen = namesen;
        this.parent = parent;
        this.parentid = parentid;
        this.seqno = seqno;
        this.statcode = statcode;
    }

   
    // Property accessors

    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAccode() {
        return this.accode;
    }
    
    public void setAccode(String accode) {
        this.accode = accode;
    }

    public String getAttributes() {
        return this.attributes;
    }
    
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getFlag() {
        return this.flag;
    }
    
    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public String getIndexcode() {
        return this.indexcode;
    }
    
    public void setIndexcode(String indexcode) {
        this.indexcode = indexcode;
    }

    public Long getIsleaf() {
        return this.isleaf;
    }
    
    public void setIsleaf(Long isleaf) {
        this.isleaf = isleaf;
    }

    public Long getLevel() {
        return this.level;
    }
    
    public void setLevel(Long level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNameen() {
        return this.nameen;
    }
    
    public void setNameen(String nameen) {
        this.nameen = nameen;
    }

    public String getNames() {
        return this.names;
    }
    
    public void setNames(String names) {
        this.names = names;
    }

    public String getNamesen() {
        return this.namesen;
    }
    
    public void setNamesen(String namesen) {
        this.namesen = namesen;
    }

    public String getParent() {
        return this.parent;
    }
    
    public void setParent(String parent) {
        this.parent = parent;
    }

    public BigDecimal getParentid() {
        return this.parentid;
    }
    
    public void setParentid(BigDecimal parentid) {
        this.parentid = parentid;
    }

    public String getSeqno() {
        return this.seqno;
    }
    
    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    public String getStatcode() {
        return this.statcode;
    }
    
    public void setStatcode(String statcode) {
        this.statcode = statcode;
    }
   








}