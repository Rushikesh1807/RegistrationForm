package org.nlt.controller.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public interface ParentInterface
{
  public static SessionFactory sf=getSessionFactory();
  public static Session ses=sf.openSession();
  
  public  static SessionFactory getSessionFactory()
      {
	  return new Configuration().configure("/org/nlt/controller/hibernate.cfg.xml").buildSessionFactory();
	  }
}
