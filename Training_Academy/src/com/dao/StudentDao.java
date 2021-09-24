package com.dao;

import java.util.List;
import java.util.Map;

import com.model.Student;

public interface StudentDao {
	boolean addStudent(Student s);
	boolean deleteStudent(int id);
	boolean updateStudent(Student s);
	List<Student> getAllStudent();
	//Map<String,Integer> getStudentWiseCount();
	void meritListTopFive(int batch_id);
	void meritListTopTen();
	void bestResult();
	void batchName();
}

