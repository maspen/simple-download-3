package com.intelligrated.download.mapper.strategy;

import java.util.Set;

import org.springframework.core.io.Resource;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.mapper.strategy.data.DataMaping;

public interface MapperStrategy {
	
	DataObject map(String line);
	
	Resource getResource();
	
	Set<DataMaping> getDataMappingSet();
}
