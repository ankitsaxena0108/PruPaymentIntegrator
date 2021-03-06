package com.prud.zm.pi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.poiji.annotation.ExcelCellName;

@JsonPropertyOrder({ "PAYRCOY", "PAYRNUM", "MANDREF", "BANKKEY", "BANKACCKEY", "BILLCD", "CHDRPFX", "CHDRCOY",
		"CHDRNUM", "SERVUNIT", "CNTTYPE", "CNTCURR", "OCCDATE", "CCDATE", "PTDATE", "BTDATE", "BILLDATE", "BILLCHNL",
		"BANKCODE", "INSTFROM", "INSTTO", "INSTBCHNL", "INSTCCHNL", "INSTFREQ", "INSTAMT01", "INSTAMT02", "INSTAMT03",
		"INSTAMT04", "INSTAMT05", "INSTAMT06", "INSTAMT07", "INSTAMT08", "INSTAMT09", "INSTAMT10", "INSTAMT11",
		"INSTAMT12", "INSTAMT13", "INSTAMT14", "INSTAMT15", "INSTJCTL", "GRUPKEY", "MEMBSEL", "FACTHOUS", "COWNPFX",
		"COWNCOY", "COWNNUM", "PAYRPFX", "CNTBRANCH", "AGNTPFX", "AGNTCOY", "AGNTNUM", "PAYFLAG", "BILFLAG", "OUTFLAG",
		"SUPFLAG", "COMPANY", "JOBNO", "SACSCODE", "SACSTYP", "GLMAP", "DHNFLAG", "ORIGINAL_MANDSTAT", "DDDEREF",
		"RDOCPFX", "RDOCCOY", "RDOCNUM", "NEXTDATE", "USER_PROFILE", "JOB_NAME", "DATIME" })

public class ILData {

	/* private Long id; */
	@ExcelCellName("PAYRCOY")
	@JsonProperty("PAYRCOY")
	private String payrCOY;
	@JsonProperty("PAYRNUM")
	@ExcelCellName("PAYRNUM")
	private String payrNUM;
	@JsonProperty("MANDREF")
	@ExcelCellName("MANDREF")
	private String mandRef;
	@JsonProperty("BANKKEY")
	@ExcelCellName("BANKKEY")
	private String bankKey;
	@JsonProperty("BANKACCKEY")
	@ExcelCellName("BANKACCKEY")
	private String bankAccKey;
	@JsonProperty("BILLCD")
	@ExcelCellName("BILLCD")
	private String billCD;
	@JsonProperty("CHDRPFX")
	@ExcelCellName("CHDRPFX")
	private String chdrPFX;
	@JsonProperty("CHDRCOY")
	@ExcelCellName("CHDRCOY")
	private String chdrCOY;
	@JsonProperty("CHDRNUM")
	@ExcelCellName("CHDRNUM")
	private String chdrNUM;
	@JsonProperty("SERVUNIT")
	@ExcelCellName("SERVUNIT")
	private String servUnit;
	@JsonProperty("CNTTYPE")
	@ExcelCellName("CNTTYPE")
	private String cntType;
	@JsonProperty("CNTCURR")
	@ExcelCellName("CNTCURR")
	private String cntCurr;
	@JsonProperty("OCCDATE")
	@ExcelCellName("OCCDATE")
	private String occDate;
	@JsonProperty("CCDATE")
	@ExcelCellName("CCDATE")
	private String ccDate;
	@JsonProperty("PTDATE")
	@ExcelCellName("PTDATE")
	private String ptDate;
	@JsonProperty("BTDATE")
	@ExcelCellName("BTDATE")
	private String byDate;
	@JsonProperty("BILLDATE")
	@ExcelCellName("BILLDATE")
	private String billDate;
	@JsonProperty("BILLCHNL")
	@ExcelCellName("BILLCHNL")
	private String billCHNL;
	@JsonProperty("BANKCODE")
	@ExcelCellName("BANKCODE")
	private String bankCode;
	@JsonProperty("INSTFROM")
	@ExcelCellName("INSTFROM")
	private String instFrom;
	@JsonProperty("INSTTO")
	@ExcelCellName("INSTTO")
	private String instTo;
	@JsonProperty("INSTBCHNL")
	@ExcelCellName("INSTBCHNL")
	private String instBCHNL;
	@JsonProperty("INSTCCHNL")
	@ExcelCellName("INSTCCHNL")
	private String instCCHNL;
	@JsonProperty("INSTFREQ")
	@ExcelCellName("INSTFREQ")
	private String instFreq;
	@JsonProperty("INSTAMT01")
	@ExcelCellName("INSTAMT01")
	private String instAmt01;
	@JsonProperty("INSTAMT02")
	@ExcelCellName("INSTAMT02")
	private String instAmt02;
	@JsonProperty("INSTAMT03")
	@ExcelCellName("INSTAMT03")
	private String instAmt03;
	@JsonProperty("INSTAMT04")
	@ExcelCellName("INSTAMT04")
	private String instAmt04;
	@JsonProperty("INSTAMT05")
	@ExcelCellName("INSTAMT05")
	private String instAmt05;
	@JsonProperty("INSTAMT06")
	@ExcelCellName("INSTAMT06")
	private String instAmt06;
	@JsonProperty("INSTAMT07")
	@ExcelCellName("INSTAMT07")
	private String instAmt07;
	@JsonProperty("INSTAMT08")
	@ExcelCellName("INSTAMT08")
	private String instAmt08;
	@JsonProperty("INSTAMT09")
	@ExcelCellName("INSTAMT09")
	private String instAmt09;
	@JsonProperty("INSTAMT10")
	@ExcelCellName("INSTAMT10")
	private String instAmt10;
	@JsonProperty("INSTAMT11")
	@ExcelCellName("INSTAMT11")
	private String instAmt11;
	@JsonProperty("INSTAMT12")
	@ExcelCellName("INSTAMT12")
	private String instAmt12;
	@JsonProperty("INSTAMT13")
	@ExcelCellName("INSTAMT13")
	private String instAmt13;
	@JsonProperty("INSTAMT14")
	@ExcelCellName("INSTAMT14")
	private String instAmt14;
	@JsonProperty("INSTAMT15")
	@ExcelCellName("INSTAMT15")
	private String instAmt15;
	@JsonProperty("GRUPKEY")
	@ExcelCellName("GRUPKEY")
	private String grupKey;
	@JsonProperty("MEMBSEL")
	@ExcelCellName("MEMBSEL")
	private String membSel;
	@JsonProperty("FACTHOUS")
	@ExcelCellName("FACTHOUS")
	private String factHous;
	@JsonProperty("COWNPFX")
	@ExcelCellName("COWNPFX")
	private String cownPFX;
	@JsonProperty("COWNCOY")
	@ExcelCellName("COWNCOY")
	private String cownCOY;
	@JsonProperty("COWNNUM")
	@ExcelCellName("COWNNUM")
	private String cownNUM;
	@JsonProperty("PAYRPFX")
	@ExcelCellName("PAYRPFX")
	private String payrPFX;
	@JsonProperty("CNTBRANCH")
	@ExcelCellName("CNTBRANCH")
	private String cntBranch;
	@JsonProperty("AGNTPFX")
	@ExcelCellName("AGNTPFX")
	private String agntPFX;
	@JsonProperty("AGNTCOY")
	@ExcelCellName("AGNTCOY")
	private String agntCOY;
	@JsonProperty("AGNTNUM")
	@ExcelCellName("AGNTNUM")
	private String agntNUM;
	@JsonProperty("PAYFLAG")
	@ExcelCellName("PAYFLAG")
	private String payFlag;
	@JsonProperty("BILFLAG")
	@ExcelCellName("BILFLAG")
	private String bilFlag;
	@JsonProperty("OUTFLAG")
	@ExcelCellName("OUTFLAG")
	private String outFlag;
	@JsonProperty("SUPFLAG")
	@ExcelCellName("SUPFLAG")
	private String supFLAG;
	@JsonProperty("COMPANY")
	@ExcelCellName("COMPANY")
	private String company;
	@JsonProperty("JOBNO")
	@ExcelCellName("JOBNO")
	private String jobNO;
	@JsonProperty("SACSCODE")
	@ExcelCellName("SACSCODE")
	private String sacsCode;
	@JsonProperty("SACSTYP")
	@ExcelCellName("SACSTYP")
	private String sacsTyp;
	@JsonProperty("GLMAP")
	@ExcelCellName("GLMAP")
	private String glMap;
	@JsonProperty("DHNFLAG")
	@ExcelCellName("DHNFLAG")
	private String dhnFlag;
	@JsonProperty("ORIGINAL_MANDSTAT")
	@ExcelCellName("ORIGINAL_MANDSTAT")
	private String originalMandStat;
	@JsonProperty("DDDEREF")
	@ExcelCellName("DDDEREF")
	private String dddeRef;
	@JsonProperty("RDOCPFX")
	@ExcelCellName("RDOCPFX")
	private String rdocPFX;
	@JsonProperty("RDOCCOY")
	@ExcelCellName("RDOCCOY")
	private String rdocCOY;
	@JsonProperty("RDOCNUM")
	@ExcelCellName("RDOCNUM")
	private String rdocNUM;
	@JsonProperty("NEXTDATE")
	@ExcelCellName("NEXTDATE")
	private String nextDate;
	@JsonProperty("USER_PROFILE")
	@ExcelCellName("USER_PROFILE")
	private String userProfile;
	@JsonProperty("JOB_NAME")
	@ExcelCellName("JOB_NAME")
	private String jobName;
	@JsonProperty("DATIME")
	@ExcelCellName("DATIME")
	private String daTime;

	/*
	 * public Long getId() { return id; } public void setId(Long id) { this.id = id;
	 * }
	 */public String getPayrCOY() {
		return payrCOY;
	}

	public void setPayrCOY(String payrCOY) {
		this.payrCOY = payrCOY;
	}

	public String getPayrNUM() {
		return payrNUM;
	}

	public void setPayrNUM(String payrNUM) {
		this.payrNUM = payrNUM;
	}

	public String getMandRef() {
		return mandRef;
	}

	public void setMandRef(String mandRef) {
		this.mandRef = mandRef;
	}

	public String getBankKey() {
		return bankKey;
	}

	public void setBankKey(String bankKey) {
		this.bankKey = bankKey;
	}

	public String getBankAccKey() {
		return bankAccKey;
	}

	public void setBankAccKey(String bankAccKey) {
		this.bankAccKey = bankAccKey;
	}

	public String getBillCD() {
		return billCD;
	}

	public void setBillCD(String billCD) {
		this.billCD = billCD;
	}

	public String getChdrPFX() {
		return chdrPFX;
	}

	public void setChdrPFX(String chdrPFX) {
		this.chdrPFX = chdrPFX;
	}

	public String getChdrCOY() {
		return chdrCOY;
	}

	public void setChdrCOY(String chdrCOY) {
		this.chdrCOY = chdrCOY;
	}

	public String getChdrNUM() {
		return chdrNUM;
	}

	public void setChdrNUM(String chdrNUM) {
		this.chdrNUM = chdrNUM;
	}

	public String getServUnit() {
		return servUnit;
	}

	public void setServUnit(String servUnit) {
		this.servUnit = servUnit;
	}

	public String getCntType() {
		return cntType;
	}

	public void setCntType(String cntType) {
		this.cntType = cntType;
	}

	public String getOccDate() {
		return occDate;
	}

	public void setOccDate(String occDate) {
		this.occDate = occDate;
	}

	public String getCcDate() {
		return ccDate;
	}

	public void setCcDate(String ccDate) {
		this.ccDate = ccDate;
	}

	public String getPtDate() {
		return ptDate;
	}

	public void setPtDate(String ptDate) {
		this.ptDate = ptDate;
	}

	public String getByDate() {
		return byDate;
	}

	public void setByDate(String byDate) {
		this.byDate = byDate;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getBillCHNL() {
		return billCHNL;
	}

	public void setBillCHNL(String billCHNL) {
		this.billCHNL = billCHNL;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getInstFrom() {
		return instFrom;
	}

	public void setInstFrom(String instFrom) {
		this.instFrom = instFrom;
	}

	public String getInstTo() {
		return instTo;
	}

	public void setInstTo(String instTo) {
		this.instTo = instTo;
	}

	public String getInstBCHNL() {
		return instBCHNL;
	}

	public void setInstBCHNL(String instBCHNL) {
		this.instBCHNL = instBCHNL;
	}

	public String getInstCCHNL() {
		return instCCHNL;
	}

	public void setInstCCHNL(String instCCHNL) {
		this.instCCHNL = instCCHNL;
	}

	public String getInstFreq() {
		return instFreq;
	}

	public void setInstFreq(String instFreq) {
		this.instFreq = instFreq;
	}

	public String getInstAmt01() {
		return instAmt01;
	}

	public void setInstAmt01(String instAmt01) {
		this.instAmt01 = instAmt01;
	}

	public String getInstAmt02() {
		return instAmt02;
	}

	public void setInstAmt02(String instAmt02) {
		this.instAmt02 = instAmt02;
	}

	public String getInstAmt03() {
		return instAmt03;
	}

	public void setInstAmt03(String instAmt03) {
		this.instAmt03 = instAmt03;
	}

	public String getInstAmt04() {
		return instAmt04;
	}

	public void setInstAmt04(String instAmt04) {
		this.instAmt04 = instAmt04;
	}

	public String getInstAmt05() {
		return instAmt05;
	}

	public void setInstAmt05(String instAmt05) {
		this.instAmt05 = instAmt05;
	}

	public String getInstAmt06() {
		return instAmt06;
	}

	public void setInstAmt06(String instAmt06) {
		this.instAmt06 = instAmt06;
	}

	public String getInstAmt07() {
		return instAmt07;
	}

	public void setInstAmt07(String instAmt07) {
		this.instAmt07 = instAmt07;
	}

	public String getInstAmt08() {
		return instAmt08;
	}

	public void setInstAmt08(String instAmt08) {
		this.instAmt08 = instAmt08;
	}

	public String getInstAmt09() {
		return instAmt09;
	}

	public void setInstAmt09(String instAmt09) {
		this.instAmt09 = instAmt09;
	}

	public String getInstAmt10() {
		return instAmt10;
	}

	public void setInstAmt10(String instAmt10) {
		this.instAmt10 = instAmt10;
	}

	public String getInstAmt11() {
		return instAmt11;
	}

	public void setInstAmt11(String instAmt11) {
		this.instAmt11 = instAmt11;
	}

	public String getInstAmt12() {
		return instAmt12;
	}

	public void setInstAmt12(String instAmt12) {
		this.instAmt12 = instAmt12;
	}

	public String getInstAmt13() {
		return instAmt13;
	}

	public void setInstAmt13(String instAmt13) {
		this.instAmt13 = instAmt13;
	}

	public String getInstAmt14() {
		return instAmt14;
	}

	public void setInstAmt14(String instAmt14) {
		this.instAmt14 = instAmt14;
	}

	public String getInstAmt15() {
		return instAmt15;
	}

	public void setInstAmt15(String instAmt15) {
		this.instAmt15 = instAmt15;
	}

	public String getGrupKey() {
		return grupKey;
	}

	public void setGrupKey(String grupKey) {
		this.grupKey = grupKey;
	}

	public String getMembSel() {
		return membSel;
	}

	public void setMembSel(String membSel) {
		this.membSel = membSel;
	}

	public String getFactHous() {
		return factHous;
	}

	public void setFactHous(String factHous) {
		this.factHous = factHous;
	}

	public String getCownPFX() {
		return cownPFX;
	}

	public void setCownPFX(String cownPFX) {
		this.cownPFX = cownPFX;
	}

	public String getCownCOY() {
		return cownCOY;
	}

	public void setCownCOY(String cownCOY) {
		this.cownCOY = cownCOY;
	}

	public String getCownNUM() {
		return cownNUM;
	}

	public void setCownNUM(String cownNUM) {
		this.cownNUM = cownNUM;
	}

	public String getPayrPFX() {
		return payrPFX;
	}

	public void setPayrPFX(String payrPFX) {
		this.payrPFX = payrPFX;
	}

	public String getCntBranch() {
		return cntBranch;
	}

	public void setCntBranch(String cntBranch) {
		this.cntBranch = cntBranch;
	}

	public String getAgntPFX() {
		return agntPFX;
	}

	public void setAgntPFX(String agntPFX) {
		this.agntPFX = agntPFX;
	}

	public String getAgntCOY() {
		return agntCOY;
	}

	public void setAgntCOY(String agntCOY) {
		this.agntCOY = agntCOY;
	}

	public String getAgntNUM() {
		return agntNUM;
	}

	public void setAgntNUM(String agntNUM) {
		this.agntNUM = agntNUM;
	}

	public String getPayFlag() {
		return payFlag;
	}

	public void setPayFlag(String payFlag) {
		this.payFlag = payFlag;
	}

	public String getBilFlag() {
		return bilFlag;
	}

	public void setBilFlag(String bilFlag) {
		this.bilFlag = bilFlag;
	}

	public String getOutFlag() {
		return outFlag;
	}

	public void setOutFlag(String outFlag) {
		this.outFlag = outFlag;
	}

	public String getSupFLAG() {
		return supFLAG;
	}

	public void setSupFLAG(String supFLAG) {
		this.supFLAG = supFLAG;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJobNO() {
		return jobNO;
	}

	public void setJobNO(String jobNO) {
		this.jobNO = jobNO;
	}

	public String getSacsCode() {
		return sacsCode;
	}

	public void setSacsCode(String sacsCode) {
		this.sacsCode = sacsCode;
	}

	public String getSacsTyp() {
		return sacsTyp;
	}

	public void setSacsTyp(String sacsTyp) {
		this.sacsTyp = sacsTyp;
	}

	public String getGlMap() {
		return glMap;
	}

	public void setGlMap(String glMap) {
		this.glMap = glMap;
	}

	public String getDhnFlag() {
		return dhnFlag;
	}

	public void setDhnFlag(String dhnFlag) {
		this.dhnFlag = dhnFlag;
	}

	public String getOriginalMandStat() {
		return originalMandStat;
	}

	public void setOriginalMandStat(String originalMandStat) {
		this.originalMandStat = originalMandStat;
	}

	public String getDddeRef() {
		return dddeRef;
	}

	public void setDddeRef(String dddeRef) {
		this.dddeRef = dddeRef;
	}

	public String getRdocPFX() {
		return rdocPFX;
	}

	public void setRdocPFX(String rdocPFX) {
		this.rdocPFX = rdocPFX;
	}

	public String getRdocCOY() {
		return rdocCOY;
	}

	public void setRdocCOY(String rdocCOY) {
		this.rdocCOY = rdocCOY;
	}

	public String getRdocNUM() {
		return rdocNUM;
	}

	public void setRdocNUM(String rdocNUM) {
		this.rdocNUM = rdocNUM;
	}

	public String getNextDate() {
		return nextDate;
	}

	public void setNextDate(String nextDate) {
		this.nextDate = nextDate;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDaTime() {
		return daTime;
	}

	public void setDaTime(String daTime) {
		this.daTime = daTime;
	}

	public String getCntCurr() {
		return cntCurr;
	}

	public void setCntCurr(String cntCurr) {
		this.cntCurr = cntCurr;
	}

	@Override
	public String toString() {
		return "ILData [, payrCOY=" + payrCOY + ", payrNUM=" + payrNUM + ", mandRef=" + mandRef + ", bankKey=" + bankKey
				+ ", bankAccKey=" + bankAccKey + ", billCD=" + billCD + ", chdrPFX=" + chdrPFX + ", chdrCOY=" + chdrCOY
				+ ", chdrNUM=" + chdrNUM + ", servUnit=" + servUnit + ", cntType=" + cntType + ", cntCurr=" + cntCurr
				+ ", occDate=" + occDate + ", ccDate=" + ccDate + ", ptDate=" + ptDate + ", byDate=" + byDate
				+ ", billDate=" + billDate + ", billCHNL=" + billCHNL + ", bankCode=" + bankCode + ", instFrom="
				+ instFrom + ", instTo=" + instTo + ", instBCHNL=" + instBCHNL + ", instCCHNL=" + instCCHNL
				+ ", instFreq=" + instFreq + ", instAmt01=" + instAmt01 + ", instAmt02=" + instAmt02 + ", instAmt03="
				+ instAmt03 + ", instAmt04=" + instAmt04 + ", instAmt05=" + instAmt05 + ", instAmt06=" + instAmt06
				+ ", instAmt07=" + instAmt07 + ", instAmt08=" + instAmt08 + ", instAmt09=" + instAmt09 + ", instAmt10="
				+ instAmt10 + ", instAmt11=" + instAmt11 + ", instAmt12=" + instAmt12 + ", instAmt13=" + instAmt13
				+ ", instAmt14=" + instAmt14 + ", instAmt15=" + instAmt15 + ", grupKey=" + grupKey + ", membSel="
				+ membSel + ", factHous=" + factHous + ", cownPFX=" + cownPFX + ", cownCOY=" + cownCOY + ", cownNUM="
				+ cownNUM + ", payrPFX=" + payrPFX + ", cntBranch=" + cntBranch + ", agntPFX=" + agntPFX + ", agntCOY="
				+ agntCOY + ", agntNUM=" + agntNUM + ", payFlag=" + payFlag + ", bilFlag=" + bilFlag + ", outFlag="
				+ outFlag + ", supFLAG=" + supFLAG + ", company=" + company + ", jobNO=" + jobNO + ", sacsCode="
				+ sacsCode + ", sacsTyp=" + sacsTyp + ", glMap=" + glMap + ", dhnFlag=" + dhnFlag
				+ ", originalMandStat=" + originalMandStat + ", dddeRef=" + dddeRef + ", rdocPFX=" + rdocPFX
				+ ", rdocCOY=" + rdocCOY + ", rdocNUM=" + rdocNUM + ", nextDate=" + nextDate + ", userProfile="
				+ userProfile + ", jobName=" + jobName + ", daTime=" + daTime + "]";
	}
}
