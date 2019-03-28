package com.greenfox.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Book {
  @Id
  @GeneratedValue
  private long id;
  private String author;
  private String title;
  private String description;
  private String pictureUrl;
  private String category;
  private double price;
  private int quantityOfStock;

  public Book() {
  }

  public Book(String author, String title, String description, String pictureUrl, String category, double price, int quantityOfStock) {
    this.author = author;
    this.title = title;
    this.description = description;
    this.pictureUrl = pictureUrl;
    this.category = category;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantityOfStock() {
    return quantityOfStock;
  }

  public void setQuantityOfStock(int quantityOfStock) {
    this.quantityOfStock = quantityOfStock;
  }
}
