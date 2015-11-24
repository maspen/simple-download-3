package com.intelligrated.download.mapping;

import com.intelligrated.download.entity.DataObject;
import com.intelligrated.download.entity.Order;

public class OrderMapper extends AbstractMapper {

	@Override
	protected DataObject getDataObject() {
		return new Order();
	}

	@Override
	protected Mapper getMapper() {
		return this;
	}
	
	@Override
	public DataObject map(String line) {

		// TODO: how the object gets mapped happens here
		
		System.out.println("OrderMapper#map");
		
		return super.map(line);
	}

}
