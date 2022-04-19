package com.spring.boot.fundamentals.springbootfundamentals.caseuse;

import com.spring.boot.fundamentals.springbootfundamentals.entity.User;
import com.spring.boot.fundamentals.springbootfundamentals.service.UserService;

import org.springframework.stereotype.Component;

@Component
public class CreateUser {
  
  private final UserService userService;

  public CreateUser(UserService userService) {
    this.userService = userService;
  }

  public User save(User user) {
    return userService.save(user);
  }

}
