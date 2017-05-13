package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String description;

	@NotEmpty
	private String course;

	private String TeacherName;

	public Game(String name, String TeacherName, String description, String question, String choices, String answer,
			String course) {
		super();
		this.TeacherName = TeacherName;
		this.name = name;
		this.description = description;
		this.course = course;
	}

	public Game() {
		TeacherName = "";
		name = "";
		description = "";
		course = "";
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

}
