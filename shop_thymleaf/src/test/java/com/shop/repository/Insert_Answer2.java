package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class Insert_Answer2 {
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	
	
	@Test
	void insertAnswer2() {
		// 1번 // 어떤 질문에 대한 답글인지 // 답변글을 넣을 Question 객체를 가지고 와야함 
		Optional<Question> op = questionRepository.findById(4);
		
		Question q = new Question();
		
		if (op.isPresent()) {
			
			q = op.get();
		}
		
		// 2번 // 앤서에 답변을 저장
		Answer a = new Answer();
		
		a.setContent("4번 글에 답변 3 : 오늘 프론트 공부해야겠다");
		a.setCreateDate(LocalDateTime.now());
		
		a.setQuestion(q);
		
		// 3번 // 앤서 레파지토리 세이브 사용해서 저장
		answerRepository.save(a);
		
	}
	
}
