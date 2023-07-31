package com.crm.group.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.group.model.Order;
import com.crm.group.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService OrderService;

	@GetMapping("/orders")
	@ResponseBody
	public ResponseEntity getAllorders() {
		List<Order> listorders = OrderService.getAllOrders();
		return ResponseEntity.ok().body(listorders.toString());
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getorderById(@PathVariable("id") Integer id) {
		Optional<Order> optionalorder = OrderService.getOrderById(id);
		if (optionalorder.isPresent()) {
			Order orderFound = optionalorder.get();
			return ResponseEntity.ok().body(orderFound);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addorder(@RequestBody Order order) {
		Order orderAdded = OrderService.addOrder(order);
		return ResponseEntity.ok().body(orderAdded);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteorder(@PathVariable("id") Integer id) {
		Boolean hasBeenDeleted = OrderService.deleteById(id);

		if (hasBeenDeleted) {
			return ResponseEntity.ok().body("Votre order a bien été supprimé");
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/update/{id}")
	@ResponseBody
	public ResponseEntity modifyorder(@PathVariable("id") Integer id, @RequestBody Order order) {
		System.out.println("Démarrage update" + id + " " + order.toString());
		Boolean hasBeenModified = OrderService.modifyOrder(id, order);

		if (hasBeenModified) {
			return ResponseEntity.ok().body("Votre order a bien été modifié en : " + order.toString());
		}
		return ResponseEntity.notFound().build();
	}
}
