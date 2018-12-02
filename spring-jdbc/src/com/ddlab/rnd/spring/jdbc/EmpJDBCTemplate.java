package com.ddlab.rnd.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpJDBCTemplate implements IEmpDAO {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Integer id,String name, Integer age) {
		String SQL = "insert into Employees (id, name, age) values (?, ?,?)";
		jdbcTemplateObject.update( SQL, id,name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;
	}

	public Employee read(Integer id) {
		String SQL = "select * from Employees where id = ?";
		Employee emp = jdbcTemplateObject.queryForObject(SQL, 
				new Object[]{id}, new EmpMapper());
		return emp;
	}

	public List<Employee> listEmployees() {
		String SQL = "select * from employees";
		List <Employee> emps = jdbcTemplateObject.query(SQL, 
				new EmpMapper());
		return emps;
	}

	public void delete(Integer id){
		String SQL = "delete from Employees where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
		return;
	}

	public void update(Integer id, Integer age){
		String SQL = "update Employees set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id );
		return;
	}
}