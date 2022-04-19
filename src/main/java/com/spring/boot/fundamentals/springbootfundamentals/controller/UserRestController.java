package com.spring.boot.fundamentals.springbootfundamentals.controller;

import java.util.List;

import com.spring.boot.fundamentals.springbootfundamentals.caseuse.GetUser;
import com.spring.boot.fundamentals.springbootfundamentals.entity.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {

  private GetUser getUser;

  public UserRestController(GetUser getUser) {
    this.getUser = getUser;
  }

  @GetMapping("/")
  List<User> get() {
    return getUser.getAllUsers();
  }

}
