package com.greatlearning.student.controller;

import org.springframework.ui.Model;

public interface StudentController {

	public String listStudents(Model theModel);

	public String showFormForAdd(Model theModel);

	public String showFormForUpdate(int id, Model theModel);

	public String delete(int id);

	public String save(int id, String name, String department, String country);

}
