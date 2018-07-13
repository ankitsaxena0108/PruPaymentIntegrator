package com.prud.zm.pi.batch.formatter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.prud.zm.pi.batch.model.ILDataBatchEntity;
import com.prud.zm.pi.model.CitiBankDomainModel;
import com.prud.zm.pi.model.EasyPayModel;

@Component
public class CSVFileFormatter implements FileFormatter{
	@Resource(name="easypayAttributes")
	private Map<String,String> env;

	private String fillValue(String value, String size) {
		System.out.println("**********************"+value);
		String[] sizes = size.split(",");
		if (value != null && !value.equals("") /*&& value.length() >= Integer.parseInt(sizes[1]) && value.length() <= Integer.parseInt(sizes[0])*/ ) {
			System.out.println("##########################"+value);
			return value;
		}
		return "";
	}

	public void writeFileToBankDirectory(StringBuilder dataBuilder) throws FileNotFoundException, IOException {
		try (FileOutputStream fos = new FileOutputStream("EASYPAY_Response.csv")) {
			fos.write(dataBuilder.toString().getBytes());
		}
	}

	public StringBuilder getRowData(List<ILDataBatchEntity> ilDataBatchEntityList) {
		System.out.println("ilDataBatchEntityList =" + ilDataBatchEntityList);
		StringBuilder rowData = new StringBuilder();
		for (ILDataBatchEntity ilDataBatchEntity : ilDataBatchEntityList) { 
			EasyPayModel easyPayModel =null;
			if(ilDataBatchEntity.getWriterObject()  instanceof EasyPayModel ) {
				easyPayModel = (EasyPayModel)ilDataBatchEntity.getWriterObject();
			}else {
				continue;
			}
			rowData.append(fillValue(easyPayModel.getDestAccountName(), env.get("destAccountName")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getAmount(), env.get("amount")));
			rowData.append(","); 
			rowData.append(fillValue(easyPayModel.getDestinationAccount(), env.get("destinationAccount")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getDestinationSortCode(), env.get("destinationSortCode")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getPhoneNumber(), env.get("phoneNumber")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getReference(), env.get("reference")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getRemarks(), env.get("remarks")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getSourceAccount(), env.get("sourceAccount")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getSourceAccountName(), env.get("sourceAccountName")));
			rowData.append(",");
			rowData.append(fillValue(easyPayModel.getSourceSortCode(), env.get("sourceSortCode")));
			rowData.append(",");
			rowData.append(System.lineSeparator());
		}
		return rowData;
	}
}
