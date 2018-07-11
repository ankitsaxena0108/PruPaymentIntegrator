package com.prud.zm.pi.mapper;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poiji.bind.Poiji;
import com.prud.zm.pi.model.BankResponse;

@Component
public class InboundXLSXtoObjectConvertor {

	public List<BankResponse> xlsxToJavaObject(File file) {

		List<BankResponse> bankResponse = null;
		System.out.println("in xls convertor");
		try {
			bankResponse = Poiji.fromExcel(file, BankResponse.class);
			System.out.println(bankResponse.get(0));
		} catch (Exception e) {
		}
		return bankResponse;
	}
}
