package com.anil.model;

public class Student {
	
	private int id;
	private String name;
	private String course;
	private String city;
	
	
	public Student() {
		super();
	}


	public Student(int id, String name, String course, String city) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.city = city;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", city=" + city + "]";
	}
	
	
	
	
//	shift + alt + s

}
