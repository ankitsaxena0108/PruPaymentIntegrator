package com.prud.zm.pi.batch.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.prud.zm.pi.batch.mapper.OrikaBatchModelConverter;
import com.prud.zm.pi.model.CitiBankDomainModel;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

public class ILDataBatchWriter implements ItemWriter<ILDataEntity> {
	@Autowired
	private Environment env;
	@Autowired
	private OrikaBatchModelConverter converter;

	private String fillValue(String value, String size) {
		if (value != null && !value.equals("")) {
			int noOfFillersNeeded = Integer.parseInt(size) - value.length();
			return value + String.join("", Collections.nCopies(noOfFillersNeeded, " "));
		}
		return "";
	}

	private void writeFileToBankDirectory(StringBuilder dataBuilder) throws FileNotFoundException, IOException {
		try (FileOutputStream fos = new FileOutputStream("_Response.txt")) {
			fos.write(dataBuilder.toString().getBytes());
		}
	}

	private StringBuilder getRowData(CitiBankDomainModel citiModel) {
		System.out.println("citiModel ="+citiModel);
		StringBuilder rowData = new StringBuilder();
		rowData.append(fillValue(citiModel.getCustomerReference(), env.getProperty("customerReference")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getAmount(), env.getProperty("amount")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getBookingDate(), env.getProperty("bookingDate")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getCreditAccount(), env.getProperty("creditAccount")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getIsoCurrency(), env.getProperty("isoCurrency")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPaymentDetails1(), env.getProperty("paymentDetails1")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPaymentDetails2(), env.getProperty("paymentDetails2")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPaymentDetails3(), env.getProperty("paymentDetails3")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPayerAccountNumber(), env.getProperty("payerAccountNumber")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPayerAccountName(), env.getProperty("payerAccountName")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPayerAddress1(), env.getProperty("payerAddress1")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPayerAddress2(), env.getProperty("payerAddress2")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPayerBankCode(), env.getProperty("payerBankCode")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getBankName(), env.getProperty("bankName")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPaymentDetails4(), env.getProperty("paymentDetails4")));
		rowData.append("#");
		rowData.append(fillValue(citiModel.getPayerAddress3(), env.getProperty("payerAddress3")));
		return rowData;
	}

	@Override
	public void write(List<? extends ILDataEntity> items) throws Exception {
		System.out.println("items " + items);
		CitiBankDomainModel citiModel = converter.map(items.get(0));
		writeFileToBankDirectory(getRowData(citiModel));
	}

}
