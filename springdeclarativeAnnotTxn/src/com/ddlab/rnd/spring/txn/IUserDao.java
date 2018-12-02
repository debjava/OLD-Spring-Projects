package com.ddlab.rnd.spring.txn;

public interface IUserDao {

	public int insertUser(User user);

	public int updateUser(User user) throws Exception;

	public void deleteUser(int uid);

	public User selectUser(int uid);
}
