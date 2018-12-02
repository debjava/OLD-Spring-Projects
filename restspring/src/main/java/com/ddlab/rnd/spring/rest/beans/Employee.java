package com.ddlab.rnd.spring.rest.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@XmlRootElement
@JsonRootName(value="Emp")
public class Employee {
	
	@JsonProperty(value="Id") private String id;
	@JsonProperty(value="Name") private String name;
	@JsonProperty(value="Adrs") private Address adrs;
	@JsonProperty(value="Account") private Account act;
	
	public Employee( String id )
	{
		this.id = id;
	}
	
	public Employee()
	{
		
	}
	
	@XmlElement
	public Address getAdrs() {
		return adrs;
	}
	public void setAdrs(Address adrs) {
		this.adrs = adrs;
	}
	@XmlElement
	public Account getAct() {
		return act;
	}
	public void setAct(Account act) {
		this.act = act;
	}
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", adrs=" + adrs
				+ ", act=" + act + "]";
	}
}
