package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.service.BookService;
import com.greenfox.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Controller
public class BookController {

  private BookService bookService;
  private UserService userService;

  @Autowired
  public BookController(BookService bookService, UserService userService) {
    this.bookService = bookService;
    this.userService = userService;
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
}
