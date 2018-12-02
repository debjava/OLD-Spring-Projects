package com.ddlab.rnd.spring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ddlab.rnd.util.XMLUtil;
import com.ddlab.rnd.web.beans.User;

public class RegistrationCotroller extends AbstractController 
{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String empId = request.getParameter("empId");
		String pwd = request.getParameter("pwd");
		User user1 = new User();
		user1.setEmpId(empId);
		user1.setFirstName(firstName);
		user1.setLastName(lastName);
		user1.setPassword(pwd);
		XMLUtil.saveUserInfo(user1);
		return new ModelAndView("/WEB-INF/pages/successfullregistration.jsp");
	}
}
