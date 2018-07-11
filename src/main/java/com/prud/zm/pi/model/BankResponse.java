package com.prud.zm.pi.model;

import com.poiji.annotation.ExcelCellName;

public class BankResponse {
	@ExcelCellName("RECORDID")
	private String recordID;
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
