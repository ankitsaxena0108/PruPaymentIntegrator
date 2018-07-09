package com.prud.zm.pi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prud.zm.pi.mapper.XLSXtoObjectConvertor;
import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.persistence.entity.ILDataEntity;
import com.prud.zm.pi.service.ILService;

@RestController
@RequestMapping("/ILDataJson")
public class ILController {

	@Autowired
	private ILService ilService;
	@Autowired
	private XLSXtoObjectConvertor xLSXtoObjectConvertor;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addOrder(@RequestBody ILDataList ilDataList) throws ParseException {
		return ilService.addILData(ilDataList);
	}

	@RequestMapping(value = "/pas/pastel", method = RequestMethod.POST)
	@ResponseBody
	public void convertXSLSToObject(@RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			List<ILData> ilList = xLSXtoObjectConvertor.xlsxToJavaObject(convert(pasFile));
			System.out.println("ilDataList = " + ilList);
			ILDataList ilDataList = new ILDataList();
			ilDataList.setIlData(ilList);
			ilService.addILData(ilDataList);
			System.out.println("persist Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("persist Failed");
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

}
