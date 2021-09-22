package com.dao;

import java.util.List;

import com.model.StudentTest;

public interface StudentTestDao {
	
		boolean addStudentMarks(StudentTest st);
		boolean deleteStudentMarks(int id);
		boolean updateStudentMarks(StudentTest st);
		List<StudentTest> getAllStudentTest();

	}

