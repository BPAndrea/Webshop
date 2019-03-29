
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


  @RequestMapping(value = "/user")
  public Principal user(Principal principal) {
    return principal;
  }
}
