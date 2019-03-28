/*package com.greenfox.webshop.config;

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
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Seed implements CommandLineRunner {
  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  OrderItemRepository orderItemRepository;

  @Override
  public void run(String... args) throws Exception {
    Book book1 = new Book("Vuk", "Fekete István", "some picture", 2.3);
    Book book2 = new Book("Vuk2", "Nagy István", "some picture2", 8.3);
    Book book3 = new Book("harmadik", "xy", "some picture2", 1.3);
    Book book4 = new Book("negyedik", "xy", "some picture2", 0.3, 0);
    bookRepository.save(book1);
    bookRepository.save(book2);
    bookRepository.save(book3);
    bookRepository.save(book4);
    User user1 = new User("a", "b");
    OrderItem orderItem1 = new OrderItem(5, book1);
    Order order1 = new Order(Arrays.asList(orderItem1), user1, Order.Status.PROCESSED);
    bookRepository.save(book1);
    orderItemRepository.save(orderItem1);
    userRepository.save(user1);
    orderRepository.save(order1);

  }


}
*/
