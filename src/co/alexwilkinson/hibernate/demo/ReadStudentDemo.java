package co.alexwilkinson.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import co.alexwilkinson.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
	//create session factory
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
	//create session
	Session session = factory.getCurrentSession();
	
	try{
		
		//use session to save the Java object
		System.out.println("creating a new student object");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
		
		//create the student object
		session.beginTransaction();
		
		//start a transaction
		System.out.println("Saving the student");
		session.save(tempStudent);
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Saved Id is: " +tempStudent.getId());
		
		//get a new session and start of transaction
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve student based on id (PK)
		System.out.println("\nGetting student with id: " + tempStudent.getId());
		
		Student myStudent = session.get(Student.class, tempStudent.getId());
		
		System.out.println("Get completed " +myStudent);
		
		//commit the transaction
		session.getTransaction().commit();
		
		
		System.out.println("Finished");
		
	}finally{
		factory.close();
	}
		
	}

	
	
	
	
	
}
