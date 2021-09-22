package com.model;

//import java.math.BigInteger;

public class Student {
	
	private int student_id;
	private String student_name;
	private long mobile;
	private int batch_id;
	
public Student() {
	// TODO Auto-generated constructor stub
}


	public Student(int student_id, String student_name, long mobile, int batch_id) {
	super();
	this.student_id = student_id;
	this.student_name = student_name;
	this.mobile = mobile;
	this.batch_id = batch_id;
}
	



	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getStudent_name() {
		return student_name;
	}


	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}


	public long getMobile() {
		return mobile;
	}


	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public int getBatch_id() {
		return batch_id;
	}


	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}


	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", mobile=" + mobile
				+ ", batch_id=" + batch_id + "]";
	}
	
	
	

}
