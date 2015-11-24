package com.intelligrated.download.mapping;

import com.intelligrated.download.entity.Carton;
import com.intelligrated.download.entity.DataObject;

public class CartonMapper extends AbstractMapper {

	@Override
	protected DataObject getDataObject() {
		return new Carton();
	}

	@Override
	protected Mapper getMapper() {
		return this;
	}
	
	@Override
	public DataObject map(String line) {

		// TODO: how the object gets mapped happens here
		
		System.out.println("CartonMapper#map");
		
		return super.map(line);
	}

}
