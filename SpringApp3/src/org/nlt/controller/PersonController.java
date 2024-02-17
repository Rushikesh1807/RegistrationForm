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
		@RequestMapping(value="/")
		public ModelAndView home(HttpServletRequest req, HttpServletResponse resp)
		{
			System.out.println(personService);
			Map m=new HashMap();
			m.put("action", "./submitPerson");		
			  m.put("buttonValue", "SUBMIT ");
			  m.put("personList", personService.getPersonList());
			return new ModelAndView("index",m);
		}
		@RequestMapping(value="/submitPerson")
		public ModelAndView addPerson(HttpServletRequest req,HttpServletResponse res)
		{
			Map m=new HashMap();
			
			
			String name=req.getParameter("name");
			String age=req.getParameter("age");
			String gender=req.getParameter("gender");
			String hobbies="";
			String[] hob=req.getParameterValues("hobbies");
		
			if(hob!=null)
			{
				for(String h:hob)
				{
					hobbies=hobbies.concat(h);
				}
			}
			String address=req.getParameter("address");
			String city=req.getParameter("city");
			String dob=req.getParameter("dob");
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(hobbies);
			System.out.println(address);
			System.out.println(city);
			System.out.println(dob);
			
			m.put("nameValue", name);
			m.put("ageValue", age);
			m.put("genderValue", gender);
			m.put("hobbiesValue", hobbies);
			m.put("addressValue",address);
			m.put("cityValue", city);
			m.put("dobValue", dob);
			
			if(name.isEmpty())
			{
				m.put("error", " Name is required");
			}
			else if(age.isEmpty())
			{
				m.put("error", "Please Enter Age");
			}
			else if(gender==null || gender.isEmpty())
			{
				m.put("error", "Please select gender");
			}
			else if( city.equals("-1"))
			{
				m.put("error", "Please select city");
			}
			else if(dob==null || dob.isEmpty())
			{
				m.put("error", "Please select dob");
			}
			else
			{
				
				Students person = new Students();
				person.setAddress(address);
				person.setAge(Integer.parseInt(age));
				person.setCity(city);
				person.setCreated(new Date());
				try 
				{
					SimpleDateFormat sd=new SimpleDateFormat("yyyy-mm-dd");
					Date dobDate = sd.parse(dob);
					person.setDob(dobDate);
				} catch(Exception ex)
				{
					System.out.println(ex);
				}
				person.setModified(new Date());
				person.setName(name);
				person.setGender(gender);
				person.setHobbies(hobbies);
	            person.setStatus(1);
				
				personService.savePerson(person);
				
				m.put("success", "Record Submitted Successfully");
				
			}
			
			
			m.put("action", "./submitPerson");
			m.put("buttonValue", "SUBMIT");
			m.put("personList", personService.getPersonList());
			return new ModelAndView("index",m);
		}
		@RequestMapping(value="/getPersonForEdit")
		public ModelAndView getEditPerson(HttpServletRequest req,HttpServletResponse res)
		{
			Map m=new HashMap();
			
			String id=req.getParameter("id");
			
			Students person=personService.getPerson(Integer.parseInt(id));
			
			m.put("idValue", person.getId());
			m.put("nameValue", person.getName());
			m.put("ageValue", person.getAge());
			m.put("genderValue", person.getGender());
			
			m.put("hobbiesValue", person.getHobbies());
			m.put("addressValue", person.getAddress());
			m.put("cityValue", person.getCity());
			m.put("dobValue", person.getDob());
			
			m.put("action", "./updatePerson");
			m.put("buttonValue", "UPDATE");
			m.put("personList", personService.getPersonList());
			return new ModelAndView("index",m);
		}
		@RequestMapping(value="/getPersonForDelete")
		public ModelAndView getDeletePerson(HttpServletRequest req,HttpServletResponse res)
		{
			Map m=new HashMap();
			
			String id=req.getParameter("id");
			
			Students person=personService.getPerson(Integer.parseInt(id));
			
			m.put("idValue", person.getId());
			m.put("nameValue", person.getName());
			m.put("ageValue", person.getAge());
			m.put("genderValue", person.getGender());
			
			m.put("hobbiesValue", person.getHobbies());
			m.put("addressValue", person.getAddress());
			m.put("cityValue", person.getCity());
			m.put("dobValue", person.getDob());
			
			m.put("action", "./deletePerson");
			m.put("buttonValue", "DELETE");
			m.put("personList", personService.getPersonList());
			return new ModelAndView("index",m);
		}
		@RequestMapping(value="/updatePerson")
		public ModelAndView updatePerson(HttpServletRequest req,HttpServletResponse res)
		{
			Map m=new HashMap();
			String id=req.getParameter("id");
				String name=req.getParameter("name");
				String age=req.getParameter("age");
				String gender=req.getParameter("gender");
				
				
				String hobbies="";
				String[] hob=req.getParameterValues("hobbies");
				if(hob!=null)
				{
					for(String h:hob)
					{
						hobbies=hobbies.concat(h);
					}
				}
				String address=req.getParameter("address");
				String city=req.getParameter("city");
				String dob=req.getParameter("dob");
				
			m.put("nameValue", name);
			m.put("ageValue", age);
			m.put("genderValue", gender);
			m.put("hobbiesValue", hobbies);
			m.put("addressValue", address);
			m.put("cityValue", city);
			m.put("dobValue", dob);
			if(name.isEmpty())
			{
				m.put("error", "Please Enter Name");
			}
			else if(age.isEmpty())
			{
				m.put("error", "Please Enter Age");
			}
			else if(gender == null||gender.isEmpty())
			{
				m.put("error", "Please select gender");
			}
			else if(address.isEmpty())
			{
				m.put("error", "Please Enter address");
			}
			else if(city.equals("-1"))
			{
				m.put("error", "Please Enter city");
			}
			else if(dob == null||dob.isEmpty())
			{
				m.put("error", "Please select dob");
			}
			else
			{
		  Students person=personService.getPerson(Integer.parseInt(id));
			person.setAddress(address);
				person.setAge(Integer.parseInt(age));
				
				person.setCity(city);
				person.setCreated(new Date());
				try
				{
					SimpleDateFormat sd=new SimpleDateFormat("yyy-mm-dd");
					Date dobDate=sd.parse(dob);
					person.setDob(dobDate);
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				person.setGender(gender);
				person.setHobbies(hobbies);
				person.setName(name);
				person.setModified(new Date());
				person.setStatus(1);
				
				personService.updatePerson(person);
				m.put("success", "Record Updated Successfully");
			
			}
			
			
			m.put("action", "./submitPerson");
			m.put("buttonValue", "SUBMIT");
			m.put("personList", personService.getPersonList());
			return new ModelAndView("index",m);
		}
		@RequestMapping(value="/deletePerson")
		public ModelAndView deletePerson(HttpServletRequest req,HttpServletResponse res)
		{
			Map m=new HashMap();
			
			String id=req.getParameter("id");
			  Students person=personService.getPerson(Integer.parseInt(id));
			
		
				person.setStatus(0);
				person.setModified(new Date());
				personService.updatePerson(person);
			m.put("success", "Record Delete Successfully");
			
	           m.put("action", "./submitPerson");
			m.put("buttonValue", "SUBMIT");
			m.put("personList", personService.getPersonList());
			return new ModelAndView("index",m);
		}
		
}
