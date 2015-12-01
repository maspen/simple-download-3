package com.intelligrated.download.mapper.strategy.data;

import java.time.LocalDateTime;

/**
 * maps String text of 'data_type' to actual data types
 * 
 * @author matt.aspen
 */
@SuppressWarnings("rawtypes")
public enum DataTypeEnum {
	INTEGER(Integer.class),
	DATE(LocalDateTime.class),
	STRING(String.class);
	
	private Class clazz;
	
	DataTypeEnum(Class clazz) {
		this.clazz = clazz;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
}
