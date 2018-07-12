package com.prud.zm.pi.batch.formatter;

import org.springframework.stereotype.Component;

@Component
public class FormatterFactory {
	
	
	public static FileFormatter getFormatter(String formatterName) {
		if (formatterName.equalsIgnoreCase("CSVFILE")) {
			return new CSVFileFormatter();
		} else {
			return new FlatFileFormatter();
		}
	}

}
