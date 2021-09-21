package com.dao;

import java.util.List;

import com.model.Trainer;
//import com.model.Trainer;
public interface TrainerDao {
	
	boolean addTrainer(Trainer t);
	boolean deleteTrainer(int id);
	boolean updateTrainer(Trainer t);
	List<Trainer> getAllTrainer();

}
