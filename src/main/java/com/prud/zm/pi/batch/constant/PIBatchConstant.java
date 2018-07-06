package com.prud.zm.pi.batch.constant;

public class PIBatchConstant {

	private PIBatchConstant() {

	}

	public static final String GET_PAYMENTDETAILS_QUERY = "select pd_id,bankId,prud_acnt_ref,sequencefrom,submissiondate,bank_acnt_desc,valuedate,recordtype,nobatchnum,sign,norecbatchnum,totalamnt,paymentstatus from paymentdetails";
	public static final String BATCH_INVOKE_SUCCESS_STATUS = "Batch job has been invoked";
}
 