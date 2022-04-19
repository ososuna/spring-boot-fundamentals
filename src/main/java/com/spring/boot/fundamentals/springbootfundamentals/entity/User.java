package com.spring.boot.fundamentals.springbootfundamentals.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor  
@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class User {
  
  @Id
  @GeneratedValue
  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @Column(length=50)
  private String name;
  
  @Column(length=50, unique=true)
  private String email;
  
  @Column(name="birthDate")
  private LocalDate birthDate;

  @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  private List<Post> posts;
  
}
