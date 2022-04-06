package com.spring.boot.fundamentals.springbootfundamentals;

import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBean;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithDependency;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithProperties;
import com.spring.boot.fundamentals.springbootfundamentals.components.ComponentDependency;
import com.spring.boot.fundamentals.springbootfundamentals.pojo.UserPojo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFundamentalsApplication implements CommandLineRunner {

	private ComponentDependency 	componentDependency;
	private MyBean 								myBean;
	private MyBeanWithDependency 	myBeanWithDependency;
	private MyBeanWithProperties 	myBeanWithProperties;
	private UserPojo 							userPojo;

	public SpringBootFundamentalsApplication(
		@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
		MyBean myBean,
		MyBeanWithDependency myBeanWithDependency,
		MyBeanWithProperties myBeanWithProperties,
		UserPojo userPojo
	) {
		this.componentDependency 	= componentDependency;
		this.myBean 							= myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo 						= userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		myBeanWithDependency.printWithDependency();
		componentDependency.doSomething();
		myBean.print();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword() + " " + userPojo.getAge());
	}

}
