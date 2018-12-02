package com.mydomain.spring.transaction.declarative.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mydomain.spring.transaction.TransactionTestService;

/**
 * @author Ross
 */
public class XmlTransactionTest {
	private final static Log log = LogFactory.getLog(XmlTransactionTest.class);

	public static void main(String[] args) {
		log.info("-- Starting Spring Declarative XML Example --");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/com/mydomain/spring/transaction/declarative/xml/xml-test.xml");
		TransactionTestService transactionTestService = (TransactionTestService)ctx.getBean("transactionTestService");
		
		transactionTestService.readOnlyCommitExampleTransaction();
		
		try {
			transactionTestService.readOnlyRollbackExampleTransaction();
		} catch (RuntimeException re) {
			log.info("-- Expected exception: " + re.getMessage());
		}	
		
		transactionTestService.readWriteCommitExampleTransaction();
		
		try {
			transactionTestService.readWriteRollbackExampleTransaction();
		} catch (RuntimeException re) {
			log.info("-- Expected exception: " + re.getMessage());
		}	
	}
}
