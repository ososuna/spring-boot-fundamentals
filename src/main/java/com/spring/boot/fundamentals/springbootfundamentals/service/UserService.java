package com.spring.boot.fundamentals.springbootfundamentals.service;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.boot.fundamentals.springbootfundamentals.entity.User;
import com.spring.boot.fundamentals.springbootfundamentals.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  private final Log LOG = LogFactory.getLog(UserService.class);

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void saveTransactional(List<User> users) {
    users.stream()
      .peek(user -> LOG.info("saving user: " + user))
      .forEach(userRepository::save);
  }

  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll(Sort.by("id"));
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  public User update(Long id, User user) {
    return userRepository.findById(id)
      .map(
        existingUser -> {
          existingUser.setName(user.getName());
          existingUser.setEmail(user.getEmail());
          existingUser.setBirthDate(user.getBirthDate());
          return userRepository.save(existingUser);
        }
      ).orElseThrow(() -> new RuntimeException("user not found"));
  }

}
