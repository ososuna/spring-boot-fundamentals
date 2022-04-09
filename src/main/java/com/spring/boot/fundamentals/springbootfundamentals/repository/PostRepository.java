package com.spring.boot.fundamentals.springbootfundamentals.repository;

import com.spring.boot.fundamentals.springbootfundamentals.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
