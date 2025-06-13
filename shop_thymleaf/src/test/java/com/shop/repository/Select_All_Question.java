package com.shop.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Select_All_Question {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void selectAllQuestion() {
		List<Question> questions = questionRepository.findAll();
		
		System.out.println("레코드의 개수: " + questions.size());
		
		
		for (int i=0; i<questions.size(); i++) {
			System.out.println(questions.get(i).getId());
			System.out.println(questions.get(i).getSubject());
			System.out.println(questions.get(i).getContent());
		}
		
		
		
		System.out.println("==========향상된 포문===============");
		for(Question question : questions) {
			System.out.println(question.getId());
			System.out.println(question.getSubject());
			System.out.println(question.getContent());
			
			
			
		}
		
		
		
		
	}
	
}
