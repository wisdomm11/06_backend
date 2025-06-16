package com.shop.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.entity.Answer;
import com.shop.entity.Question;

@SpringBootTest
public class InsertAnswer {

	// 질문 테이블에 값을 넣기
	
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	
	@Test
	void insertAnswer() {
		
		// 1번 // 답변 테이블에 값을 넣는것 // 어떤 질문에 대한 답변인지 알아내는것
		// 답변을 저장하는 퀘스천 객체를 가져오는것
		Optional<Question> oq = questionRepository.findById(3);
		
		Question q = new Question();
		if (oq.isPresent()) {
			q = oq.get();
		}
		
		// 2번 // 앤서 객체에 세터를 사용해서 답글을 입력하기
		Answer a = new Answer();
		a.setContent("3번 질문에 대한 답변5 : 프론트도 열심히 하자");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q); // 질문에 대한 답변
		
		// 3번 // 앤서 레파지토리를 사용한 저장
		answerRepository.save(a);
		
		
	}
	
}
