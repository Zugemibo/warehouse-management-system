package com.dawidp.warehousemanagementsystem.controller;

import com.dawidp.warehousemanagementsystem.dto.OrderDTO;
import com.dawidp.warehousemanagementsystem.dto.OrderLineDTO;
import com.dawidp.warehousemanagementsystem.model.Order;
import com.dawidp.warehousemanagementsystem.model.OrderLine;
import com.dawidp.warehousemanagementsystem.model.OrderStatus;
import com.dawidp.warehousemanagementsystem.model.Product;
import com.dawidp.warehousemanagementsystem.service.CustomerService;
import com.dawidp.warehousemanagementsystem.service.OrderLineService;
import com.dawidp.warehousemanagementsystem.service.OrderService;
import com.dawidp.warehousemanagementsystem.service.ProductService;
import com.dawidp.warehousemanagementsystem.util.OrderNumberGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dto/order")
public class OrderDTOController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderLineService orderLineService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public OrderDTO addNewOrder(@RequestBody OrderDTO orderDTO){
        orderDTO.setOrderNumber(OrderNumberGenerator.generator());
        orderDTO.setOrderDate(OrderNumberGenerator.getCurrentDateInString());
        Order order = convertToEntity(orderDTO);
        order.setStatus(OrderStatus.ORDERED);
        Order orderCreated = orderService.save(order);
        return convertToDto(orderCreated);
    }

    @PostMapping("/line")
    public OrderLineDTO addNewLine(@RequestBody OrderLineDTO orderLineDTO){
        Product product = productService.getProductByCode(orderLineDTO.getProductBarcode());
        OrderLine orderLine = convertToEntity(orderLineDTO);
        orderLine.setProduct(product);
        OrderLine orderLineCreated = orderLineService.save(orderLine);
        return convertToDto(orderLineCreated);
    }



    private OrderDTO convertToDto(Order order) {
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return orderDTO;
    }

    private Order convertToEntity(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        return order;
    }
    private OrderLineDTO convertToDto(OrderLine orderLine) {
        OrderLineDTO orderLineDTO = modelMapper.map(orderLine, OrderLineDTO.class);
        return orderLineDTO;
    }

    private OrderLine convertToEntity(OrderLineDTO orderLineDTO) {
        OrderLine orderLine = modelMapper.map(orderLineDTO, OrderLine.class);
        return orderLine;
    }



}
