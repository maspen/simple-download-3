package com.intelligrated.download.mapping;

import com.intelligrated.download.entity.DataObject;

public abstract class AbstractMapper implements Mapper {

	@Override
	public DataObject map(String line) {
		// instantiate new data object
		DataObject dataObject = getDataObject();

		// get the correct type of mapper based on 
		// the 'type' of object
		Mapper mapper = getMapper();
		
		// parse line into fields & insert into data object
		return mapper.map(line);
	}
	
	protected abstract DataObject getDataObject();
	
	protected abstract Mapper getMapper();
}
