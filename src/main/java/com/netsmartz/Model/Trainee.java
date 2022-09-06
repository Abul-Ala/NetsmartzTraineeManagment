package com.netsmartz.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Trainee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int traineeId;
	private String traineeName;
	private String traineeEmail;
	private String traineePhone;
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Trainer> trainer=new ArrayList<>();
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Language>language=new ArrayList<>();
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public String getTraineeEmail() {
		return traineeEmail;
	}
	public void setTraineeEmail(String traineeEmail) {
		this.traineeEmail = traineeEmail;
	}
	public String getTraineePhone() {
		return traineePhone;
	}
	public void setTraineePhone(String traineePhone) {
		this.traineePhone = traineePhone;
	}
	public List<Trainer> getTrainer() {
		return trainer;
	}
	public void setTrainer(List<Trainer> trainer) {
		this.trainer = trainer;
	}
	public List<Language> getLanguage() {
		return language;
	}
	public void setLanguage(List<Language> language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return this.traineeName;
	}
	public Trainee(int traineeId, String traineeName, String traineeEmail, String traineePhone, List<Trainer> trainer,
			List<Language> language) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeEmail = traineeEmail;
		this.traineePhone = traineePhone;
		this.trainer = trainer;
		this.language = language;
	}
	public Trainee() {
		super();
	}
	
	
	

}
