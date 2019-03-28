package com.greenfox.webshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

  @GetMapping(value = "/")
  public String index() {
    return "Hello webshop!";
  }
}
