package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.BookRepository;
import com.greenfox.webshop.repository.OrderItemRepository;
import com.greenfox.webshop.repository.OrderRepository;
import com.greenfox.webshop.service.BookService;
import com.greenfox.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Controller
public class BookController {

  private BookService bookService;
  private BookRepository bookRepository;
  private UserService userService;
  private OrderItemRepository orderItemRepository;
  private OrderRepository orderRepository;

  @Autowired
  public BookController(BookService bookService, UserService userService, BookRepository bookRepository,
                        OrderItemRepository orderItemRepository, OrderRepository orderRepository) {
    this.bookService = bookService;
    this.userService = userService;
    this.bookRepository = bookRepository;
    this.orderItemRepository = orderItemRepository;
    this.orderRepository = orderRepository;
  }

  @GetMapping("/home")
  public String index(@RequestParam(value = "keyword", required = false) String keyword, Model model, OAuth2Authentication authentication) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    List<String> details = new ArrayList<>();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    User userToSave = new User(name, userEmail);
    userService.saveUser(name, userEmail);
    if (keyword == null) {
      model.addAttribute("books", bookService.getAll());
      model.addAttribute("name", name);
      model.addAttribute("email", userEmail);
      return "index";
    } else {
      model.addAttribute("books", bookService.findByTitleDescriptionorAuthor(keyword));
      return "index";
    }
  }

  @GetMapping(value = "/in-stock")
  public List<Book> getAviable() {
    return bookService.getAviable();
  }

  @RequestMapping(value = "/sort-by-price-asc")
  public List<Book> getCheapestFirst() {
    return bookService.sortByPrice();
  }

  @GetMapping(value = "/{id}/orderitem")
  public String getOrdersByUserId(@PathVariable long id, OAuth2Authentication authentication) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    List<String> details = new ArrayList<>();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    User userToSave = new User(name, userEmail);
    userService.saveUser(name, userEmail);
    Book ordered = bookRepository.findById(id);
    Order order = new Order();
    OrderItem orderItem = new OrderItem(1, ordered, order);
    List<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(orderItem);
    order.setOrderItem(orderItemList);
    order.setUser(userToSave);
    orderItemRepository.save(orderItem);
    orderRepository.save(order);

    return "redirect:/";
  }
}
