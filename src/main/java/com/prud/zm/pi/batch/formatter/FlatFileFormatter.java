package com.prud.zm.pi.batch.formatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.prud.zm.pi.batch.model.ILDataBatchEntity;
import com.prud.zm.pi.model.CitiBankDomainModel;
@Component
public class FlatFileFormatter implements FileFormatter{
	@Resource(name="citbankAttributes")
	private Map<String,String> env;

	private String fillValue(String value, String size) {
		System.out.println("FlatFileFormatter fillValue value");
		if (value != null && !value.equals("")) {
			System.out.println("FlatFileFormatter fillValue value");
			int noOfFillersNeeded = Integer.parseInt(size) - value.length();
			return value + String.join("", Collections.nCopies(noOfFillersNeeded, " "));
		}
		return "";
	}

	public void writeFileToBankDirectory(StringBuilder dataBuilder) throws FileNotFoundException, IOException {
		System.out.println("FlatFileFormatter writeFileToBankDirectory value"+dataBuilder);
		try (FileOutputStream fos = new FileOutputStream("CITIBANK_Response.txt")) {
			System.out.println("FlatFileFormatter writeFileToBankDirectory value"+dataBuilder);
			fos.write(dataBuilder.toString().getBytes());
		}
	}

	public StringBuilder getRowData(List<ILDataBatchEntity> ilDataBatchEntityList) {
		System.out.println("ilDataBatchEntityList =" + ilDataBatchEntityList);
		StringBuilder rowData = new StringBuilder();
		for (ILDataBatchEntity ilDataBatchEntity : ilDataBatchEntityList) {
			CitiBankDomainModel citibankModel = null;
			if(ilDataBatchEntity.getWriterObject()  instanceof CitiBankDomainModel ) {
				System.out.println("citibankmodel getRowData=" + ilDataBatchEntityList);
				citibankModel = (CitiBankDomainModel)ilDataBatchEntity.getWriterObject();
			}else {
				System.out.println("getRowData Continue");
				continue;
			}
			rowData.append(fillValue(citibankModel.getCustomerReference(), env.get("customerReference")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getAmount(), env.get("amount")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getBookingDate(), env.get("bookingDate")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getCreditAccount(), env.get("creditAccount")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getIsoCurrency(), env.get("isoCurrency")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPaymentDetails1(), env.get("paymentDetails1")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPaymentDetails2(), env.get("paymentDetails2")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPaymentDetails3(), env.get("paymentDetails3")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPayerAccountNumber(), env.get("payerAccountNumber")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPayerAccountName(), env.get("payerAccountName")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPayerAddress1(), env.get("payerAddress1")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPayerAddress2(), env.get("payerAddress2")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPayerBankCode(), env.get("payerBankCode")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getBankName(), env.get("bankName")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPaymentDetails4(), env.get("paymentDetails4")));
			rowData.append("#");
			rowData.append(fillValue(citibankModel.getPayerAddress3(), env.get("payerAddress3")));
			rowData.append(System.lineSeparator());
		}

		return rowData;
	}
}
