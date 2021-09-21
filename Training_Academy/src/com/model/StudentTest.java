package com.model;

public class StudentTest {
	private int student_id;
	private int test_id;
	private int marks;
	
	public StudentTest() {
		// TODO Auto-generated constructor stub
	}

	public StudentTest(int student_id, int test_id, int marks) {
		super();
		this.student_id = student_id;
		this.test_id = test_id;
		this.marks = marks;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentTest [student_id=" + student_id + ", test_id=" + test_id + ", marks=" + marks + "]";
	}
	
	
}
