package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.BookRepository;
import com.greenfox.webshop.repository.OrderItemRepository;
import com.greenfox.webshop.repository.OrderRepository;
import com.greenfox.webshop.service.BookService;
import com.greenfox.webshop.service.OrderItemService;
import com.greenfox.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


@Controller
public class BookController {

  private BookService bookService;
  private BookRepository bookRepository;
  private UserService userService;
  private OrderItemRepository orderItemRepository;
  private OrderItemService orderItemService;
  private OrderRepository orderRepository;

  @Autowired
  public BookController(BookService bookService, UserService userService, BookRepository bookRepository,
                        OrderItemRepository orderItemRepository, OrderRepository orderRepository, OrderItemService orderItemService) {
    this.bookService = bookService;
    this.userService = userService;
    this.bookRepository = bookRepository;
    this.orderItemRepository = orderItemRepository;
    this.orderRepository = orderRepository;
    this.orderItemService = orderItemService;
  }

  @GetMapping("/home")
  public String index(@RequestParam(value = "keyword", required = false) String keyword, Model model, OAuth2Authentication authentication) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    userService.saveUser(name, userEmail);
    model.addAttribute("name", name);
    model.addAttribute("email", userEmail);
    model.addAttribute("order", new Order());
    if (keyword == null) {
      model.addAttribute("books", bookService.getAll());
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
  public String createOrderItem(@PathVariable long id, OAuth2Authentication authentication, Model model) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    User userWhoOrdered = userService.saveUser(name, userEmail);
    OrderItem orderItem = new OrderItem(1, bookRepository.findById(id), userWhoOrdered);
    Order order = new Order(Arrays.asList(orderItem), userWhoOrdered, Order.Status.PROCESSED);
    orderItemRepository.save(orderItem);
    orderRepository.save(order);
    model.addAttribute("orderitem", orderItemRepository.findAllByUser(userWhoOrdered.getId()));
    model.addAttribute("name", name);
    model.addAttribute("email", userEmail);
    model.addAttribute("totalCost", orderItemService.totalCost(userWhoOrdered.getId()));
    return "ordered_items";
  }

  @GetMapping(value = "/myOrder")
  public String getOrderItem(OAuth2Authentication authentication, Model model) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    User userWhoOrdered = userService.saveUser(name, userEmail);
   // OrderItem orderItem = new OrderItem(1, bookRepository.findById(id), userWhoOrdered);
   // Order order = new Order(Arrays.asList(orderItem), userWhoOrdered, Order.Status.PROCESSED);
   // orderItemRepository.save(orderItem);
   // orderRepository.save(order);
    model.addAttribute("orderitem", orderItemRepository.findAllByUser(userWhoOrdered.getId()));
    model.addAttribute("name", name);
    model.addAttribute("email", userEmail);
    model.addAttribute("totalCost", orderItemService.totalCost(userWhoOrdered.getId()));
    return "ordered_items";
  }
  @GetMapping(value = "/thankyou")
  public String sayThankyou() {
    return "thankyou";
  }
}
