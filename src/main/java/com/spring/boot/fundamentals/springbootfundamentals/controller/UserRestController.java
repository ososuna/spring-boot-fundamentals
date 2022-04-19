package com.spring.boot.fundamentals.springbootfundamentals.controller;

import java.util.List;

import com.spring.boot.fundamentals.springbootfundamentals.caseuse.CreateUser;
import com.spring.boot.fundamentals.springbootfundamentals.caseuse.DeleteUser;
import com.spring.boot.fundamentals.springbootfundamentals.caseuse.GetUser;
import com.spring.boot.fundamentals.springbootfundamentals.caseuse.UpdateUser;
import com.spring.boot.fundamentals.springbootfundamentals.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserRestController {

  private GetUser     getUser;
  private CreateUser  createUser;
  private DeleteUser  deleteUser;
  private UpdateUser  updateUser;

  public UserRestController(
    GetUser     getUser,
    CreateUser  createUser,
    DeleteUser  deleteUser,
    UpdateUser  updateUser
  ) {
    this.getUser    = getUser;
    this.createUser = createUser;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
  }

  @GetMapping("/")
  List<User> get() {
    return getUser.getAllUsers();
  }

  @PostMapping("/")
  ResponseEntity<User> createUser(@RequestBody User user) {
    return new ResponseEntity<>(createUser.save(user), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  ResponseEntity deleteUser(@PathVariable Long id) {
    deleteUser.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  @PutMapping("/{id}")
  ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    return new ResponseEntity<>(updateUser.update(id, user), HttpStatus.OK);
  }

}
