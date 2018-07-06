package com.prud.zm.pi.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prud.zm.pi.batch.constant.PIBatchConstant;
import com.prud.zm.pi.batch.listener.BatchJobCompletionListener;
import com.prud.zm.pi.batch.mapper.ILDataBatchRowMapper;
import com.prud.zm.pi.batch.model.ILDataBatchEntity;
import com.prud.zm.pi.batch.processor.ILDataBatchProcessor;
import com.prud.zm.pi.batch.writer.ILDataBatchWriter;

@Configuration
@EnableBatchProcessing
public class PaymentBatchConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private DataSource dataSource;

	@Bean
	public JdbcCursorItemReader<ILDataBatchEntity> reader() {
		System.out.println("in reader vipul");
		JdbcCursorItemReader<ILDataBatchEntity> cursorItemReader = new JdbcCursorItemReader<>();
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setSql(PIBatchConstant.GET_PAYMENTDETAILS_QUERY);
		cursorItemReader.setRowMapper(new ILDataBatchRowMapper());
		return cursorItemReader;
	}

	@Bean
	public ILDataBatchProcessor processor() {
		System.out.println("in processor vipul");
		return new ILDataBatchProcessor();
	}

	@Bean
	public ItemWriter<? super ILDataBatchEntity> writer() {
		System.out.println("in writer vipul");
		return new ILDataBatchWriter();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<ILDataBatchEntity, ILDataBatchEntity>chunk(10).reader(reader())
				.processor(processor()).writer(writer()).build();
	}
    @Bean
	public Job exportILDataJob() {
		return jobBuilderFactory.get("exportILDataJob").preventRestart().incrementer(new RunIdIncrementer()).listener(listener()).flow(step1()).end().build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new BatchJobCompletionListener();
	}

}
