package com.greatlearning.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.repository.StudentRepository;
import com.greatlearning.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}

	@Override
	public List<Student> getStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int StudentId) {

		return studentRepository.getById(StudentId);
		/*
		 * Optional<Student> optionalStudent = studentRepository.findById(StudentId);
		 * 
		 * if (optionalStudent.isPresent()) return optionalStudent.get(); else return
		 * null;
		 */
	}

	@Override
	public Student updateStudent(int id, Student student) {

		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent())
			return studentRepository.save(student);
		else
			return null;

	}

	@Override
	public Student deleteStudent(int studentId) {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);

		if (optionalStudent.isPresent()) {
			Student student = optionalStudent.get();
			studentRepository.delete(student);
			return student;
		} else
			return null;

	}

}
