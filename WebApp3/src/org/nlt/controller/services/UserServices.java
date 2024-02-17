package org.nlt.controller.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.controller.services.model.Students;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	private SessionFactory sf;
	private Session ses;

	public UserServices() {
		sf = new Configuration().configure("/org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
		ses = sf.openSession();
		ses.beginTransaction();
		ses.getTransaction().commit();
	}

	public Students validateUser(String login, String password) {
	    ses.beginTransaction();

	    
	    	Query query = ses.createQuery("from Students where login='"+login+"' and password='"+password+"' and status=1");
	     

	        List<Students> userList = query.list();

	        ses.getTransaction().commit();
	        try 
	        {
	        	if (userList.isEmpty()) 
	        	{
	            return null;
	        	} 
	        	else 
	        	{
	            return userList.get(0);
	        	}
	        }
	        catch(Exception e)
	        {
	        	throw e;
	        }
	}
}
