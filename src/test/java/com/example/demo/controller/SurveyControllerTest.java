package com.example.demo.controller;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Question;
import com.example.demo.service.SurveyService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SurveyControllerTest {

	@Autowired
	MockMvc mockMVC;

	@MockBean
	private SurveyService surveyService;

	// ("/survery/{surveyId}/questions")
	@Test
	public void testCreateSurvey() throws Exception {

		Question mockQuestion = new Question("1", "First alpahbet in english", "A", Arrays.asList("A", "B", "C", "D"));

		String question = "{\"descriptions\":\"First alphabet in english\",\"correctAnswer\":\"A\", \"options\":[\"A\",\"B\",\"C\",\"D\"]}";

		Mockito.when(surveyService.addQuestion(Mockito.anyString(), Mockito.any(Question.class)))
				.thenReturn(mockQuestion);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/survery/Survey1/questions")
				.accept(MediaType.APPLICATION_JSON).content(question).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMVC.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}

}
