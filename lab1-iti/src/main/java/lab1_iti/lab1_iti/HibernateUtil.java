package lab1_iti.lab1_iti;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	/*
	 *  usig singlton design pattern 
	 *  to return one object from session factory to avoid the problem of thread 
	 *  
	 */
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    private static SessionFactory buildSessionFactory() {
        try {
            //creating configuration object  
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
        	
            // Create the SessionFactory from hibernate.cfg.xml
            SessionFactory factory = cfg.buildSessionFactory();
            return  factory;
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
        
    }
 

}
