package com.intelligrated.download.entity;

/**
 *  0  1-4 5  6-10
 * "3|0011|t|125.00"
 * 
 * @author matt.aspen
 *
 */
public class Carton implements DataObject {
	Integer numberItems;
	Boolean isFull;
	Float weight;
	
	public Integer getNumberItems() {
		return numberItems;
	}
	public void setNumberItems(Integer numberItems) {
		this.numberItems = numberItems;
	}
	public Boolean getIsFull() {
		return isFull;
	}
	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
}
