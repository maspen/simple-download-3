package com.intelligrated.download;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.intelligrated.download.mapper.strategy.CartonMapperStrategy;
import com.intelligrated.download.mapper.strategy.HeaderMapperStrategy;
import com.intelligrated.download.mapper.strategy.OrderMapperStrategy;

@Configuration
//@ComponentScan(basePackages = {"com.intelligrated.download"})
@Import({HeaderMapperStrategy.class, OrderMapperStrategy.class, CartonMapperStrategy.class})
public class Config {

	@Bean(name="headerMapperResource")
	public Resource getHeaderMapperResource() {
		ClassPathResource classpathResource = new ClassPathResource("mapping-header.txt");
		return classpathResource;
	}
	
	@Bean(name="orderMapperResource")
	public Resource getOrderMapperResource() {
		ClassPathResource classpathResource = new ClassPathResource("mapping-order.txt");
		return classpathResource;
	}
	
	@Bean(name="cartonMapperResource")
	public Resource getCartonMapperResource() {
		ClassPathResource classpathResource = new ClassPathResource("mapping-carton.txt");
		return classpathResource;
	}
}
