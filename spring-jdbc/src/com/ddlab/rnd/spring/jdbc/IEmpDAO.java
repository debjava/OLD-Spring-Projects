package com.ddlab.rnd.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

public interface IEmpDAO {
	
	public void setDataSource(DataSource ds);
	   
	   public void create(Integer id,String name, Integer age);
	   
	   public Employee read(Integer id);
	   
	   public void update(Integer id, Integer age);
	   
	   public void delete(Integer id);
	  
	   public List<Employee> listEmployees();
	   
}
