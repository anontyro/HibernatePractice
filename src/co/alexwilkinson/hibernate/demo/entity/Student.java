package co.alexwilkinson.hibernate.demo.entity;

import javax.persistence.*;

/*
 * Hibernate mapping class that will allow Java to map the data to the
 * MYSQL database via Hibernate
 */

@Entity //highlight this is a hibernate object
@Table(name="student") //table annotation
public class Student {
	
	@Id //used for primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") //links to the specfic column in the database
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	public Student(){
		
	}

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

	
	
	
	
	

}
