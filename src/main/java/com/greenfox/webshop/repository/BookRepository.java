package com.greenfox.webshop.repository;

import com.greenfox.webshop.model.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
  List<Book> findAll();
  List<Book> findAllByTitleContainingOrDescriptionContainingOrAuthorContaining(String title, String description, String author);
  Book findById(long id);
}
