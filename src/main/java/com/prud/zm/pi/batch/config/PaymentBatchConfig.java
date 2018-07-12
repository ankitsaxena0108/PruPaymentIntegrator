package com.prud.zm.pi.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prud.zm.pi.batch.listener.BatchJobCompletionListener;
import com.prud.zm.pi.batch.mapper.ILDataBatchRowMapper;
import com.prud.zm.pi.batch.model.ILDataBatchEntity;
import com.prud.zm.pi.batch.processor.ILDataBatchProcessor;
import com.prud.zm.pi.batch.writer.ILDataBatchWriter;
import com.prud.zm.pi.persistence.entity.ILDataEntity;

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
	public JdbcPagingItemReader<ILDataEntity> reader() {
		System.out.println("in Batch reader");
		JdbcPagingItemReader<ILDataEntity> reader = new JdbcPagingItemReader<ILDataEntity>();
		final SqlPagingQueryProviderFactoryBean sqlPagingQueryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
		sqlPagingQueryProviderFactoryBean.setDataSource(dataSource);
		sqlPagingQueryProviderFactoryBean.setSelectClause("select *");
		sqlPagingQueryProviderFactoryBean.setFromClause("from paymentdetails");
		sqlPagingQueryProviderFactoryBean.setWhereClause("where RECORDSTATUS = 'READY'");
		sqlPagingQueryProviderFactoryBean.setSortKey("pd_id");
		try {
			reader.setQueryProvider(sqlPagingQueryProviderFactoryBean.getObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		reader.setDataSource(dataSource);
		reader.setPageSize(1);
	    reader.setRowMapper(new ILDataBatchRowMapper());
		return reader;
	}

	@Bean
	public ItemProcessor processor() {
		System.out.println("in batch processor");
		return new ILDataBatchProcessor();
	}

	@Bean
	public ItemWriter<ILDataBatchEntity> writer() {
		System.out.println("in batch writer");
		return new ILDataBatchWriter();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<ILDataEntity, ILDataEntity>chunk(10).reader(reader())
				.processor(processor()).writer(writer()).build();
	}

	@Bean
	public Job exportILDataJob() {
		return jobBuilderFactory.get("exportILDataJob").preventRestart().incrementer(new RunIdIncrementer())
				.listener(listener()).flow(step1()).end().build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new BatchJobCompletionListener();
	}

}
