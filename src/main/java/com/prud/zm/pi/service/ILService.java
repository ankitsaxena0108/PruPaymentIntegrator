package com.prud.zm.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prud.zm.pi.batch.helper.PaymentBatchJobLauncher;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.persist.ILPersister;
import com.prud.zm.pi.persistence.entity.ILDataEntity;
import com.prud.zm.pi.processor.ILProcessor;

@Service
public class ILService {

	@Autowired
	private ILPersister ilPersister;
	
	@Autowired
	private ILProcessor ilProcessor;
	@Autowired
	private PaymentBatchJobLauncher jobLauncher;
	
	public String addILData(ILDataList ilDataList){
		List<ILDataEntity> parseILData = ilProcessor.parseILData(ilDataList);
		for(ILDataEntity ildataEntity : parseILData){
			ilPersister.addIlData(ildataEntity);
		}
		try {
			jobLauncher.invokeJob();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SUCCESS";
	}
}
