package com.spring.boot.fundamentals.springbootfundamentals.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {
  
  Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
  
  MyOperation myOperation;

  public MyBeanWithDependencyImplement(MyOperation myOperation) {
    this.myOperation = myOperation;
  }

  @Override
  public void printWithDependency() {
    LOGGER.info("print with dependency method");
    int number = 5;
    LOGGER.debug("the number sent as parameter of dependency operation is: " + number);
    System.out.println(myOperation.sum(number));
    System.out.println("MyBeanWithDependencyImplement");
  }

}
