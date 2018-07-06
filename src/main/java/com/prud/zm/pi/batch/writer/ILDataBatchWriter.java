package com.prud.zm.pi.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.prud.zm.pi.batch.model.ILDataBatchEntity;

public class ILDataBatchWriter implements ItemWriter<ILDataBatchEntity>{

	@Override
	public void write(List<? extends ILDataBatchEntity> items) throws Exception {
		System.out.println("items "+ items);
	}
	
}
