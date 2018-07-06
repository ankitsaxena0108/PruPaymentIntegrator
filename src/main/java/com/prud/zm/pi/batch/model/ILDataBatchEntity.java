package com.prud.zm.pi.batch.model;

public class ILDataBatchEntity {
	private Long paymentDetailsId;
	private String bankId;
	private String prudAccountRef;
	private String subMissionDate;
	private Long sequenceFrom;
	private String bankAccountDesc;
	private String valueDate;
	private String recordType;
	private String noBatchNumber;
	private String sign;
	private String noRecbatchNumber;
	private String totalAmount;
	private String paymentStatus;

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getPrudAccountRef() {
		return prudAccountRef;
	}

	public void setPrudAccountRef(String prudAccountRef) {
		this.prudAccountRef = prudAccountRef;
	}

	public String getSubMissionDate() {
		return subMissionDate;
	}

	public void setSubMissionDate(String subMissionDate) {
		this.subMissionDate = subMissionDate;
	}

	public Long getSequenceFrom() {
		return sequenceFrom;
	}

	public void setSequenceFrom(Long sequenceFrom) {
		this.sequenceFrom = sequenceFrom;
	}

	public String getBankAccountDesc() {
		return bankAccountDesc;
	}

	public void setBankAccountDesc(String bankAccountDesc) {
		this.bankAccountDesc = bankAccountDesc;
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

	public Long getPaymentDetailsId() {
		return paymentDetailsId;
	}

	public void setPaymentDetailsId(Long paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}

}
