package com.ddlab.rnd.spring.txn;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotationTransactions {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("annotationTransactionContext.xml");
		IUserDao dao = applicationContext.getBean("userDao", IUserDao.class);
		User user= new User(generateId(), "deb"+generateId(), "passowrd", "false");
		dao.insertUser(user);
		dao.deleteUser(2);
		
		/*throws a checked Exception that is not automatically rolled back.Contrary to this is the RuntimeException
		which are automatically rolled back. See next try catch block. We can controll the default roll back behaviour by setting properties in xml
		SEE txAdviceWithRollBackSettings bean and txAdvice bean definations*/
		try{
			dao.updateUser(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			/*throws a runtime exception which will be automatically rolled back
			 * We can controll the default roll back behaviour by setting properties in xml. 
			 * SEE txAdviceWithRollBackSettings bean  and txAdvice bean definations*/
			dao.selectUser(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private static int generateId(){
		return new Random().nextInt(500);
	}
}
