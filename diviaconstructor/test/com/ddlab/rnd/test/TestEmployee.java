package com.ddlab.rnd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.di.constructor.Employee;

public class TestEmployee {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee) context.getBean("emp");
		
		System.out.println("Employee Id : "+emp.getId());
		System.out.println("Employee Name : "+emp.getName());
	}

}
