package com.intelligrated.download.mapper.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.intelligrated.download.data.DataObject;

public class OrderMapperStrategy implements MapperStrategy {

	@Autowired
	private Resource orderMapperResource;
	
	@Override
	public DataObject map(String line) {
		System.out.println("*** OrderMapperStrategy#map()");
		return null;
	}

}
