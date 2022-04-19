package com.spring.boot.fundamentals.springbootfundamentals.caseuse;

import java.util.List;

import com.spring.boot.fundamentals.springbootfundamentals.entity.User;
import com.spring.boot.fundamentals.springbootfundamentals.service.UserService;

public class GetUserImplement implements GetUser {
  
  private final UserService userService;

  public GetUserImplement(UserService userService) {
    this.userService = userService;
  }

  @Override
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

}
