package com.greenfox.webshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
  @Id
  @GeneratedValue
  private long id;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime creation;
  @OneToMany
  private List<OrderItem> orderItem;
  @ManyToOne
  private User user;
  public enum Status {
    PROCESSED,
    SHIPPED
  }
  private Status status;
  private double price;

  public Order() {
  }

  public Order(List<OrderItem> orderItem, User user, Status status) {
    this.creation = LocalDateTime.now();
    this.orderItem = orderItem;
    this.user = user;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDateTime getCreation() {
    return creation;
  }

  public void setCreation(LocalDateTime creation) {
    this.creation = creation;
  }

  public List<OrderItem> getOrderItem() {
    return orderItem;
  }

  public void setOrderItem(List<OrderItem> orderItem) {
    this.orderItem = orderItem;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
