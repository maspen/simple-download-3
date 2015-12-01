package com.intelligrated.download.mapper.strategy;

import com.intelligrated.download.data.DataObject;

public class CartonMapperStrategy implements MapperStrategy {

	@Override
	public DataObject map(String line) {
		System.out.println("*** CartonMapperStrategy#map()");
		return null;
	}

}
