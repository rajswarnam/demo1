package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Question;
import com.example.demo.model.Survey;
import com.example.demo.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	SurveyService surveyService;

	@RequestMapping("/welcome")
	public String displayWelcome() {
		return "welcome";
	}

	@GetMapping("/survery/{surveyId}/questions")
	public Survey listSurvey(@PathVariable String surveyId) {
		System.out.println("Entering list survey method");
		return surveyService.retrieveSurvey(surveyId);
	}
	
	@PostMapping("/survery/{surveyId}/questions")
	public ResponseEntity<?> postQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		System.out.println("Entering list survey method");
		URI location=null;
		Question result= surveyService.addQuestion(surveyId, question);
		if(result!=null) {
			location=ServletUriComponentsBuilder.fromCurrentRequest().path("/${surveyId}").buildAndExpand(question.getId()).toUri();
		}else
			return ResponseEntity.noContent().build();
		 return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/survery/{surveyId}/questions/{questionId}")
	public Question getSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		System.out.println("Entering list Question method");
		return surveyService.retrieveQuestion(surveyId, questionId);
	}
	
	@GetMapping("/surverys")
	public List<Survey> listSurvey() {
		System.out.println("Entering list survey method");
		return surveyService.retrieveAllSurvey();
	}
}
