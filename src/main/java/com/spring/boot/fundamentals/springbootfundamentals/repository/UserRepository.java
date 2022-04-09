package com.spring.boot.fundamentals.springbootfundamentals.repository;

import java.util.List;
import java.util.Optional;

import com.spring.boot.fundamentals.springbootfundamentals.entity.User;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u from User u where u.email = ?1")
  Optional<User> findByUserEmail(String email);

  @Query("select u from User u where u.name like ?1%")
  List<User> findByNameAndSort(String name, Sort sort);

}
