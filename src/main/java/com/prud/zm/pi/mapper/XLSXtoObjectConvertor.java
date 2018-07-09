package com.prud.zm.pi.mapper;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;
import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Component
public class XLSXtoObjectConvertor {

	public List<ILData> xlsxToJavaObject(File file) {

		List<ILData> ilDataList = null;
		System.out.println("in xls convertor");
		try {
			ilDataList = Poiji.fromExcel(file, ILData.class);
			System.out.println(ilDataList.get(0));
		} catch (Exception e) {
		}
		return ilDataList;
	}
}
