package com.coderscampus.assignment4;

public class Student implements Comparable<Student>{
	private String id;
	private String name;
	private String course;
	private String grade;
	
	public Student() {}
	
	public Student(String id, String name, String course, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + course + "," + grade;
		
	}

	@Override
	public int compareTo(com.coderscampus.assignment4.Student that) {
		int thisGrade = Integer.parseInt(this.grade);
		int thatGrade = Integer.parseInt(that.grade);
		return thatGrade - thisGrade;
	}
}