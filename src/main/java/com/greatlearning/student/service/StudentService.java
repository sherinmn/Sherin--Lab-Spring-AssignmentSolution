package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.entity.Student;

public interface StudentService {

	// Create
	Student saveStudent(Student student);

	// Read
	List<Student> getStudents();

	Student getStudentById(int StudentId);

	// Update
	Student updateStudent(int id, Student student);

	// Delete
	Student deleteStudent(int studentId);

}
