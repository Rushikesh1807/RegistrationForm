package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.controller.services.PersonServices;
import org.nlt.controller.services.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class HomeController {
	    
	    @Autowired
	    private PersonServices personService;
	    
	    public HomeController()
	    {
	        System.out.println("Home Controller Object Created");
	    }

	    @RequestMapping("/welcome")
	    public ModelAndView showWelcomePage(HttpSession session) 
	    {
	        ModelAndView modelAndView = new ModelAndView("welcome"); 

	      
	        String loggedInUserName = null;
	        if (session.getAttribute("LoginUser") != null)
	        {
	            
	            loggedInUserName = ((Students) session.getAttribute("LoginUser")).getName(); 
	        }

	        
	        modelAndView.addObject("loggedInUserName", loggedInUserName);

	        return modelAndView;
	    }
	

	
	
	@RequestMapping(value="/xyz")
	public ModelAndView home3()
	{
		System.out.println("Home3 Method");
		return null;
	}
}
