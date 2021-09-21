package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {
	boolean addStudent(Student s);
	boolean deleteStudent(int id);
	boolean updateStudent(Student s);
	List<Student> getAllStudent();

}

