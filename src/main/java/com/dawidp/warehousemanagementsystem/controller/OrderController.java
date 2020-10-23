package com.dawidp.warehousemanagementsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawidp.warehousemanagementsystem.model.Order;
import com.dawidp.warehousemanagementsystem.model.OrderLine;
import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.service.OrderLineService;
import com.dawidp.warehousemanagementsystem.service.OrderService;
import com.dawidp.warehousemanagementsystem.service.ProductService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	OrderService service;

	@Autowired
	OrderLineService lservice;

	@Autowired
	ProductService pservice;

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	Date date = new Date(System.currentTimeMillis());

	@GetMapping("/order/{orderId}")
	public Order getOrderById(@PathVariable("orderId") Long orderId) {
		return service.getOrder(orderId);
	}

	@GetMapping("/orders")
	public List<Order> getOrders() {
		List<Order> orders = service.getAllOrders();
		return orders;
	}

	@PostMapping("/order")
	public Order createOrder() {
		Order order = new Order();
		return service.save(order);
	}

	@PostMapping("/order/{orderId}/lines")
	public Order addToOrder(@PathVariable("orderId") Long orderId, @RequestBody OrderLine line) {
		Order order = service.getOrder(orderId);
		Product product = pservice.getProductById(line.getProduct().getProductId());
		order.addLine(line);
		return service.save(order);
	}

	@DeleteMapping("/order/{orderId}/clear")
	public Order deleteAllLines(@PathVariable("orderId") Long orderId) {
		Order order = service.getOrder(orderId);
		order.removeLines();
		return service.save(order);
	}

	@DeleteMapping("/order/{orderId}/lines/{id}")
	public Order deleteFromOrder(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id) {
		Order order = service.getOrder(orderId);
		OrderLine line = lservice.getOrderLine(id);
		order.removeLine(line);
		return service.save(order);
	}

	@DeleteMapping("/order/{orderId}/cancel-order")
	public void deleteOrderById(@PathVariable("orderId") Long orderId) {
		service.deleteOrderById(orderId);
	}

	/*
	 * @PutMapping("/order/{OrderId}/lines/{id}") public
	 * ResponseEntity<ShoppingOrder> changeQuantity(@PathVariable("OrderId") int
	 * OrderId,
	 * 
	 * @PathVariable("id") int id, @RequestBody LineItem line) { ShoppingOrder Order
	 * = service.getOrderById(OrderId); LineItem lineItem =
	 * service.getOrderLineById(id); Order.setSubTotal(Order.getSubTotal() -
	 * lineItem.getTotalPrice()); lineItem.setQuantity(line.getQuantity());
	 * lineItem.setTotalPrice(lineItem.getQuantity() *
	 * lineItem.getProduct().getPrice()); Order.setSubTotal(Order.getSubTotal() +
	 * lineItem.getTotalPrice()); service.updateOrder(Order); return new
	 * ResponseEntity<>(Order, HttpStatus.OK); }
	 */

}
