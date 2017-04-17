package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
