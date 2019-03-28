package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping({"/","/index"})
  public List<Book> index() {
    return bookService.getAll();
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
