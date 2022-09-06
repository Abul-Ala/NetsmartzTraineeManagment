package com.netsmartz.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Language {
	
@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int skillId;
	private String skill;



	public int getSkillId() {
		return skillId;
	}


	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}


	public String getSkill() {
		return skill;
	}


	public void setSkill(String skill) {
		this.skill = skill;
	}


	





	@Override
	public String toString() {
		return this.skill;
	}


	public Language(int skillId, String skill, Trainer trainer) {
		super();
		this.skillId = skillId;
		this.skill = skill;

	}


	public Language() {
		super();
	}

	
	
}
