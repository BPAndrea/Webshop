package com.greenfox.webshop;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.BookRepository;
import com.greenfox.webshop.repository.OrderItemRepository;
import com.greenfox.webshop.repository.OrderRepository;
import com.greenfox.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  OrderItemRepository orderItemRepository;
  @Autowired
  BookRepository bookRepository;

  public static void main(String[] args) {
    SpringApplication.run(WebshopApplication.class, args);
    System.out.println("hello");
  }

  @Override
  public void run(String... args) throws Exception {
    Book book1 = new Book("a", "b", "c", "d", "e", 100.0d, 5);
    OrderItem orderItem1 = new OrderItem(5, book1);
    User user1 = new User("a", "b");
    Order order1 = new Order(Arrays.asList(orderItem1), user1, Order.Status.PROCESSED);
    bookRepository.save(book1);
    orderItemRepository.save(orderItem1);
    userRepository.save(user1);
    orderRepository.save(order1);
  }
}
