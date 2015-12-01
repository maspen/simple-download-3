package com.intelligrated.download.mapper.strategy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.data.OrderObject;
import com.intelligrated.download.mapper.strategy.data.DataMaping;

public class OrderMapperStrategy extends AbstractMapperStrategy {

	@Autowired
	private Resource orderMapperResource;
	
	private static Set<DataMaping> dataMapingSet = new HashSet<DataMaping>();
	
	@Override
	public DataObject map(String line) {
		System.out.println("*** OrderMapperStrategy#map()");
		
		OrderObject dataObject = new OrderObject();
		for (DataMaping dataMaping : dataMapingSet) {
			String value = line.substring(dataMaping.getIndexStart(), (dataMaping.getIndexStart() + dataMaping.getIndexLength() ));
			String fieldName = dataMaping.getFieldName();
			switch(dataMaping.getFieldName()) {
				case "sku":
					dataObject.setSku(value);
					break;
				case "description":
					dataObject.setDescription(value);
					break;
				case "quantity":
					dataObject.setQuantity(value);
					break;
				default:
					System.err.println("invalid field name: " + fieldName);
					break;
			}
		}
		
		return dataObject;
	}

	@Override
	public Resource getResource() {
		return orderMapperResource;
	}
	
	@Override
	public Set<DataMaping> getDataMappingSet() {
		return dataMapingSet;
	}
}
