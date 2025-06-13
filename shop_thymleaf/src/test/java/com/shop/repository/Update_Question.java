package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Update_Question {

	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void updateQuestion() {
		// 1번 // db에서 1개의 레코드를 가지고 온다 퀘스천 엔티티에 담는다
		Optional<Question> oq = questionRepository.findById(95);
		
		Question question = new Question();
		if(oq.isPresent()) {
			question = oq.get();
			
			
			
			
			
		}
		
		// 2번 // 퀘스천 엔티티의 세터로 수정한다
		question.setSubject("test1 제목");
		question.setContent("test1 내용");
		
		
		// 3번 // 레파지토리의 세이브를 사용한다
		questionRepository.save(question);
		
		
		
	}
}
