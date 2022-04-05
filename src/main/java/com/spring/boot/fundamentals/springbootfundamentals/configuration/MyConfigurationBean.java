package com.spring.boot.fundamentals.springbootfundamentals.configuration;

import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBean;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanTwoImplement;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithDependency;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithDependencyImplement;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyOperation;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyOperationImplement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
  
  @Bean
  public MyBean beanOperation() {
    return new MyBeanTwoImplement();
  }
  
  @Bean
  public MyOperation beanOperationOperation() {
    return new MyOperationImplement();
  }
  
  @Bean
  public MyBeanWithDependency beanOperationWithDependency(MyOperation myOperation) {
    return new MyBeanWithDependencyImplement(myOperation);
  }

}
