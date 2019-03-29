package com.greenfox.webshop.service;

import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.OrderItemRepository;
import com.greenfox.webshop.repository.OrderRepository;
import com.greenfox.webshop.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private OrderItemRepository orderItemRepository;

  public Order getOrderById(long id){
    return this.orderRepository.findById(id);
  }

  public String totalCost (long id){
    double result = 0.0d;
    List<OrderItem> orderItemList = orderItemRepository.findAllByUser(id);
    for (OrderItem orderItem: orderItemList) {
      result+= orderItem.getQuantity() * orderItem.getBook().getPrice();
    }
    String s = String.format("%.1f", result);
    return s;
  }

  public List<OrderItem> getOrderItemsByOrder(Order order){
    return this.orderItemRepository.findAllByOrder(order);
  }

  public List<Order> getOrdersByUserId (long id){
    return this.orderRepository.findAllByUserId(id);
  }
}
