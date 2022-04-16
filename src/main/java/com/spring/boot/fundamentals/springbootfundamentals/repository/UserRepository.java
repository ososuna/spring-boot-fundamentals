package com.spring.boot.fundamentals.springbootfundamentals.repository;

import java.time.LocalDate;
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

  List<User> findByName(String name);
  
  Optional<User> findByNameAndEmail(String name, String email);

  List<User> findByNameLike(String name);

  List<User> findByNameOrEmail(String name, String email);

  List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

  List<User> findByNameContainingOrderByIdAsc(String name);

}
