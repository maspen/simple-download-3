package com.intelligrated.download;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.intelligrated.download.mapper.strategy.HeaderMapperStrategy;
import com.intelligrated.download.mapper.strategy.OrderMapperStrategy;

@Configuration
//@ComponentScan(basePackages = {"com.intelligrated.download"})
@Import({HeaderMapperStrategy.class, OrderMapperStrategy.class})
public class Config {

	@Bean(name="headerMapperResource")
	public Resource getHeaderMapperResource() {
		//ClassPathResource classpathResource = new ClassPathResource("classpath:simple-data-for-testing.txt");
		ClassPathResource classpathResource = new ClassPathResource("sample-data-header.txt");
		//return new ClassPathResource("classpath:simple-data-for-testing.txt");
		return classpathResource;
	}
	
	@Bean(name="orderMapperResource")
	public Resource getOrderMapperResource() {
		return null;
	}
}
