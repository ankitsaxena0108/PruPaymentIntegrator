package com.prud.zm.pi.processor;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prud.zm.pi.model.ILData;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.persistence.entity.ILDataEntity;


@Component
public class ILProcessor {

	public List<ILDataEntity> parseILData(ILDataList ilDataList){
		List<ILDataEntity> ilDataEntityList = new ArrayList<ILDataEntity>();
		List<ILData> ilDataCollection = ilDataList.getIlData();
		for(ILData ilData : ilDataCollection){
			ILDataEntity ilDataEntity = new ILDataEntity();
			ilDataEntity.setBankIdentifier(ilData.getBankIdentifier());
			ilDataEntity.setBankAccountdescription(ilData.getBankAccountdescription());
			ilDataEntity.setNoBatchNumber(ilData.getNoBatchNumber());
			ilDataEntity.setNoRecbatchNumber(ilData.getNoRecbatchNumber());
			ilDataEntity.setPrudAccountRef(ilData.getPrudAccountRef());
			ilDataEntity.setRecordType(ilData.getRecordType());
			ilDataEntity.setSequenceFrom(ilData.getSequenceFrom());
			ilDataEntity.setSign(ilData.getSign());
			
			ilDataEntity.setSubMissionDate(parseDate(ilData.getSubmissionDate()));
			ilDataEntity.setValueDate(parseDate(ilData.getValueDate()));
			ilDataEntity.setTotalAmount(ilData.getTotalAmount());
			ilDataEntityList.add(ilDataEntity);
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
