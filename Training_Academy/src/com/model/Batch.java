package com.model;

public class Batch {
    private int batch_id;
    private String batch_name;
    private int trainer_id;
    
    public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int batch_id, String batch_name, int trainer_id) {
		super();
		this.batch_id = batch_id;
		this.batch_name = batch_name;
		this.trainer_id = trainer_id;
	}

	public int getBatch_id() {
		return batch_id;
	}

	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}

	public String getBatch_name() {
		return batch_name;
	}

	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	@Override
	public String toString() {
		return "Batch [batch_id=" + batch_id + ", batch_name=" + batch_name + ", trainer_id=" + trainer_id + "]";
	}
    
}
