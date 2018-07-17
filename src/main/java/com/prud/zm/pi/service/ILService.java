package com.prud.zm.pi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.prud.zm.pi.batch.helper.PaymentBatchJobLauncher;
import com.prud.zm.pi.constant.PIConstant;
import com.prud.zm.pi.helper.ILDataHelper;
import com.prud.zm.pi.mapper.InboundXLSXtoObjectConvertor;
import com.prud.zm.pi.mapper.OutboundXLSXtoObjectConvertor;
import com.prud.zm.pi.model.BankResponse;
import com.prud.zm.pi.model.BankResponseList;
import com.prud.zm.pi.model.ILData;
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
	@Autowired
	private OutboundXLSXtoObjectConvertor outboundXLSXtoObjectConvertor;
	@Autowired
	private InboundXLSXtoObjectConvertor inboundXLSXtoObjectConvertor;

	public static final HashMap<String, String> fileRecordMap = new HashMap<>();

	public void populateILDataList(final MultipartFile pasFile) throws IOException {
		String extension = FilenameUtils.getExtension(pasFile.getOriginalFilename());
		List<ILData> ilList = null;
		if (extension.equalsIgnoreCase(PIConstant.FORMAT_CSV)) {
			ilList = csvToJavaObjectConvertor(convert(pasFile));
		} else {
			ilList = outboundXLSXtoObjectConvertor.xlsxToJavaObject(convert(pasFile));
		}
		System.out.println("ilDataList = " + ilList);
		ILDataList ilDataList = new ILDataList();
		ilDataList.setIlData(ilList);
		addILData(ilDataList);
	}
	public void pupulateBankResponseList(final MultipartFile pasFile) throws IOException {
		String extension = FilenameUtils.getExtension(pasFile.getOriginalFilename());
		System.out.println("extension " + extension);
		List<BankResponse> bResponseList = null;

		if (extension.equalsIgnoreCase(PIConstant.FORMAT_XLS))
			bResponseList = inboundXLSXtoObjectConvertor.xlsxToJavaObject(convert(pasFile));
		else
			bResponseList = csvToJavaObjectInboundConvertor(convert(pasFile));

		System.out.println("bankResponseList = " + bResponseList);
		BankResponseList bankResponseList = new BankResponseList();
		bankResponseList.setBankResponseList(bResponseList);
		updateBankDetails(bankResponseList);
	}
	public List<BankResponse> csvToJavaObjectInboundConvertor(File file) {
		CsvMapper csvMapper = new CsvMapper();
		CsvSchema csvSchema = csvMapper.typedSchemaFor(BankResponse.class).withHeader();
		List list = null;
		try {
			list = new CsvMapper().readerFor(BankResponse.class)
					.with(csvSchema.withColumnSeparator(CsvSchema.DEFAULT_COLUMN_SEPARATOR)).readValues(file).readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}	

	private String addILData(ILDataList ilDataList) {
		List<ILDataEntity> parseILData = ilHelper.parseILData(ilDataList);
		for (ILDataEntity ildataEntity : parseILData) {
			ilPersister.saveIlData(ildataEntity);
		}
		try {
			jobLauncher.invokeJob();
			return PIConstant.STATUS_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PIConstant.STATUS_FAILURE;
	}

	public String updateBankDetails(BankResponseList bankResponseList) {
		List<BankResponse> bankResponselist = bankResponseList.getBankResponseList();
		if (bankResponselist.isEmpty()) {
			return "Falure: bankResponselist is empty ";
		}
		for (BankResponse bankResponse : bankResponseList.getBankResponseList()) {
			ilPersister.updateIlData(bankResponse);
			fileRecordMap.put(bankResponse.getRecordID(), bankResponse.getRecordStatus());
			System.out.println(fileRecordMap);
			appendXLS(fileRecordMap, PIConstant.ILDATA_FILENAME);
		}

		return PIConstant.STATUS_SUCCESS;
	}

	private void appendXLS(HashMap<String, String> map, String fileName) {
		try {
			File inputFile = new File(fileName);
			CSVReader reader = new CSVReader(new FileReader(inputFile), PIConstant.DELIMITER_COMMA);
			List<String[]> csvBody = reader.readAll();
			// get CSV row column and replace with by using row and column
			for (String[] strings : csvBody) {
				String key = strings[1];
				if (map.containsKey(key)) {
					strings[51] = map.get(key);
				}
			}
			reader.close();

			// Write to CSV file which is open
			CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
			writer.writeAll(csvBody);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	public List<ILData> csvToJavaObjectConvertor(File file) {
		CsvMapper csvMapper = new CsvMapper();
		CsvSchema csvSchema = csvMapper.typedSchemaFor(ILData.class).withHeader();
		List list = null;
		try {
			list = new CsvMapper().readerFor(ILData.class)
					.with(csvSchema.withColumnSeparator(CsvSchema.DEFAULT_COLUMN_SEPARATOR)).readValues(file).readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}
}
