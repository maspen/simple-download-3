package com.intelligrated.download.data;
/*
 * 0 1-4  5 6-11
 * 3|0011|t|125.00
 * 
 */
public class CartonObject implements DataObject {
	private String cartonId; // 1-4
	private Boolean isFull; // 5
	private Float pricePerUnit; // 6-11
	
	public String getCartonId() {
		return cartonId;
	}
	public void setCartonId(String cartonId) {
		this.cartonId = cartonId;
	}
	public Boolean getIsFull() {
		return isFull;
	}
	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}
	
	// b/c 't'/'f' comes in as String
	public void setIsFull(String isFull) {
		setIsFull(Boolean.valueOf(isFull));
	}
	
	public Float getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Float pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	// b/c pricePerUnit comes in as String
	public void setPricePerUnit(String pricePerUnit) {
		setPricePerUnit(Float.valueOf(pricePerUnit));
	}

	@Override
	public String toString() {
		return "{cartonId:" + getCartonId() +"\n" +
				"isFull:" + getIsFull().booleanValue() + "\n" +
				"pricePerUnit:" + getPricePerUnit().floatValue() + "}";
	}
}
