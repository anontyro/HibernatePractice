package co.alexwilkinson.hibernate.demo;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import co.alexwilkinson.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
	//create session factory
	SessionFactory factory = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
	//create session
	Session session = factory.getCurrentSession();
	
	try{
		
		//start transaction
		session.beginTransaction();
		
		//query all students
		List<Student> theStudents = session.createQuery("from Student").getResultList();
		
		//display the students
		System.out.println("Query All");
		displayStudents(theStudents);
		System.out.println("\n");
		
		//query for where lastname
		theStudents = session.createQuery("from Student s where s.lastName='Miller'").getResultList();
		
		//display the students
		System.out.println("Query Miller last name");
		displayStudents(theStudents);
		System.out.println("\n");
		
		//query for where lastname
		theStudents = session.createQuery("from Student s where s.lastName='Miller' OR s.firstName='Daffy' ").getResultList();
		
		//display the students
		System.out.println("Query Lastname Miller or firstname Daffy");
		displayStudents(theStudents);
		System.out.println("\n");
		
		//query for where lastname
		theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com' ").getResultList();
		
		//display the students
		System.out.println("Query any with email ending in gmail.com");
		displayStudents(theStudents);
		
		//commit transaction
		session.getTransaction().commit();
		
		System.out.println("Finished");
		
	}finally{
		factory.close();
	}
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student s : theStudents){
			System.out.println(s);
		}
	}

	
	
	
	
	
}
