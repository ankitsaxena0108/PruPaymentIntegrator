package com.prud.zm.pi.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.prud.zm.pi.persistence.entity.ILDataEntity;

public class ILDataBatchProcessor implements ItemProcessor<ILDataEntity, ILDataEntity> {


	@Override
	public ILDataEntity process(ILDataEntity ilDataEntity) throws Exception {
		return ilDataEntity;
	}

}
