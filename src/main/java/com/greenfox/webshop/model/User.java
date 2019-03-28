package com.greenfox.webshop.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String email;
  @OneToMany
  private List<Order> order;

  public User() {
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Order> getOrder() {
    return order;
  }

  public void setOrder(List<Order> order) {
    this.order = order;
  }
}



