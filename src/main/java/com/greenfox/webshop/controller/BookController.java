package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping("/index")
  public List<Book> index() {
    return bookService.getAll();
  }

  @RequestMapping(value="/in-stock")
  public List<Book>  getAviable() {
    return bookService.getAviable();
  }

}
