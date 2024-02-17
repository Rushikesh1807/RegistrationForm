package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.controller.services.model.Students;

import org.springframework.stereotype.Service;

@Service
public class PersonServices 
{   
	
	private SessionFactory  sf;
	private Session ses;
	
   public PersonServices()
   {
	   System.out.println(" ps oc");
	   System.out.println(ses);
	   sf = new Configuration().configure("/org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		 ses = sf.openSession();
		ses.beginTransaction();
		ses.getTransaction().commit();
		System.out.println(ses);
   }
   public void savePerson(Students person)
   {
	   ses.beginTransaction();
	   ses.save(person);
	   ses.getTransaction();
	   
   }
	
   public List<Students> getPersonList(String login)
   {
	  ses.beginTransaction();
	
	  Query query=ses.createQuery("from Students where status=1 and login != :login ");
	  query.setParameter("login", login);
	  List<Students> personlist=query.list();
	 
	  System.out.println(personlist);
	  ses.getTransaction().commit();
	  return personlist;
   }
   public Students getPerson(int id) {
		ses.beginTransaction();
		Students per =(Students) ses.get(Students.class, id);
		ses.getTransaction().commit();
		return per;
   }
 
}
