package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Controller
public class BookController {

  private BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/")
  public String index(String keyword, Model model) {
    if (keyword == null) {
      model.addAttribute("books", bookService.getAll());
      return "index";
    } else {
      model.addAttribute("books", bookService.findByTitleDescriptionorAuthor(keyword));
      return "index";
    }
  }

  @GetMapping(value="/in-stock")
  public List<Book> getAviable() {
    return bookService.getAviable();
  }

  @RequestMapping(value = "/sort-by-price-asc")
  public List<Book> getCheapestFirst() {
    return bookService.sortByPrice();
  }
}
