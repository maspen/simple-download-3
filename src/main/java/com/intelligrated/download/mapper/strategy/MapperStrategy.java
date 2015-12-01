package com.intelligrated.download.mapper.strategy;

import com.intelligrated.download.data.DataObject;

public interface MapperStrategy {
	
	DataObject map(String line);
}
