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

import com.leoni.sapbooking.model.SAPBooking;
import com.leoni.sapbooking.model.SAPHeurePresence;

@Configuration
public class SAPBookingBatchConfig {
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private DataSource dataSource;
	@Bean
	public FlatFileItemReader<SAPBooking> readfromcsvbook(){
		FlatFileItemReader<SAPBooking> reader= new FlatFileItemReader<SAPBooking>();
		reader.setResource(new FileSystemResource("C://Users/ASUS/OneDrive/Bureau/jobsCSV/data2.csv"));
		//reader.setResource(new ClassPathResource("data.csv"));
		reader.setLineMapper(new DefaultLineMapper<SAPBooking>(){
			{
			setLineTokenizer(new DelimitedLineTokenizer(){
				{
					setNames(SAPBooking.fields());
				}
			});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<SAPBooking>() {
					{
						setTargetType(SAPBooking.class);
					}		
			});
			}
		});
		return reader;	
	}
	
	@Bean
	public JdbcBatchItemWriter<SAPBooking> writerintodbbook(){
		JdbcBatchItemWriter<SAPBooking> writer=new JdbcBatchItemWriter<SAPBooking>();
		writer.setDataSource(dataSource);
		writer.setSql("INSERT INTO sapbooking(pers_num,name,status,act,team,date,rec_cost,wbs,cost_center,short_text,hours,creaton,time_of_ent,last_change,time_of_last,document,created_by) Values (:persNum,:name,:status,:act,:team,:date,:recCost,:wbs,:costCenter,:shortText,:hours,:creaton,:timeOfEnt,:lastChange,:timeOfLast,:document,:createdBy);");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<SAPBooking>());
		return writer;
	}
	@Bean
	public Step stepbook() {
		return stepBuilderFactory.get("stepbook").<SAPBooking,SAPBooking>chunk(10)
		.reader(readfromcsvbook()).writer(writerintodbbook()).build();
		 
	}
	@Bean
	public Job jobbook() {
		return jobBuilderFactory.get("jobbook").flow(stepbook()).end().build();
		
	}
	
}
