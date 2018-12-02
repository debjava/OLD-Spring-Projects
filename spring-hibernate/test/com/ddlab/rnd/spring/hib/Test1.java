package com.ddlab.rnd.spring.hib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserDao dao=(UserDao)context.getBean("userDao");
		User user = new User();
		user.setId(3);
		user.setFirstName("John2");
		user.setLastName("Abraham2");
		user.setPassword("mypassword");
		dao.saveEmployee(user);
		System.out.println("User information saved successfully");
	}

}
