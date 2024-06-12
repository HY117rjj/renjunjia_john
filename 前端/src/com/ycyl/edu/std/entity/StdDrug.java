package com.ycyl.edu.std.entity;

import java.math.BigDecimal;


/**
 * StdDrug entity. @author MyEclipse Persistence Tools
 */

public class StdDrug implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6207765896132127418L;
	private BigDecimal id;
	private String stopedflag;
	private String stopComment;
	private BigDecimal parentNumber;
	private BigDecimal rootNumber;
	private BigDecimal serialNumber;
	private String attribute;
	private String transcode01;
	private String transcode02;
	private String transcode03;
	private String transcode04;
	private String transcode05;
	private String transcode06;
	private String transcode07;
	private String transcode08;
	private String transcode09;
	private String code;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String indexName1;
	private String indexName2;
	private String indexName3;
	private String indexName4;
	private String indexName5;
	private Byte level;
	private String acidBase;
	private String mainComponent;
	private String chemicalFormula;
	private String molecularFormula;
	private String molecularWeight;
	private String properties;
	private String phToxicology;
	private String phAction;
	private String pharmacokinetics;
	private String indication;
	private String usageDosage;
	private String adverseReaction;
	private String taboo;
	private String sign01;
	private String sign02;
	private String sign03;
	private String sign04;
	private String sign05;
	private String sign06;
	private String sign07;
	private String sign08;
	private String sign09;
	private String sign10;
	private String sign11;
	private String sign12;
	private String antimicrobialCtrl;
	private String narcoticDrug;
	private String psychotropicDrug;
	private String chineseDrug;
	private String icfId;
	private String enterpriseId;
	private String enterprise;
	private String approvalNumber;
	private Short packingNumber;
	private String packingUnit;
	private Short giveNumber;
	private Double giveUnitPrice;
	private String giveUnit;
	private String preparationUnit;
	private String specification;
	private String dosageForm;
	private String routeAdmin;
	private String appendix;
	private String comment;
	private String nameEn;
	private String interaction;
	private String preparation;
	private String storage;

	// Constructors

	/** default constructor */
	public StdDrug() {
    }

    
    /** full constructor */
    public StdDrug(String stopedflag, String stopComment, BigDecimal parentNumber, BigDecimal rootNumber, BigDecimal serialNumber, String attribute, String transcode01, String transcode02, String transcode03, String transcode04, String transcode05, String transcode06, String transcode07, String transcode08, String transcode09, String code, String name1, String name2, String name3, String name4, String name5, String indexName1, String indexName2, String indexName3, String indexName4, String indexName5, Byte level, String acidBase, String mainComponent, String chemicalFormula, String molecularFormula, String molecularWeight, String properties, String phToxicology, String phAction, String pharmacokinetics, String indication, String usageDosage, String adverseReaction, String taboo, String sign01, String sign02, String sign03, String sign04, String sign05, String sign06, String sign07, String sign08, String sign09, String sign10, String sign11, String sign12, String antimicrobialCtrl, String narcoticDrug, String psychotropicDrug, String chineseDrug, String icfId, String enterpriseId, String enterprise, String approvalNumber, Short packingNumber, String packingUnit, Short giveNumber, Double giveUnitPrice, String giveUnit, String preparationUnit, String specification, String dosageForm, String routeAdmin, String appendix, String comment, String nameEn, String interaction, String preparation, String storage) {
        this.stopedflag = stopedflag;
        this.stopComment = stopComment;
        this.parentNumber = parentNumber;
        this.rootNumber = rootNumber;
        this.serialNumber = serialNumber;
        this.attribute = attribute;
        this.transcode01 = transcode01;
        this.transcode02 = transcode02;
        this.transcode03 = transcode03;
        this.transcode04 = transcode04;
        this.transcode05 = transcode05;
        this.transcode06 = transcode06;
        this.transcode07 = transcode07;
        this.transcode08 = transcode08;
        this.transcode09 = transcode09;
        this.code = code;
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
        this.indexName1 = indexName1;
        this.indexName2 = indexName2;
        this.indexName3 = indexName3;
        this.indexName4 = indexName4;
        this.indexName5 = indexName5;
        this.level = level;
        this.acidBase = acidBase;
        this.mainComponent = mainComponent;
        this.chemicalFormula = chemicalFormula;
        this.molecularFormula = molecularFormula;
        this.molecularWeight = molecularWeight;
        this.properties = properties;
        this.phToxicology = phToxicology;
        this.phAction = phAction;
        this.pharmacokinetics = pharmacokinetics;
        this.indication = indication;
        this.usageDosage = usageDosage;
        this.adverseReaction = adverseReaction;
        this.taboo = taboo;
        this.sign01 = sign01;
        this.sign02 = sign02;
        this.sign03 = sign03;
        this.sign04 = sign04;
        this.sign05 = sign05;
        this.sign06 = sign06;
        this.sign07 = sign07;
        this.sign08 = sign08;
        this.sign09 = sign09;
        this.sign10 = sign10;
        this.sign11 = sign11;
        this.sign12 = sign12;
        this.antimicrobialCtrl = antimicrobialCtrl;
        this.narcoticDrug = narcoticDrug;
        this.psychotropicDrug = psychotropicDrug;
        this.chineseDrug = chineseDrug;
        this.icfId = icfId;
        this.enterpriseId = enterpriseId;
        this.enterprise = enterprise;
        this.approvalNumber = approvalNumber;
        this.packingNumber = packingNumber;
        this.packingUnit = packingUnit;
        this.giveNumber = giveNumber;
        this.giveUnitPrice = giveUnitPrice;
        this.giveUnit = giveUnit;
        this.preparationUnit = preparationUnit;
        this.specification = specification;
        this.dosageForm = dosageForm;
        this.routeAdmin = routeAdmin;
        this.appendix = appendix;
        this.comment = comment;
        this.nameEn = nameEn;
        this.interaction = interaction;
        this.preparation = preparation;
        this.storage = storage;
    }

   
    // Property accessors

    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStopedflag() {
        return this.stopedflag;
    }
    
    public void setStopedflag(String stopedflag) {
        this.stopedflag = stopedflag;
    }

    public String getStopComment() {
        return this.stopComment;
    }
    
    public void setStopComment(String stopComment) {
        this.stopComment = stopComment;
    }

    public BigDecimal getParentNumber() {
        return this.parentNumber;
    }
    
    public void setParentNumber(BigDecimal parentNumber) {
        this.parentNumber = parentNumber;
    }

    public BigDecimal getRootNumber() {
        return this.rootNumber;
    }
    
    public void setRootNumber(BigDecimal rootNumber) {
        this.rootNumber = rootNumber;
    }

    public BigDecimal getSerialNumber() {
        return this.serialNumber;
    }
    
    public void setSerialNumber(BigDecimal serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAttribute() {
        return this.attribute;
    }
    
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getTranscode01() {
        return this.transcode01;
    }
    
    public void setTranscode01(String transcode01) {
        this.transcode01 = transcode01;
    }

    public String getTranscode02() {
        return this.transcode02;
    }
    
    public void setTranscode02(String transcode02) {
        this.transcode02 = transcode02;
    }

    public String getTranscode03() {
        return this.transcode03;
    }
    
    public void setTranscode03(String transcode03) {
        this.transcode03 = transcode03;
    }

    public String getTranscode04() {
        return this.transcode04;
    }
    
    public void setTranscode04(String transcode04) {
        this.transcode04 = transcode04;
    }

    public String getTranscode05() {
        return this.transcode05;
    }
    
    public void setTranscode05(String transcode05) {
        this.transcode05 = transcode05;
    }

    public String getTranscode06() {
        return this.transcode06;
    }
    
    public void setTranscode06(String transcode06) {
        this.transcode06 = transcode06;
    }

    public String getTranscode07() {
        return this.transcode07;
    }
    
    public void setTranscode07(String transcode07) {
        this.transcode07 = transcode07;
    }

    public String getTranscode08() {
        return this.transcode08;
    }
    
    public void setTranscode08(String transcode08) {
        this.transcode08 = transcode08;
    }

    public String getTranscode09() {
        return this.transcode09;
    }
    
    public void setTranscode09(String transcode09) {
        this.transcode09 = transcode09;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getName1() {
        return this.name1;
    }
    
    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return this.name2;
    }
    
    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return this.name3;
    }
    
    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return this.name4;
    }
    
    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return this.name5;
    }
    
    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getIndexName1() {
        return this.indexName1;
    }
    
    public void setIndexName1(String indexName1) {
        this.indexName1 = indexName1;
    }

    public String getIndexName2() {
        return this.indexName2;
    }
    
    public void setIndexName2(String indexName2) {
        this.indexName2 = indexName2;
    }

    public String getIndexName3() {
        return this.indexName3;
    }
    
    public void setIndexName3(String indexName3) {
        this.indexName3 = indexName3;
    }

    public String getIndexName4() {
        return this.indexName4;
    }
    
    public void setIndexName4(String indexName4) {
        this.indexName4 = indexName4;
    }

    public String getIndexName5() {
        return this.indexName5;
    }
    
    public void setIndexName5(String indexName5) {
        this.indexName5 = indexName5;
    }

    public Byte getLevel() {
        return this.level;
    }
    
    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getAcidBase() {
        return this.acidBase;
    }
    
    public void setAcidBase(String acidBase) {
        this.acidBase = acidBase;
    }

    public String getMainComponent() {
        return this.mainComponent;
    }
    
    public void setMainComponent(String mainComponent) {
        this.mainComponent = mainComponent;
    }

    public String getChemicalFormula() {
        return this.chemicalFormula;
    }
    
    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    public String getMolecularFormula() {
        return this.molecularFormula;
    }
    
    public void setMolecularFormula(String molecularFormula) {
        this.molecularFormula = molecularFormula;
    }

    public String getMolecularWeight() {
        return this.molecularWeight;
    }
    
    public void setMolecularWeight(String molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getProperties() {
        return this.properties;
    }
    
    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getPhToxicology() {
        return this.phToxicology;
    }
    
    public void setPhToxicology(String phToxicology) {
        this.phToxicology = phToxicology;
    }

    public String getPhAction() {
        return this.phAction;
    }
    
    public void setPhAction(String phAction) {
        this.phAction = phAction;
    }

    public String getPharmacokinetics() {
        return this.pharmacokinetics;
    }
    
    public void setPharmacokinetics(String pharmacokinetics) {
        this.pharmacokinetics = pharmacokinetics;
    }

    public String getIndication() {
        return this.indication;
    }
    
    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getUsageDosage() {
        return this.usageDosage;
    }
    
    public void setUsageDosage(String usageDosage) {
        this.usageDosage = usageDosage;
    }

    public String getAdverseReaction() {
        return this.adverseReaction;
    }
    
    public void setAdverseReaction(String adverseReaction) {
        this.adverseReaction = adverseReaction;
    }

    public String getTaboo() {
        return this.taboo;
    }
    
    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getSign01() {
        return this.sign01;
    }
    
    public void setSign01(String sign01) {
        this.sign01 = sign01;
    }

    public String getSign02() {
        return this.sign02;
    }
    
    public void setSign02(String sign02) {
        this.sign02 = sign02;
    }

    public String getSign03() {
        return this.sign03;
    }
    
    public void setSign03(String sign03) {
        this.sign03 = sign03;
    }

    public String getSign04() {
        return this.sign04;
    }
    
    public void setSign04(String sign04) {
        this.sign04 = sign04;
    }

    public String getSign05() {
        return this.sign05;
    }
    
    public void setSign05(String sign05) {
        this.sign05 = sign05;
    }

    public String getSign06() {
        return this.sign06;
    }
    
    public void setSign06(String sign06) {
        this.sign06 = sign06;
    }

    public String getSign07() {
        return this.sign07;
    }
    
    public void setSign07(String sign07) {
        this.sign07 = sign07;
    }

    public String getSign08() {
        return this.sign08;
    }
    
    public void setSign08(String sign08) {
        this.sign08 = sign08;
    }

    public String getSign09() {
        return this.sign09;
    }
    
    public void setSign09(String sign09) {
        this.sign09 = sign09;
    }

    public String getSign10() {
        return this.sign10;
    }
    
    public void setSign10(String sign10) {
        this.sign10 = sign10;
    }

    public String getSign11() {
        return this.sign11;
    }
    
    public void setSign11(String sign11) {
        this.sign11 = sign11;
    }

    public String getSign12() {
        return this.sign12;
    }
    
    public void setSign12(String sign12) {
        this.sign12 = sign12;
    }

    public String getAntimicrobialCtrl() {
        return this.antimicrobialCtrl;
    }
    
    public void setAntimicrobialCtrl(String antimicrobialCtrl) {
        this.antimicrobialCtrl = antimicrobialCtrl;
    }

    public String getNarcoticDrug() {
        return this.narcoticDrug;
    }
    
    public void setNarcoticDrug(String narcoticDrug) {
        this.narcoticDrug = narcoticDrug;
    }

    public String getPsychotropicDrug() {
        return this.psychotropicDrug;
    }
    
    public void setPsychotropicDrug(String psychotropicDrug) {
        this.psychotropicDrug = psychotropicDrug;
    }

    public String getChineseDrug() {
        return this.chineseDrug;
    }
    
    public void setChineseDrug(String chineseDrug) {
        this.chineseDrug = chineseDrug;
    }

    public String getIcfId() {
        return this.icfId;
    }
    
    public void setIcfId(String icfId) {
        this.icfId = icfId;
    }

    public String getEnterpriseId() {
        return this.enterpriseId;
    }
    
    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterprise() {
        return this.enterprise;
    }
    
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getApprovalNumber() {
        return this.approvalNumber;
    }
    
    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    public Short getPackingNumber() {
        return this.packingNumber;
    }
    
    public void setPackingNumber(Short packingNumber) {
        this.packingNumber = packingNumber;
    }

    public String getPackingUnit() {
        return this.packingUnit;
    }
    
    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public Short getGiveNumber() {
        return this.giveNumber;
    }
    
    public void setGiveNumber(Short giveNumber) {
        this.giveNumber = giveNumber;
    }

    public Double getGiveUnitPrice() {
        return this.giveUnitPrice;
    }
    
    public void setGiveUnitPrice(Double giveUnitPrice) {
        this.giveUnitPrice = giveUnitPrice;
    }

    public String getGiveUnit() {
        return this.giveUnit;
    }
    
    public void setGiveUnit(String giveUnit) {
        this.giveUnit = giveUnit;
    }

    public String getPreparationUnit() {
        return this.preparationUnit;
    }
    
    public void setPreparationUnit(String preparationUnit) {
        this.preparationUnit = preparationUnit;
    }

    public String getSpecification() {
        return this.specification;
    }
    
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDosageForm() {
        return this.dosageForm;
    }
    
    public void setDosageForm(String dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getRouteAdmin() {
        return this.routeAdmin;
    }
    
    public void setRouteAdmin(String routeAdmin) {
        this.routeAdmin = routeAdmin;
    }

    public String getAppendix() {
        return this.appendix;
    }
    
    public void setAppendix(String appendix) {
        this.appendix = appendix;
    }

    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNameEn() {
        return this.nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getInteraction() {
        return this.interaction;
    }
    
    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getPreparation() {
        return this.preparation;
    }
    
    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getStorage() {
        return this.storage;
    }
    
    public void setStorage(String storage) {
        this.storage = storage;
    }
   








}