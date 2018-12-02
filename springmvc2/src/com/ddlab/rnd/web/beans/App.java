package com.ddlab.rnd.web.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name="App" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType(propOrder={"name","users"})
public class App {
	
	@XmlElement(name="Name") private String name;
	@XmlElement(name="Users") private Users users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

}
