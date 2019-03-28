package com.greenfox.webshop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Order {
  @Id
  @GeneratedValue
  private long id;
  @OneToMany
  OrderItem orderItem;
}
