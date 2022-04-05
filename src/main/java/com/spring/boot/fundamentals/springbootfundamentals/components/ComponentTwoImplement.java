package com.spring.boot.fundamentals.springbootfundamentals.components;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {
  
  @Override
  public void doSomething() {
    System.out.println("ComponentTwoImplement.doSomething()");
  }

}
