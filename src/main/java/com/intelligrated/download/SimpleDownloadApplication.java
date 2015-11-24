package com.intelligrated.download;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.intelligrated.download.repo.DataObjectRepository;


@SpringBootApplication
public class SimpleDownloadApplication implements CommandLineRunner {
	// 3 different lines
	static String[] lines = {
			"1631192015-11-19Order1", // see Header
			"2SKU123ABCDESC0011223",  // see Order
			"30011t125.00"			  // see Carton
	};
	
	
	@Autowired
	private DataObjectRepository dataObjectRepository;
	
	static String timeAsString = LocalDateTime.now().toString();
	//					 [order number][sku][ship date]
	static String line = "123456XYZ6789ABC" + timeAsString + "DESCRIPTION";
	// sample date: 2015-11-19T15:30:33.384
	
    public static void main(String[] args) {
        SpringApplication.run(SimpleDownloadApplication.class, args);
    }
    
    @Override
    public void run(String... srings) throws Exception {
    	// iterate over all lines
    	for (String line : srings) {
    		// send each to a mapper			
		}
    }
}
