package com.spring.boot.fundamentals.springbootfundamentals.configuration;

import com.spring.boot.fundamentals.springbootfundamentals.caseuse.GetUser;
import com.spring.boot.fundamentals.springbootfundamentals.caseuse.GetUserImplement;
import com.spring.boot.fundamentals.springbootfundamentals.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
  
  @Bean
  GetUser getuser(UserService userService) {
    return new GetUserImplement(userService);
  }

}
