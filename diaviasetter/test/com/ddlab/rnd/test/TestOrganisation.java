package com.ddlab.rnd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.di.setter.Organisation;

public class TestOrganisation {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Organisation org = (Organisation) context.getBean("org");
		
		System.out.println(org.getAdrs());
		System.out.println(org.getTurnOver());
	}

}
