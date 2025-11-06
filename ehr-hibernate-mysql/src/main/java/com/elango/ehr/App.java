package com.elango.ehr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Patient elango = new Patient("elango", 27, "fine");
       Patient raj = new Patient("raj", 27, "not good");

       Configuration configuration = new Configuration();
       configuration.addAnnotatedClass(Patient.class);

       configuration.configure("hibernate.cfg.xml");

       SessionFactory sf = configuration.buildSessionFactory();
       Session session = sf.openSession();

       Transaction transaction = session.beginTransaction();

       session.persist(elango);
       session.persist(raj);
       transaction.commit();

       System.out.println(raj);
    }
}
