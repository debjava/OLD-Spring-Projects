package com.ddlab.rnd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.autowire.Movie;

public class TestMovie {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Movie movie = (Movie) context.getBean("movie1");
		System.out.println("Movie Name : "+movie.getName());
		System.out.println("Star Cast : "+movie.getActor().getName());
		
		movie = (Movie) context.getBean("movie2");
		System.out.println("Movie Name : "+movie.getName());
		System.out.println("Star Cast : "+movie.getActor().getName());
		
		movie = (Movie) context.getBean("movie3");
		System.out.println("Movie Name : "+movie.getName());
		System.out.println("Star Cast : "+movie.getActor().getName());
		
		movie = (Movie) context.getBean("movie4");
		System.out.println("Movie Name : "+movie.getName());
		System.out.println("Star Cast : "+movie.getActor().getName());
		
	}

}
