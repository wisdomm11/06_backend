package com.shop.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Question;

@SpringBootTest
public class Delete_Question {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Test
	void deleteQuestion() {
		// 1번 // 딜리트 레코드를 가지고 오기 // 퀘스천 엔티티에 넣기
		Optional<Question> oq = questionRepository.findById(100);
		
		Question question = new Question();
		if(oq.isPresent()) {
			question = oq.get();
		}
		
		
		// 2번 // 레파지토리의 딜리트(q) 넣어서 제거한다
		questionRepository.delete(question);
		
	}

}
