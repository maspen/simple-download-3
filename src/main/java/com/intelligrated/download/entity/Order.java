package com.intelligrated.download.entity;

import javax.persistence.Entity;

/**
 *  0  2-9	    10-13  14-20
 * "2|SKU123ABC|DESC|0011223"
 * 
 * @author matt.aspen
 *
 */

@Entity
public class Order implements DataObject {
	String sku;
	String description;
	Integer orderNumber;
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
}
