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

@PropertySource("classpath:citbank-attributes.properties")
public class ILDataBatchWriter implements ItemWriter<ILDataEntity> {
	@Autowired
	private Environment env;
	@Autowired
	private OrikaBatchModelConverter converter;

	private String fillValue(String value, int size) {
		if (value != null) {
			int noOfFillersNeeded = size - value.length();
			return value + String.join("", Collections.nCopies(noOfFillersNeeded, " "));
		}
		return null;
	}

	private void writeFileToBankDirectory(StringBuilder dataBuilder) throws FileNotFoundException, IOException {
		try (FileOutputStream fos = new FileOutputStream("_Response.txt")) {
			fos.write(dataBuilder.toString().getBytes());
		}
	}

	private StringBuilder getRowData(CitiBankDomainModel citiModel) {
		System.out.println(env.getProperty("REC-SORT-CODE"));
		StringBuilder rowData = new StringBuilder();
		rowData.append(fillValue(citiModel.getRecAcctNO(), 20));
		rowData.append(fillValue(citiModel.getRecAcctCode(), 20));
		/*
		 * rowData.append(fillValue("ABCD1234",16)); //BANKACCKEY
		 * rowData.append(fillValue("",4)); //CURRTO rowData.append(fillValue("+",1));
		 * //SIGN rowData.append(fillValue("1000",10)); //DEBITAMT
		 * rowData.append(fillValue("",8)); //CHRDNUM
		 * rowData.append(fillValue("DONE",12)); //CHRDNUM
		 */ return rowData;
	}

	@Override
	public void write(List<? extends ILDataEntity> items) throws Exception {
		System.out.println("items " + items);
		CitiBankDomainModel citiModel = converter.map(items.get(0));
		writeFileToBankDirectory(getRowData(citiModel));
	}

}
