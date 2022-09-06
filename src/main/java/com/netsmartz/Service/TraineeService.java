package com.netsmartz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.Model.Trainee;
import com.netsmartz.Repository.TraineeRepository;

@Service
public class TraineeService {

	@Autowired
	TraineeRepository traineeRepo;
	public void addTrainee(Trainee trainee) {
		traineeRepo.save(trainee);
		
	}
	public Iterable<Trainee> getAllTrainee() {
		Iterable<Trainee> traineeList= traineeRepo.findAll();
		return traineeList;
	}
	public Object getTraineeById(Integer id) {
		Trainee trainee=traineeRepo.findById(id).get();
		return trainee;
	}
	public void deleteTraineeById(Integer id) {
		traineeRepo.deleteById(id);
		
	}

}
