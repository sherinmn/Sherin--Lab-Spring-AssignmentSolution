package com.greatlearning.student.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentControllerImpl implements StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> students = studentService.getStudents();
		theModel.addAttribute("Student", students);
		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Student student = new Student();
		theModel.addAttribute("Student", student);
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("StudentId") int id, Model theModel) {
		Student student = studentService.getStudentById(id);
		theModel.addAttribute("Student", student);
		return "student-form";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("StudentId") int id) {
		Student student = studentService.getStudentById(id);
		studentService.deleteStudent(id);
		return "redirect:/students/list";

	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		System.out.println("Saving student with Id: " + id);
		Student student;
		if (id != 0) {
			student = studentService.getStudentById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else {
			student = new Student(name, department, country);
		}
		studentService.saveStudent(student);

		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
