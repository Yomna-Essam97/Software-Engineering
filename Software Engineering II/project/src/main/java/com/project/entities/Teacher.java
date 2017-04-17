package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "users")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String email;

	private String name;

	@Min(20)
	private int age;

	private String gender;

	private String nationality;

	private String VerificationCode;

	private String password;

	private String type = "teacher";

	public Teacher() {
		password = "";
		name = "";
		age = 20;
		gender = "";
		nationality = "";
		email = "";
		VerificationCode = "";
	}

	public Teacher(Integer id, String email, String name, int age, String gender, String nationality,
			String verificationCode, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		VerificationCode = verificationCode;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getVerificationCode() {
		return VerificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		VerificationCode = verificationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
