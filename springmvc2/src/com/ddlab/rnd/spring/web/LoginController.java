package com.ddlab.rnd.spring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddlab.rnd.util.XMLUtil;
import com.ddlab.rnd.web.beans.Login;
import com.ddlab.rnd.web.beans.User;

@Controller
@RequestMapping(value = "/login.html")
public class LoginController {

	private @Autowired Validator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String showLoginForm(ModelMap model) {
		validator.validate();
		Login login = new Login();
		model.addAttribute("Login", login);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm1(@ModelAttribute(value = "Login") Login login,
			BindingResult result) {
		validator.validate();
		System.out.println("Login User Name :::"+login.getUserName());
		System.out.println("Login User Password :::"+login.getPassword());
		try {
			boolean userFlag = false;
			List<User> userList = XMLUtil.getUserInfoList();
			for (User user : userList) {
				if (user.getFirstName().equals(login.getUserName())
						&& user.getPassword().equals(login.getPassword())) {
					userFlag = true;
					break;
				}
			}
			if (userFlag)
				return "success";
			else
				return "failurelogin";
		} catch (Exception e) {
			e.printStackTrace();
			return "failurelogin";
		}
	}
}
