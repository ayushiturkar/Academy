package com.model;

public class Test {
      private int test_id;
      private String test_name;
      
      public Test() {
		// TODO Auto-generated constructor stub
	}

	public Test(int test_id, String test_name) {
		super();
		this.test_id = test_id;
		this.test_name = test_name;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	@Override
	public String toString() {
		return "Test [test_id=" + test_id + ", test_name=" + test_name + "]";
	}
      
}
