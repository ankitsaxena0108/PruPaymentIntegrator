package com.prud.zm.pi.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prud.zm.pi.batch.helper.PaymentBatchJobLauncher;
import com.prud.zm.pi.helper.ILDataHelper;
import com.prud.zm.pi.model.BankResponse;
import com.prud.zm.pi.model.BankResponseList;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.persist.ILPersister;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Service
public class ILService {

	@Autowired
	private ILPersister ilPersister;
	
	@Autowired
	private ILDataHelper ilHelper;
	@Autowired
	private PaymentBatchJobLauncher jobLauncher;
	
	public static final HashMap<String, String> fileRecordMap = new HashMap<>(); 
	
	public String addILData(ILDataList ilDataList){
		List<ILDataEntity> parseILData = ilHelper.parseILData(ilDataList);
		for(ILDataEntity ildataEntity : parseILData){
			ilPersister.saveIlData(ildataEntity);
		}
		try {
			jobLauncher.invokeJob();
			return "SUCCESS"; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAILURE";
	}
	public String updateBankDetails(BankResponseList bankResponseList){
		List<BankResponse> bankResponselist = bankResponseList.getBankResponseList();
		if(bankResponselist.isEmpty()) {
			return "Falure: bankResponselist is empty ";
		}
		for(BankResponse bankResponse : bankResponseList.getBankResponseList()){
			//ilPersister.updateIlData(bankResponse);
			fileRecordMap.put(bankResponse.getRecordID(),bankResponse.getRecordStatus());
			System.out.println(fileRecordMap);
			appendXLS(fileRecordMap,"DD source.xls");
		}
		
		return "Success";
	}
	private void appendXLS(HashMap<String, String> map,String fileName) {
		Workbook workbook = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileName));
            workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				String key=row.getCell(1).getStringCellValue();
				if (map.containsKey(key)) {
					System.out.println("1 Column Updated");
					row.getCell(51).setCellValue(map.get(key));
					System.out.println(row.getCell(51));
				}
			}
			inputStream.close();
			 
            FileOutputStream outputStream = new FileOutputStream("updated_"+fileName);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
			 	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
