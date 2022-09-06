package com.netsmartz.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.netsmartz.Model.Language;
import com.netsmartz.Model.Trainee;
import com.netsmartz.Model.Trainer;
import com.netsmartz.Service.LanguageService;
import com.netsmartz.Service.TraineeService;
import com.netsmartz.Service.TrainerService;


@Controller
public class HomeController {
	
	ModelAndView mv=new ModelAndView();
	
	@Autowired
	LanguageService langService;

	@Autowired
	TrainerService trainerService;

	@Autowired
	TraineeService traineeService;
	
	@GetMapping("/home")
	public ModelAndView home() {
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("/addLanguage")
	public ModelAndView addLanguage() {
		
		mv.setViewName("addNewLanguage.html");
		return mv;
	}
	
	@GetMapping("/addNewLanguage")
	public ModelAndView addNewLanguage(Language language) {
		langService.addLanguage(language);
		mv.setViewName("home.html");
		return mv;
	}
	
	@GetMapping("/deleteLanguage")
	public ModelAndView deleteLanguage() {
		mv.setViewName("deleteLanguage.html");
		mv.addObject("languages", langService.getAllLanguage());
		return mv;
	
	}
	@GetMapping("/deleteLang")
	public ModelAndView deleteLanguage(Language language) {
		langService.deleteLanguage(language);
		return home();
	
	}
	
	@GetMapping("/addTrainer")
	public ModelAndView addTrainer() {
		mv.addObject("languages", langService.getAllLanguage());
		mv.addObject("trainer", new Trainer());
		mv.setViewName("addNewTrainer.html");
		return mv;
	}
	
	
	@GetMapping("/addNewTrainer")
	public ModelAndView addNewTrainer(Trainer trainer ) {
		
		trainerService.addTrainer(trainer);
		mv.setViewName("home.html");
		return mv;
	}
	
	
	
	
	@GetMapping("/viewModifyDeleteTrainer")
	public ModelAndView viewTrainer(Trainer trainer) {
	
		mv.addObject("List",trainerService.getAllTrainer());
		mv.setViewName("viewTrainer.html");
		return mv;
	}
	
	@GetMapping("/editTrainer{trainerId}")
	public ModelAndView editTrainer(@PathVariable("trainerId") Integer id) {
	
		mv.addObject("trainer",trainerService.getTrainerById(id));
		mv.addObject("languages", langService.getAllLanguage());
		mv.setViewName("addNewTrainer");
		return mv;
	}
	
	@GetMapping("/deleteTrainer{trainerId}")
	public ModelAndView deleteTrainer(@PathVariable("trainerId") Integer id) {
		
		trainerService.deleteTrainerById(id);
		return home();
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		
		mv.setViewName("addNewTrainee.html");
		mv.addObject("trainers",trainerService.getAllTrainer());
		mv.addObject("languages", langService.getAllLanguage());
		mv.addObject("trainee", new Trainee());
		
		
		return mv;
	}
	
	@GetMapping("/addNewTrainee")
	public ModelAndView addNewTrainee(Trainee trainee) {

		traineeService.addTrainee(trainee);
		mv.setViewName("home");
		return mv;
	}
	
	
	@GetMapping("/viewModifyDeleteTrainee")
	public ModelAndView viewTrainee(Trainee trainee) {
	
		mv.addObject("traineeList",traineeService.getAllTrainee());
		mv.addObject("languageList",langService.getAllLanguage());
		mv.setViewName("viewTrainee.html");
		return mv;
	}
	
	@GetMapping("/editTrainee{traineeId}")
	public ModelAndView editTrainee(@PathVariable("traineeId") Integer id) {
		
		mv.addObject("trainee", traineeService.getTraineeById(id));
		mv.addObject("languages", langService.getAllLanguage());	
		mv.setViewName("addNewTrainee");
		return mv;
	}
	
	
	@GetMapping("/deleteTrainee{traineeId}")
	public ModelAndView deleteTrainee(@PathVariable("traineeId") Integer id) {
		
		traineeService.deleteTraineeById(id);
		return home();
	}
	
	/*
	@GetMapping("/search")
	public ModelAndView SearchById(int id) {
		
	Trainee trainee=	traineeRepo.findById(id).orElse(new Trainee());
	mv.addObject(trainee);
	mv.setViewName("searchResults.html");	
	return mv;
	}
	*/
	
	
	
	@GetMapping("/signin")
	public ModelAndView signup() {
		mv.setViewName("signin");
		return mv;
	}
	
	


}
