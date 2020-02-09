package com.example.shivam.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class Person {
	
	private long id;
	private String firstName;	
	private String lastName;
	private String age;    
    private String favouriteColor;
    private String hobby;
	
	public Person(String firstName, String lastName, String age, String favouritColor, String hobby) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.favouriteColor = favouritColor;
		this.hobby = hobby;
	}

	 public Person() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getFavouritColor() {
		return favouriteColor;
	}
	public void setFavouritColor(String favouritColor) {
		this.favouriteColor = favouritColor;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

}
