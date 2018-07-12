package com.prud.zm.pi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.poiji.annotation.ExcelCellName;
@JsonPropertyOrder({ "RECORDID", "RECORDSTATUS" })

public class BankResponse {
	@ExcelCellName("RECORDID")
	 @JsonProperty("RECORDID")
	private String recordID;
	 @JsonProperty("RECORDSTATUS")
	@ExcelCellName("RECORDSTATUS")
	private String recordStatus;

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	@Override
	public String toString() {
		return "BankResponse [recordId=" + recordID + ", recordStatus=" + recordStatus + "]";
	}

}
