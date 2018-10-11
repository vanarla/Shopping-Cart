package com.capgemini.shoppingcartapp.entity;

public class Item {

	private int itemId;
	private int itemQuantity;
	private int productId;

	public Item() {
		super();
	}

	public Item(int itemId, int itemQuantity, int productId) {
		super();
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.productId = productId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

}
