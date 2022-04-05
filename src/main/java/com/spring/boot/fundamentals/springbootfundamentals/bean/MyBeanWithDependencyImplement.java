package com.spring.boot.fundamentals.springbootfundamentals.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
  
  MyOperation myOperation;

  public MyBeanWithDependencyImplement(MyOperation myOperation) {
    this.myOperation = myOperation;
  }

  @Override
  public void printWithDependency() {
    System.out.println(myOperation.sum(5));
    System.out.println("MyBeanWithDependencyImplement");
  }

}
