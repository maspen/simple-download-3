package com.intelligrated.download.mapper;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.data.object.CartonObject;
import com.intelligrated.download.data.object.HeaderObject;
import com.intelligrated.download.data.object.OrderObject;

public class MapperFactory {
	
	// Q: is there a better way of mapping than DataObject:Mapper?
	
	public static Mapper getMapper(DataObject data) {
		// TODO:
		// if data == null --> throw exception
		if(data instanceof HeaderObject) {
			System.out.println("HeaderObject mapper");
		} else if(data instanceof OrderObject) {
			System.out.println("OrderObject mapper");
		} else if(data instanceof CartonObject) {
			System.out.println("CartonObject mapper");
		} else {
			// TODO: throw error
			System.out.println("error ... unkown DataObject type");
		}
		
		
		return null;
	}
}
