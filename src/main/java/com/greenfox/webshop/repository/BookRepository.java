package com.greenfox.webshop.repository;

import com.greenfox.webshop.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
  List<Book> findAll();
  List<Book> findAllByTitleContainingOrDescriptionContainingOrAuthorContaining(String title, String description, String author);
}
