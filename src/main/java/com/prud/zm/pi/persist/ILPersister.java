package com.prud.zm.pi.persist;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prud.zm.pi.model.BankResponse;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

@WebService
@Component
public class ILPersister {

	@Autowired
	private ILRepository ilRepository;

	// @Autowired
	// private EntityManagerFactory entityManagerFactory;

	public void saveIlData(ILDataEntity ildataEntity) {
		System.out.println("Before add " + ildataEntity);
		ilRepository.save(ildataEntity);
	}

	public void updateIlData(BankResponse bankResponse) {
		System.out.println("Before add " + bankResponse);
		ilRepository.updateBankResponseStatus(bankResponse.getRecordStatus(), String.valueOf(bankResponse.getRecordID()));
	}
}
