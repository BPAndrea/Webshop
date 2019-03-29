package com.greenfox.webshop.repository;

import com.greenfox.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
  List<Order> findAllByUserId(long id);
  Order findById(long id);
  Order save(Order order);
}
