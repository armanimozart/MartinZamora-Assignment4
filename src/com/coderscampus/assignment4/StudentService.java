package com.coderscampus.assignment4;

import java.util.Arrays;

public class StudentService {
	
    public void processAndSaveStudentsByCourse(Student[] students, String[]courses) {
    	FileService fileService = new FileService();
    	int courseIndex = 1;
    	for (String course: courses) {
    		Student[] courseStudent = getStudentsForCourse(students, course);
    		String filename = "course" + courseIndex++ + ".csv";
    		fileService.writeStudentsToCsv(courseStudent, filename);
    		System.out.println("Created " + filename + " with " + courseStudent.length + 
                    " students from course: " + course);
    	}
    }
	
	private int countStudentsInCourse(Student[] students, String course) {
        int count = 0;
        for(Student student : students) {
            if (student != null && student.getCourse().startsWith(course)) {
                count++;
            }
        }
        return count;
    }
    private Student[] getStudentsForCourse(Student[] allStudents, String course) {
        int count = countStudentsInCourse(allStudents, course);
        Student[] courseStudents = new Student[count];
        int index = 0;
        
        for (Student allStudent : allStudents) {
            if (allStudent != null && allStudent.getCourse().startsWith(course)) {
                courseStudents[index++] = allStudent;
            }
        }
        Arrays.sort(courseStudents);
        return courseStudents;
    }
}
