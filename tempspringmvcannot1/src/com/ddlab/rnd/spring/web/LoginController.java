package com.ddlab.rnd.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddlab.rnd.web.beans.Login;
import com.ddlab.rnd.web.beans.User;

@Controller
@RequestMapping(value="/login.html")
public class LoginController
{
	
	@RequestMapping(method=RequestMethod.GET)
	public String showForm1(ModelMap model) {
		System.out.println("=================showForm1()=================");
		Login login = new Login();
		model.addAttribute("Login", login);
		System.out.println("............. Going to call showForm() method .............");
		//return "registrationpage";
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processForm1(@ModelAttribute(value="Login") Login login,BindingResult result) {
		
		if( login.getPassword().equals("piku")) {
			return "success";
		}
		else {
//			return "registrationpage";
			return "failurelogin";
		}
		
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
//		ModelAndView modelNView = new ModelAndView();
//		String userName = request.getParameter("username");
//		String pwd = request.getParameter("password");
//		try {
//			boolean userFlag = false;
//			List<User> userList = XMLUtil.getUserInfoList();
//			for( User user : userList ) {
//				if( user.getFirstName().equals(userName) && user.getPassword().equals(pwd)) {
//					userFlag = true;
//					break;
//				}
//			}
//			if( userFlag )
//				modelNView.setViewName("/WEB-INF/pages/success.jsp");
//			else
//				modelNView.setViewName("/WEB-INF/pages/failurelogin.jsp");
//		}
//		catch( Exception e ) {
//			e.printStackTrace();
//			modelNView.setViewName("/WEB-INF/pages/failurelogin.jsp");
//		}
//		
//		return modelNView;
//	}

}
