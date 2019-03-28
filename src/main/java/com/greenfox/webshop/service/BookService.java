package com.greenfox.webshop.service;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  public List<Book> getAll(){
    return bookRepository.findAll();
  }

  public List<Book> getAviable(){
    return bookRepository.findAll()
       .stream()
       .filter(onStock -> onStock.getQuantityOfStock() > 0)
      .collect(Collectors.toList());
  }
}
