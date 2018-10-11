package com.capgemini.shoppingcartapp.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.shoppingcartapp.entity.Item;
import com.capgemini.shoppingcartapp.entity.Order;
import com.capgemini.shoppingcartapp.repository.OrderRepository;
import com.capgemini.shoppingcartapp.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	private HashMap<Integer, Set<Item>> map = new HashMap<>();

	@Override
	public Order submitOrder(Order order) {

		return orderRepository.save(order);
	}
	
	@Override
	public Order updateOrder(Order order) {
		return null;
	}

	@Override
	public Order getOrder(int orderId) {
		Optional<Order> optionalOrder=orderRepository.findById(orderId);
		if(optionalOrder.isPresent())
			optionalOrder.get();
		return orderRepository.save(optionalOrder.get());
         
	}

	@Override
	public List<Order> getOrders() {
		
		return orderRepository.findAll();
	}

	@Override
	public Order deleteOrder(int orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent())
			optionalOrder.get().setStatus("deleted");
		return orderRepository.save(optionalOrder.get());

	}

	@Override
	public Order cancelOrder(int orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent())
			optionalOrder.get().setStatus("cancelled");
		return orderRepository.save(optionalOrder.get());

	}

	@Override
	public void additem(Item item, int customerId) {
		Set<Item> tempSet = map.get(customerId);
		if (tempSet == null) {
			tempSet = new HashSet<>();
			tempSet.add(item);
			map.put(customerId, tempSet);
		} else {
			tempSet.add(item);
			map.put(customerId, tempSet);
		}

	}

	@Override
	public void removeItem(Item item, int customerId) {

		Set<Item> tempSet = map.get(customerId);
		if (tempSet != null) {
			tempSet.remove(item);
			map.put(customerId, tempSet);
		}

	}

	@Override
	public Set<Item> getItems(int customerId) {

		Set<Item> tempSet = map.get(customerId);
		return tempSet;
	}

	

}
