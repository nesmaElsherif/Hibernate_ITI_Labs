package lab1_iti.lab1_iti;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iti.dao.Account;

public class Test {

	public static void main(String[] args) {
		

        //creating session object  
		Session session = HibernateUtil.getSessionFactory().openSession();
		
        //creating transaction object  
		Transaction transaction	=session.beginTransaction();
		
        //creating transaction object  
		Account account = new Account();
		account.setFullName("Nesma Elsherif ");
		account.setUserName("Nesma");
		account.setPhone("0235355637");
		account.setBirthday(new Date());
		account.setEmail("ahyousif@mcit.gov.eg");
		account.setAddress("Elsherif ");
		account.setPassword("12345");
		session.persist(account);//persisting the object 
		account.setUserName("basma "); 
		
	//	session.getTransaction().commit(); or 
		transaction.commit();
		
		System.out.println("Insertion Done");


	}

}
