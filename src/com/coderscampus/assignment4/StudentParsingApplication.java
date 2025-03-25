package com.coderscampus.assignment4;

public class StudentParsingApplication {

	public static void main(String[] args) {
		String [] courses = {"APMTH", "COMPSCI", "STAT"};
		FileService fileService = new FileService();
		StudentService studentService = new StudentService();
		Student[] students = fileService.loadStudents("student-master-list.csv");
		studentService.processAndSaveStudentsByCourse(students, courses);
		System.out.println("Process Complete. Course files created.");
	}
}