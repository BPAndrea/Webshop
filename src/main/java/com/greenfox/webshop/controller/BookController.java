package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping("/index")
  public String index(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
    if (keyword == null) {
      model.addAttribute("books", bookService.getAll());
      return "index";
    } else {
      model.addAttribute("books", bookService.findByTitleDescriptionorAuthor(keyword))
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
