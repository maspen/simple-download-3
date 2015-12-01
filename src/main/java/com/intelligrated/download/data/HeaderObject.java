package com.intelligrated.download.data;

import java.time.LocalDate;

/* 0 1 - 5 6 - 15     16-21
 * 1|63119|2015-11-19|Order1"
 * 
 */
public class HeaderObject implements DataObject {
	
	private Integer sku; // 1-5
	private LocalDate shipDate; // 6-15
	private String description; // 16-21

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}
	
	// added b/c from file line, comes in as String
	public void setSku(String sku) {
		// TODO: check sku
		setSku(Integer.valueOf(sku));
	}

	public LocalDate getShipDate() {
		return shipDate;
	}

	public void setShipDate(LocalDate shipDate) {
		this.shipDate = shipDate;
	}
	
	// added b/c from file line, comes in as String
	public void setShipDate(String shipDate) {
		// TODO: check shipDate
		// format: 2015-11-19 == yyyy-MM-dd
		setShipDate(LocalDate.parse(shipDate));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return "{sku:" + getSku() + "\n" +
				"shipDate:" + getShipDate().toString() + "\n" +
				"description:" + getDescription() +"}";
	}
}
