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
public class Trainer {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int trainerId;
	private String trainerName;
	private String trainerEmail;
	private String trainerPhone;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Language> language=new ArrayList<>();

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerEmail() {
		return trainerEmail;
	}

	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}

	public String getTrainerPhone() {
		return trainerPhone;
	}

	public void setTrainerPhone(String trainerPhone) {
		this.trainerPhone = trainerPhone;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return this.trainerName;
	}

	public Trainer(int trainerId, String trainerName, String trainerEmail, String trainerPhone,
			List<Language> language) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
		this.trainerPhone = trainerPhone;
		this.language = language;
	}

	public Trainer() {
		super();
	}
	

	
	
	
	

}
