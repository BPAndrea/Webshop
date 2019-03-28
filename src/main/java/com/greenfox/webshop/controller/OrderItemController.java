/*package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.BookRepository;
import com.greenfox.webshop.repository.OrderItemRepository;
import com.greenfox.webshop.repository.OrderRepository;
import com.greenfox.webshop.repository.UserRepository;
import com.greenfox.webshop.service.BookService;
import com.greenfox.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class OrderItemController {
  private BookService bookService;
  private BookRepository bookRepository;
  private UserService userService;
  private UserRepository userRepository;
  private OrderItemRepository orderItemRepository;
  private OrderRepository orderRepository;

  @Autowired
  public OrderItemController(BookService bookService, UserService userService, BookRepository bookRepository,
                        OrderItemRepository orderItemRepository, OrderRepository orderRepository, UserRepository userRepository) {
    this.bookService = bookService;
    this.userService = userService;
    this.bookRepository = bookRepository;
    this.orderItemRepository = orderItemRepository;
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
  }

  @GetMapping(value = "/1/orderitem")
  public OrderItem createOrderItem() {
   *//* LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    List<String> details = new ArrayList<>();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    User userToSave = new User(name, userEmail);
    userService.saveUser(userToSave);*//*
    Book ordered = bookRepository.findById(1);
    User usernew = new User ("test", "name");
    userRepository.save(usernew);
    OrderItem orderItem2 = new OrderItem(1, bookRepository.findById(1));
    Order order = new Order(Arrays.asList(orderItem2), usernew, Order.Status.PROCESSED );
    orderItemRepository.save(orderItem2);
    orderRepository.save(order);

    return orderItem2;
  }
}*/
/*
    User user1 = new User("a", "b");
    OrderItem orderItem1 = new OrderItem(2, bookRepository.findById(1));
    Order order1 = new Order(Arrays.asList(orderItem1), user1, Order.Status.PROCESSED);
    //bookRepository.save(book1);
    orderItemRepository.save(orderItem1);
    userRepository.save(user1);
    orderRepository.save(order1);
 */