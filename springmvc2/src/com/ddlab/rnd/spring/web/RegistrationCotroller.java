package com.ddlab.rnd.spring.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddlab.rnd.util.XMLUtil;
import com.ddlab.rnd.web.beans.User;

@Controller
@RequestMapping(value="/registrationpage.html")
public class RegistrationCotroller
{
	
	@RequestMapping(method=RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		User user = new User();
		model.addAttribute("User", user);
		return "registrationpage";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processRegistrationForm(@ModelAttribute(value="User") User user,BindingResult result) {
		System.out.println("User Password :::"+user.getPassword());
		XMLUtil.saveUserInfo(user);
		return "successfullregistration";
	}
}
