package com.prud.zm.pi.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
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
			ilPersister.updateIlData(bankResponse);
			fileRecordMap.put(bankResponse.getRecordID(),bankResponse.getRecordStatus());
			System.out.println(fileRecordMap);
			appendXLS(fileRecordMap,"DD source.csv");
		}
		
		return "Success";
	}
	private void appendXLS(HashMap<String, String> map,String fileName) {
		try {
			File inputFile = new File(fileName);
			CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
			List<String[]> csvBody = reader.readAll();
			// get CSV row column  and replace with by using row and column
			for (String[] strings : csvBody) {
				String key=strings[1];
				if(map.containsKey(key))
				{
					strings[51]=map.get(key);
				}
			}
			reader.close();

			// Write to CSV file which is open
			CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		/*
		Workbook workbook = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(fileName));
            workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Double key=row.getCell(1).getNumericCellValue();
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
	*/}
}
