package com.example.demo.controller;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.SurveyApplication;
import com.example.demo.model.Question;
import com.example.demo.service.SurveyService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SurveyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class SurveyControllerIT {

	@LocalServerPort
	private int port;

	@Test
	public void test() {
		// fail("Not yet implemented");
		String URL = "http://localhost:" + port + "/survery/Survey1/questions/Question4";
		ResponseEntity<String> response = setupTest(URL);
		// String result=restTemplate.getForObject(URL, String.class);
		System.out.println("Result in Junit Test" + response.getBody());
	}

	@Test
	public void testRetreiveAllSurvey() {
		String URL = "http://localhost:" + port + "/surverys";
		TestRestTemplate restTemplate = new TestRestTemplate();
		ResponseEntity<String> response = setupTest(URL);
		System.out.println("Retreive all results"+ response.getBody());

	}

	private ResponseEntity<String> setupTest(String URL) {
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null, header);

		ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
		return response;
	}
	
	
	
}
