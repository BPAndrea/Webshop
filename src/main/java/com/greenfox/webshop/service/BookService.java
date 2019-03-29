package com.greenfox.webshop.service;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
  @Autowired
  private BookRepository bookRepository;

  //Pageable pageRequest = PageRequest.of(1, 8);

  public List<Book> getAll(){
    return bookRepository.findAll();
  }

  public List<Book> getNthPage(int pageNumber){
    return bookRepository.findAll(PageRequest.of(pageNumber,8)).getContent();
  }

  public List<Book> getAviable(){
    return bookRepository.findAll()
       .stream()
       .filter(onStock -> onStock.getQuantityOfStock() > 0)
      .collect(Collectors.toList());
  }

  public List<Book> findByTitleDescriptionorAuthor(String keyword){
    return bookRepository.findAllByTitleContainingOrDescriptionContainingOrAuthorContaining(keyword, keyword, keyword);
  }

  public List<Book> sortByPrice() {
    return bookRepository.findAll()
        .stream()
        .filter(onStock -> onStock.getQuantityOfStock() > 0)
        .sorted(Comparator.comparing(Book::getPrice))
        .collect(Collectors.toList());
  }
}
