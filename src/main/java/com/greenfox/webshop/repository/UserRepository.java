package com.greenfox.webshop.repository;

import com.greenfox.webshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  public User findById(long id);
}
