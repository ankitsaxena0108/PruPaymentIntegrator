package com.prud.zm.pi.batch.writer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.prud.zm.pi.batch.formatter.CSVFileFormatter;
import com.prud.zm.pi.batch.formatter.FlatFileFormatter;
import com.prud.zm.pi.batch.model.ILDataBatchEntity;

public class ILDataBatchWriter implements ItemWriter<ILDataBatchEntity> {
	@Autowired
	private FlatFileFormatter flatFileFormatter;
	@Autowired
	private CSVFileFormatter csvFileFormatter;
	@Override
	public void write(List<? extends ILDataBatchEntity> items) throws Exception {
		System.out.println("1writer **********************"+items);
		List<ILDataBatchEntity> iLDataBatchEntitylist = new ArrayList<>(items);
		flatFileFormatter.writeFileToBankDirectory(flatFileFormatter.getRowData(iLDataBatchEntitylist));
		System.out.println("2writer **********************"+items);
		csvFileFormatter.writeFileToBankDirectory(flatFileFormatter.getRowData(iLDataBatchEntitylist));
		System.out.println("3writer **********************"+items);
	}

	
}
