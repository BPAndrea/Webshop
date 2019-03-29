package com.greenfox.webshop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class OrderItem {
  @Id
  @GeneratedValue
  private long id;
  private int quantity;
  @OneToOne
  private Book book;
  @ManyToOne
  private Order order;
  @OneToOne
  private User user;

  public OrderItem() {
  }

  public OrderItem(int quantity, Book book) {
    this.quantity = quantity;
    this.book = book;
  }

  public OrderItem(int quantity, Book book, Order order) {
    this.quantity = quantity;
    this.book = book;
    this.order = order;
  }

  public OrderItem(int quantity, Book book, User user) {
    this.quantity = quantity;
    this.book = book;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
