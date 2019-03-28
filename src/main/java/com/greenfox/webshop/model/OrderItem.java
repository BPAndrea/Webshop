package com.greenfox.webshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {
  @Id
  @GeneratedValue
  private long id;
  private int quantity;
  @OneToOne
  private Book book;
  @ManyToOne
  private Order order;

  public OrderItem(int quantity, Book book) {
    this.quantity = quantity;
    this.book = book;
  }
}
