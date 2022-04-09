package com.spring.boot.fundamentals.springbootfundamentals.configuration;

import javax.sql.DataSource;

import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithProperties;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithPropertiesImplement;
import com.spring.boot.fundamentals.springbootfundamentals.pojo.UserPojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

  @Value("${value.name}")
  private String name;
  
  @Value("${value.lastName}")
  private String lastName;
  
  @Value("${value.random}")
  private String random;

  @Value("${jdbc.url}")
  private String jdbcUrl;
  
  @Value("${driver}")
  private String driver;
  
  @Value("${username}")
  private String username;
  
  @Value("${password}")
  private String password;

  @Bean
  public MyBeanWithProperties function() {
    return new MyBeanWithPropertiesImplement(name, lastName);
  }

  @Bean
  public DataSource dataSource() {
    
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    
    dataSourceBuilder.driverClassName(driver);
    dataSourceBuilder.url(jdbcUrl);
    dataSourceBuilder.username(username);
    dataSourceBuilder.password(password );

    return dataSourceBuilder.build();
  }

}
