package com.intelligrated.download.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

/** 0 1-5	6-14		15-20
 * "1|63119|2015-11-19|Order1"
 * 
 * @author matt.aspen
 *
 */

@Entity
public class Header implements DataObject {
	private Integer addressZip;
	private LocalDateTime orderDate;
	private String orderName;
	
	
	public Integer getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(Integer addressZip) {
		this.addressZip = addressZip;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
}
