package com.intelligrated.download.data;

import com.intelligrated.download.data.object.CartonObject;
import com.intelligrated.download.data.object.HeaderObject;
import com.intelligrated.download.data.object.OrderObject;

public class DataObjectFactory {
	
	// Q: how to replace switch statement
	//    is there a way to map 1st char of string w/ object (and mapper)
	//    externally & have application pick these up?

	public static DataObject getDataObject(String line) {
		// TODO:
		// if line == null --> throw exception
		// if line == "" --> throw exception
		String firstChar = line.substring(0, 1);
		
		DataObject dataObject = null;
		switch(firstChar) {
		case("1"):
			System.out.println("create Header");
			dataObject = new HeaderObject();
			break;
		case("2"):
			System.out.println("create Order");
			dataObject = new OrderObject();
			break;
		case("3"):
			System.out.println("create Carton");
			dataObject = new CartonObject();
			break;
		default:
			System.out.println("unknown DataObject type");
		}
		
		return dataObject;
	}
}
