package com.greenfox.webshop.config;

import com.greenfox.webshop.model.Book;
import com.greenfox.webshop.model.Order;
import com.greenfox.webshop.model.OrderItem;
import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.BookRepository;
import com.greenfox.webshop.repository.OrderItemRepository;
import com.greenfox.webshop.repository.OrderRepository;
import com.greenfox.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SetupInitialData implements CommandLineRunner {
  private BookRepository bookRepository;
  private OrderRepository orderRepository;
  private UserRepository userRepository;
  private OrderItemRepository orderItemRepository;

  private List<Book> books;

  @Autowired
  public SetupInitialData(BookRepository bookRepository, OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository) {
    this.bookRepository = bookRepository;
    this.orderRepository = orderRepository;
    this.userRepository = userRepository;
    this.orderItemRepository = orderItemRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    generateBooks();
    saveBooks();
  }

  private void generateBooks() {
    books = Arrays.asList(
        new Book("Charles Dickens", "Non-fiction", "This is an awesome book.", "https://i.pinimg.com/originals/ff/27/ee/ff27ee5e53478a0fc429583345408797.jpg", 19.9d, 10, "A Tale Of Two Cities"),
        new Book("Charles Dickens", "Non-fiction", "This is an awesome book.", "https://images-na.ssl-images-amazon.com/images/I/41uMgxeWY0L._SX313_BO1,204,203,200_.jpg", 18.9d, 10, "David Copperfield"),
        new Book("Charlotte Bronte", "Non-fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQU5mRUk0pDW0Qi8jqD_ilOYsCjdTBAWPuSFLVwmrWXqOCzkFXf", 25.9d, 10, "Jane Eyre"),
        new Book("Fyodor Dostoyevsky", "Fiction", "This is an awesome book.", "https://s3.amazonaws.com/lowres.cartoonstock.com/caricatures-russians-russian_literature-literary_figures-authors-writers-atan667_low.jpg", 18.5d, 10, "The Brothers Karamazov"),
        new Book("Fyodor Dostoyevsky", "Non-fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR308WPW08cOVZh4Q4pxw_L-ouZyyiOiU-HPiH_-2c70z6Cb6Uy-Q", 20.9d, 10, "Crime and Punishment"),
        new Book("Gabriel Garcia Marquez", "Fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR308WPW08cOVZh4Q4pxw_L-ouZyyiOiU-HPiH_-2c70z6Cb6Uy-Q", 13.9d, 10, "One Hundred Years of Solitude"),
        new Book("George Orwell", "Non-fiction", "This is an awesome book.", "https://i0.wp.com/visitbath.com/wp-content/uploads/2018/09/Animal-Farm.jpg?fit=454%2C624&ssl=1", 27.5d, 10, "Animal Farm"),
        new Book("James Joyce", "Fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx3oO1Tdpp2SE3XFjQeJph3TjHXg22dqvDFnG-9jA6q3aGNzqv", 23, 10, "Ulysses"),
        new Book("James Joyce", "Guide", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx3oO1Tdpp2SE3XFjQeJph3TjHXg22dqvDFnG-9jA6q3aGNzqv", 13.9d, 10, "A Portrait of the Artists as a Young Man"),
        new Book("Lev Tolstoy", "Fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx3oO1Tdpp2SE3XFjQeJph3TjHXg22dqvDFnG-9jA6q3aGNzqv", 12.5, 10, "War and Peace"),
        new Book("Lev Tolstoy", "Non-fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx3oO1Tdpp2SE3XFjQeJph3TjHXg22dqvDFnG-9jA6q3aGNzqv", 14, 10, "Anna Karenina"),
        new Book("Virginia Woolf", "Non-fiction", "This is an awesome book.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx3oO1Tdpp2SE3XFjQeJph3TjHXg22dqvDFnG-9jA6q3aGNzqv", 14.5, 10, "To the Lighthouse"),
        new Book("Virginia Woolf", "Non-fiction", "This is an awesome book.", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.hellogiggles.com%2Fuploads%2F2018%2F03%2F21041247%2Fpuppies.jpg&w=450&c=sc&poi=face&q=85", 15, 10, "Mrs. Dalloway"),
        new Book("Fekete István", "Children", "This is an awesome book.", "http://ocdn.eu/pulscms-transforms/1/xNsktkqTURBXy9kY2RiYmUzZmMxMjE0MjUxMzRjZTI0MjZmYjFkZjdjMS5qcGVnkZMFzQMUzQMU", 16, 10, "Vuk"));
  }

  private void saveBooks() {
    books.forEach(b -> bookRepository.save(b));
  }

  /*User user1 = new User("a", "b");
  OrderItem orderItem1 = new OrderItem(2, bookRepository.findById(1));
  Order order1 = new Order(Arrays.asList(orderItem1), user1, Order.Status.PROCESSED);
  //bookRepository.save(book1);
    orderItemRepository.save(orderItem1);
    userRepository.save(user1);
    orderRepository.save(order1);*/
}


