package com.intelligrated.download.data;

/* 0 1-9       10-17    18-20
 * 2|SKU123ABC|DESC0011|223"
 * 
 */
public class OrderObject implements DataObject {

	private String sku;
	private String description;
	private Integer quantity;
	
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	// b/c value comes in as String
	public void setQuantity(String quantity) {
		setQuantity(Integer.valueOf(quantity));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{sku:" + getSku() + "\n" +
				"description:" + getDescription() + "\n" +
				"quantity:" + getQuantity().intValue() + "}";
	}
}
