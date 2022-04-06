package com.spring.boot.fundamentals.springbootfundamentals.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix="user")
public class UserPojo {

  private String email;
  private String password;
  private int age;

}
