package com.greenfox.webshop.service;

import com.greenfox.webshop.model.User;
import com.greenfox.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  public User getUserById(long id){
    return this.userRepository.findById(id);
  }

  public User saveUser(String name, String email) {
    User userToFind = userRepository.findByEmail(email);
    if(userToFind==null) {
      User userToSave = new User(name, email);
      userRepository.save(userToSave);
      return userToSave;
    }
    return userToFind;
  }
}
