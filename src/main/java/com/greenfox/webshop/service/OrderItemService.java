package com.greenfox.webshop.service;

import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
  @Autowired
  private OrderItemRepository orderItemRepository;

  public String totalCost (long id){
    double result = 0.0d;
    List<OrderItem> orderItemList = orderItemRepository.findAllByUser(id);
    for (OrderItem orderItem: orderItemList) {
      result+= orderItem.getQuantity() * orderItem.getBook().getPrice();
    }
    String s = String.format("%.1f", result);
    return s;
  }
}
