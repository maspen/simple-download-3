package com.intelligrated.download.mapping;

import com.intelligrated.download.entity.DataObject;
import com.intelligrated.download.entity.Header;

public class HeaderMapper extends AbstractMapper {

	@Override
	protected DataObject getDataObject() {
		return new Header();
	}

	@Override
	protected Mapper getMapper() {
		return this;
	}
	
	@Override
	public DataObject map(String line) {
		
		// TODO: how the object gets mapped happens here
		
		System.out.println("HeaderMapper#map");
		
		return super.map(line);
	}
}
