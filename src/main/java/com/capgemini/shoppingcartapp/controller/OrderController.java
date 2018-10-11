package com.capgemini.shoppingcartapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.shoppingcartapp.entity.Item;
import com.capgemini.shoppingcartapp.entity.Order;
import com.capgemini.shoppingcartapp.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/additem/{customerId}")
	public ResponseEntity<Item> addItem(@RequestBody Item item, @PathVariable int customerId) {
		orderService.additem(item, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	} 
	
	@DeleteMapping("/removeitem/{customerId}")
	public ResponseEntity<Set<Item>> removeItem(@PathVariable int customerId, @RequestBody Item item) {
		orderService.removeItem(item, customerId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/getitem/{customerId}")
	public ResponseEntity<Set<Item>> getLineItems(@PathVariable int customerId) {
		ResponseEntity<Set<Item>> tempSet = new ResponseEntity<Set<Item>>(orderService.getItems(customerId),HttpStatus.OK);
		return tempSet;
	}
	
	@PostMapping("/order")
	public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
		order.setDate(LocalDate.now());
		return new ResponseEntity<Order>(orderService.submitOrder(order), HttpStatus.OK);

	}
	
	@GetMapping("/cancel/{orderId}")
	public ResponseEntity<Order> cancelOrder(@PathVariable int orderId){
		ResponseEntity<Order> response= new ResponseEntity<Order>(orderService.cancelOrder(orderId),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/delete/{orderId}")
	public ResponseEntity<Order> deleteOrder(@PathVariable int orderId){
		ResponseEntity<Order> response= new ResponseEntity<Order>(orderService.deleteOrder(orderId),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/get/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable int orderId){
		ResponseEntity<Order> response=new ResponseEntity<Order>(orderService.getOrder(orderId),HttpStatus.OK);
		return response;

	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Order>> getOrders(){
		ResponseEntity<List<Order>> response=new ResponseEntity<List<Order>>(orderService.getOrders(),HttpStatus.OK);
		return response;
	}
	
}
