package com.iit.test.spring.web;

import java.util.concurrent.locks.Lock;

import com.ddlab.rnd.util.Util;
import com.ddlab.rnd.util.XMLUtil;
import com.ddlab.rnd.web.beans.User;

public class RegistrationThread implements Runnable {

//	private Lock lock = null;
	String firstName = null;
	String lastName = null;
	String empId = null;
	String pwd = null;
	private User user = null;
	private Util util = new Util();
	
	
	public RegistrationThread( User user) {
		this.user = user;
	}

	@Override
	public void run() {
		try {
//			util.saveUserDetails(user);
			util.saveUserDetailsFaulty(user);
//			
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
//		finally {
//			lock.unlock();
//		}
	}
}
