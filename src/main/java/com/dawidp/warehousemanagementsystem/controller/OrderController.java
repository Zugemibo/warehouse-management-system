package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.model.Order;
import com.dawidp.warehousemanagementsystem.model.OrderLine;
import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.model.Stock;
import com.dawidp.warehousemanagementsystem.operations.OrderPick;
import com.dawidp.warehousemanagementsystem.operations.PickLine;
import com.dawidp.warehousemanagementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderLineService orderLineService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderPickService orderPickService;

    @Autowired
    private StockService stockService;

    @Autowired
    private PickLineService pickLineService;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    @GetMapping("/order/{orderId}")
    public Order getOrderById(@PathVariable("orderId") Long orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        List<Order> orders = orderService.getAllOrders();
        return orders;
    }

    @PostMapping("/order")
    public Order addOrder() {
        Order order = new Order();
        return orderService.save(order);
    }
    @PostMapping("/addFromShop")
    public Order addOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PostMapping("/order/{orderId}/lines")
    public Order addToOrder(@PathVariable("orderId") Long orderId, @RequestBody OrderLine line) {
        Order order = orderService.getOrder(orderId);
        Product product = productService.getProductById(line.getProduct().getProductId());
        order.addLine(line);
        return orderService.save(order);
    }

    @DeleteMapping("/order/{orderId}/clear")
    public Order deleteAllLines(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getOrder(orderId);
        order.removeLines();
        return orderService.save(order);
    }

    @DeleteMapping("/order/{orderId}/lines/{id}")
    public Order deleteFromOrder(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id) {
        Order order = orderService.getOrder(orderId);
        OrderLine line = orderLineService.getOrderLine(id);
        order.removeLine(line);
        return orderService.save(order);
    }

    @DeleteMapping("/order/{orderId}/cancel-order")
    public void deleteOrderById(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @PostMapping("/moveToPick/{orderId}")
    public void moveOrderToOrderPick(@PathVariable("orderId") Long orderId) {
        Order order = orderService.getOrder(orderId);
        OrderPick orderPick = new OrderPick(order);
        for (OrderLine orderLine : order.getLinesItems()) {
            Stock stock = stockService.getStockWithSufficientQuantity(orderLine.getProduct().getProductBarcode(), orderLine.getQuantity());
            PickLine pickLine = new PickLine(orderLine, stock);
            stock.setStockAvailable(stock.getStockAvailable() - orderLine.getQuantity());
            stock.setStockReserved(stock.getStockReserved() + orderLine.getQuantity());
//            pickLineService.save(pickLine);
            orderPick.addLine(pickLine);
            orderPickService.save(orderPick);
        }
    }

}
