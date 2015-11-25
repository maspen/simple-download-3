package com.intelligrated.download;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.data.DataObjectFactory;
import com.intelligrated.download.mapper.Mapper;
import com.intelligrated.download.mapper.MapperFactory;

@SpringBootApplication
//@EntityScan
public class SimpleDownloadApplication implements CommandLineRunner {
	// 3 different lines
	static String[] lines = {
			"1631192015-11-19Order1", // see Header
			"2SKU123ABCDESC0011223",  // see Order
			"30011t125.00"			  // see Carton
	};
	
    public static void main(String[] args) {
        SpringApplication.run(SimpleDownloadApplication.class, args);
    }
    
    @Override
    public void run(String... srings) throws Exception {
    	System.out.println("*** starting:");

    	for (String line : lines) {
			System.out.println("line: " + line);
			DataObject dataObject = DataObjectFactory.getDataObject(line);
			Mapper mapper = MapperFactory.getMapper(dataObject);
			
			System.out.println("dataObject class: " + dataObject.getClass().getName());
		}
    	
    	System.out.println("stopping ***");
    }
}
