package com.prud.zm.pi.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.prud.zm.pi.batch.model.ILDataBatchEntity;

public class ILDataBatchProcessor implements ItemProcessor<ILDataBatchEntity, ILDataBatchEntity>{

	@Override
	public ILDataBatchEntity process(ILDataBatchEntity ilDataEntity) throws Exception {
		// TODO Auto-generated method stub
		return ilDataEntity;
	}

}
