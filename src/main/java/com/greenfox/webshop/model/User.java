package com.greenfox.webshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String email;
 // @OneToMany
  //private List<Order> order;


  public User() {
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }
}