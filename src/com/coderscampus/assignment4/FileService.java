package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileService {
private static final String [] COURSE_PREFIXES = {"APMTH", "COMPSCI", "STAT"};
	
	public Student[] students(String filename) {
		Student[] students = new Student[100];
		
			try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
				String line; 
				int index = 0; 
				br.readLine(); 
				while ((line = br.readLine()) != null) {
					String[] splitLine = line.split(",");
					Student student = new Student(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
					students[index] = student;
					index++;
				}
			} catch (FileNotFoundException e) {
				System.err.println("File not found: " + filename);
			} catch (IOException e) {
				System.err.println("IOException: " + e.getMessage());
			} 
			return students;
		}
    private int countStudentsInCoursePrefix(Student[] students, String prefix) {
        int count = 0;
        
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getCourse().startsWith(prefix)) {
                count++;
            }
        }
        return count;
    }
    private Student[] getStudentsForCoursePrefix(Student[] allStudents, String prefix) {
        int count = countStudentsInCoursePrefix(allStudents, prefix);
        Student[] prefixStudents = new Student[count];
        int index = 0;
        
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i] != null && allStudents[i].getCourse().startsWith(prefix)) {
                prefixStudents[index] = allStudents[i];
                index++;
            }
        }
        Arrays.sort(prefixStudents);
        return prefixStudents;
    }
    
    private void writeStudentsToCsv(Student[] students, String filename) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename));){
            writer.write("Student ID,Student Name,Course,Grade");
            writer.newLine();
            
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    writer.write(students[i].getId() + "," + 
                                 students[i].getName() + "," + 
                                 students[i].getCourse() + "," + 
                                 students[i].getGrade());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        } 
    }
    
    public void processAndSaveStudentsByCourse(Student[] students) {
        for (int i = 0; i < COURSE_PREFIXES.length; i++) {
            String prefix = COURSE_PREFIXES[i];
            Student[] prefixStudents = getStudentsForCoursePrefix(students, prefix);
            
            String filename = "course" + (i + 1) + ".csv";
            writeStudentsToCsv(prefixStudents, filename);
            
            System.out.println("Created " + filename + " with " + prefixStudents.length + 
                              " students from course: " + prefix);
        }
    }
}