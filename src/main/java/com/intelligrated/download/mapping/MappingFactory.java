package com.intelligrated.download.mapping;

import java.util.HashMap;
import java.util.Map;

import com.intelligrated.download.entity.DataObject;

public class MappingFactory {

	@SuppressWarnings("serial")
	static Map<String, Mapper> mapperMap = new HashMap<String, Mapper>(){{
		put("1", new HeaderMapper());
		put("2", new OrderMapper());
		put("3", new CartonMapper());
	}}; 
	
	public static DataObject map(String line) {
		// get 1'st character from line
		// & get the correct type of mapper
		
		// TODO: 1st char can be invalid
		Mapper mapper = mapperMap.get(line.charAt(0));
		
		DataObject data = mapper.map(line);
		return data;
	}
}
