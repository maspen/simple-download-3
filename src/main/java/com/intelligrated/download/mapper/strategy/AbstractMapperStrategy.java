package com.intelligrated.download.mapper.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.core.io.Resource;

import com.intelligrated.download.data.DataObject;
import com.intelligrated.download.mapper.strategy.data.DataMaping;

public class AbstractMapperStrategy implements MapperStrategy {

	@Override
	public DataObject map(String line) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct
	public void load() {
		try {
			final InputStream inputStream = getResource().getInputStream();
			// use the stream
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			// StringBuilder stringBuilder = new StringBuilder();
			String line;
			boolean firstLine = true;

			while ((line = br.readLine()) != null) {
				if (!firstLine) {
					DataMaping maping = dataMap(line);
					getDataMappingSet().add(maping);
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
	
	protected DataMaping dataMap(String line) {
		// TODO: check 'line'
		line.trim();
		String[] lineSplitArray = line.split("\t");
		// TODO: check that 'array' is correct length

		return new DataMaping(lineSplitArray);
	}

	@Override
	public Resource getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DataMaping> getDataMappingSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
