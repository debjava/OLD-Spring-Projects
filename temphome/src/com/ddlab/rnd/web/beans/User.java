package com.ddlab.rnd.web.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType( XmlAccessType.FIELD )
public class User {
	
	@XmlElement( name="FirstName") private String firstName;
	@XmlElement( name="LastName") private String lastName;
	@XmlElement( name="Password") private String password;
	@XmlElement( name="EmpId") private String empId;
	
	public User() {
		
	}
	
	public User( String firstName,String lastName,String password,String empId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.empId = empId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", empId=" + empId + "]";
	}
	
//	public static void main(String[] args) {
//		
//		User user = new User();
//		user.setEmpId("11");
//		user.setFirstName("Deba");
//		user.setLastName("Mishra");
//		user.setPassword("aaa");
//		System.out.println(user.toString());
//		
//	}
	
}
