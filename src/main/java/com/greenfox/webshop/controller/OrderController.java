package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController(value = "/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping(value="/{id}")
  public List<Order> getOrdersById (@PathVariable long id){
    return this.orderService.getOrdersByUserId(id);
  }

  @GetMapping(value="/totalcost")
  public double getTotalCost(@RequestParam long orderId){
    return this.orderService.totalCost(orderService.getOrderById(orderId));
  }
}
