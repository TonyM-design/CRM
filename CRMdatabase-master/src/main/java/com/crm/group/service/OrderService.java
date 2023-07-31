package com.crm.group.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.group.model.Order;
import com.crm.group.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	/**
	 * 
	 * @return all orders in database
	 */
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return the order associated with "id"
	 */
	public Optional<Order> getOrderById(Integer id) {
		return orderRepository.findById(id);
	}

	/**
	 * 
	 * @param order
	 * @return the order saved in the database
	 */
	public Order addOrder(Order order) {

		return orderRepository.save(order);
	}

	/**
	 * 
	 * @param id
	 * @param order
	 * @return true if an order with id existed and was correctly modified
	 */
	public Boolean modifyOrder(Integer id, Order order) {
		Optional<Order> optOrder = orderRepository.findById(id);
		if (optOrder.isPresent()) {
			orderRepository.save(order);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param id
	 * @return true if an order with "id" existed and was correctly deleted
	 */
	public Boolean deleteById(Integer id) {
		Optional<Order> orderToDelete = orderRepository.findById(id);
		if (orderToDelete.isPresent()) {
			orderRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
