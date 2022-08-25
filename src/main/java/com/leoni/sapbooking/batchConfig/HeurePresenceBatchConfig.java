package com.leoni.sapbooking.batchConfig;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.leoni.sapbooking.model.SAPHeurePresence;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration

public class HeurePresenceBatchConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private DataSource dataSource;
	

	
	@Bean
	public FlatFileItemReader<SAPHeurePresence> readfromcsv(){
		FlatFileItemReader<SAPHeurePresence> reader= new FlatFileItemReader<SAPHeurePresence>();
		reader.setResource(new FileSystemResource("C://Users/ASUS/OneDrive/Bureau/jobsCSV/data.csv"));
		//reader.setResource(new ClassPathResource("data.csv"));
		reader.setLineMapper(new DefaultLineMapper<SAPHeurePresence>(){
			{
			setLineTokenizer(new DelimitedLineTokenizer(){
				{
					setNames(SAPHeurePresence.fields());
				}
			});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<SAPHeurePresence>() {
					{
						setTargetType(SAPHeurePresence.class);
					}
				
			});
			}
		});
		return reader;
		
	}
	
	
	@Bean
	public JdbcBatchItemWriter<SAPHeurePresence> writerintodb(){
		JdbcBatchItemWriter<SAPHeurePresence> writer=new JdbcBatchItemWriter<SAPHeurePresence>();
		writer.setDataSource(dataSource);
		writer.setSql("INSERT INTO sapheure_presence (matriculerh,name,date,numb,cost_ctr,cost_cent) Values (:matriculeRH,:name,:date,:numb,:costCtr,:costCent);");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<SAPHeurePresence>());
		return writer;
	}
	@Bean
	public Step step() {
		return stepBuilderFactory.get("step").<SAPHeurePresence,SAPHeurePresence>chunk(10)
		.reader(readfromcsv()).writer(writerintodb()).build();
		 
	}
	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").flow(step()).end().build();
		
	}
	
}
