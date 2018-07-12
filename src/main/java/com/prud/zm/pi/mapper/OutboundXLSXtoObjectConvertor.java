package com.prud.zm.pi.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.prud.zm.pi.model.ILData;

@Component
public class OutboundXLSXtoObjectConvertor {

	public List<ILData> xlsxToJavaObject(File file) {

		List<ILData> ilDataList = null;
		System.out.println("in xls convertor");
		InputStream stream=null;
		try {
			//ilDataList = Poiji.fromExcel(file, ILData.class);
			stream= new FileInputStream(file);
			ilDataList = Poiji.fromExcel(stream, PoijiExcelType.XLS, ILData.class);
			System.out.println(ilDataList.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ilDataList;
	}
}
