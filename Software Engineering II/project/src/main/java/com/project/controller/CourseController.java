package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.project.entities.Course;
import com.project.repository.CourseRepository;

@Controller
public class CourseController extends WebMvcConfigurerAdapter {

	@Autowired
	private CourseRepository repo;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/AddCourse").setViewName("AddCourse");
		registry.addViewController("/ShowCoursesS").setViewName("ShowCoursesS");
		registry.addViewController("/ShowCoursesT").setViewName("ShowCoursesT");
		registry.addViewController("/contact - 2").setViewName("contact - 2");
		registry.addViewController("/profile").setViewName("profile");

	}

	@GetMapping("/AddCourse")
	public String ShowForm(Model model) {
		model.addAttribute("course", new Course());
		return "AddCourse";
	}

	@PostMapping("/AddCourse")
	public String addCourse(Model model, @ModelAttribute @Valid Course course, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "AddCourse";
		}

		System.out.println(course.getName());
		System.out.println(course.getAge());
		System.out.println(course.getBio());
		repo.save(course);
		model.addAttribute("course", new Course());
		return "redirect:/ShowCoursesT";
	}

	@GetMapping("/coursesS")
	public String showCoursesS(Model model) {
		Iterable<Course> coursesIT = repo.findAll();
		List<Course> coursesList = new ArrayList<Course>();
		for (Course course : coursesIT) {
			coursesList.add(course);
		}
		model.addAttribute("courses", coursesList);
		return "ShowCoursesS";
	}

	@GetMapping("/coursesT")
	public String showCoursesT(Model model) {
		Iterable<Course> coursesIT = repo.findAll();
		List<Course> coursesList = new ArrayList<Course>();
		for (Course course : coursesIT) {
			coursesList.add(course);
		}
		model.addAttribute("courses", coursesList);
		return "ShowCoursesT";
	}

}
