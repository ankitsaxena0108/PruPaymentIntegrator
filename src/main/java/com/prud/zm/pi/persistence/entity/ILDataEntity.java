package com.prud.zm.pi.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENTDETAILS")
public class ILDataEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="pd_id")
		private Long id;
		@Column(name = "PAYRCOY")
		private String payrCOY;
		@Column(name = "PAYRNUM")
		private String payrNUM;
		@Column(name = "MANDREF")
		private String mandRef;
		@Column(name = "BANKKEY")
		private String bankKey;
		@Column(name = "BANKACCKEY")
		private String bankAccKey;
		@Column(name = "BILLCD")
		private String billCD;
		@Column(name = "CHDRPFX")
		private String chdrPFX;
		@Column(name = "CHDRCOY")
		private String chdrCOY;
		@Column(name = "CHDRNUM")
		private String chdrNUM;
		@Column(name = "SERVUNIT")
		private String servUnit;
		@Column(name = "CNTTYPE")
		private String cntType;
		@Column(name = "CNTCURR")
		private String cntCurr;
		@Column(name = "OCCDATE")
		private String occDate;
		@Column(name = "CCDATE")
		private String ccDate;
		@Column(name = "PTDATE")
		private String ptDate;
		@Column(name = "BTDATE")
		private String byDate;
		@Column(name = "BILLDATE")
		private String billDate;
		@Column(name = "BILLCHNL")
		private String billCHNL;
		@Column(name = "BANKCODE")
		private String bankCode;
		@Column(name = "INSTFROM")
		private String instFrom;
		@Column(name = "INSTTO")
		private String instTo;
		@Column(name = "INSTBCHNL")
		private String instBCHNL;
		@Column(name = "INSTCCHNL")
		private String instCCHNL;
		@Column(name = "INSTFREQ")
		private String instFreq;
		@Column(name = "INSTAMT01")
		private String instAmt01;
		@Column(name = "INSTAMT02")
		private String instAmt02;
		@Column(name = "INSTAMT03")
		private String instAmt03;
		@Column(name = "INSTAMT04")
		private String instAmt04;
		@Column(name = "INSTAMT05")
		private String instAmt05;
		@Column(name = "INSTAMT06")
		private String instAmt06;
		@Column(name = "INSTAMT07")
		private String instAmt07;
		@Column(name = "INSTAMT08")
		private String instAmt08;
		@Column(name = "INSTAMT09")
		private String instAmt09;
		@Column(name = "INSTAMT10")
		private String instAmt10;
		@Column(name = "INSTAMT11")
		private String instAmt11;
		@Column(name = "INSTAMT12")
		private String instAmt12;
		@Column(name = "INSTAMT13")
		private String instAmt13;
		@Column(name = "INSTAMT14")
		private String instAmt14;
		@Column(name = "INSTAMT15")
		private String instAmt15;
		@Column(name = "GRUPKEY")
		private String grupKey;
		@Column(name = "MEMBSEL")
		private String membSel;
		@Column(name = "FACTHOUS")
		private String factHous;
		@Column(name = "COWNPFX")
		private String cownPFX;
		@Column(name = "COWNCOY")
		private String cownCOY;
		@Column(name = "COWNNUM")
		private String cownNUM;
		@Column(name = "PAYRPFX")
		private String payrPFX;
		@Column(name = "CNTBRANCH")
		private String cntBranch;
		@Column(name = "AGNTPFX")
		private String agntPFX;
		@Column(name = "AGNTCOY")
		private String agntCOY;
		@Column(name = "AGNTNUM")
		private String agntNUM;
		@Column(name = "PAYFLAG")
		private String payFlag;
		@Column(name = "BILFLAG")
		private String bilFlag;
		@Column(name = "OUTFLAG")
		private String outFlag;
		@Column(name = "SUPFLAG")
		private String supFLAG;
		@Column(name = "COMPANY")
		private String company;
		@Column(name = "JOBNO")
		private String jobNO;
		@Column(name = "SACSCODE")
		private String sacsCode;
		@Column(name = "SACSTYP")
		private String sacsTyp;
		@Column(name = "GLMAP")
		private String glMap;
		@Column(name = "DHNFLAG")
		private String dhnFlag;
		@Column(name = "ORIGINAL_MANDSTAT")
		private String originalMandStat;
		@Column(name = "DDDEREF")
		private String dddeRef;
		@Column(name = "RDOCPFX")
		private String rdocPFX;
		@Column(name = "RDOCCOY")
		private String rdocCOY;
		@Column(name = "RDOCNUM")
		private String rdocNUM;
		@Column(name = "NEXTDATE")
		private String nextDate;
		@Column(name = "USER_PROFILE")
		private String userProfile;
		@Column(name = "JOB_NAME")
		private String jobName;
		@Column(name = "DATIME")
		private String daTime;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPayrCOY() {
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
			return "ILDataEntity [id=" + id + ", payrCOY=" + payrCOY + ", payrNUM=" + payrNUM + ", mandRef=" + mandRef
					+ ", bankKey=" + bankKey + ", bankAccKey=" + bankAccKey + ", billCD=" + billCD + ", chdrPFX="
					+ chdrPFX + ", chdrCOY=" + chdrCOY + ", chdrNUM=" + chdrNUM + ", servUnit=" + servUnit
					+ ", cntType=" + cntType + ", cntCurr=" + cntCurr + ", occDate=" + occDate + ", ccDate=" + ccDate
					+ ", ptDate=" + ptDate + ", byDate=" + byDate + ", billDate=" + billDate + ", billCHNL=" + billCHNL
					+ ", bankCode=" + bankCode + ", instFrom=" + instFrom + ", instTo=" + instTo + ", instBCHNL="
					+ instBCHNL + ", instCCHNL=" + instCCHNL + ", instFreq=" + instFreq + ", instAmt01=" + instAmt01
					+ ", instAmt02=" + instAmt02 + ", instAmt03=" + instAmt03 + ", instAmt04=" + instAmt04
					+ ", instAmt05=" + instAmt05 + ", instAmt06=" + instAmt06 + ", instAmt07=" + instAmt07
					+ ", instAmt08=" + instAmt08 + ", instAmt09=" + instAmt09 + ", instAmt10=" + instAmt10
					+ ", instAmt11=" + instAmt11 + ", instAmt12=" + instAmt12 + ", instAmt13=" + instAmt13
					+ ", instAmt14=" + instAmt14 + ", instAmt15=" + instAmt15 + ", grupKey=" + grupKey + ", membSel="
					+ membSel + ", factHous=" + factHous + ", cownPFX=" + cownPFX + ", cownCOY=" + cownCOY
					+ ", cownNUM=" + cownNUM + ", payrPFX=" + payrPFX + ", cntBranch=" + cntBranch + ", agntPFX="
					+ agntPFX + ", agntCOY=" + agntCOY + ", agntNUM=" + agntNUM + ", payFlag=" + payFlag + ", bilFlag="
					+ bilFlag + ", outFlag=" + outFlag + ", supFLAG=" + supFLAG + ", company=" + company + ", jobNO="
					+ jobNO + ", sacsCode=" + sacsCode + ", sacsTyp=" + sacsTyp + ", glMap=" + glMap + ", dhnFlag="
					+ dhnFlag + ", originalMandStat=" + originalMandStat + ", dddeRef=" + dddeRef + ", rdocPFX="
					+ rdocPFX + ", rdocCOY=" + rdocCOY + ", rdocNUM=" + rdocNUM + ", nextDate=" + nextDate
					+ ", userProfile=" + userProfile + ", jobName=" + jobName + ", daTime=" + daTime + "]";
		}
				
}
