package com.greenfox.webshop.repository;

import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
  List<OrderItem> findAllByOrder(Order order);
}

