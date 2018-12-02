package com.ddlab.rnd.spring.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ddlab.rnd.util.XMLUtil;
import com.ddlab.rnd.web.beans.Login;
import com.ddlab.rnd.web.beans.User;

@Controller
@RequestMapping(value="/registrationpage.html")
public class RegistrationCotroller
{
	
	@RequestMapping(method=RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		System.out.println("=================showRegistrationForm()=================");
		User user = new User();
		model.addAttribute("User", user);
		System.out.println("............. Going to call showForm() method .............");
		return "registrationpage";
//		return "login";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String processRegistrationForm(@ModelAttribute(value="User") Login login,BindingResult result) {
		
		
		return "success";
		
//		if( login.getPassword().equals("piku")) {
//			return "success";
//		}
//		else {
////			return "registrationpage";
//			return "failurelogin";
//		}
		
//		if(result.hasErrors()){
//			return "registration";
//		}else{
//			System.out.println("User values is : " + user);
//			return "success";
//		}		
	}
	
	
	
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest request,
//			HttpServletResponse response) throws Exception
//	{
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String empId = request.getParameter("empId");
//		String pwd = request.getParameter("pwd");
//		User user1 = new User();
//		user1.setEmpId(empId);
//		user1.setFirstName(firstName);
//		user1.setLastName(lastName);
//		user1.setPassword(pwd);
//		XMLUtil.saveUserInfo(user1);
//		return new ModelAndView("/WEB-INF/pages/successfullregistration.jsp");
//	}
}
