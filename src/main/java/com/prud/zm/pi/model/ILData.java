package com.prud.zm.pi.model;

public class ILData {

	private String bankIdentifier;
	private String prudAccountRef;
	private String submissionDate;
	private Long sequenceFrom;
	private String bankAccountdescription;
	private String valueDate;
	private String recordType;
	private String noBatchNumber;
	private String sign;
	private String noRecbatchNumber;
	private String totalAmount;
	
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
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String subMissionDate) {
		this.submissionDate = subMissionDate;
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
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
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
