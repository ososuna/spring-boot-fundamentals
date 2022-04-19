package com.spring.boot.fundamentals.springbootfundamentals.caseuse;

import com.spring.boot.fundamentals.springbootfundamentals.entity.User;
import com.spring.boot.fundamentals.springbootfundamentals.service.UserService;

import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
  
  private final UserService userService;

  public UpdateUser(UserService userService) {
    this.userService = userService;
  }

  public User update(Long id, User user) {
    return userService.update(id, user);
  }

}
