package com.capgemini.shoppingcartapp.service;

import java.util.List;
import java.util.Set;

import com.capgemini.shoppingcartapp.entity.Item;
import com.capgemini.shoppingcartapp.entity.Order;

public interface OrderService {

	public Order submitOrder(Order order);

	public Order getOrder(int orderId);

	public List<Order> getOrders();

	public Order updateOrder(Order order);

	public Order deleteOrder(int orderId);

	public Order cancelOrder(int orderId);

	public void additem(Item item, int customerId);

	public void removeItem(Item item, int customerId);

	public Set<Item> getItems(int customerId);

}
