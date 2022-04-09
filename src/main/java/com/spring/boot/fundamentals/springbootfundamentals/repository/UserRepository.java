package com.spring.boot.fundamentals.springbootfundamentals.repository;

import com.spring.boot.fundamentals.springbootfundamentals.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
