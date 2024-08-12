package com.rays.service01.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.rays.service01.dto.Product;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job jobBean(JobRepository jobRepository, JobCompletionNotificationImpl listener, Step steps) {
		return jobBuilderFactory.get("job").listener(listener).start(steps).build();
	}

	@Bean
	public Step steps(ItemReader<Product> reader, ItemProcessor<Product, Product> processor,
			ItemWriter<Product> writer) {
		return stepBuilderFactory.get("jobStep").<Product, Product>chunk(5).reader(reader).processor(processor)
				.writer(writer).build();
	}

	// reader
	@Bean
	public FlatFileItemReader<Product> reader() {
		return new FlatFileItemReaderBuilder<Product>().name("itemReader").resource(new ClassPathResource("data.csv"))
				.delimited().names("productId", "title", "description", "price", "discount").targetType(Product.class)
				.linesToSkip(1).build();
	}

	// processor
	@Bean
	public ItemProcessor<Product, Product> itemProcessor() {
		return new CustomItemProcessor();
	}

	// writer
	@Bean
	public ItemWriter<Product> itemWriter(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Product>().sql(
				"insert into products(product_id, title, description, price, discount, discounted_price) values(:productId, :title, :description, :price, :discount, :discountedPrice)")
				.dataSource(dataSource).beanMapped().build();
	}

}
