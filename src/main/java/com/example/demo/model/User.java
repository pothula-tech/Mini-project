package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Range;

@Entity            //class User is an @Entity class as data here needs to be saved in database
@Table(name="employee")
public class User {
    @Id //specifying id is primary key
	private int id;
    //validations for fields
    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
	private String username;
    
    @NotNull
    @Size(min=2, max=16, message="First Name should have min 2 and max 16 characters")
	private String firstname;
    
    @NotNull
    @Size(min=2, max=16, message="Name should have min 2 and max 16 characters")
	private String lastname;
    
    @NotNull
    @Range(min = 0l, message = "Please select positive numbers Only")
	private int age;
    
    @NotNull
    private String password;
	
    
    //default constructor
	public User () 
	{
		
	}
	
	//setters and getters
	public User(String username, String firstname, String lastname, int age, String password) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", age=" + age + ", password=" + password + "]";
	}
	
}
