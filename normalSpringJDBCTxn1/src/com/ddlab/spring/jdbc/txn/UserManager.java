package com.ddlab.spring.jdbc.txn;

import java.util.List;

public interface UserManager {

	void insertUser(User user);
	
	User getUser(String username);
	
	List<User> getUsers();
}
