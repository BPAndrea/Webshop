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
        new Book("Fyodor Dostoyevsky", "Non-fiction", "This is an awesome book.", "https://images-na.ssl-images-amazon.com/images/I/51zZH9paouL._SX310_BO1,204,203,200_.jpg", 20.9d, 10, "Crime and Punishment"),
        new Book("Gabriel Garcia Marquez", "Fiction", "This is an awesome book.", "https://images-na.ssl-images-amazon.com/images/I/91D-NuBThAL.jpg", 13.9d, 10, "One Hundred Years of Solitude"),
        new Book("George Orwell", "Non-fiction", "This is an awesome book.", "https://i0.wp.com/visitbath.com/wp-content/uploads/2018/09/Animal-Farm.jpg?fit=454%2C624&ssl=1", 27.5d, 10, "Animal Farm"),
        new Book("James Joyce", "Fiction", "This is an awesome book.", "http://gorse.ie/wp-content/uploads/2014/06/image18.jpg", 23, 10, "Ulysses"),
        new Book("James Joyce", "Guide", "This is an awesome book.", "https://images.gr-assets.com/books/1387738909l/580717.jpg", 13.9d, 10, "A Portrait of the Artist as a Young Man"),
        new Book("Lev Tolstoy", "Fiction", "This is an awesome book.", "https://images.gr-assets.com/books/1384803290l/18626867.jpg", 12.5, 10, "War and Peace"),
        new Book("Lev Tolstoy", "Non-fiction", "This is an awesome book.", "https://image3.mouthshut.com/images/imagesp/925075358s.jpg", 14, 10, "Anna Karenina"),
        new Book("Virginia Woolf", "Non-fiction", "This is an awesome book.", "https://upload.wikimedia.org/wikipedia/en/thumb/8/8c/ToTheLighthouse.jpg/220px-ToTheLighthouse.jpg", 14.5, 10, "To the Lighthouse"),
        new Book("Virginia Woolf", "Non-fiction", "This is an awesome book.", "https://i.pinimg.com/originals/b2/31/45/b23145dc68680996faad8764d9fb301d.jpg", 15, 10, "Mrs. Dalloway"),
        new Book("Fekete István", "Children", "This is an awesome book.", "http://ocdn.eu/pulscms-transforms/1/xNsktkqTURBXy9kY2RiYmUzZmMxMjE0MjUxMzRjZTI0MjZmYjFkZjdjMS5qcGVnkZMFzQMUzQMU", 16, 10, "Vuk"),
        new Book("Jack Kerouac", "Fiction", "This is an awesome book.", "https://images.gr-assets.com/books/1422377088l/2552.jpg", 15, 10, "On The Road"),
        new Book("John Steinbeck", "Fiction", "This is an awesome book.", "https://upload.wikimedia.org/wikipedia/en/thumb/1/1f/JohnSteinbeck_TheGrapesOfWrath.jpg/200px-JohnSteinbeck_TheGrapesOfWrath.jpg", 22, 10, "The Grapes of Wrath"));
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


