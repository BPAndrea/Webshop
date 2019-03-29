package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

  private OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping(value="/{id}/orders")
  public String getOrdersByUserId (@PathVariable long id, Model model){
    model.addAttribute("orders", orderService.getOrdersByUserId(id));
    return "cart";
  }

  @GetMapping(value="/totalcost")
  public double getTotalCost(@RequestParam long orderId){

    return this.orderService.totalCost(orderService.getOrderById(orderId));
  }
}
