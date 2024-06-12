package com.ycyl.edu.std.entity;

import java.math.BigDecimal;


/**
 * StdDisease entity. @author MyEclipse Persistence Tools
 */

public class StdDisease  implements java.io.Serializable {


	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1598400718683497484L;
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
	private String cname;
	private String accodeflag;
	private String manflag;
	private String nodeathflag;
	private String womanflag;
	private String documentz;
	private String linkz;
	private String lineage;
	private Long stopedflag;
	private String noprimaryflag;
	private String externalcauseflag;
	private String tumourmorphologicflag;
	private String cnameindex;
	private String stdconsultationsubject;
	private String outercaseflag;
	private String noprimarynoecflag;
	private String rfrcode;
	private Long attentionflag;
	private String clinicalDiagnosis;
	private String cdIndex;
	private String operationFlag;
	private String flag_1;

	// Constructors

    /** default constructor */
    public StdDisease() {
    	
    }

    
    /** full constructor */
    public StdDisease(String accode, String attributes, String code, String comment, Long flag, String indexcode, Long isleaf, Long level, String name, String nameen, String names, String namesen, String parent, BigDecimal parentid, String seqno, String statcode, String cname, String accodeflag, String manflag, String nodeathflag, String womanflag, String documentz, String linkz, String lineage, Long stopedflag, String noprimaryflag, String externalcauseflag, String tumourmorphologicflag, String cnameindex, String stdconsultationsubject, String outercaseflag, String noprimarynoecflag, String rfrcode, Long attentionflag, String clinicalDiagnosis, String cdIndex, String operationFlag, String flag_1) {
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
        this.cname = cname;
        this.accodeflag = accodeflag;
        this.manflag = manflag;
        this.nodeathflag = nodeathflag;
        this.womanflag = womanflag;
        this.documentz = documentz;
        this.linkz = linkz;
        this.lineage = lineage;
        this.stopedflag = stopedflag;
        this.noprimaryflag = noprimaryflag;
        this.externalcauseflag = externalcauseflag;
        this.tumourmorphologicflag = tumourmorphologicflag;
        this.cnameindex = cnameindex;
        this.stdconsultationsubject = stdconsultationsubject;
        this.outercaseflag = outercaseflag;
        this.noprimarynoecflag = noprimarynoecflag;
        this.rfrcode = rfrcode;
        this.attentionflag = attentionflag;
        this.clinicalDiagnosis = clinicalDiagnosis;
        this.cdIndex = cdIndex;
        this.operationFlag = operationFlag;
        this.flag_1 = flag_1;
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

    public String getCname() {
        return this.cname;
    }
    
    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAccodeflag() {
        return this.accodeflag;
    }
    
    public void setAccodeflag(String accodeflag) {
        this.accodeflag = accodeflag;
    }

    public String getManflag() {
        return this.manflag;
    }
    
    public void setManflag(String manflag) {
        this.manflag = manflag;
    }

    public String getNodeathflag() {
        return this.nodeathflag;
    }
    
    public void setNodeathflag(String nodeathflag) {
        this.nodeathflag = nodeathflag;
    }

    public String getWomanflag() {
        return this.womanflag;
    }
    
    public void setWomanflag(String womanflag) {
        this.womanflag = womanflag;
    }

    public String getDocumentz() {
        return this.documentz;
    }
    
    public void setDocumentz(String documentz) {
        this.documentz = documentz;
    }

    public String getLinkz() {
        return this.linkz;
    }
    
    public void setLinkz(String linkz) {
        this.linkz = linkz;
    }

    public String getLineage() {
        return this.lineage;
    }
    
    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public Long getStopedflag() {
        return this.stopedflag;
    }
    
    public void setStopedflag(Long stopedflag) {
        this.stopedflag = stopedflag;
    }

    public String getNoprimaryflag() {
        return this.noprimaryflag;
    }
    
    public void setNoprimaryflag(String noprimaryflag) {
        this.noprimaryflag = noprimaryflag;
    }

    public String getExternalcauseflag() {
        return this.externalcauseflag;
    }
    
    public void setExternalcauseflag(String externalcauseflag) {
        this.externalcauseflag = externalcauseflag;
    }

    public String getTumourmorphologicflag() {
        return this.tumourmorphologicflag;
    }
    
    public void setTumourmorphologicflag(String tumourmorphologicflag) {
        this.tumourmorphologicflag = tumourmorphologicflag;
    }

    public String getCnameindex() {
        return this.cnameindex;
    }
    
    public void setCnameindex(String cnameindex) {
        this.cnameindex = cnameindex;
    }

    public String getStdconsultationsubject() {
        return this.stdconsultationsubject;
    }
    
    public void setStdconsultationsubject(String stdconsultationsubject) {
        this.stdconsultationsubject = stdconsultationsubject;
    }

    public String getOutercaseflag() {
        return this.outercaseflag;
    }
    
    public void setOutercaseflag(String outercaseflag) {
        this.outercaseflag = outercaseflag;
    }

    public String getNoprimarynoecflag() {
        return this.noprimarynoecflag;
    }
    
    public void setNoprimarynoecflag(String noprimarynoecflag) {
        this.noprimarynoecflag = noprimarynoecflag;
    }

    public String getRfrcode() {
        return this.rfrcode;
    }
    
    public void setRfrcode(String rfrcode) {
        this.rfrcode = rfrcode;
    }

    public Long getAttentionflag() {
        return this.attentionflag;
    }
    
    public void setAttentionflag(Long attentionflag) {
        this.attentionflag = attentionflag;
    }

    public String getClinicalDiagnosis() {
        return this.clinicalDiagnosis;
    }
    
    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
    }

    public String getCdIndex() {
        return this.cdIndex;
    }
    
    public void setCdIndex(String cdIndex) {
        this.cdIndex = cdIndex;
    }

    public String getOperationFlag() {
        return this.operationFlag;
    }
    
    public void setOperationFlag(String operationFlag) {
        this.operationFlag = operationFlag;
    }

    public String getFlag_1() {
        return this.flag_1;
    }
    
    public void setFlag_1(String flag_1) {
        this.flag_1 = flag_1;
    }
   








}