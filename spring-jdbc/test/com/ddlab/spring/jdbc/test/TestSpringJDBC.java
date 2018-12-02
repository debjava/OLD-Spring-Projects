package com.ddlab.spring.jdbc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddlab.rnd.spring.jdbc.EmpJDBCTemplate;
import com.ddlab.rnd.spring.jdbc.Employee;

public class TestSpringJDBC {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");

		EmpJDBCTemplate empJDBCTemplate = (EmpJDBCTemplate) context
				.getBean("empJDBCTemplate");

		System.out.println("------Records Creation--------");
		empJDBCTemplate.create(1, "John Abraham", 41);
		empJDBCTemplate.create(2, "Bipasha Basu", 22);
		empJDBCTemplate.create(3, "Vidya Balan", 35);
		empJDBCTemplate.create(4, "Raghavendra Lawrence", 42);
		empJDBCTemplate.create(5, "Mahesh Babu", 39);
		empJDBCTemplate.create(6, "Darshan Thoogudeep", 37);

		System.out.println("------Listing Multiple Records--------");
		List<Employee> emps = empJDBCTemplate.listEmployees();
		for (Employee record : emps) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}

		System.out.println("----Updating Record with ID = 2 -----");
		empJDBCTemplate.update(2, 32);

		System.out.println("----Listing Record with ID = 2 -----");
		Employee emp = empJDBCTemplate.read(2);
		System.out.print("ID : " + emp.getId());
		System.out.print(", Name : " + emp.getName());
		System.out.println(", Age : " + emp.getAge());

	}

}
