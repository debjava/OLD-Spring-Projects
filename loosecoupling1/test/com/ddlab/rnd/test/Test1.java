package com.ddlab.rnd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.core.IState;
import com.ddlab.rnd.core.Information;

public class Test1 {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml"); 
		IState state = (IState) context.getBean("state");
		Information info = state.getInformation();
		System.out.println("Cultural info : "+info.getCulture().getCulturalInfo());
		System.out.println("Language : "+info.getLanguage().getName());
	}

}
