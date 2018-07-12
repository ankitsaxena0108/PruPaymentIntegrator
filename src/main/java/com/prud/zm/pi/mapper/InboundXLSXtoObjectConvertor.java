package com.prud.zm.pi.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.prud.zm.pi.model.BankResponse;

@Component
public class InboundXLSXtoObjectConvertor {

	public List<BankResponse> xlsxToJavaObject(File file) {

		List<BankResponse> bankResponse = null;
		InputStream stream = null;
		System.out.println("in xls convertor");
		try {
			// bankResponse = Poiji.fromExcel(file, BankResponse.class);
			stream = new FileInputStream(file);
			bankResponse = Poiji.fromExcel(stream, PoijiExcelType.XLS, BankResponse.class);
			System.out.println(bankResponse.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bankResponse;
	}
}
