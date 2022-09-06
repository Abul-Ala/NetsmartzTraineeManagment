package com.netsmartz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.Model.Trainer;
import com.netsmartz.Repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	TrainerRepository trainerRepo;
	public void addTrainer(Trainer trainer) {
		trainerRepo.save(trainer);
		
	}
	public Iterable<Trainer> getAllTrainer() {
		Iterable<Trainer> trainerList= trainerRepo.findAll();
		return trainerList;
	}
	public Trainer getTrainerById(Integer id) {
		Trainer trainer=trainerRepo.findById(id).get();
		return trainer;
	}
	public void deleteTrainerById(Integer id) {
		trainerRepo.deleteById(id);
		
	}

}
