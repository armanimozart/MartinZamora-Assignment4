package com.coderscampus.assignment4;

public class FileParsingApplication {

	public static void main(String[] args) {
		FileService fileService = new FileService();
		Student[] students = fileService.students("student-master-list.csv");
		fileService.processAndSaveStudentsByCourse(students);
		System.out.println("Process Complete. Course files created.");
	}
}