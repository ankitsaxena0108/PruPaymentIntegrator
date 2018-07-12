package com.prud.zm.pi.batch.processor;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.prud.zm.pi.batch.mapper.OrikaModelConverter;
import com.prud.zm.pi.batch.model.ILDataBatchEntity;
import com.prud.zm.pi.model.CitiBankDomainModel;
import com.prud.zm.pi.model.EasyPayModel;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

public class ILDataBatchProcessor implements ItemProcessor<ILDataEntity, ILDataBatchEntity> {
	@Autowired
	private OrikaModelConverter converter;
	@Resource(name = "citbankMappingProperty")
	private Map<String, String> citbankProperty;
	@Resource(name = "ilToEasypayProperties")
	private Map<String, String> ilToEasypayProperties;

	@Override
	public ILDataBatchEntity process(ILDataEntity ilDataEntity) throws Exception {
		System.out.println("process1 **********************"+ilDataEntity);
		CitiBankDomainModel citiModel = null;
		ILDataBatchEntity transferObject = new ILDataBatchEntity();
		if (ilDataEntity.getBankKey().equalsIgnoreCase("CITIBANK")) {
			System.out.println("process2 **********************"+ilDataEntity);
			transferObject.setWriterObject((CitiBankDomainModel) converter.map(ilDataEntity, ILDataEntity.class,
					CitiBankDomainModel.class, citbankProperty));
		} else if (ilDataEntity.getBankKey().equalsIgnoreCase("EASYPAY")) {
			System.out.println("process3 **********************"+ilDataEntity);
			transferObject.setWriterObject((EasyPayModel) converter.map(ilDataEntity, ILDataEntity.class,
					EasyPayModel.class, ilToEasypayProperties));
		}

		return transferObject;
	}

}
