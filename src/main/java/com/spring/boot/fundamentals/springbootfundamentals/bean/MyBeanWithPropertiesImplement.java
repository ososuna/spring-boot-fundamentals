package com.spring.boot.fundamentals.springbootfundamentals.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

  private String name;
  private String lastName;

  public MyBeanWithPropertiesImplement(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  @Override
  public String function() {
    return this.lastName + " " + this.name;
  }

}
