package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.controller.services.model.Students;

import org.springframework.stereotype.Service;

@Service
public class PersonServices implements ParentInterface
{
   public PersonServices()
   {
	   System.out.println(" ps oc");
	   System.out.println(ses);
   }
   public void savePerson(Students person)
   {
	   ses.beginTransaction();
	   ses.save(person);
	   ses.getTransaction();
	   
   }
	public void updatePerson(Students person)
	{
		ses.beginTransaction();
		ses.update(person);
		ses.getTransaction().commit();
	}
	
   public List<Students>getPersonList()
   {
	  ses.beginTransaction();
	  Query query=ses.createQuery("from Students where status=1");
	  List<Students> personlist=query.list();	
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
