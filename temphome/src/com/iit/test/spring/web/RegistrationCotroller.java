package com.iit.test.spring.web;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ddlab.rnd.util.Util;
import com.ddlab.rnd.web.beans.User;

public class RegistrationCotroller extends AbstractController 
{
//	private Lock lock = new ReentrantLock(true);
//	private ExecutorService executor = Executors.newFixedThreadPool(1);
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String empId = request.getParameter("empId");
		String pwd = request.getParameter("pwd");
		System.out.println("__________________________________________________________");
		System.out.println("First Name ---------->"+firstName);
		System.out.println("Last Name ---------->"+lastName);
		System.out.println("Emp Id ---------->"+empId);
		
		//With Multi threading with protection
//		try {
//			User user1 = new User(firstName,lastName,pwd,empId);
//			RegistrationThread rt = new RegistrationThread(user1);
//			Thread th = new Thread(rt);
//			th.start();
//		}
//		finally {
//			
//		}
		
		
		
		//With Multi threading without protection
//		try {
//			User user1 = new User(firstName,lastName,pwd,empId);
//			RegistrationThread rt = new RegistrationThread(user1);
//			Thread th = new Thread(rt);
//			th.start();
//		}
//		finally {
//			
//		}
		
		
//		Without threading
		User user1 = new User(firstName,lastName,pwd,empId);
		new Util().saveUserDetailsFaulty(user1);
		
		
		
		return new ModelAndView("/WEB-INF/pages/successfullregistration.jsp");
	}
}
