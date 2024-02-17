package org.nlt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nlt.controller.services.PersonServices;
import org.nlt.controller.services.model.Students;

import org.nlt.controller.services.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController
{
		@Autowired
		private PersonServices personService;
		
		public PersonController()
		{
			System.out.println("Person Controller Object Created");
			System.out.println();
		
		}
		@RequestMapping(value="/submit")
		public ModelAndView home(HttpServletRequest req, HttpServletResponse resp)
		{
			System.out.println(personService);
			Map m=new HashMap();
			m.put("action", "./submitPerson");		
			  m.put("buttonValue", "SUBMIT ");
			// m.put("personList", personService.getPersonList(login));
			return new ModelAndView("index",m);
		}
		@RequestMapping(value="/submitPerson")
		public ModelAndView addPerson(HttpServletRequest req,HttpServletResponse res)
		{
			Map m=new HashMap();
			
			
			String name=req.getParameter("name");
			String dob=req.getParameter("dob");
			
			String gender=req.getParameter("gender");
			
		
			
			String address=req.getParameter("address");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String login=req.getParameter("login");
			String password=req.getParameter("password");
			System.out.println(name);
			System.out.println(dob);
			System.out.println(gender);
			
			System.out.println(address);
			System.out.println(city);
			System.out.println(state);
			System.out.println(login);
			System.out.println(password);
			
			
			m.put("nameValue", name);
			m.put("dobValue", dob);
			m.put("genderValue", gender);
			
			m.put("addressValue",address);
			m.put("cityValue", city);
			m.put("stateValue", state);
			m.put("loginValue", login);
			m.put("passwordValue", password);
			
			if(name.isEmpty())
			{
				m.put("error", " Name is required");
			}
			else if(dob==null || dob.isEmpty())
			{
				m.put("error", "Please select DOB");
			}
			else if(gender==null || gender.isEmpty())
			{
				m.put("error", "Please select gender");
			}
			else if( address.isEmpty())
			{
				m.put("error", "Address is required");
			}
			else if( city.equals("-1"))
			{
				m.put("error", "Please select city");
			}
			else if(state.isEmpty())
			{
				m.put("error", "Please Enter State");
			}
			
			else if( login.isEmpty())
			{
				m.put("error", "Please Enter LOGIN-ID");
			}
			else if( password.isEmpty())
			{
				m.put("error", "Please Enter Password");
			}
			else
			{
				
				Students person = new Students();
				person.setName(name);
				try 
				{
					SimpleDateFormat sd=new SimpleDateFormat("yyyy-mm-dd");
					Date dobDate = sd.parse(dob);
					person.setDob(dobDate);
				} catch(Exception ex)
				{
					System.out.println(ex);
				}
				person.setGender(gender);
				person.setAddress(address);
				
				person.setCity(city);
				person.setState(state);
				person.setLogin(login);
				person.setPassword(password);
				person.setCreated(new Date());
			
				person.setModified(new Date());
				
				
				
	            person.setStatus(1);
				
				personService.savePerson(person);
				
				m.put("success", "Record Submitted Successfully");
				m.put("nameValue", "");
				m.put("dobValue", "");
				m.put("genderValue", "");
				m.put("addressValue", "");
				m.put("cityValue", "");
				m.put("stateValue", "");
				m.put("loginValue", "");
				m.put("passwordValue", "");
				
			}
			
			
			m.put("action", "./submitPerson");
			m.put("buttonValue", "SUBMIT");
			m.put("personList", personService.getPersonList(login));
			return new ModelAndView("index",m);
		}
		
		
		
		
}
