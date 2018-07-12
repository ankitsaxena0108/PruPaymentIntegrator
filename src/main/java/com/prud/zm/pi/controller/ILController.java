package com.prud.zm.pi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.prud.zm.pi.mapper.InboundXLSXtoObjectConvertor;
import com.prud.zm.pi.mapper.OutboundXLSXtoObjectConvertor;
import com.prud.zm.pi.model.BankResponse;
import com.prud.zm.pi.model.BankResponseList;
import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.service.ILService;

@RestController
@RequestMapping("/payment")
@PropertySource("classpath:citbank-attributes.properties")
public class ILController {
	@Autowired
	private ILService ilService;
	@Autowired
	private OutboundXLSXtoObjectConvertor outboundXLSXtoObjectConvertor;
	@Autowired
	private InboundXLSXtoObjectConvertor inboundXLSXtoObjectConvertor;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addOrder(@RequestBody ILDataList ilDataList) throws ParseException {
		return ilService.addILData(ilDataList);
	}

	@RequestMapping(value = "/outbound", method = RequestMethod.POST)
	@ResponseBody
	public void outBoundflow(HttpServletResponse response, @RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			String extension = FilenameUtils.getExtension(pasFile.getOriginalFilename());
			List<ILData> ilList = null;
			if (extension.equalsIgnoreCase("CSV")) {
				ilList = csvToJavaObjectConvertor(convert(pasFile));
			} else {
				ilList = outboundXLSXtoObjectConvertor.xlsxToJavaObject(convert(pasFile));
			}
			System.out.println("ilDataList = " + ilList);
			ILDataList ilDataList = new ILDataList();
			ilDataList.setIlData(ilList);
			ilService.addILData(ilDataList);
			File f = new File("CITIBANK_Response.txt");
			doXLSResponse(response, f, "CITIBANK_Response.txt");
			System.out.println("persist Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("persist Failed");
		}
	}

	@RequestMapping(value = "/inbound", method = RequestMethod.POST)
	@ResponseBody
	public void inBoundflow(HttpServletResponse response, @RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			String extension = FilenameUtils.getExtension(pasFile.getOriginalFilename());
			System.out.println("extension " + extension);
			List<BankResponse> bResponseList = null;

			if (extension.equalsIgnoreCase("xls"))
				bResponseList = inboundXLSXtoObjectConvertor.xlsxToJavaObject(convert(pasFile));
			else
				bResponseList = csvToJavaObjectInboundConvertor(convert(pasFile));

			System.out.println("bankResponseList = " + bResponseList);
			BankResponseList bankResponseList = new BankResponseList();
			bankResponseList.setBankResponseList(bResponseList);
			ilService.updateBankDetails(bankResponseList);
			System.out.println("persist Success");
			File f = new File("DD source.csv");
			doXLSResponse(response, f, "DD source.csv");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("file updation Failed");
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

	private void doXLSResponse(HttpServletResponse response, File file, String fileName) {
		byte[] contents = fileToByte(file);
		String responseFile = fileName;
		response.setContentType("text/plain");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", responseFile);
		response.setHeader(headerKey, headerValue);
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(contents);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		response.setContentLength(contents.length);
		response.setHeader("Content-Disposition", "attachment;filename= " + responseFile);

		/*
		 * if (!file.delete()) { System.out.println("Unable to delete file"); }
		 */
	}

	private byte[] fileToByte(File file) {
		FileInputStream fileInputStream = null;

		byte[] bFile = new byte[(int) file.length()];

		try {
			fileInputStream = new FileInputStream(file);
			int count = fileInputStream.read(bFile);
			fileInputStream.close();
			if (count > 0)
				return bFile;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bFile;
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

}
