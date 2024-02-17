package org.nlt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.controller.services.PersonServices;
import org.nlt.controller.services.UserServices;
import org.nlt.controller.services.model.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	private PersonServices personService;
	
	@Autowired
	private UserServices userService;
	
	public LoginController()
	{
		System.out.println("Login Controller Object Created");
	}
	 @RequestMapping("/")
	    public String showLoginPage() {
	        return "login";
	    }
	@RequestMapping(value="/getLoginUser")
	public ModelAndView getLogin(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap<>();
		
		String login=req.getParameter("login");
		String password=req.getParameter("password");
		
		HttpSession httpSession =req.getSession();
		
		Students user = userService.validateUser(login,password);
		
		if(user!=null)
		{
			httpSession.setAttribute("LoginUser", user);
			
			m.put("personList", personService.getPersonList(login));
			//httpSession.setAttribute("personList", personService.getPersonList());
			return new ModelAndView("welcome",m);
		}
		else
		{
			m.put("error", "Invalid Username or Password! Please Try Again");
			return new ModelAndView("login",m);
		}
	}

	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest req,HttpServletResponse res)
	{
		Map<String, Object> m=new HashMap<>();
		HttpSession httpSession =req.getSession();
		
		httpSession.invalidate();//remove all the data from session
		
		return new ModelAndView("login",m);
	}
}
