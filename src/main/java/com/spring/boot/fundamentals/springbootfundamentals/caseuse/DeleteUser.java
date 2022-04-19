package com.spring.boot.fundamentals.springbootfundamentals.caseuse;

import com.spring.boot.fundamentals.springbootfundamentals.service.UserService;

import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
  
  private final UserService userService;

  public DeleteUser(UserService userService) {
    this.userService = userService;
  }

  public void delete(Long id) {
    userService.delete(id);
  }

}
