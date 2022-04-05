package com.spring.boot.fundamentals.springbootfundamentals.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency  {
  
  @Override
  public void doSomething() {
    System.out.println("ComponentImplement.doSomething()");
  }
  
}
