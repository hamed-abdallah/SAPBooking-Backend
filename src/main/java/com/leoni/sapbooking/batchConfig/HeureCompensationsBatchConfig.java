package com.leoni.sapbooking.batchConfig;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.leoni.sapbooking.model.SAPHeureCompensations;


@Configuration
public class HeureCompensationsBatchConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private DataSource dataSource;
	

	
	@Bean
	public FlatFileItemReader<SAPHeureCompensations> readfromcsvcomp(){
		FlatFileItemReader<SAPHeureCompensations> reader= new FlatFileItemReader<SAPHeureCompensations>();
		reader.setResource(new FileSystemResource("C://Users/ASUS/OneDrive/Bureau/jobsCSV/data1.csv"));
		//reader.setResource(new ClassPathResource("data.csv"));
		reader.setLineMapper(new DefaultLineMapper<SAPHeureCompensations>(){
			{
			setLineTokenizer(new DelimitedLineTokenizer(){
				{
					setNames(SAPHeureCompensations.fields());
				}
			});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<SAPHeureCompensations>() {
					{
						setTargetType(SAPHeureCompensations.class);
					}
				
			});
			}
		});
		return reader;
		
	}
	
	
	@Bean
	public JdbcBatchItemWriter<SAPHeureCompensations> writerintodbcomp(){
		JdbcBatchItemWriter<SAPHeureCompensations> writer=new JdbcBatchItemWriter<SAPHeureCompensations>();
		writer.setDataSource(dataSource);
		writer.setSql("INSERT INTO sapheure_compensations (matriculerh,name,date,number,time_type_text,cost_) Values (:matriculeRH,:name,:date,:number,:TimeTypeText,:costCtr);");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<SAPHeureCompensations>());
		return writer;
	}
	@Bean
	public Step stepcomp() {
		return stepBuilderFactory.get("stepcomp").<SAPHeureCompensations,SAPHeureCompensations>chunk(10)
		.reader(readfromcsvcomp()).writer(writerintodbcomp()).build();
		 
	}
	@Bean
	public Job jobcomp() {
		return jobBuilderFactory.get("jobcomp").flow(stepcomp()).end().build();
		
	}
	

}
