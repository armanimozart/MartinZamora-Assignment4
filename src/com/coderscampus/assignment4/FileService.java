package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

	public Student[] loadStudents(String filename) {
		int count = 0;
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
			while(bufferedReader.readLine() != null) {
				count++;
			}
		} catch (IOException e) {
			System.err.println("There was an issue counting the number of lines inside (" + filename + "): " + e.getMessage());
			}
		
		Student[] students = new Student[count];
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
			String line;
			int index = 0;
			bufferedReader.readLine(); // skips the header
			while ((line = bufferedReader.readLine()) != null) {
				String[] splitLine = line.split(",");
				Student student = new Student(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
				students[index++] = student;
			}
		} catch (IOException e) {
			System.err.println("There was an issue reading the file (" + filename + "): " + e.getMessage());
		}
		return students;
	}

	public void writeStudentsToCsv(Student[] students, String filename) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			writer.write("Student ID,Student Name,Course,Grade"); // header
			writer.newLine();
			for (Student student : students) {
				if (student != null) {
					writer.write(student.toString());
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.err.println("Error writing to file (" + filename + "): " + e.getMessage());
		}
	}
}