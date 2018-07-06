package com.prud.zm.pi.persist;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prud.zm.pi.persistence.entity.ILDataEntity;

@WebService
@Component
public class ILPersister{

	@Autowired
	private ILRepository ilRepository;
	
//	@Autowired
//	private EntityManagerFactory entityManagerFactory;
	
	public void addIlData(ILDataEntity ildataEntity){
		ilRepository.save(ildataEntity);
	}
}
