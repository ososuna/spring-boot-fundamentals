package com.spring.boot.fundamentals.springbootfundamentals.configuration;

import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithProperties;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithPropertiesImplement;
import com.spring.boot.fundamentals.springbootfundamentals.pojo.UserPojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

  @Value("${value.name}")
  private String name;
  
  @Value("${value.lastName}")
  private String lastName;
  
  @Value("${value.random}")
  private String random;

  @Bean
  public MyBeanWithProperties function() {
    return new MyBeanWithPropertiesImplement(name, lastName);
  }

}
