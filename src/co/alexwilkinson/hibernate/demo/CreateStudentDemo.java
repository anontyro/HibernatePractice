package co.alexwilkinson.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import co.alexwilkinson.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
		Student tempStudent = new Student("Bonita", "Applebum", "bonita@gmail.com");
		
		//create the student object
		session.beginTransaction();
		
		//start a transaction
		System.out.println("Saving the student");
		session.save(tempStudent);
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Finished");
		
	}finally{
		factory.close();
	}
		
	}

	
	
	
	
	
}
