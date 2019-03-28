/*package com.greenfox.webshop.config;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seed implements CommandLineRunner {
  @Autowired
  private BookRepository bookRepository;

  @Override
  public void run(String... args) throws Exception {
    Book book1 = new Book("Vuk", "Fekete István", "some picture", 2.3);
    Book book2 = new Book("Vuk2", "Nagy István", "some picture2", 8.3);
    Book book3 = new Book("harmadik", "xy", "some picture2", 1.3);
    Book book4 = new Book("negyedik", "xy", "some picture2", 0.3, 0);
    bookRepository.save(book1);
    bookRepository.save(book2);
    bookRepository.save(book3);
    bookRepository.save(book4);

  }


}
*/
