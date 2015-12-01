package com.intelligrated.download.data;

/* 0 1-9       10-17    18-20
 * 2|SKU123ABC|DESC0011|223"
 * 
 */
public class OrderObject implements DataObject {

	private String sku;
	private String description;
	private Integer quantity;
}
