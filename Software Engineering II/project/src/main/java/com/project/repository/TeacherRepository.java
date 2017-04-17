package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
