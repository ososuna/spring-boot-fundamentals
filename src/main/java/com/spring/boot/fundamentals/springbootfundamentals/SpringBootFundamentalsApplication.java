package com.spring.boot.fundamentals.springbootfundamentals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBean;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithDependency;
import com.spring.boot.fundamentals.springbootfundamentals.bean.MyBeanWithProperties;
import com.spring.boot.fundamentals.springbootfundamentals.components.ComponentDependency;
import com.spring.boot.fundamentals.springbootfundamentals.entity.User;
import com.spring.boot.fundamentals.springbootfundamentals.pojo.UserPojo;
import com.spring.boot.fundamentals.springbootfundamentals.repository.UserRepository;
import com.spring.boot.fundamentals.springbootfundamentals.service.UserService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SpringBootFundamentalsApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(SpringBootFundamentalsApplication.class);

	private ComponentDependency 	componentDependency;
	private MyBean 								myBean;
	private MyBeanWithDependency 	myBeanWithDependency;
	private MyBeanWithProperties 	myBeanWithProperties;
	private UserPojo 							userPojo;
	private UserRepository 				userRepository;
	private UserService 					userService;

	public SpringBootFundamentalsApplication(
		@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
		MyBean myBean,
		MyBeanWithDependency myBeanWithDependency,
		MyBeanWithProperties myBeanWithProperties,
		UserPojo userPojo,
		UserRepository userRepository,
		UserService userService
	) {
		this.componentDependency 	= componentDependency;
		this.myBean 							= myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo 						= userPojo;
		this.userRepository 			= userRepository;
		this.userService 					= userService;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		examplesPrev();
		saveUsersInDB();
		// getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional() {
		
		User test1 = new User();
		test1.setName("test transactional 1");
		test1.setEmail("test1@test.com");
		test1.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User test2 = new User();
		test2.setName("test transactional 2");
		test2.setEmail("test2@test.com");
		test2.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User test3 = new User();
		test3.setName("test transactional 3");
		test3.setEmail("test2@test.com");
		test3.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User test4 = new User();
		test4.setName("test transactional 4");
		test4.setEmail("test4@test.com");
		test4.setBirthDate(LocalDate.of(1990, 1, 1));


		List<User> users = Arrays.asList(test1, test2, test3, test4);

		try {
			userService.saveTransactional(users);
		} catch (Exception e) {
			LOGGER.error("transactional method error", e);
		}

		userService.getAllUsers()
			.stream()
			.forEach(user -> LOGGER.info("user with get all users" + user.toString()));

	}

	private void getInformationJpqlFromUser() {
		
		LOGGER.info(
			"user found: " +
			userRepository.findByUserEmail("rengoku@test.com")
			.orElseThrow(() -> new RuntimeException("user not found"))
		);

		userRepository.findByNameAndSort("tomioka", Sort.by("id").descending())
			.stream()
			.forEach(user -> LOGGER.info("user with sort method " + user));

		userRepository.findByName("mitsuri")
			.stream()
			.forEach(user -> LOGGER.info("user with name query  method " + user));

		LOGGER.info(
			"user with email and name query method: " +
			userRepository.findByNameAndEmail("iguro", "iguro@test.com")
			.orElseThrow(() -> new RuntimeException("user not found"))
		);

		userRepository.findByNameLike("%t%")
			.stream()
			.forEach(user -> LOGGER.info("user with name like query method " + user));
		
		userRepository.findByNameOrEmail("mitsuri", null)
			.stream()
			.forEach(user -> LOGGER.info("user with name or email query method " + user));
		
		userRepository.findByBirthDateBetween(
			LocalDate.of(1980, 12, 1),
			LocalDate.of(1990, 2, 1)
		)
			.stream()
			.forEach(user -> LOGGER.info("user with birth date between query method " + user));

		userRepository.findByNameContainingOrderByIdAsc("tomioka")
			.stream()
			.forEach(user -> LOGGER.info("user with name like and order by query method " + user));

		userRepository.getAllByBirthDateAndEmail(
			LocalDate.of(1990, 1, 1),
			"rengoku@test.com"
		)
			.stream()
			.forEach(user -> LOGGER.info("user with birth date and email query method " + user));

	}

	public void saveUsersInDB() {
		
		User user1 = new User();
		user1.setName("mitsuri");
		user1.setEmail("mitsuri@test.com");
		user1.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User user2 = new User();
		user2.setName("rengoku");
		user2.setEmail("rengoku@test.com");
		user2.setBirthDate(LocalDate.of(1990, 1, 1));

		User user3 = new User();
		user3.setName("iguro");
		user3.setEmail("iguro@test.com");
		user3.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User user4 = new User();
		user4.setName("tokito");
		user4.setEmail("tokito@test.com");
		user4.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User user5 = new User();
		user5.setName("shinobu");
		user5.setEmail("shinobu@test.com");
		user5.setBirthDate(LocalDate.of(1990, 1, 1));
		
		User user6 = new User();
		user6.setName("tomioka");
		user6.setEmail("tomioka@test.com");
		user6.setBirthDate(LocalDate.of(1990, 1, 1));

		User user7 = new User();
		user7.setName("tomioka2");
		user7.setEmail("tomioka2@test.com");
		user7.setBirthDate(LocalDate.of(1990, 1, 1));

		List<User> list = Arrays.asList(
			user1,
			user2,
			user3,
			user4,
			user5,
			user6,
			user7
		);

		list.stream().forEach(userRepository::save);

	}

	private void examplesPrev() {
		myBeanWithDependency.printWithDependency();
		componentDependency.doSomething();
		myBean.print();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword() + " " + userPojo.getAge());
		try {
			int value = 10/0;
			LOGGER.debug("value is: " + value);
		} catch (Exception e) {
			LOGGER.error("error at divide by zero", e);
		}
	}

}
 