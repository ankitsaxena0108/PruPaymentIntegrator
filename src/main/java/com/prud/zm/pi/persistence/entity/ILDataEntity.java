package com.prud.zm.pi.persistence.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENTDETAILS")
public class ILDataEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="pd_id")
		private Long id;
		@Column(name = "bankid")
		private String bankIdentifier;
		@Column(name = "prud_acnt_ref")
		private String prudAccountRef;
		@Column(name = "submissiondate")
		private Date subMissionDate;
		@Column(name = "sequencefrom")
		private Long sequenceFrom;
		@Column(name = "bank_acnt_desc")
		private String bankAccountdescription;
		@Column(name = "valuedate")
		private Date valueDate;
		@Column(name = "recordtype")
		private String recordType;
		@Column(name = "nobatchnum")
		private String noBatchNumber;
		@Column(name = "sign")
		private String sign;
		@Column(name = "norecbatchnum")
		private String noRecbatchNumber;
		@Column(name = "totalamnt")
		private String totalAmount;
		@Column(name = "paymentstatus")
		private String paymentStatus;
		
		public String getBankIdentifier() {
			return bankIdentifier;
		}
		public void setBankIdentifier(String bankIdentifier) {
			this.bankIdentifier = bankIdentifier;
		}
		public String getPrudAccountRef() {
			return prudAccountRef;
		}
		public void setPrudAccountRef(String prudAccountRef) {
			this.prudAccountRef = prudAccountRef;
		}
		public Date getSubMissionDate() {
			return subMissionDate;
		}
		public void setSubMissionDate(Date subMissionDate) {
			this.subMissionDate = subMissionDate;
		}
		public long getSequenceFrom() {
			return sequenceFrom;
		}
		public void setSequenceFrom(long sequenceFrom) {
			this.sequenceFrom = sequenceFrom;
		}
		public String getBankAccountdescription() {
			return bankAccountdescription;
		}
		public void setBankAccountdescription(String description) {
			this.bankAccountdescription = description;
		}
		public Date getValueDate() {
			return valueDate;
		}
		public void setValueDate(Date valueDate) {
			this.valueDate = valueDate;
		}
		public String getRecordType() {
			return recordType;
		}
		public void setRecordType(String recordType) {
			this.recordType = recordType;
		}
		public String getNoBatchNumber() {
			return noBatchNumber;
		}
		public void setNoBatchNumber(String noBatchNumber) {
			this.noBatchNumber = noBatchNumber;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public String getNoRecbatchNumber() {
			return noRecbatchNumber;
		}
		public void setNoRecbatchNumber(String noRecbatchNumber) {
			this.noRecbatchNumber = noRecbatchNumber;
		}
		public String getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(String totalAmount) {
			this.totalAmount = totalAmount;
		}
		

}
