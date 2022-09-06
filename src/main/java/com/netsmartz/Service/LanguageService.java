package com.netsmartz.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartz.Model.Language;
import com.netsmartz.Repository.LanguageRepository;

@Service
public class LanguageService {
	
	
	@Autowired
	LanguageRepository langRepo;

	public List<Language> getAllLanguage() {
		List<Language>list=(List<Language>) langRepo.findAll();
		return list;
	}

	public void deleteLanguage(Language language) {
		langRepo.delete(language);
		
	}

	public void addLanguage(Language language) {
		langRepo.save(language);
		
	}
	
	

}
