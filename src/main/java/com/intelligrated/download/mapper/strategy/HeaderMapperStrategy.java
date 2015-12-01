package com.intelligrated.download.mapper.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.data.HeaderObject;
import com.intelligrated.download.mapper.strategy.data.DataMaping;

public class HeaderMapperStrategy implements MapperStrategy {
	@Autowired
	private Resource headerMapperResource;

	// has to be 'static' b/c after @PostConstruct becomes null
	private static Set<DataMaping> dataMapingSet = new HashSet<DataMaping>();

	@PostConstruct
	public void load() {
		try {
			final InputStream inputStream = headerMapperResource.getInputStream();
			// use the stream
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			// StringBuilder stringBuilder = new StringBuilder();
			String line;
			boolean firstLine = true;

			while ((line = br.readLine()) != null) {
				if (!firstLine) {
					DataMaping maping = dataMap(line);
					dataMapingSet.add(maping);
				} else {
					// skip since this is the row containing the column names
					firstLine = false;
				}
			}
			br.close();
		} catch (IOException e) {
			System.err.println("error loading file:" + e.getMessage());
		}
	}

	private DataMaping dataMap(String line) {
		// TODO: check 'line'
		line.trim();
		String[] lineSplitArray = line.split("\t");
		// TODO: check that 'array' is correct length

		return new DataMaping(lineSplitArray);
	}

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

	public Resource getResource() {
		return headerMapperResource;
	}

	public void setResource(Resource resource) {
		this.headerMapperResource = resource;
	}
}
