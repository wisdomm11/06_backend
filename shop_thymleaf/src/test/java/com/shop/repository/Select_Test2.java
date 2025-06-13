package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;

@SpringBootTest
public class Select_Test2 {

	// answer 테이블의 id 1 값을 가지고 오는것
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Test
	void selectTest2() {
		
		Answer a = new Answer();

		Optional<Answer> oa = answerRepository.findById(1);
		
		if (oa.isPresent()) {
			a = oa.get();
		}
		
		System.out.println(a.getId());
		System.out.println(a.getContent());
		System.out.println(a.getCreateDate()); 
		
		
	}
	
}
