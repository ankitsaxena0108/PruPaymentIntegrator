package com.prud.zm.pi.controller;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prud.zm.pi.constant.PIConstant;
import com.prud.zm.pi.helper.ResponseHelper;
import com.prud.zm.pi.service.ILService;

@RestController
@RequestMapping("/payment")
@PropertySource("classpath:citbank-attributes.properties")
@CrossOrigin(origins="*")
public class ILController {
	@Autowired
	private ILService ilService;
	@Autowired
	private ResponseHelper responseHelper;

	@RequestMapping(value = "/collectionReceivable", method = RequestMethod.POST)
	@ResponseBody
	public void outBoundflow(HttpServletResponse response, @RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			ilService.populateILDataList(pasFile);
			File f = new File(PIConstant.PI_TO_BANK_FILENAME);
			responseHelper.doXLSResponse(response, f, PIConstant.PI_TO_BANK_FILENAME);
			System.out.println("persist Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("persist Failed");
		}
	}

	@RequestMapping(value = "/collectionsReceived", method = RequestMethod.POST)
	@ResponseBody
	public void inBoundflow(HttpServletResponse response, @RequestParam(value = "file") final MultipartFile pasFile) {
		try {
			ilService.pupulateBankResponseList(pasFile);
			System.out.println("persist Success");
			File f = new File(PIConstant.IL_INPUT_FILENAME);
			responseHelper.doXLSResponse(response, f, PIConstant.IL_INPUT_FILENAME);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("file updation Failed");
		}
	}
}
