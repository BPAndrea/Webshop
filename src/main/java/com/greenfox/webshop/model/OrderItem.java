package com.greenfox.webshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class OrderItem {
  @Id
  @GeneratedValue
  private long id;
  int quantity;
  Book book;
}
