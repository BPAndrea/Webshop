package com.greenfox.webshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

  public Order(List<OrderItem> orderItem, User user, Status status) {
    this.creation = LocalDateTime.now();
    this.orderItem = orderItem;
    this.user = user;
    this.status = status;
  }
}
