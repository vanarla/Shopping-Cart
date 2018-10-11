package com.capgemini.shoppingcartapp.entity;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {

	@Id
	private int orderId;
	private float ordersTotal;
	private LocalDate date;
	private int customerId;
	private Set<Item> item;
	private String status; 

	public Order() {
		super();
		status="true";
	}

	public Order(int orderId, float ordersTotal, LocalDate date, int customerId, Set<Item> item, String status) {
		super();
		this.orderId = orderId;
		this.ordersTotal = ordersTotal;
		this.date = date;
		this.customerId = customerId;
		this.item = item;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getOrdersTotal() {
		return ordersTotal;
	}

	public void setOrdersTotal(float ordersTotal) {
		this.ordersTotal = ordersTotal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
