package com.prud.zm.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prud.zm.pi.batch.helper.PaymentBatchJobLauncher;
import com.prud.zm.pi.helper.ILDataHelper;
import com.prud.zm.pi.model.ILDataList;
import com.prud.zm.pi.persist.ILPersister;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

@Service
public class ILService {

	@Autowired
	private ILPersister ilPersister;
	
	@Autowired
	private ILDataHelper ilProcessor;
	@Autowired
	private PaymentBatchJobLauncher jobLauncher;
	
	public String addILData(ILDataList ilDataList){
		List<ILDataEntity> parseILData = ilProcessor.parseILData(ilDataList);
		for(ILDataEntity ildataEntity : parseILData){
			ilPersister.addIlData(ildataEntity);
		}
		try {
			jobLauncher.invokeJob();
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAILURE";
	}
}
