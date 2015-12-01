package com.intelligrated.download.mapper.strategy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.data.HeaderObject;
import com.intelligrated.download.mapper.strategy.data.DataMaping;

public class HeaderMapperStrategy extends AbstractMapperStrategy {
	@Autowired
	private Resource headerMapperResource;

	// TODO:  not sure if this can be moved to Abstract class
	// has to be 'static' b/c after @PostConstruct becomes null
	private static Set<DataMaping> dataMapingSet = new HashSet<DataMaping>();

	@Override
	public DataObject map(String line) {
		System.out.println("*** HeaderMapperStrategy#map()");

		HeaderObject dataObject = new HeaderObject();
		// iterate over dataMapingSet
		// for each entry, pull out data from String
		// create correct data type
		// set in HeaderObject
		for (DataMaping dataMaping : dataMapingSet) {
			String value = line.substring(dataMaping.getIndexStart(), (dataMaping.getIndexStart() + dataMaping.getIndexLength() ));
			String fieldName = dataMaping.getFieldName();
			switch(dataMaping.getFieldName()) {
				case "sku":
					dataObject.setSku(value);
					break;
				case "ship_date":
					dataObject.setShipDate(value);
					break;
				case "descr":
					dataObject.setDescription(value);
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
		return headerMapperResource;
	}

	public void setResource(Resource resource) {
		this.headerMapperResource = resource;
	}
	
	@Override
	public Set<DataMaping> getDataMappingSet() {
		return dataMapingSet;
	}
}
