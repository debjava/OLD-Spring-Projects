package com.ddlab.rnd.spring.rest.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ddlab.rnd.spring.rest.beans.Employee;
import com.ddlab.rnd.spring.rest.beans.StatusBean;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	private List<Employee> empList = new ArrayList<Employee>();

	@RequestMapping(value = "ID/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object getEmp( @PathVariable String id )
	{
		Object obj = null;
		Employee emp = new Employee(id);

		if( empList.contains(emp))
		{
			for( Employee emp1 : empList )
			{
				if( emp.equals(emp1))
				{
					obj = emp1;
					break;
				}
			}
		}
		else
		{
			StatusBean statusBean = new StatusBean();
			statusBean.setErrCode("002");
			statusBean.setErrMsg("Employee with this id "+id+" does not exist");
			obj = statusBean;
		}

		return obj;
	}

	@RequestMapping(value = "ID", method = RequestMethod.GET)
	@ResponseBody
	public Object getEmp1( @RequestParam("id") String id )
	{
		/*Request will be like this
		 * http://localhost:8080/restspring/emp/ID?id=Id123
		 */
		System.out.println("------- Invoking method getEmp1 with @RequestParam as parameter ------");
		Object obj = null;
		Employee emp = new Employee(id);

		if( empList.contains(emp))
		{
			for( Employee emp1 : empList )
			{
				if( emp.equals(emp1))
				{
					obj = emp1;
					break;
				}
			}
		}
		else
		{
			StatusBean statusBean = new StatusBean();
			statusBean.setErrCode("002");
			statusBean.setErrMsg("Employee with this id "+id+" does not exist");
			obj = statusBean;
		}

		return obj;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public StatusBean create( @RequestBody Employee emp ) {
		StatusBean statusBean = new StatusBean();
		if( empList.contains(emp) )
		{
			statusBean.setErrCode("001");
			statusBean.setErrMsg("Employee with this id "+emp.getId()+" already exists");
		}
		else
		{
			empList.add(emp);
			statusBean.setStatus("Success");
		}

		display();
		return statusBean;
	}

	@RequestMapping(value = "create1", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public StatusBean create1( @RequestBody Employee emp ) {
		/*
		 * Get all the request header information
		 * Request will be http://localhost:8080/restspring/emp/create1
		 */
		System.out.println("-------- Inside Method create1 with no HttpServletRequest Object -------");
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		Enumeration en = request.getHeaderNames();
		while( en.hasMoreElements() ) {
			Object obj = en.nextElement();
			System.out.println("Header Name : "+obj);
			System.out.println("Header Value : "+request.getHeader((String)obj));
		}

		StatusBean statusBean = new StatusBean();
		if( empList.contains(emp) )
		{
			statusBean.setErrCode("001");
			statusBean.setErrMsg("Employee with this id "+emp.getId()+" already exists");
		}
		else
		{
			empList.add(emp);
			statusBean.setStatus("Success");
		}
		return statusBean;
	}

	@RequestMapping(value = "create2", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public StatusBean create2( @RequestBody Employee emp , HttpServletRequest request) {
		/*
		 * Get all the request header information
		 * Request will be http://localhost:8080/restspring/emp/create2
		 */
		System.out.println("-------- Inside Method create2 with HttpServletRequest Object as method parameter -------");
		Enumeration en = request.getHeaderNames();
		while( en.hasMoreElements() ) {
			Object obj = en.nextElement();
			System.out.println("Header Name : "+obj);
			System.out.println("Header Value : "+request.getHeader((String)obj));
		}

		StatusBean statusBean = new StatusBean();
		if( empList.contains(emp) )
		{
			statusBean.setErrCode("001");
			statusBean.setErrMsg("Employee with this id "+emp.getId()+" already exists");
		}
		else
		{
			empList.add(emp);
			statusBean.setStatus("Success");
		}
		return statusBean;
	}

	@RequestMapping(value = "create3", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public StatusBean create3( @RequestBody Employee emp , HttpServletRequest request , HttpServletResponse response ) {
		/*
		 * Get all the request header information
		 * Request will be http://localhost:8080/restspring/emp/create3
		 */
		System.out.println("-------- Inside Method create3 with HttpServletResponse Object as method parameter -------");
		System.out.println("Response Object : "+response);
		Enumeration en = request.getHeaderNames();
		while( en.hasMoreElements() ) {
			Object obj = en.nextElement();
			System.out.println("Header Name : "+obj);
			System.out.println("Header Value : "+request.getHeader((String)obj));
		}

		StatusBean statusBean = new StatusBean();
		if( empList.contains(emp) )
		{
			statusBean.setErrCode("001");
			statusBean.setErrMsg("Employee with this id "+emp.getId()+" already exists");
		}
		else
		{
			empList.add(emp);
			statusBean.setStatus("Success");
		}

		try {
			//Send a response error message
			response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,"This service is not available for you");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return statusBean;
	}


	@RequestMapping(value = "update", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public StatusBean update( @RequestBody Employee emp ) {
		StatusBean statusBean = new StatusBean();

		if( empList.contains(emp))
		{
			for( Employee emp1 : empList )
			{
				if( emp.equals(emp1))
				{
					empList.remove(emp1);
					empList.add(emp);
					statusBean.setStatus("Success");
					break;
				}
			}
		}
		else
		{
			statusBean.setErrCode("002");
			statusBean.setErrMsg("Employee with this id "+emp.getId()+" does not exist");
		}
		return statusBean;
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public StatusBean delete( @RequestBody Employee emp ) {
		StatusBean statusBean = new StatusBean();

		if( empList.contains(emp))
		{
			for( Employee emp1 : empList )
			{
				if( emp.equals(emp1))
				{
					empList.remove(emp1);
					statusBean.setStatus("Success");
					break;
				}
			}
		}
		else
		{
			statusBean.setErrCode("003");
			statusBean.setErrMsg("Employee with this id "+emp.getId()+" does not exist, hence data can not be deleted");
		}
		return statusBean;
	}

	public void display()
	{
		for( Employee emps : empList )
			System.out.println(emps);
		System.out.println("---------------------------------****************-----------------------------------");
	}

}
