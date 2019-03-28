package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.UserRepository;
import com.greenfox.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class AuthController {
  @Autowired
  private UserService userService;


  @RequestMapping(value = "/userfull")
  public Principal user(Principal principal) {
    return principal;
  }


  @RequestMapping("/user")
  public List<String> user(OAuth2Authentication authentication) {
    LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
    List<String> details = new ArrayList<>();
    String userEmail = properties.get("email").toString();
    String name = properties.get("name").toString();
    User userToSave = new User(name, userEmail);
    userService.saveUser(name,userEmail);
    details.add(userEmail);
    details.add(name);
    return details;
  }
}