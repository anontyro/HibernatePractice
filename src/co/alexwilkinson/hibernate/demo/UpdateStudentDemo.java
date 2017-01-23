package co.alexwilkinson.hibernate.demo;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import co.alexwilkinson.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
	//create session factory
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
	//create session
	Session session = factory.getCurrentSession();
	
	try{
		
		int studentId = 1;
		
		//get a new session and start of transaction
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve student based on id (PK)
		System.out.println("\nGetting student with id: " + studentId);
		
		Student myStudent = session.get(Student.class,studentId);
		
		System.out.println("Updating student ");
		myStudent.setFirstName("Scooby");
		
		//commit the transaction
		session.getTransaction().commit();
		
		
		System.out.println("Finished");
		
	}finally{
		factory.close();
	}
		
	}

	
	
	
	
	
}
