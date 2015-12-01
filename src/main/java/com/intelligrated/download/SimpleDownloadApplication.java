package com.intelligrated.download;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.mapper.strategy.CartonMapperStrategy;
import com.intelligrated.download.mapper.strategy.HeaderMapperStrategy;
import com.intelligrated.download.mapper.strategy.MapperStrategy;
import com.intelligrated.download.mapper.strategy.OrderMapperStrategy;

@SpringBootApplication
//@EntityScan
public class SimpleDownloadApplication implements CommandLineRunner {
	// 3 different lines
	static String[] lines = {
			"1631192015-11-19Order1", // see Header
			"2SKU123ABCDESC0011223",  // see Order
			"30011t125.00"			  // see Carton
	};
	
	static Map<String, MapperStrategy> mapperStrategyMape = new ConcurrentHashMap<String, MapperStrategy>(){{
		put("1", new HeaderMapperStrategy());
		put("2", new OrderMapperStrategy());
		put("3", new CartonMapperStrategy());
	}};
	
    public static void main(String[] args) {
        SpringApplication.run(SimpleDownloadApplication.class, args);
    }
    
    /**
     * 1. read in file line by line
     * 2. using 1st 'char' determine what type of DataObject will be created
     * 3. send correct DataObject to MapperFactory to get the correct mapper
     * 4. call mapper.map which returns a persisted DataObject of correct type
     */
    @Override
    public void run(String... srings) throws Exception {
    	System.out.println("*** starting:");

    	for (String line : lines) {
			System.out.println("line: " + line);
			MapperStrategy mapperStrategy = getMapperStrategy(line);
			
			DataObject dataObject = mapperStrategy.map(line);
			
//			System.out.println(dataObject.toString());
			
			// TODO: persist dataObject
			System.out.println("");
		}
    	
    	System.out.println("stopping ***");
    }
    
    private MapperStrategy getMapperStrategy(String line) {
    	// TODO: if line == null -->NPE
    	// TODO: if line == ""
    	String firstChar = line.substring(0, 1);
    	// TODO: if '1st char' not in map
    	return mapperStrategyMape.get(firstChar);
    }
}
