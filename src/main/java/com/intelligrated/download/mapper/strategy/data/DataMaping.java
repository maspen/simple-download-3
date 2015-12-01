package com.intelligrated.download.mapper.strategy.data;

/**
 * Represents data in 'external file' that allows a DataMapper
 * to extract subsets of input string & insert into objects
 * 
 * @author matt.aspen
 */
public class DataMaping {
	Object value;
	String fieldName;
	String fieldTitle;
	String fieldTableName;
	Integer indexStart;
	Integer indexLength;
	@SuppressWarnings("rawtypes")
	Class dataType;
	
	public DataMaping(Object value, String fieldName, String fieldTitle, String fieldTableName, Integer indexStart,
			Integer indexLength, Class dataType) {
		this.value = value;
		this.fieldName = fieldName;
		this.fieldTitle = fieldTitle;
		this.fieldTableName = fieldTableName;
		this.indexStart = indexStart;
		this.indexLength = indexLength;
		this.dataType = dataType;
	}
	
	public DataMaping(String[] stringValuesArray) {
		// don't care about stringValuesArray[0] since value will be set later
		this.fieldName = stringValuesArray[1];
		this.fieldTitle = stringValuesArray[2];
		this.fieldTableName = stringValuesArray[3];
		this.indexStart = Integer.valueOf(stringValuesArray[4]);
		this.indexLength = Integer.valueOf(stringValuesArray[5]);
		
		String className = stringValuesArray[6].toUpperCase();
		this.dataType = DataTypeEnum.valueOf(className).getClazz();
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldTitle() {
		return fieldTitle;
	}

	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}

	public String getFieldTableName() {
		return fieldTableName;
	}

	public void setFieldTableName(String fieldTableName) {
		this.fieldTableName = fieldTableName;
	}

	public Integer getIndexStart() {
		return indexStart;
	}

	public void setIndexStart(Integer indexStart) {
		this.indexStart = indexStart;
	}

	public Integer getIndexLength() {
		return indexLength;
	}

	public void setIndexLength(Integer indexLength) {
		this.indexLength = indexLength;
	}

	public Class getDataType() {
		return dataType;
	}

	public void setDataType(Class dataType) {
		this.dataType = dataType;
	}
}

