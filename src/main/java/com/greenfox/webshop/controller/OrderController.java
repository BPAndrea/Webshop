package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping(value="/{id}/orders")
  public List<Order> getOrdersByUserId (@PathVariable long id){
    return this.orderService.getOrdersByUserId(id);
  }

  @GetMapping(value="/totalcost")
  public double getTotalCost(@RequestParam long orderId){
    return this.orderService.totalCost(orderService.getOrderById(orderId));
  }
}
