package com.model;

public class Trainer {
     private int trainer_id;
     private String trainer_name;
     private long mobile;
     
     public Trainer() {
		// TODO Auto-generated constructor stub
    	 
	}

	public Trainer(int trainer_id, String trainer_name, long mobile) {
		super();
		this.trainer_id = trainer_id;
		this.trainer_name = trainer_name;
		this.mobile = mobile;
	}

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Trainer [trainer_id=" + trainer_id + ", trainer_name=" + trainer_name + ", mobile=" + mobile + "]";
	}
	
     
     
}
