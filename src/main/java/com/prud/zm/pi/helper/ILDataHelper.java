package com.prud.zm.pi.helper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prud.zm.pi.mapper.OrikaConverter;
import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Component
public class ILDataHelper {
	@Autowired
	private OrikaConverter orikaConverter;

	public List<ILDataEntity> parseILData(ILDataList ilDataList) {
		List<ILDataEntity> ilDataEntityList = new ArrayList<ILDataEntity>();
		List<ILData> ilDataCollection = ilDataList.getIlData();
		for (ILData ilData : ilDataCollection) {
			ilDataEntityList.add(orikaConverter.map(ilData));
		}
		return ilDataEntityList;
	}

	public Date parseDate(String subMissionDate) {
		Date date = null;
		try {
			date = new Date(((java.util.Date) new SimpleDateFormat("yyyy/MM/dd").parse(subMissionDate)).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
