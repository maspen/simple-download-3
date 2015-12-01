package com.intelligrated.download.mapper.strategy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.intelligrated.download.data.CartonObject;
import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.mapper.strategy.data.DataMaping;

public class CartonMapperStrategy extends AbstractMapperStrategy {
	@Autowired
	private Resource cartonMapperResource;
	
	// TODO:  not sure if this can be moved to Abstract class
	// has to be 'static' b/c after @PostConstruct becomes null
	private static Set<DataMaping> dataMapingSet = new HashSet<DataMaping>();
	
	@Override
	public DataObject map(String line) {
		System.out.println("*** CartonMapperStrategy#map()");
		
		CartonObject dataObject = new CartonObject();
		for (DataMaping dataMaping : dataMapingSet) {
			String value = line.substring(dataMaping.getIndexStart(), (dataMaping.getIndexStart() + dataMaping.getIndexLength() ));
			String fieldName = dataMaping.getFieldName();
			switch(dataMaping.getFieldName()) {
				case "carton_id":
					dataObject.setCartonId(value);
					break;
				case "is_full":
					dataObject.setIsFull(value);
					break;
				case "unit_price":
					dataObject.setPricePerUnit(value);
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
		return cartonMapperResource;
	}

	public void setResource(Resource resource) {
		this.cartonMapperResource = resource;
	}
	
	@Override
	public Set<DataMaping> getDataMappingSet() {
		return dataMapingSet;
	}
}
