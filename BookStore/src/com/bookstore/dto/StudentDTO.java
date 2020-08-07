package com.bookstore.dto;

public class StudentDTO {
	private int 	studentId;
	private String 	name;
	private int 	age;
	private boolean gender;
	
	
	
	public StudentDTO(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public StudentDTO(int studentId, String name, int age, boolean gender) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	
}
